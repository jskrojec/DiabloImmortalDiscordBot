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
 * Description: Class for the Diablo Immortal Assembly. Shadow clan event.
 * Times: Monday through Saturday at 6:00 PM.
 */
public class Assembly {

    private final NotificationChannelsCache notificationChannelsCache;
    private final GuildsCache guildsCache;
    private final GameEventsCache gameEventsCache;

    public Assembly(final NotificationChannelsCache notificationChannelsCache, final GuildsCache guildsCache, final GameEventsCache gameEventsCache) {
        this.notificationChannelsCache = notificationChannelsCache;
        this.guildsCache = guildsCache;
        this.gameEventsCache = gameEventsCache;
    }

    public String checkOnAssemblyEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!notificationChannelsCache.isAssemblyMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, LanguageController.getAssemblyHeadUpMessage(language));
            return LanguageController.getAssemblyHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, LanguageController.getAssemblyMessage(language));
            return LanguageController.getAssemblyMessage(language) + "\n";
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
        return gameEventsCache.getListWithAssemblyTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeUtils.getTimeWithWeekday(timezone);
        return gameEventsCache.getListWithAssemblyTimes().get(time);
    }

}