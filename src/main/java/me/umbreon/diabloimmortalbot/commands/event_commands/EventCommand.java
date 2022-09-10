package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.commands.ChangeEventValueCommand;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

public class EventCommand {

    private final EventListCommand eventListCommand;
    private final ChangeEventValueCommand changeEventValueCommand;

    public EventCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.eventListCommand = new EventListCommand(clientCache);
        this.changeEventValueCommand = new ChangeEventValueCommand(clientCache, databaseRequests);
    }

    public String runEventCommand(final String[] args, final TextChannel textChannel) {
        switch (args[1].toLowerCase()) {
            case "list":
            case "l":
                return eventListCommand.runEventListCommand(textChannel, textChannel.getGuild().getId());
            default:
                return changeEventValueCommand.runChangeEventValueCommand(args, textChannel);
        }
    }
}
