package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class NotifierCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public NotifierCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void onNotifierCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        message.delete().queue();
        String channelId = textChannel.getId();

        if (databaseRequests.doNotificationChannelExists(channelId)) {
            textChannel.sendMessage(textChannel.getAsMention() + " is already registered as Notify-Channel.").queue();
        } else {
            databaseRequests.createNewNotificationChannelEntry(channelId);
            textChannel.sendMessage(textChannel.getAsMention() + " is now a Notify-Channel.").queue();
            clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
        }

    }

}
