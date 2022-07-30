package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class Battleground {

    private final Map<String, Boolean> listBattleground;
    private final ClientCache clientCache;

    public Battleground(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listBattleground = databaseRequests.getEventTimes("event_battleground", true);
        this.clientCache = clientCache;
    }

    public String checkBattleground(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (!clientCache.isBattlegroundsNotificationsEnabled(guildID)) return "";

        if (isHeadUpTime(timezone)) {
            if (clientCache.getHeadUpValue(guildID)) {
                return LanguageController.getBattlegroundHeadUpMessage(language) + "\n";
            }
        } else {
            if (clientCache.isEventMessageEnabled(guildID))
            return LanguageController.getBattlegroundMessage(language) + "\n";
        }
        return "";
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTime(timezone);
        return listBattleground.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTime(timezone);
        return listBattleground.get(time);
    }

}
