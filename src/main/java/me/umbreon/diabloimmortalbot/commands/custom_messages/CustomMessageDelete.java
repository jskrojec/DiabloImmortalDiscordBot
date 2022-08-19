package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CustomMessageDelete {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessageDelete(ClientCache clientCache, DatabaseRequests databaseRequests){
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessageDelete(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        String guildID = textChannel.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanguage));
            return;
        }

        int customMessageID = Integer.parseInt(args[2]);
        if (!isCustomMessageGuildIdCurrentGuildId(guildID, customMessageID)) return;

        deleteCustomMessage(customMessageID);
        String CmDeleted = String.format(LanguageController.getCustomMessageWithIdDeleted(guildLanguage), customMessageID);
        sendMessageToTextChannel(guildID, textChannel, CmDeleted);
    }

    private boolean isCustomMessageGuildIdCurrentGuildId(String guildID, int customMessageID) {
        String targetGuildID = clientCache.getCustomMessageByID(customMessageID).getGuildID();
        return Objects.equals(guildID, targetGuildID);
    }


    private boolean areArgumentsValid(String[] args) {
        if (args.length < 2) return true;

        try {
            Integer.parseInt(args[2]);
            return true;
        } catch (NumberFormatException ignored) {}

        return false;
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }

    private void deleteCustomMessage(int customMessageID) {
        clientCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
    }
}
