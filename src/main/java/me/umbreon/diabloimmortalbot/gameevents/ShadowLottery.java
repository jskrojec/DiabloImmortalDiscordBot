package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class ShadowLottery {

    private final Map<String, Boolean> listShadowLottery;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public ShadowLottery(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listShadowLottery = databaseRequests.getEventTimes("event_shadow_lottery", true);
        this.clientCache = clientCache;
    }

    public String checkShadowLottery(String timezone) {
        if (!isTimeValid(timezone)) return "";

        String notificationMessage;

        if (isHeadUpTime(timezone)) {
            notificationMessage = clientConfig.getShadowLotteryHeadUpMessage() + "\n";
        } else {
            notificationMessage = clientConfig.getShadowLotteryMessage() + "\n";
        }

        return notificationMessage;
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getFullTime(timezone);
        return listShadowLottery.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getFullTime(timezone);
        return listShadowLottery.get(time);
    }

}
