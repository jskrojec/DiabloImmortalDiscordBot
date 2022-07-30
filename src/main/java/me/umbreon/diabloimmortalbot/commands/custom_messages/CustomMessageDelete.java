package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

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
        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getLanguage(guildID);
        clientCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
        textChannel.sendMessageEmbeds(buildCustomMessageDeletedEmbed(customMessageID, language)).queue();
    }

    private MessageEmbed buildCustomMessageDeletedEmbed(int customMessageID, String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.GRAY);
        embedBuilder.addField(LanguageController.getCustomMessageDeletedMessage(language), String.format(LanguageController.getCustomMessageWithIdDeleted(language), customMessageID), false);

        return embedBuilder.build();
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

        if (args[1].equalsIgnoreCase("delete")) {
            return true;
        }

        try {
            Integer.parseInt(args[2]);
            return true;
        } catch (NumberFormatException ignored) {
        }


        return false;
    }
}
