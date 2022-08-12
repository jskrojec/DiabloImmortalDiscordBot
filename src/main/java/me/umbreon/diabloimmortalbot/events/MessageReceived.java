package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.commands.channel_commands.InfoCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.RegisterCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.RoleCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.UnregisterCommand;
import me.umbreon.diabloimmortalbot.commands.custom_messages.CustomMessageCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.NotificationsCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerLanguageCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerTimezoneCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.HelpCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.InstructionCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.LanguagesCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.TimezonesCommand;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class MessageReceived extends ListenerAdapter {

    private final RegisterCommand registerCommand;
    private final ServerTimezoneCommand serverTimezoneCommand;
    private final RoleCommand roleCommand;
    private final UnregisterCommand unregisterCommand;
    private final HelpCommand helpCommand;
    private final TimezonesCommand timezonesCommand;
    private final ServerLanguageCommand serverLanguageCommand;
    private final InstructionCommand instructionCommand;
    private final LanguagesCommand languagesCommand;
    private final NotificationsCommand notificationsCommand;
    private final CustomMessageCommand customMessageCommand;
    private final InfoCommand infoCommand;
    private final ServerCommand serverCommand;

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public MessageReceived(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;

        this.registerCommand = new RegisterCommand(databaseRequests, clientCache);
        this.serverTimezoneCommand = new ServerTimezoneCommand(databaseRequests, clientCache);
        this.roleCommand = new RoleCommand(databaseRequests, clientCache);
        this.unregisterCommand = new UnregisterCommand(databaseRequests, clientCache);
        this.helpCommand = new HelpCommand(clientCache);
        this.timezonesCommand = new TimezonesCommand();
        this.serverLanguageCommand = new ServerLanguageCommand(clientCache, databaseRequests);
        this.instructionCommand = new InstructionCommand();
        this.languagesCommand = new LanguagesCommand();
        this.notificationsCommand = new NotificationsCommand(clientCache, databaseRequests);
        this.customMessageCommand = new CustomMessageCommand(clientCache, databaseRequests);
        this.infoCommand = new InfoCommand(clientCache);
        this.serverCommand = new ServerCommand(clientCache, databaseRequests);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (!isChannelTypeTextChannel(event.getChannel().getType())) return;

        TextChannel textChannel = event.getMessage().getTextChannel();

        checkForCustomMessageCreationMessage(textChannel, event);
        String[] args = event.getMessage().getContentRaw().split(" ");
        String guildID = event.getGuild().getId();
        registerGuildIfDoNotExist(guildID);
        Member member = event.getMember();
        String effectiveName = member.getEffectiveName();
        Message eventMessage = event.getMessage();

        try {
            if (!isUserPermitted(member) && hasUserMessageManagePermission(member)) {
                checkForCommandsWithNoPermissions(eventMessage, effectiveName, args[0].toLowerCase());
                return;
            }

            checkForCommandsWithPermissions(eventMessage, effectiveName, args[0].toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
            ClientLogger.createNewErrorLogEntry(e);
        }
    }

    private boolean isChannelTypeTextChannel(ChannelType channelType) {
        return channelType.getId() == 0;
    }

    private void checkForCommandsWithPermissions(Message message, String effectiveName, String command) {

        switch (command) {
            case ">notifier":
            case ">register":
                registerCommand.runRegisterCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">unnotifier":
            case ">unregister":
                unregisterCommand.runUnregisterCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">timezone":
                serverTimezoneCommand.runTimezoneCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">role":
                roleCommand.runRoleCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">help":
                helpCommand.runHelpCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">timezones":
                timezonesCommand.runTimezonesCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">language":
                serverLanguageCommand.runLanguageCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">instructions":
            case ">instruction":
            case ">install":
                instructionCommand.runInstructionCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">languages":
                languagesCommand.runLanguagesCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">notifications":
            case ">notification":
                notificationsCommand.runNotificationsCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">cm":
            case ">customessage":
                customMessageCommand.runCustomMessageCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">info":
                infoCommand.runInfoCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">server":
                serverCommand.runCustomMessageCommand(message);
                logCommandExecution(effectiveName, message);
                break;
        }
    }

    private void checkForCommandsWithNoPermissions(Message message, String effectiveName, String command) {
        switch (command) {
            case ">instruction":
            case ">instructions":
            case ">install":
                instructionCommand.runInstructionCommand(message);
                logCommandExecution(effectiveName, message);
                break;
            case ">help":
                helpCommand.runHelpCommand(message);
                logCommandExecution(effectiveName, message);
                break;
        }
    }

    private boolean isUserPermitted(Member member) {
        List<Role> roles = member.getRoles();
        Role tempRole = roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
        return tempRole != null;
    }

    private boolean hasUserMessageManagePermission(Member member) {
        return member.hasPermission(Permission.MESSAGE_MANAGE);
    }

    private void registerGuildIfDoNotExist(String guildID) {
        if (!clientCache.doGuildExists(guildID)) {
            GuildInformation guildInformation = new GuildInformation(guildID);
            clientCache.addGuildInformation(guildInformation);
            databaseRequests.createNewGuildEntry(guildInformation);
        }
    }

    private void logCommandExecution(String userName, Message command) {
        System.out.println(userName + " used: " + command);
        ClientLogger.createNewClientLogEntry(userName + " used: " + command.getContentRaw());
    }

    private void checkForCustomMessageCreationMessage(TextChannel textChannel, MessageReceivedEvent event) {
        if (clientCache.isUserInOperationMode(textChannel.getId(), event.getAuthor().getId())) {

            if (clientCache.isOperatingUserForChannel(textChannel.getId(), event.getAuthor().getId())) {
                customMessageCommand.getCustomMessageCreate().addTextChannelToPreparingCustomMessage(event.getMessage());
                return;
            }

            if (clientCache.isOperatingUserForDay(textChannel.getId(), event.getAuthor().getId())) {
                customMessageCommand.getCustomMessageCreate().addDayToPreparingCustomMessage(event.getMessage());
                return;
            }

            if (clientCache.isOperatingUserForTime(textChannel.getId(), event.getAuthor().getId())) {
                customMessageCommand.getCustomMessageCreate().addTimeToPreparingCustomMessage(event.getMessage());
                return;
            }

            if (clientCache.isOperatingUserForRepeating(textChannel.getId(), event.getAuthor().getId())) {
                customMessageCommand.getCustomMessageCreate().addRepeatingValueToCustomMessage(event.getMessage());
                return;
            }

            if (clientCache.isOperatingUserForMessage(textChannel.getId(), event.getAuthor().getId())) {
                customMessageCommand.getCustomMessageCreate().addMessageToCustomMessage(event.getMessage());
            }
        }
    }
}
