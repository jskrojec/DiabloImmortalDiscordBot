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

/**
 * Command: >cm delete ID
 */
public class CustomMessageDelete {

    private final ClientCache clientCache;
    private MessageEmbed invalidCommandUsageEmbed;
    private final DatabaseRequests databaseRequests;

    public CustomMessageDelete(ClientCache clientCache, DatabaseRequests databaseRequests){
        this.clientCache = clientCache;
        buildInvalidCommandUsageEmbed();
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessageDelete(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();

        if (!areArgumentsValid(args)) {
            textChannel.sendMessageEmbeds(invalidCommandUsageEmbed).queue();
            return;
        }

        int customMessageID = Integer.parseInt(args[2]);

        String s = clientCache.getCustomMessageByID(customMessageID).getGuildID();
        String s1 = message.getGuild().getId();

        if (!Objects.equals(s1, s)) return;

        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);
        clientCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
        textChannel.sendMessage(String.format(LanguageController.getCustomMessageWithIdDeleted(language), customMessageID)).queue();
    }

    private void buildInvalidCommandUsageEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.RED);
        embedBuilder.addField("Invalid command", "Command example: >cm create #YOUR_TEXTCHANNEL " +
                "Tuesday 16:30 Yes Here's your custom message.", false);
        this.invalidCommandUsageEmbed = embedBuilder.build();
    }

    private boolean areArgumentsValid(String[] args) {
        if (args.length < 2) {
            return true;
        }

        try {
            Integer.parseInt(args[2]);
            return true;
        } catch (NumberFormatException ignored) {}

        return false;
    }
}
