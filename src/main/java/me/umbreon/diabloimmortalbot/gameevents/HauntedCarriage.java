package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class HauntedCarriage {

    private final Map<String, Boolean> listHauntedCarriage;
    private final ClientCache clientCache;

    public HauntedCarriage(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listHauntedCarriage = databaseRequests.getEventTimes("event_haunted_carriage", false);
        this.clientCache = clientCache;
    }

    public String checkHauntedCarriage(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            if (clientCache.getHeadUpValue(guildID)) {
                return LanguageController.getHauntedCarriageHeadUpMessage(language) + "\n";
            }
        } else {
            return LanguageController.getHauntedCarriageMessage(language) + "\n";
        }
        return null;
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
