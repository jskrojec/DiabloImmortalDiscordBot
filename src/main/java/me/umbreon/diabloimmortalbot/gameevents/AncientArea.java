package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class AncientArea {

    private final Map<String, Boolean> listAncientArea;

    public AncientArea(DatabaseRequests databaseRequests) {
        this.listAncientArea = databaseRequests.getEventTimes("event_ancient_area", false);
    }

    public String checkAncientArea(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAncientArenaHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getAncientArenaMessage("ENG") + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientArea.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientArea.get(time);
    }

}
