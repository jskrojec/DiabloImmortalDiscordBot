package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class RaidVault {

    private final ClientCache clientCache;

    public RaidVault(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkVault(String timezone, String language, String guildID, String textChannelID) {
        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isRaidVaultMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getRaidTheVaultHeadUpMessage(language) + "\n";

        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getRaidTheVaultMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithVaultTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithVaultTimes().get(time);
    }

}
