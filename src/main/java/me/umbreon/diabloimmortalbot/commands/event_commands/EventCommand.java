package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;

public class EventCommand {

    private final EventListCommand eventListCommand;
    private final EventSetCommand eventSetCommand;

    public EventCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.eventListCommand = new EventListCommand(clientCache);
        this.eventSetCommand = new EventSetCommand(clientCache, databaseRequests);
    }

    public void runEventCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");

        switch (args[1].toLowerCase()) {
            case "list":
            case "l":
                eventListCommand.runEventListCommand(message);
                break;
            default:
                eventSetCommand.runNotificationsCommand(message);
                break;
        }
    }
}
