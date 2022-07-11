package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class DemonGates {

    private final Map<String, Boolean> listDemonGates;

    public DemonGates(DatabaseRequests databaseRequests) {
        this.listDemonGates = databaseRequests.getEventTimes("event_demon_gates", false);
    }

    public String checkDemonGates(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getDemonGatesHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getDemonGatesMessage("ENG") + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listDemonGates.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listDemonGates.get(time);
    }
}
