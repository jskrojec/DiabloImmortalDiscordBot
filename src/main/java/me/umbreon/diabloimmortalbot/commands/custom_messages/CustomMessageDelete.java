package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Objects;

public class CustomMessageDelete {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessageDelete(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runCustomMessageDelete(final String[] args, final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args))
            return LanguageController.getInvalidCommandMessage(guildLanguage);

        final int customMessageID = Integer.parseInt(args[2]);
        if (!isCustomMessageGuildIdCurrentGuildId(guildID, customMessageID))
            return null;

        deleteCustomMessage(customMessageID);
        return String.format(LanguageController.getCustomMessageWithIdDeleted(guildLanguage), customMessageID);
    }

    private boolean isCustomMessageGuildIdCurrentGuildId(final String guildID, final int customMessageID) {
        final String targetGuildID = clientCache.getCustomMessageByID(customMessageID).getGuildID();
        return Objects.equals(guildID, targetGuildID);
    }


    private boolean areArgumentsValid(final String[] args) {
        if (args.length < 2) return true;

        try {
            Integer.parseInt(args[2]);
            return true;
        } catch (final NumberFormatException ignored) {
        }

        return false;
    }

    private void deleteCustomMessage(final int customMessageID) {
        clientCache.deleteCustomMessageByID(customMessageID);
        databaseRequests.deleteCustomMessageEntry(customMessageID);
    }
}
