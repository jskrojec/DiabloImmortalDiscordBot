package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Class for the Diablo Immortal event Ancient Nightmare. Overworld event.
 * Times: Wednesday & Friday at 12:00 PM, 8:30 PM & 10:00 PM
 */
public class AncientNightMare {

    private final ClientCache clientCache;

    public AncientNightMare(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkOnAncientNightMareEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!clientCache.isAncientNightmareMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getAncientNightmareHeadUpMessage(language));
            return LanguageController.getAncientNightmareHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getAncientNightmareMessage(language));
            return LanguageController.getAncientNightmareMessage(language) + "\n";
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
        return clientCache.getListWithAncientNightmareTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithAncientNightmareTimes().get(time);
    }

}
