package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Class for the Diablo Immortal event Demon Gates. Overworld event.
 * Times: Monday, Thursday & Sunday at 12:00 PM, 8:30 PM & 10:00 PM
 */
public class DemonGates {

    private final ClientCache clientCache;

    public DemonGates(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkOnDemonGatesEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!clientCache.isDemonGatesMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getDemonGatesHeadUpMessage(language));
            return LanguageController.getDemonGatesHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getDemonGatesMessage(language));
            return LanguageController.getDemonGatesMessage(language) + "\n";
        }
    }

    private boolean isEventMessageEnabled(final String guildID, final String textChannelID) {
        return clientCache.isEventMessageOnServerEnabled(guildID) || clientCache.isEventMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpEnabled(final String guildID, final String textChannelID) {
        return clientCache.isHeadUpOnServerEnabled(guildID) && clientCache.isHeadUpMessageOnChannelEnabled(textChannelID);
    }

    private boolean isTimeValid(final String timezone) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithDemonGatesTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithDemonGatesTimes().get(time);
    }
}
