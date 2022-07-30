package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.List;

/**
 * Command: >cm list
 */
public class CustomMessageList {

    private final ClientCache clientCache;

    public CustomMessageList(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runCustomMessageList(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();

        List<CustomMessage> customMessageList = clientCache.getAllCustomMessagesByGuildID(guildID);
        String language = clientCache.getLanguage(guildID);
        if (customMessageList.size() == 0) {
            textChannel.sendMessage(LanguageController.getNoCustomMessagesMessage(language)).queue();
            return;
        }

        MessageEmbed messageEmbed = buildCustomMessagesListEmbed(customMessageList, language);
        textChannel.sendMessageEmbeds(messageEmbed).queue();
    }

    private MessageEmbed buildCustomMessagesListEmbed(List<CustomMessage> customMessageList, String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setTitle(LanguageController.getYourCustomMessagesMessage(language));

        customMessageList.forEach(customMessage -> {
            String customMessageMessage;

            if (customMessage.getMessage().length() > 15) {
                customMessageMessage = customMessage.getMessage().substring(0, 15);
            } else {
                customMessageMessage = customMessage.getMessage();
            }

            String ID = "ID: " + customMessage.getCustomMessageID();
            embedBuilder.addField(ID, customMessageMessage, false);
        });

        return embedBuilder.build();
    }
}
