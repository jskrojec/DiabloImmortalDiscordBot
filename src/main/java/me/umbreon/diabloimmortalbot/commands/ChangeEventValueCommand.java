package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * @author Umbreon Majora
 * <p>
 * Command example: /event <game_event> ON/OFF
 * Description: Allows the user to enable or disable each event for the channel the command is sent in.
 */
public class ChangeEventValueCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ChangeEventValueCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runChangeEventValueCommand(final String[] args, final TextChannel textChannel) {
        final String selectedEvent = args[1].toLowerCase();
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            return null;
        }

        if (!doEventExist(selectedEvent)) {
            return LanguageController.getErrorCannotDisableEventMessage(guildLanguage);
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventValue(true, selectedEvent, textChannel.getId());
            return String.format(LanguageController.getEventEnabledMessage(guildLanguage), selectedEvent);
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventValue(false, selectedEvent, textChannel.getId());
            return String.format(LanguageController.getEventDisabledMessage(guildLanguage), selectedEvent);
        }

        return LanguageController.getInvalidCommandMessage(guildLanguage);
    }

    private boolean areArgumentsValid(final String[] args) {
        return args.length == 3;
    }

    private boolean doEventExist(final String event) {
        return clientCache.getListWithAvailableNotifications().contains(event);
    }

    private void setEventValue(final boolean value, final String event, final String textChannelID) {
        databaseRequests.updateNotifierChannelEventMessage(event, textChannelID, value);
        clientCache.setNotificationsValue(event, value, textChannelID);
    }

}
