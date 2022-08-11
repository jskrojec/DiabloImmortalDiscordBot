package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.commands.custom_messages.CustomMessageCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.NotificationsCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerLanguageCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerTimezoneCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.*;
import me.umbreon.diabloimmortalbot.commands.notifier_commands.InfoCommand;
import me.umbreon.diabloimmortalbot.commands.notifier_commands.RegisterCommand;
import me.umbreon.diabloimmortalbot.commands.notifier_commands.RoleCommand;
import me.umbreon.diabloimmortalbot.commands.notifier_commands.UnregisterCommand;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
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
        this.helpCommand = new HelpCommand();
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
        TextChannel textChannel;


        try {
            textChannel = event.getMessage().getTextChannel();
        } catch (IllegalStateException ignore) {
            return; //This message is not send in a text channel
        }

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


        String[] args = event.getMessage().getContentRaw().split(" ");
        String guildID = event.getGuild().getId();
        registerGuildIfDoNotExist(guildID);

        Member member = event.getMember();
        if (findBotRole(member) == null) {
            if (member.hasPermission(Permission.MESSAGE_MANAGE)) {
                checkForCommandsWithNoPermissions(args[0], event.getMessage());
            }
            return;
        }

        try {
            checkForCommandAndRun(event, member, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkForCommandAndRun(MessageReceivedEvent event, Member member, String[] args) {
        switch (args[0].toLowerCase()) {
            case ">notifier":
            case ">register":
                registerCommand.runRegisterCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">unnotifier":
            case ">unregister":
                unregisterCommand.runUnregisterCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">timezone":
                serverTimezoneCommand.runTimezoneCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">role":
                roleCommand.runRoleCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">help":
                helpCommand.runHelpCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">timezones":
                timezonesCommand.runTimezonesCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">language":
                serverLanguageCommand.runLanguageCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">instructions":
            case ">instruction":
            case ">install":
                instructionCommand.runInstructionCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">languages":
                languagesCommand.runLanguagesCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">notifications":
            case ">notification":
                notificationsCommand.runNotificationsCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">cm":
            case ">customessage":
                customMessageCommand.runCustomMessageCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">info":
                infoCommand.runInfoCommand(event.getMessage());
                break;
            case ">server":
                serverCommand.runCustomMessageCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
        }
    }

    private void checkForCommandsWithNoPermissions(String arg, Message message) {
        switch (arg.toLowerCase()) {
            case ">instruction":
            case ">instructions":
            case ">install":
                instructionCommand.runInstructionCommand(message);
                break;
            case ">help":
                helpCommand.runHelpCommand(message);
                break;
        }
    }

    private Role findBotRole(Member member) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
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

}
