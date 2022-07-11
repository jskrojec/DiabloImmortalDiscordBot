package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class HauntedCarriage {

    private final Map<String, Boolean> listHauntedCarriage;

    public HauntedCarriage(DatabaseRequests databaseRequests) {
        this.listHauntedCarriage = databaseRequests.getEventTimes("event_haunted_carriage", false);
    }

    public String checkHauntedCarriage(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getHauntedCarriageHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getHauntedCarriageMessage("ENG") + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listHauntedCarriage.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listHauntedCarriage.get(time);
    }

}
