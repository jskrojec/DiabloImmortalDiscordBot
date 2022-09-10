package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;

public class DeleteCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public DeleteCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runDeleteCommand(final String guildID) {
        databaseRequests.deleteEverythingFromDatabase(guildID);
        clientCache.getListWithNotifierChannels().forEach((s, notifierChannel) -> {
            if (notifierChannel.getGuildID().equalsIgnoreCase(guildID)) {
                clientCache.getListWithNotifierChannels().remove(s);
            }
        });

        clientCache.listWithGuildInformation.forEach((s, guildInformation) -> {
            if (s.equalsIgnoreCase(guildID)) {
                clientCache.listWithGuildInformation.remove(s);
            }
        });
    }
}
