package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class AncientNightMare {

    private final Map<String, Boolean> listAncientNightMare;
    private final ClientConfig clientConfig;

    public AncientNightMare(DatabaseRequests databaseRequests, ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        listAncientNightMare = databaseRequests.getEventTimes("event_ancient_nightmare", false);
    }

    public String checkAncientNightMare(String timezone) {
        if (!isTimeValid(timezone)) return null;

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getAncientNightmareHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getAncientNightmareMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listAncientNightMare.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listAncientNightMare.get(time);
    }

}
