package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class Assembly {

    private final Map<String, Boolean> listAssembly;
    private final ClientCache clientCache;

    public Assembly(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listAssembly = databaseRequests.getEventTimes("event_assembly", false);
        this.clientCache = clientCache;
    }

    public String checkAssembly(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            if (clientCache.getHeadUpValue(guildID)) {
                return LanguageController.getAssemblyHeadUpMessage(language) + "\n";
            }
        } else {
            return LanguageController.getAssemblyMessage(language) + "\n";
        }
        return "";
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
