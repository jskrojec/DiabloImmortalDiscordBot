package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

/**
 * @author Umbreon Majora
 * <p>
 * Description: Class for the Diablo Immortal event Defend The Vault. Immortal event.
 * Times: Every day at 12:00 PM and 7:00 PM
 */
public class DefendVault {

    private final ClientCache clientCache;

    public DefendVault(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkOnDefendVaultEvent(final String timezone, final String language, final String guildID, final String textChannelID) {
        if (!isTimeValid(timezone)) {
            return "";
        }

        if (!clientCache.isDefendVaultMessageEnabled(textChannelID)) {
            return "";
        }

        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getDefendTheVaultHeadUpMessage(language));
            return LanguageController.getDefendTheVaultHeadUpMessage(language) + "\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, LanguageController.getDefendTheVaultMessage(language));
            return LanguageController.getDefendTheVaultMessage(language) + "\n";
        }
    }

    private boolean isEventMessageEnabled(final String guildID, final String textChannelID) {
        return clientCache.isEventMessageOnServerEnabled(guildID) || clientCache.isEventMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpEnabled(final String guildID, final String textChannelID) {
        return clientCache.isHeadUpOnServerEnabled(guildID) && clientCache.isHeadUpMessageOnChannelEnabled(textChannelID);
    }

    private boolean isTimeValid(final String timezone) {
        final String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithVaultTimes().get(time) != null;
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithVaultTimes().get(time);
    }

}
