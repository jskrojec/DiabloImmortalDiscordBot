package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.cache.CustomMessagesCache;
import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /custommessageinfo <ID>
 */
public class CustomMessageInfo {

    private final CustomMessagesCache customMessagesCache;

    private final Logger LOGGER = LoggerFactory.getLogger(CustomMessageInfo.class);

    public CustomMessageInfo(CustomMessagesCache customMessagesCache) {
        this.customMessagesCache = customMessagesCache;
    }

    public void runCustomMessageInfoCommand(final SlashCommandInteractionEvent event) {
        OptionMapping customMessageIdOption = event.getOption("custommessageid");

        String guildID = event.getGuild().getId();
        String textChannelID = event.getTextChannel().getId();

        int customMessageID;
        if (customMessageIdOption != null) {
            customMessageID = customMessageIdOption.getAsInt();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to get custom message information but it failed because ID was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            return;
        }

        event.replyEmbeds(buildCustomMessageInfoEmbed(customMessageID)).setEphemeral(true).queue();
    }

    private MessageEmbed buildCustomMessageInfoEmbed(final int customMessageID) {
        CustomMessage customMessage = customMessagesCache.getCustomMessageByID(customMessageID);
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.ORANGE);
        String textChannelMention = "<#" + customMessage.getChannelID() + ">";
        String time = customMessage.getDay() + " " + customMessage.getTime();
        embedBuilder.addField("TextChannel:", textChannelMention, true);
        embedBuilder.addField("Message:", customMessage.getMessage(), true);
        embedBuilder.addField("Time:", time, true);
        embedBuilder.addField("Repeating:", String.valueOf(customMessage.isRepeat()), true);
        return embedBuilder.build();
    }

}
