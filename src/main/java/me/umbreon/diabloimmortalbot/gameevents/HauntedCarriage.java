package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class HauntedCarriage {

    private final Map<String, Boolean> listHauntedCarriage;
    private final ClientConfig clientConfig;

    public HauntedCarriage(DatabaseRequests databaseRequests, ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        this.listHauntedCarriage = databaseRequests.getEventTimes("event_haunted_carriage", false);
    }

    public String checkHauntedCarriage(String timezone) {
        if (!isTimeValid(timezone)) return "";

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getHauntedCarriageHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getHauntedCarriageMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listHauntedCarriage.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listHauntedCarriage.get(time);
    }

}
