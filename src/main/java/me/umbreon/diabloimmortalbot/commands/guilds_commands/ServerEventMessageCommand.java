package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

public class ServerEventMessageCommand {

    public ClientCache clientCache;
    public DatabaseRequests databaseRequests;

    public ServerEventMessageCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runServerEventMessageCommand(final String[] args, final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        if (clientCache.isEventMessageOnServerEnabled(guildID) && BooleanAssistant.isValueTrue(args[2])) {
            return LanguageController.getEventMessagesAlreadyOnMessage(guildLanguage);
        }

        if (!clientCache.isEventMessageOnServerEnabled(guildID) && BooleanAssistant.isValueFalse(args[2])) {
            return LanguageController.getEventMessagesAlreadyOffMessage(guildLanguage);
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventMessageOnServerValue(guildID, true);
            return String.format(LanguageController.getEventEnabledMessage(guildLanguage), "Event messages");
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventMessageOnServerValue(guildID, false);
            return String.format(LanguageController.getEventDisabledMessage(guildLanguage), "Event messages");
        }

        return LanguageController.getInvalidCommandMessage(guildLanguage);
    }

    private boolean areArgumentsValid(final String[] args) {
        return args.length == 3;
    }

    private void setEventMessageOnServerValue(final String guildID, final boolean value) {
        databaseRequests.setEventMessageOnServerValue(value, guildID);
        clientCache.setEventMessageOnServerValue(guildID, value);
    }
}
