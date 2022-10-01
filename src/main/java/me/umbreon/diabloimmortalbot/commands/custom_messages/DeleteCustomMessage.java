package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.cache.CustomMessagesCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /deletecustommessage <ID>
 */
public class DeleteCustomMessage {

    private final DatabaseRequests databaseRequests;
    private final GuildsCache guildsCache;
    private final CustomMessagesCache customMessagesCache;

    private final Logger LOGGER = LoggerFactory.getLogger(DeleteCustomMessage.class);

    public DeleteCustomMessage(final DatabaseRequests databaseRequests, GuildsCache guildsCache, CustomMessagesCache customMessagesCache) {
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
        this.customMessagesCache = customMessagesCache;
    }

    public void runDeleteCustomMessage(final SlashCommandInteractionEvent event) {
        OptionMapping customMessageIdOption = event.getOption("custommessageid");

        String guildID = event.getGuild().getId();
        String textChannelID = event.getTextChannel().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);

        int customMessageID;
        if (customMessageIdOption != null) {
            customMessageID = customMessageIdOption.getAsInt();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to get custom message information but it failed because ID was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!isCustomMessageGuildIdCurrentGuildId(guildID, customMessageID)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to get custom message information but it failed because guildID did not match!";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
        }

        deleteCustomMessage(customMessageID);
        event.reply(String.format(LanguageController.getCustomMessageWithIdDeleted(guildLanguage), customMessageID)).setEphemeral(true).queue();
    }

    private boolean isCustomMessageGuildIdCurrentGuildId(final String guildID, final int customMessageID) {
        //Todo: Add a sperate error message, like "Custom Message with ID <ID> does not exists.
        if (customMessagesCache.getCustomMessageByID(customMessageID) == null) {
            return false;
        }
        String targetGuildID = customMessagesCache.getCustomMessageByID(customMessageID).getGuildID();
        return Objects.equals(guildID, targetGuildID);
    }

    private void deleteCustomMessage(final int customMessageID) {
        customMessagesCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
    }

}
