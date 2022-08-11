package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class Battleground {

    private final ClientCache clientCache;

    public Battleground(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkBattleground(String timezone, String language, String guildID, String textChannelID) {
        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isBattlegroundMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getBattlegroundHeadUpMessage(language) + "\n";

        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getBattlegroundMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithBattlegroundTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithBattlegroundTimes().get(time);
    }
}
