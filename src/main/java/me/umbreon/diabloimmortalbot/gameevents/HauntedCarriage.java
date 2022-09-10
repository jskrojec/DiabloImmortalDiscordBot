package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Class for the Diablo Immortal event Demon Gates. Overworld event.
 * Times: Tuesday & Saturday at 12:00 PM, 8:30 PM & 10:00 PM
 */
public class HauntedCarriage {

    private final ClientCache clientCache;

    public HauntedCarriage(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkOnHauntedCarriageEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!clientCache.isHauntedCarriageMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getHauntedCarriageHeadUpMessage(language));
            return LanguageController.getHauntedCarriageHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getHauntedCarriageMessage(language));
            return LanguageController.getHauntedCarriageMessage(language) + "\n";
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
        return clientCache.getListWithHauntedCarriageTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithHauntedCarriageTimes().get(time);
    }

}
