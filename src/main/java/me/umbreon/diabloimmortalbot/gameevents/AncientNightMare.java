package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class AncientNightMare {

    private final ClientCache clientCache;

    public AncientNightMare(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkAncientNightMare(String timezone, String language, String guildID, String textChannelID) {
        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isAncientNightmareMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getAncientNightmareHeadUpMessage(language) + "\n";
        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getAncientNightmareMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithAncientNightmareTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithAncientNightmareTimes().get(time);
    }
}
