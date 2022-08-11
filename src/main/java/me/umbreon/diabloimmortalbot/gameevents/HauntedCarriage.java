package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class HauntedCarriage {

    private final ClientCache clientCache;

    public HauntedCarriage(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkHauntedCarriage(String timezone, String language, String guildID, String textChannelID) {

        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isHauntedCarriageMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getHauntedCarriageHeadUpMessage(language) + "\n";

        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)){
                return "";
            }

            return LanguageController.getHauntedCarriageMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithHauntedCarriageTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithHauntedCarriageTimes().get(time);
    }

}
