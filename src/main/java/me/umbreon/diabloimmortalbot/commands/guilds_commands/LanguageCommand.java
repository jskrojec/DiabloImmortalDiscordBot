package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class LanguageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public LanguageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runLanguageCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");

        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        String language = args[1].toUpperCase();
        String guildID = message.getGuild().getId();
        String defaultLanguage = "ENG";

        if (!isLanguageSupported(language)) {
            String responseMessage = LanguageController.getLanguageNotSupportedMessage(defaultLanguage);
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        databaseRequests.setGuildLanguage(guildID, language);
        clientCache.setLanguage(guildID, language);

        String responseMessage = String.format(LanguageController.getLanguageUpdatedMessage(defaultLanguage), language);
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
    }

    private boolean isLanguageSupported(String lang) {
        switch (lang) {
            case "GER":
            case "ENG":
            case "ESP":
            case "FRA":
            case "POL":
            case "ITA":
            case "RUS":
            case "IND":
                return true;
            default:
                return false;
        }
    }
}
