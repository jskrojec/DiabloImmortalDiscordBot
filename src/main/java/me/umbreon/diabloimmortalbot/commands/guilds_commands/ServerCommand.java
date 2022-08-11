package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;

public class ServerCommand {

    private final ServerConfigCommand serverConfigCommand;
    private final ServerEventMessageCommand serverEventMessageCommand;
    private final ServerHeadUpCommand serverHeadUpCommand;
    private final ServerLanguageCommand serverLanguageCommand;
    private final ServerTimezoneCommand serverTimezoneCommand;

    public ServerCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.serverConfigCommand = new ServerConfigCommand(clientCache);
        this.serverEventMessageCommand = new ServerEventMessageCommand(clientCache, databaseRequests);
        this.serverHeadUpCommand = new ServerHeadUpCommand(clientCache, databaseRequests);
        this.serverLanguageCommand = new ServerLanguageCommand(clientCache, databaseRequests);
        this.serverTimezoneCommand = new ServerTimezoneCommand(databaseRequests, clientCache);
    }

    public void runCustomMessageCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");

        switch (args[1].toLowerCase()) {
            case "config":
                serverConfigCommand.runServerConfigCommand(message);
                break;
            case "message":
                serverEventMessageCommand.runServerEventMessageCommand(message);
                break;
            case "headup":
                serverHeadUpCommand.runServerHeadUpCommand(message);
                break;
            case "language":
                serverLanguageCommand.runLanguageCommand(message);
                break;
            case "timezone":
                serverTimezoneCommand.runTimezoneCommand(message);
                break;
        }
    }
}
