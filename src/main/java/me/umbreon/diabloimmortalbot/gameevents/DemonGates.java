package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class DemonGates {

    private final Map<String, Boolean> listDemonGates;
    private final ClientConfig clientConfig;

    public DemonGates(DatabaseRequests databaseRequests, ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        this.listDemonGates = databaseRequests.getEventTimes("event_demon_gates", false);
    }

    public String checkDemonGates(String timezone) {
        if (!isTimeValid(timezone)) return "";

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getDemonGatesHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getDemonGatesMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listDemonGates.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listDemonGates.get(time);
    }
}
