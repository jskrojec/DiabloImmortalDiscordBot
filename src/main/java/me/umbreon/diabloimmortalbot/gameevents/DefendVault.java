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
 * Description: Class for the Diablo Immortal event Defend The Vault. Immortal event.
 * Times: Every day at 12:00 PM and 7:00 PM
 */
public class DefendVault {

    private final NotificationChannelsCache notificationChannelsCache;
    private final GuildsCache guildsCache;
    private final GameEventsCache gameEventsCache;

    public DefendVault(final NotificationChannelsCache notificationChannelsCache, final GuildsCache guildsCache, final GameEventsCache gameEventsCache) {
        this.notificationChannelsCache = notificationChannelsCache;
        this.guildsCache = guildsCache;
        this.gameEventsCache = gameEventsCache;
    }

    public String checkOnDefendVaultEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!notificationChannelsCache.isDefendVaultMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, LanguageController.getDefendTheVaultHeadUpMessage(language));
            return LanguageController.getDefendTheVaultHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, LanguageController.getDefendTheVaultMessage(language));
            return LanguageController.getDefendTheVaultMessage(language) + "\n";
        }
    }

    private boolean isEventMessageEnabled(final String guildID, final String textChannelID) {
        return guildsCache.isEventMessageOnServerEnabled(guildID) || notificationChannelsCache.isEventMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpEnabled(final String guildID, final String textChannelID) {
        return guildsCache.isHeadUpOnServerEnabled(guildID) && notificationChannelsCache.isHeadUpMessageOnChannelEnabled(textChannelID);
    }

    private boolean isTimeValid(final String timezone) {
        final String time = TimeUtils.getTime(timezone);
        return gameEventsCache.getListWithVaultTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeUtils.getTime(timezone);
        return gameEventsCache.getListWithVaultTimes().get(time);
    }

}
