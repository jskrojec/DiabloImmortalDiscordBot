package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class RegisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RegisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runRegisterCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getLanguage(guildID);

        if (clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getAlreadyRegisteredMessage(guildLanguage)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(channelID);
        databaseRequests.createNewNotificationChannelEntry(notificationChannel);
        clientCache.addNotificationChannel(notificationChannel);

        textChannel.sendMessage(textChannel.getAsMention() +
                LanguageController.getRegisteredMessage(guildLanguage)).queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });
    }
}
