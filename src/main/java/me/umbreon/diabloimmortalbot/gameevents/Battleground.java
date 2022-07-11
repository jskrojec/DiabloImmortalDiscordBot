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

    public Battleground(DatabaseRequests databaseRequests) {
        this.listBattleground = databaseRequests.getEventTimes("event_battleground", true);
    }

    public String checkBattleground(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getBattlegroundHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getBattlegroundMessage("ENG") + "\n";
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
