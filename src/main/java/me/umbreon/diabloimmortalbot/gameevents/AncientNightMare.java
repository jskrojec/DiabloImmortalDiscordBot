package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class AncientNightMare {

    private final Map<String, Boolean> listAncientNightMare;

    public AncientNightMare(DatabaseRequests databaseRequests) {
        listAncientNightMare = databaseRequests.getEventTimes("event_ancient_nightmare", false);
    }

    public String checkAncientNightMare(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAncientNightmareHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getAncientNightmareMessage("ENG") + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientNightMare.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientNightMare.get(time);
    }

}
