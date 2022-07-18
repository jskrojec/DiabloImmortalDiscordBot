package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;
/**
 * Command: >register
 */
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
        String language = clientCache.getLanguage(guildID);

        if (clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = textChannel.getAsMention() + LanguageController.getAlreadyRegisteredMessage(language);
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(channelID);
        databaseRequests.createNewNotificationChannelEntry(notificationChannel);
        clientCache.addNotificationChannel(notificationChannel);

        String responseMessage = String.format(LanguageController.getRegisteredMessage(language), textChannel.getAsMention());
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
        createLogEntry(message, responseMessage);
    }

    private void createLogEntry(Message message, String responseMessage) {
        String channelName = message.getTextChannel().getName();
        String guildName = message.getGuild().getName();
        String logMessage = "Sended message " + responseMessage + " to " + channelName + " in guild " + guildName + ".";
        ClientLogger.createNewInfoLogEntry(logMessage);
    }
}
