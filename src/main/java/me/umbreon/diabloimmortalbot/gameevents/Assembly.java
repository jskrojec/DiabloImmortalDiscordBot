package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class Assembly {

    private final Map<String, Boolean> listAssembly;

    public Assembly(DatabaseRequests databaseRequests) {
        this.listAssembly = databaseRequests.getEventTimes("event_assembly", false);
    }

    public String checkAssembly(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAssemblyHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getAssemblyMessage("ENG") + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAssembly.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAssembly.get(time);
    }

}
