package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

public class ShadowLottery {

    private final ClientCache clientCache;

    public ShadowLottery(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String checkShadowLottery(String timezone, String language, String guildID, String textChannelID) {

        if (!isTimeValid(timezone)) return "";
        if (!clientCache.isShadowLotteryMessageEnabled(textChannelID)) return "";

        if (isHeadUpTime(timezone)) {
            if (!clientCache.isHeadUpOnServerEnabled(guildID) || !clientCache.isHeadUpMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getShadowLotteryHeadUpMessage(language) + "\n";

        } else {
            if (!clientCache.isEventMessageOnServerEnabled(guildID) || !clientCache.isEventMessageOnChannelEnabled(textChannelID)) {
                return "";
            }

            return LanguageController.getShadowLotteryMessage(language) + "\n";

        }
    }

    private boolean isTimeValid(String timezone) {
        String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithShadowLotteryTimes().get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = TimeAssistant.getTime(timezone);
        return clientCache.getListWithShadowLotteryTimes().get(time);
    }

}
