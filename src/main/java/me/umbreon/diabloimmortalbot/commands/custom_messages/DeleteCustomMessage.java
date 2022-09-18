package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Objects;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /deletecustommessage <ID>
 */
public class DeleteCustomMessage {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public DeleteCustomMessage(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runDeleteCustomMessage(final SlashCommandInteractionEvent event) {
        OptionMapping customMessageIdOption = event.getOption("custommessageid");

        String guildID = event.getGuild().getId();
        String textChannelID = event.getTextChannel().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

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
        if (clientCache.getCustomMessageByID(customMessageID) == null) {
            return false;
        }
        String targetGuildID = clientCache.getCustomMessageByID(customMessageID).getGuildID();
        return Objects.equals(guildID, targetGuildID);
    }

    private void deleteCustomMessage(final int customMessageID) {
        clientCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
    }

}
