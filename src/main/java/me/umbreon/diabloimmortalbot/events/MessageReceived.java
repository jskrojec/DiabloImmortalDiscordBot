package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.commands.*;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class MessageReceived {

    private final RegisterCommand registerCommand;
    private final StatusCommand statusCommand;
    private final TimezoneCommand timezoneCommand;
    private final RoleCommand roleCommand;
    private final UnregisterCommand unregisterCommand;
    private final DebugCommand debugCommand;
    private final CheckTimeZoneCommand checkTimeZoneCommand;
    private final HelpCommand helpCommand;
    private final TimezonesCommand timezonesCommand;
    private final LanguageCommand languageCommand;
    private final WhatsMyChannelIdCommand whatsMyChannelIdCommand;

    public MessageReceived(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.debugCommand = new DebugCommand(databaseRequests, clientCache);
        this.registerCommand = new RegisterCommand(databaseRequests, clientCache);
        this.statusCommand = new StatusCommand(databaseRequests, clientCache);
        this.timezoneCommand = new TimezoneCommand(databaseRequests, clientCache);
        this.roleCommand = new RoleCommand(databaseRequests, clientCache);
        this.unregisterCommand = new UnregisterCommand(databaseRequests, clientCache);
        this.checkTimeZoneCommand = new CheckTimeZoneCommand();
        this.helpCommand = new HelpCommand();
        this.timezonesCommand = new TimezonesCommand();
        this.languageCommand = new LanguageCommand(clientCache, databaseRequests);
        this.whatsMyChannelIdCommand = new WhatsMyChannelIdCommand();
    }

    public void onMessageReceivedEvent(MessageReceivedEvent event, Member member) {
        if (event.getAuthor().isBot()) {
            return;
        }

        if (findBotRole(member) == null || !event.getAuthor().getId().equals(event.getGuild().getOwnerId())) {
            return;
        }

        String[] args = event.getMessage().getContentRaw().split(" ");

        switch (args[0].toLowerCase()) {
            case ">notifier":
            case ">register":
                registerCommand.runRegisterCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">unnotifier":
            case ">unregister":
                unregisterCommand.runUnregisterCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">status":
                statusCommand.runStatusCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">timezone":
                timezoneCommand.onTimezoneCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">role":
                roleCommand.runRoleCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">debug":
                debugCommand.runDebugCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">help":
                helpCommand.runHelpCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">checktimezone":
            case ">ctz":
            case ">checktz":
                checkTimeZoneCommand.runCheckTimezoneCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">timezones":
                timezonesCommand.runTimezonesCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">language":
                languageCommand.runLanguageCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
                break;
            case ">whatismychannelid":
                whatsMyChannelIdCommand.runWhatsMyChannelIdCommand(event.getMessage());
                System.out.println(member.getEffectiveName() + " used: " + event.getMessage());
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

}
