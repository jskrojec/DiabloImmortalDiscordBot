package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Objects;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /deletecustommessage <ID>
 */
public class DeleteCustomMessage {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public DeleteCustomMessage(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runDeleteCustomMessage(final String[] args, final TextChannel textChannel) {
        String guildID = textChannel.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!isCommandValid(args)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        int customMessageID = Integer.parseInt(args[1]);
        if (!isCustomMessageGuildIdCurrentGuildId(guildID, customMessageID)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        deleteCustomMessage(customMessageID);
        return String.format(LanguageController.getCustomMessageWithIdDeleted(guildLanguage), customMessageID);
    }

    private boolean isCustomMessageGuildIdCurrentGuildId(final String guildID, final int customMessageID) {
        //Todo: Add a sperate error message, like "Custom Message with ID <ID> does not exists.
        if (clientCache.getCustomMessageByID(customMessageID) == null) {
            return false;
        }
        String targetGuildID = clientCache.getCustomMessageByID(customMessageID).getGuildID();
        return Objects.equals(guildID, targetGuildID);
    }

    private boolean isCommandValid(final String[] args) {
        if (args.length != 2) {
            return false;
        }

        try {
            Integer.parseInt(args[1]);
            return true;
        } catch (final NumberFormatException ignored) {
            return false;
        }
    }

    private void deleteCustomMessage(final int customMessageID) {
        clientCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
    }

}
