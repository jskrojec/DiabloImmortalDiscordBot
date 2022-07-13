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
    }

    public void onMessageReceivedEvent(MessageReceivedEvent event, Member member) {
        if (event.getAuthor().isBot()) {
            return;
        }

        if (findBotRole(member) == null) {
            return;
        }

        String[] args = event.getMessage().getContentRaw().split(" ");

        switch (args[0].toLowerCase()) {
            case ">notifier":
            case ">register":
                registerCommand.onNotifierCommand(event.getMessage());
                break;
            case ">unnotifier":
            case ">unregister":
                unregisterCommand.onUnregisterCommand(event.getMessage());
                break;
            case ">status":
                statusCommand.runStatusCommand(event.getMessage());
                break;
            case ">timezone":
                timezoneCommand.onTimezoneCommand(event.getMessage());
                break;
            case ">role":
                roleCommand.onRoleCommand(event.getMessage());
                break;
            case ">debug":
                debugCommand.onDebugCommand(event.getMessage());
                break;
            case ">help":
                helpCommand.onHelpCommand(event.getMessage());
                break;
            case ">checktimezone":
            case ">ctz":
            case ">checktz":
                checkTimeZoneCommand.onCheckTimeZoneCommand(event.getMessage());
                break;
            case ">timezones":
                timezonesCommand.onTimezonesCommand(event.getMessage());
                break;

        }
    }

    private Role findBotRole(Member member) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equals("Bot Admin"))
                .findFirst()
                .orElse(null);
    }

}
