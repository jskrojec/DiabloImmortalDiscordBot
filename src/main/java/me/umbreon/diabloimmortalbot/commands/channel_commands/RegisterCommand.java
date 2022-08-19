package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.data.NotifierChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;

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
        String language = clientCache.getGuildLanguage(guildID);

        String textChannelID = getTextChannelID(message, args);
        if (textChannelID == null) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getChannelNotFoundMessage(language));
            return;
        }

        if (isChannelRegistered(textChannelID)) {
            String alreadyRegisteredMessage = String.format(LanguageController.getChannelAlreadyRegisteredMessage(language), textChannel.getAsMention());
            sendMessageToTextChannel(guildID, textChannel, alreadyRegisteredMessage);
            return;
        }

        TextChannel targetTextChannel = message.getGuild().getTextChannelById(textChannelID);
        if (targetTextChannel == null) return;
        NotifierChannel notifierChannel = new NotifierChannel(textChannelID, guildID);
        createNotifierChannel(notifierChannel);
        String formattedChannelRegisteredMessage = String.format(LanguageController.getChannelRegisteredMessage(language), targetTextChannel.getAsMention());
        sendMessageToTextChannel(guildID, textChannel, formattedChannelRegisteredMessage);
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

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    public void createNotifierChannel(NotifierChannel notifierChannel) {
        databaseRequests.createNewNotifierChannel(notifierChannel);
        clientCache.addNotifierChannelToList(notifierChannel);
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }
}
