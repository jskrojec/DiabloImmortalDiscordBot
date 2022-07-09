package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class AncientArea {

    private final Map<String, Boolean> listAncientArea;
    private final ClientConfig clientConfig;

    public AncientArea(DatabaseRequests databaseRequests, ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        this.listAncientArea = databaseRequests.getEventTimes("event_ancient_area", false);
    }

    public String checkAncientArea(String timezone) {
        if (!isTimeValid(timezone)) return null;

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getAncientAreaHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getAncientAreaMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listAncientArea.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listAncientArea.get(time);
    }

}
