package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class DemonGates {

    private final ClientCache clientCache;

    public DemonGates(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkDemonGates(String timezone, String language, String guildID, String textChannelID) {
        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isDemonGatesMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getDemonGatesHeadUpMessage(language) + "\n";

        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getDemonGatesMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithDemonGatesTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithDemonGatesTimes().get(time);
    }
}
