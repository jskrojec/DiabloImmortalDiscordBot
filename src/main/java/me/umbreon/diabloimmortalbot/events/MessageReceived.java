package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.commands.*;
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

import java.util.List;

public class MessageReceived {

    private final RegisterCommand registerCommand;
    private final StatusCommand statusCommand;
    private final TimezoneCommand timezoneCommand;
    private final RoleCommand roleCommand;
    private final UnregisterCommand unregisterCommand;
    private final CheckTimeZoneCommand checkTimeZoneCommand;
    private final HelpCommand helpCommand;
    private final TimezonesCommand timezonesCommand;
    private final LanguageCommand languageCommand;
    private final WhatsMyChannelIdCommand whatsMyChannelIdCommand;
    private final HeadUpCommand headUpCommand;
    private final InstructionCommand instructionCommand;

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public MessageReceived(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.registerCommand = new RegisterCommand(databaseRequests, clientCache);
        this.statusCommand = new StatusCommand(databaseRequests, clientCache);
        this.timezoneCommand = new TimezoneCommand(databaseRequests, clientCache);
        this.roleCommand = new RoleCommand(databaseRequests, clientCache);
        this.unregisterCommand = new UnregisterCommand(databaseRequests, clientCache);
        this.checkTimeZoneCommand = new CheckTimeZoneCommand(clientCache);
        this.helpCommand = new HelpCommand();
        this.timezonesCommand = new TimezonesCommand();
        this.languageCommand = new LanguageCommand(clientCache, databaseRequests);
        this.whatsMyChannelIdCommand = new WhatsMyChannelIdCommand();
        this.headUpCommand = new HeadUpCommand(clientCache, databaseRequests);
        this.instructionCommand = new InstructionCommand();

        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void onMessageReceivedEvent(MessageReceivedEvent event, Member member) {
        if (event.getAuthor().isBot()) {
            return;
        }

        TextChannel textChannel;

        try {
            textChannel = event.getMessage().getTextChannel();
        } catch (IllegalStateException ignore) {
            return;
            //This message is not send in a text channel
        }

        String[] args = event.getMessage().getContentRaw().split(" ");
        String channelID = textChannel.getId();
        if (clientCache.doNotificationChannelExists(channelID)) {
            String guildID = event.getGuild().getId();
            registerGuildIfDoNotExist(guildID, channelID);
        }

        if (findBotRole(member) == null) {
            if (member.hasPermission(Permission.MESSAGE_MANAGE)) {
                checkForCommandsWithNoPermissions(args[0], event.getMessage());
            }
            return;
        }

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
            case ">status":
                statusCommand.runStatusCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">timezone":
                timezoneCommand.onTimezoneCommand(event.getMessage());
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
            case ">checktimezone":
            case ">ctz":
            case ">checktz":
                checkTimeZoneCommand.runCheckTimezoneCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">timezones":
                timezonesCommand.runTimezonesCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">language":
                languageCommand.runLanguageCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">whatismychannelid":
                whatsMyChannelIdCommand.runWhatsMyChannelIdCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">headup":
                headUpCommand.runHeadUpCommand(event.getMessage());
                logCommandExecution(member.getEffectiveName(), event.getMessage());
                break;
            case ">instructions":
            case ">instruction":
            case ">install":
                instructionCommand.runInstructionCommand(event.getMessage());
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

    private void registerGuildIfDoNotExist(String guildID, String channelID) {
        if (!clientCache.doGuildExists(guildID)) {
            String timezone = clientCache.getTimezone(channelID);
            GuildInformation guildInformation = new GuildInformation(guildID, "ENG", true);
            clientCache.addGuildInformation(guildInformation);
            databaseRequests.createNewGuildEntry(guildInformation);
        }
    }

    private void logCommandExecution(String userName, Message command) {
        System.out.println(userName + " used: " + command);
        ClientLogger.createNewInfoLogEntry(userName + " used: " + command);
    }

}
