package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Arrays;
import java.util.List;

/**
 * Command: >server language #LANGUAGE
 */
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
            textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
            return;
        }

        String language = args[2].toLowerCase();
        if (!isLanguageSupported(language)) {
            textChannel.sendMessage(LanguageController.getLanguageNotSupportedMessage(guildLanguage)).queue();
            return;
        }

        setGuildLanguage(guildID, language);
        textChannel.sendMessage(String.format(LanguageController.getLanguageUpdatedMessage(guildLanguage), language)).queue();
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
}
