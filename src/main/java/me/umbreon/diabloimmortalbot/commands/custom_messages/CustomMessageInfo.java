package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /custommessageinfo <ID>
 */
public class CustomMessageInfo {

    private final ClientCache clientCache;

    public CustomMessageInfo(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public MessageEmbed runCustomMessageInfoCommand(final String[] args) {
        return buildCustomMessageInfoEmbed(Integer.parseInt(args[1]));
    }

    private MessageEmbed buildCustomMessageInfoEmbed(final int customMessageID) {
        final CustomMessage customMessage = clientCache.getCustomMessageByID(customMessageID);
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.ORANGE);
        final String textChannelMention = "<#" + customMessage.getChannelID() + ">";
        final String time = customMessage.getDay() + " " + customMessage.getTime();
        embedBuilder.addField("TextChannel:", textChannelMention, true);
        embedBuilder.addField("Message:", customMessage.getMessage(), true);
        embedBuilder.addField("Time:", time, true);
        embedBuilder.addField("Repeating:", String.valueOf(customMessage.isRepeat()), true);
        return embedBuilder.build();
    }

}
