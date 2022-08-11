package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class AncientArena {

    private final ClientCache clientCache;

    public AncientArena(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkAncientArea(String timezone, String language, String guildID, String textChannelID) {
        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isAncientArenaMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getAncientArenaHeadUpMessage(language) + "\n";
        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getAncientArenaMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithAncientAreaTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        return clientCache.getListWithAncientAreaTimes().get(time);
    }
}
