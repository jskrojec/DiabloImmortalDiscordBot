package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Class for the Diablo Immortal event Ancient Arena. Overworld event.
 * Times: Tuesday 9:30 PM, Thursday 9:30 PM, Friday 9:30 PM & Saturday 9:30 PM
 */
public class AncientArena {

    private final NotificationChannelsCache notificationChannelsCache;
    private final GuildsCache guildsCache;
    private final GameEventsCache gameEventsCache;

    public AncientArena(final NotificationChannelsCache notificationChannelsCache, final GuildsCache guildsCache, final GameEventsCache gameEventsCache) {
        this.notificationChannelsCache = notificationChannelsCache;
        this.guildsCache = guildsCache;
        this.gameEventsCache = gameEventsCache;
    }

    public String checkOnAncientAreaEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!notificationChannelsCache.isAncientArenaMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getAncientArenaHeadUpMessage(language));
            return LanguageController.getAncientArenaHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getAncientArenaMessage(language));
            return LanguageController.getAncientArenaMessage(language) + "\n";
        }
    }

    private boolean isEventMessageEnabled(final String guildID, final String textChannelID) {
        return guildsCache.isEventMessageOnServerEnabled(guildID) || notificationChannelsCache.isEventMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpEnabled(final String guildID, final String textChannelID) {
        return guildsCache.isHeadUpOnServerEnabled(guildID) && notificationChannelsCache.isHeadUpMessageOnChannelEnabled(textChannelID);
    }

    private boolean isTimeValid(final String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return gameEventsCache.getListWithAncientAreaTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return gameEventsCache.getListWithAncientAreaTimes().get(time);
    }

}
