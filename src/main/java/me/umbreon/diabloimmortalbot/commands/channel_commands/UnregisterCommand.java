package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;

public class UnregisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public UnregisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runUnregisterCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);

        String textChannelID = getTextChannelID(message, args);
        if (!isChannelRegistered(textChannelID)) {
            String notRegisteredMessage = String.format(LanguageController.getChannelNotRegisteredMessage(language), textChannel.getAsMention());
            sendMessageToTextChannel(guildID, textChannel, notRegisteredMessage);
            return;
        }

        removeNotificationChannel(textChannelID);
        String channelUnregisteredMessage = String.format(LanguageController.getChannelUnregisteredMessage(language), textChannel.getAsMention());
        sendMessageToTextChannel(guildID, textChannel, channelUnregisteredMessage);
    }

    @Nullable
    private String getTextChannelID(Message message, String[] args) {
        String textChannelID;
        if (args.length == 2) {
            textChannelID = StringAssistant.removeAllNonNumbers(args[1]);
        } else if (args.length == 1) {
            textChannelID = message.getTextChannel().getId();
        } else {
            return null;
        }
        return textChannelID;
    }

    private void removeNotificationChannel(String textChannelID) {
        databaseRequests.deleteNotifierChannelEntry(textChannelID);
        clientCache.removeNotifierChannelFromList(textChannelID);
    }

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }
}
