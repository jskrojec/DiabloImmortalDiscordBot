package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

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

        if (isHeadUpTime(timezone) && clientCache.getHeadUpValue(guildID)) {
            return LanguageController.getBattlegroundHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getBattlegroundMessage(language) + "\n";
        }
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
