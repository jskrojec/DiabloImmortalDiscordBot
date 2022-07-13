package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class UnregisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public UnregisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void onUnregisterCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        if (!clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getNotRegisteredMessage("ENG")).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        databaseRequests.deleteNotificationChannelEntry(channelID);
        clientCache.deleteNotificationChannel(channelID);

        textChannel.sendMessage(textChannel.getAsMention() +
                LanguageController.getUnregisteredChannel("ENG")).queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });
    }
}
