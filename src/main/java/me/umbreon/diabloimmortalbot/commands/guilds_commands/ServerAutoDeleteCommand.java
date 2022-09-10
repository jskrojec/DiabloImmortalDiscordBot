package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

public class ServerAutoDeleteCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ServerAutoDeleteCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runServerAutoDeleteCommand(final String[] args, final TextChannel textChannel) {
        final String value = args[2];
        final String guildID = textChannel.getGuild().getId();
        final String guildLanugage = clientCache.getGuildLanguage(guildID);

        if (BooleanAssistant.isValueTrue(value)) {
            setAutoDeleteValue(guildID, true);
            return LanguageController.getAutoDeleteEnabledMessage(guildLanugage);
        }

        if (BooleanAssistant.isValueFalse(value)) {
            setAutoDeleteValue(guildID, false);
            return LanguageController.getAutoDeleteDisabledMessage(guildLanugage);
        }

        final int autoDeleteValue;
        try {
            autoDeleteValue = Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            return LanguageController.getInvalidCommandMessage(guildLanugage);
        }

        if (isAutoSaveValueValid(autoDeleteValue)) {
            setAutoDeleteValue(guildID, autoDeleteValue);
            return String.format(LanguageController.getAutoDeleteValueSetMessage(guildLanugage), autoDeleteValue);
        }

        return LanguageController.getInvalidCommandMessage(guildLanugage);
    }

    private void setAutoDeleteValue(final String guildID, final int autoDeleteValue) {
        clientCache.setAutoDeleteIntValue(guildID, autoDeleteValue);
        databaseRequests.setAutoDeleteValue(guildID, autoDeleteValue);
    }

    private void setAutoDeleteValue(final String guildID, final boolean value) {
        clientCache.setAutoDeleteBoolValue(guildID, value);
        databaseRequests.setAutoDeleteEnabled(guildID, value);
    }

    private boolean isAutoSaveValueValid(final int autoSaveValue) {
        return (autoSaveValue == 24 || autoSaveValue == 48 || autoSaveValue == 72);
    }
}
