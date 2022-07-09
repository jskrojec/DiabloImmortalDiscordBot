package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class Assembly {

    private final Map<String, Boolean> listAssembly;
    private final ClientConfig clientConfig;

    public Assembly(DatabaseRequests databaseRequests, ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        this.listAssembly = databaseRequests.getEventTimes("event_assembly", false);
    }

    public String checkAssembly(String timezone) {
        if (!isTimeValid(timezone)) return null;

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getAssemblyHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getAssemblyMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listAssembly.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listAssembly.get(time);
    }

}
