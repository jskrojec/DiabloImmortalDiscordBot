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

    public String checkAssembly(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAssemblyHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getAssemblyMessage(language) + "\n";
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
