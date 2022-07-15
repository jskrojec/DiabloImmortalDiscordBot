package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Guild;
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
        message.delete().queue();

        String[] args = message.getContentRaw().split(" ");
        String language = args[1].toUpperCase();
        TextChannel textChannel = message.getTextChannel();

        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getLanguage(guildID);

        if (!isLanguageSupported(language)) {
            textChannel.sendMessage(LanguageController.getLanguageUpdatedMessage(guildLanguage)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        if (!clientCache.doGuildExists(guildID)) {
            GuildInformation guildInformation = new GuildInformation(guildID, language, "GMT");
            createNewGuildAndSetLanguage(guildInformation);
        } else {
            setNewLanguage(guildID, language);
        }

        textChannel.sendMessage(LanguageController.getLanguageUpdatedMessage(guildLanguage)).queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });
    }

    private boolean isLanguageSupported(String lang) {
        switch (lang) {
            case "GER":
            case "ENG":
                return true;
            default:
                return false;

        }
    }

    private void createNewGuildAndSetLanguage(GuildInformation guildInformation) {
        databaseRequests.createNewGuildEntry(guildInformation);
        clientCache.addGuildInformation(guildInformation);
    }

    private void setNewLanguage(String guildID, String language) {
        databaseRequests.setGuildLanguage(guildID, language);
        clientCache.setLanguage(guildID, language);
    }
}
