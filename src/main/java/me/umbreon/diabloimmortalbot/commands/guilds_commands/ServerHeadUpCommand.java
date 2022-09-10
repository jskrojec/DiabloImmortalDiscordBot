package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Command: >server headup on/off
 */
public class ServerHeadUpCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ServerHeadUpCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runServerHeadUpCommand(final String[] args, final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args))
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        
        if (clientCache.isHeadUpOnServerEnabled(guildID) && BooleanAssistant.isValueTrue(args[2]))
            return LanguageController.getHeadUpMessagesAlreadyOnMessage(guildLanguage);

        if (!clientCache.isHeadUpOnServerEnabled(guildID) && BooleanAssistant.isValueFalse(args[2]))
            return LanguageController.getHeadUpMessagesAlreadyOffMessages(guildLanguage);

        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventHeadUpOnServerValue(guildID, true);
            return String.format(LanguageController.getEventEnabledMessage(guildLanguage), "Head up");
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventHeadUpOnServerValue(guildID, false);
            return String.format(LanguageController.getEventDisabledMessage(guildLanguage), "Head up");
        }

        return LanguageController.getInvalidCommandMessage(guildLanguage);
    }

    private boolean areArgumentsValid(final String[] args) {
        return args.length == 3;
    }

    private void setEventHeadUpOnServerValue(final String guildID, final boolean value) {
        databaseRequests.setEventHeadUpOnServerValue(value, guildID);
        clientCache.setHeadUpOnServerValue(guildID, value);
    }
}
