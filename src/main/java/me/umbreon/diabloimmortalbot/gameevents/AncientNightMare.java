package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Class for the Diablo Immortal event Ancient Nightmare. Overworld event.
 * Times: Wednesday & Friday at 12:00 PM, 8:30 PM & 10:00 PM
 */
public class AncientNightMare {

    private final NotificationChannelsCache notificationChannelsCache;
    private final GuildsCache guildsCache;
    private final GameEventsCache gameEventsCache;

    public AncientNightMare(final NotificationChannelsCache notificationChannelsCache, final GuildsCache guildsCache, final GameEventsCache gameEventsCache) {
        this.notificationChannelsCache = notificationChannelsCache;
        this.guildsCache = guildsCache;
        this.gameEventsCache = gameEventsCache;
    }

    public String checkOnAncientNightMareEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!notificationChannelsCache.isAncientNightmareMessageEnabled(textChannelID)) {
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
        return guildsCache.isEventMessageOnServerEnabled(guildID) || notificationChannelsCache.isEventMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpEnabled(final String guildID, final String textChannelID) {
        return guildsCache.isHeadUpOnServerEnabled(guildID) && notificationChannelsCache.isHeadUpMessageOnChannelEnabled(textChannelID);
    }

    private boolean isTimeValid(final String timezone) {
        final String time = TimeUtils.getTimeWithWeekday(timezone);
        return gameEventsCache.getListWithAncientNightmareTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeUtils.getTimeWithWeekday(timezone);
        return gameEventsCache.getListWithAncientNightmareTimes().get(time);
    }

}
