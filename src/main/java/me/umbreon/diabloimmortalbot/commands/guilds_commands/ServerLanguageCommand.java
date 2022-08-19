package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServerLanguageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ServerLanguageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runLanguageCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanguage));
            return;
        }

        String language = args[2].toLowerCase();
        if (!isLanguageSupported(language)) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getLanguageNotSupportedMessage(guildLanguage));
            return;
        }

        setGuildLanguage(guildID, language);
        sendMessageToTextChannel(guildID, textChannel, String.format(LanguageController.getLanguageUpdatedMessage(guildLanguage), language));
    }

    private boolean isLanguageSupported(String lang) {
        return clientCache.getListWithSupportedLanguage().contains(lang);
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length == 3;
    }

    private void setGuildLanguage(String guildID, String guildLanguage) {
        databaseRequests.setGuildLanguage(guildID, guildLanguage);
        clientCache.setGuildLanguage(guildID, guildLanguage);
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }
}
