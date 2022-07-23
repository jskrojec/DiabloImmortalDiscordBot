package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.Client;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TextChannelDelete extends ListenerAdapter {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public TextChannelDelete(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    @Override
    public void onChannelDelete(ChannelDeleteEvent event) {
        if (event.getChannelType().getId() == 0) {

            String channelID = event.getChannel().getId();

            if (clientCache.doNotificationChannelExists(channelID)) {
                clientCache.deleteNotificationChannel(channelID);
                databaseRequests.deleteNotificationChannelEntry(channelID);
            }

        }
    }
}
