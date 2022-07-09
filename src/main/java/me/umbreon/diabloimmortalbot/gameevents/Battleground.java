package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class Battleground {

    private final Map<String, Boolean> listBattleground;
    private final ClientConfig clientConfig;

    public Battleground(DatabaseRequests databaseRequests, ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        this.listBattleground = databaseRequests.getEventTimes("event_battleground", true);
    }

    public String checkBattleground(String timezone) {
        if (!isTimeValid(timezone)) return null;

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getBattlegroundHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getBattlegroundMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listBattleground.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listBattleground.get(time);
    }

}
