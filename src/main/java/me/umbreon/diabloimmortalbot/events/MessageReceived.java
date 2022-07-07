package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.commands.*;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class MessageReceived {

    private final NotifierCommand notifierCommand;
    private final StatusCommand statusCommand;
    private final TimezoneCommand timezoneCommand;
    private final RoleCommand roleCommand;
    private final HelpCommand helpCommand;
    private final UnnotifierCommand unnotifierCommand;

    public MessageReceived(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.notifierCommand = new NotifierCommand(databaseRequests, clientCache);
        this.statusCommand = new StatusCommand(databaseRequests, clientCache);
        this.timezoneCommand = new TimezoneCommand(databaseRequests, clientCache);
        this.roleCommand = new RoleCommand(databaseRequests, clientCache);
        this.helpCommand = new HelpCommand();
        this.unnotifierCommand = new UnnotifierCommand(databaseRequests, clientCache);
    }

    public void onMessageReceivedEvent(MessageReceivedEvent event, Member member) {
        if (event.getAuthor().isBot()) {
            return;
        }

        String[] args = event.getMessage().getContentRaw().split(" ");

        if (event.getAuthor().isBot()) {
            return;
        }

        if (findBotRole(member) == null) {
            return;
        }

        switch (args[0].toLowerCase()) {
            case "/notifier":
                notifierCommand.onNotifierCommand(event.getMessage());
                break;
            case "/unnotifier":
                unnotifierCommand.onUnnotifierCommand(event.getMessage());
                break;
            case "/status":
                statusCommand.runStatusCommand(event.getMessage());
                break;
            case "/timezone":
                timezoneCommand.onTimezoneCommand(event.getMessage());
                break;
            case "/role":
                roleCommand.onRoleCommand(event.getMessage());
                break;
            case "/help":
                helpCommand.onHelpCommand(event.getMessage());
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
