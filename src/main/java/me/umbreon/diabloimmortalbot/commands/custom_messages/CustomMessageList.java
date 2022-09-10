package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.List;

/**
 * Command: >cm list
 */
public class CustomMessageList {

    private final ClientCache clientCache;

    public CustomMessageList(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runCustomMessageList(final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();

        final List<CustomMessage> customMessageList = clientCache.getAllCustomMessagesByGuildID(guildID);
        final String language = clientCache.getGuildLanguage(guildID);
        if (customMessageList.size() == 0) {
            textChannel.sendMessage(LanguageController.getNoCustomMessagesMessage(language)).queue();
            return;
        }

        final MessageEmbed messageEmbed = buildCustomMessagesListEmbed(customMessageList, language);
        textChannel.sendMessageEmbeds(messageEmbed).queue();
    }

    private MessageEmbed buildCustomMessagesListEmbed(final List<CustomMessage> customMessageList, final String language) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setTitle(LanguageController.getShowAllCustomMessages(language));

        customMessageList.forEach(customMessage -> {
            final String customMessageID = "ID: " + customMessage.getCustomMessageID();
            final String s = "Channel: <#" + customMessage.getChannelID() + ">\n" +
                    "Message: " + customMessage.getMessage() + "\n" +
                    "Time: " + customMessage.getDay() + " " + customMessage.getTime() + "\n";
            embedBuilder.addField(customMessageID, s, true);
        });

        return embedBuilder.build();
    }
}
