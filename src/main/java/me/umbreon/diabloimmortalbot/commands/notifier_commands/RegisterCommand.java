package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.*;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;
/**
 * Command: >register (TextChannelMention)
 * Alias: >notifier (TextChannelMention)
 * L:2
 * (Optional)
 */
public class RegisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RegisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runRegisterCommand(Message message) {
        String channelID = message.getTextChannel().getId();
        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        if (clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = textChannel.getAsMention() + LanguageController.getAlreadyRegisteredMessage(language);
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(channelID);
        databaseRequests.createNewNotificationChannelEntry(notificationChannel);
        clientCache.createNewNotificationChannelEntry(notificationChannel);

        String responseMessage = String.format(LanguageController.getRegisteredMessage(language), textChannel.getAsMention());
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
    }

    public void runRegisterCommandNew(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        String language = clientCache.getLanguage(message.getGuild().getId());

        String textChannelID = getTextChannelID(message, args);
        if (textChannelID == null) {

            return;
        }

        if (isChannelRegistered(textChannelID)) {
            textChannel.sendMessage(
                    String.format(LanguageController.getAlreadyRegisteredMessage(language), textChannel.getAsMention())
            ).queue();
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(textChannelID);
        createNotificationChannel(notificationChannel);

        textChannel.sendMessage(
                String.format(LanguageController.getRegisteredMessage(language), textChannel.getAsMention())
        ).queue();
    }

    @Nullable
    private String getTextChannelID(Message message, String[] args) {
        String textChannelID;
        if (args.length == 2) {
            textChannelID = args[1].replaceAll("[^\\d.]", "");
        } else if (args.length == 1) {
            textChannelID = message.getTextChannel().getId();
        } else {
            return null;
        }
        return textChannelID;
    }

    // -

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotificationChannelExists(textChannelID);
    }

    private void createNotificationChannel(NotificationChannel notificationChannel) {
        databaseRequests.createNewNotificationChannelEntry(notificationChannel);
        clientCache.createNewNotificationChannelEntry(notificationChannel);
    }

}
