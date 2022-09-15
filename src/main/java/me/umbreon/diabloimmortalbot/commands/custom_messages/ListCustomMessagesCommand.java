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
 * @author Umbreon Majora
 * <p>
 * Command: /listcustommessaages
 */
public class ListCustomMessagesCommand {

    private final ClientCache clientCache;

    public ListCustomMessagesCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public MessageEmbed runListCustomMessages(final TextChannel textChannel) {
        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);

        List<CustomMessage> customMessageList = clientCache.getAllCustomMessagesByGuildID(guildID);

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setTitle(LanguageController.getShowAllCustomMessages(language));

        if (customMessageList.size() == 0) {
            embedBuilder.addField(LanguageController.getNoCustomMessagesMessage(language), "", true);
            return embedBuilder.build();
        }

        customMessageList.forEach(customMessage -> {
                String customMessageID = "ID: " + customMessage.getCustomMessageID();
            String s = "Channel: <#" + customMessage.getChannelID() + ">\n" +
                    "Message: " + customMessage.getMessage() + "\n" +
                    "Time: " + customMessage.getDay() + " " + customMessage.getTime() + "\n";
            embedBuilder.addField(customMessageID, s, true);
        });

        return embedBuilder.build();
    }
}
