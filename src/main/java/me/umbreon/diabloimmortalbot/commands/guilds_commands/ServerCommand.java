package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.commands.TimezoneCommand;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class ServerCommand {

    private final ServerConfigCommand serverConfigCommand;
    private final ServerEventMessageCommand serverEventMessageCommand;
    private final ServerHeadUpCommand serverHeadUpCommand;
    private final ServerLanguageCommand serverLanguageCommand;
    private final TimezoneCommand timezoneCommand;
    private final ServerAutoDeleteCommand serverAutoDeleteCommand;

    public ServerCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.serverConfigCommand = new ServerConfigCommand(clientCache);
        this.serverEventMessageCommand = new ServerEventMessageCommand(clientCache, databaseRequests);
        this.serverHeadUpCommand = new ServerHeadUpCommand(clientCache, databaseRequests);
        this.serverLanguageCommand = new ServerLanguageCommand(clientCache, databaseRequests);
        this.timezoneCommand = new TimezoneCommand(databaseRequests, clientCache);
        this.serverAutoDeleteCommand = new ServerAutoDeleteCommand(clientCache, databaseRequests);
    }

    public String runServerCommand(final String[] args, final TextChannel textChannel, final Member member) {
        switch (args[1].toLowerCase()) {
            case "config":
            case "cfg":
                serverConfigCommand.runServerConfigCommand(member, textChannel);
                return "Messages sent!";
            case "message":
            case "msg":
                return serverEventMessageCommand.runServerEventMessageCommand(args, textChannel);
            case "headup":
                return serverHeadUpCommand.runServerHeadUpCommand(args, textChannel);
            case "language":
            case "lang":
                return serverLanguageCommand.runLanguageCommand(args, textChannel);
            case "timezone":
            case "tz":
                return timezoneCommand.runTimezoneCommand(args, textChannel);
            case "autodelete":
            case "ad":
                return serverAutoDeleteCommand.runServerAutoDeleteCommand(args, textChannel);
            default:
                return null;
        }
    }
}
