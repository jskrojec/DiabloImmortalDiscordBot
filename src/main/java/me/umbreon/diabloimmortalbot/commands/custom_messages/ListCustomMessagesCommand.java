package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;
import java.util.List;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /listcustommessaages
 * Description: List's all custom messages of the guild.
 */
public class ListCustomMessagesCommand {

    private final ClientCache clientCache;

    public ListCustomMessagesCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runListCustomMessages(final SlashCommandInteractionEvent event) {
        String guildID = event.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);

        List<CustomMessage> customMessageList = clientCache.getAllCustomMessagesByGuildID(guildID);

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setTitle(LanguageController.getShowAllCustomMessages(language));

        if (customMessageList.size() == 0) {
            embedBuilder.addField(LanguageController.getNoCustomMessagesMessage(language), "", true);
            event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
            return;
        }

        customMessageList.forEach(customMessage -> {
            String customMessageID = "ID: " + customMessage.getCustomMessageID();
            String s = "Channel: <#" + customMessage.getChannelID() + ">\n" +
                    "Message: " + customMessage.getMessage() + "\n" +
                    "Time: " + customMessage.getDay() + " " + customMessage.getTime() + "\n";
            embedBuilder.addField(customMessageID, s, true);
        });

        event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
    }
}
