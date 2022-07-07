package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnnotifierCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public UnnotifierCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void onUnnotifierCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        message.delete().queue();
        String channelId = textChannel.getId();

        if (databaseRequests.doNotificationChannelExists(channelId)) {
            databaseRequests.deleteNotificationChannelEntry(channelId);
            textChannel.sendMessage(textChannel.getAsMention() + " is unregistered.").queue();
            clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
        } else {
            textChannel.sendMessage(textChannel.getAsMention() + " isn't a Notify-Channel.").queue();
        }

    }

}
