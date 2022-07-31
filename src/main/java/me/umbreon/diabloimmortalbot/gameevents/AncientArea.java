package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class AncientArea {

    private final Map<String, Boolean> listAncientArea;
    private final ClientCache clientCache;

    public AncientArea(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listAncientArea = databaseRequests.getEventTimes("event_ancient_area", false);
        this.clientCache = clientCache;
    }

    public String checkAncientArea(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            if (clientCache.getHeadUpValue(guildID))
                return LanguageController.getAncientArenaHeadUpMessage(language) + "\n";
        } else {
            if (clientCache.isEventMessageEnabled(guildID))
                return LanguageController.getAncientArenaMessage(language) + "\n";
        }
        return "";
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
