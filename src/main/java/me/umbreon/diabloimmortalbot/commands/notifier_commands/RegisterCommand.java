package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.IdentifierConverter;
import net.dv8tion.jda.api.entities.*;
import org.jetbrains.annotations.Nullable;
/**
 * Command: >register
 * Command: >register #Channel
 * Alias: >notifier
 **/
public class RegisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RegisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runRegisterCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        String textChannelID = getTextChannelID(message, args);
        if (textChannelID == null) {
            textChannel.sendMessage(LanguageController.getChannelNotFoundMessage(language)).queue();
            return;
        }

        if (isChannelRegistered(textChannelID)) {
            textChannel.sendMessage(String.format(LanguageController.getAlreadyRegisteredMessage(language), textChannel.getAsMention())).queue();
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(textChannelID);
        createNotificationChannel(notificationChannel);
        textChannel.sendMessage(String.format(LanguageController.getRegisteredMessage(language), textChannel.getAsMention())).queue();
    }

    // -

    @Nullable
    private String getTextChannelID(Message message, String[] args) {
        String textChannelID;
        if (args.length == 2) {
            textChannelID = IdentifierConverter.removeAllNonNumbers(args[1]);
        } else if (args.length == 1) {
            textChannelID = message.getTextChannel().getId();
        } else {
            return null;
        }
        return textChannelID;
    }

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotificationChannelExists(textChannelID);
    }

    private void createNotificationChannel(NotificationChannel notificationChannel) {
        databaseRequests.createNewNotificationChannelEntry(notificationChannel);
        clientCache.createNewNotificationChannelEntry(notificationChannel);
    }


}
