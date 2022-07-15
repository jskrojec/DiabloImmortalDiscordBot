package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class ShadowLottery {

    private final Map<String, Boolean> listShadowLottery;

    public ShadowLottery(DatabaseRequests databaseRequests) {
        this.listShadowLottery = databaseRequests.getEventTimes("event_shadow_lottery", true);
    }

    public String checkShadowLottery(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getShadowLotteryHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getShadowLotteryMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listShadowLottery.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listShadowLottery.get(time);
    }

}
