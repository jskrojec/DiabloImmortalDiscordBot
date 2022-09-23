package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.cache.ClientCache;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Listens for channel deletes and if deleted channel is registered, remove it from the system.
 */
public class ChannelDelete extends ListenerAdapter {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;
    private final NotificationChannelsCache notificationChannelsCache;

    public ChannelDelete(final ClientCache clientCache, final DatabaseRequests databaseRequests, final NotificationChannelsCache notificationChannelsCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    @Override
    public void onChannelDelete(final ChannelDeleteEvent event) {
        if (!isTypeTextChannelType(event.getChannel().getType())) {
            return;
        }

        String channelID = event.getChannel().getId();

        if (notificationChannelsCache.doNotifierChannelExists(channelID)) {
            notificationChannelsCache.removeNotifierChannelFromList(channelID);
            databaseRequests.deleteNotifierChannelEntry(channelID);
        }
    }

    private boolean isTypeTextChannelType(ChannelType channelType) {
        return channelType.isMessage();
    }
}
