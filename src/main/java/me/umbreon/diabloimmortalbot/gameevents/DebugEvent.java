package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DebugEvent {

    private final Map<String, Boolean> listOfDebugTimes = new ConcurrentHashMap<>();

    private final ClientCache clientCache;

    public DebugEvent(final ClientCache clientCache) {
        this.clientCache = clientCache;

        listOfDebugTimes.put("00:00", true);
        listOfDebugTimes.put("00:30", false);
        listOfDebugTimes.put("01:00", true);
        listOfDebugTimes.put("01:30", false);
        listOfDebugTimes.put("02:00", true);
        listOfDebugTimes.put("02:30", false);
        listOfDebugTimes.put("03:00", true);
        listOfDebugTimes.put("03:30", false);
        listOfDebugTimes.put("04:00", true);
        listOfDebugTimes.put("04:30", false);
        listOfDebugTimes.put("05:00", true);
        listOfDebugTimes.put("05:30", false);
        listOfDebugTimes.put("06:00", true);
        listOfDebugTimes.put("06:30", false);
        listOfDebugTimes.put("07:00", true);
        listOfDebugTimes.put("07:30", false);
        listOfDebugTimes.put("08:00", true);
        listOfDebugTimes.put("08:30", false);
        listOfDebugTimes.put("09:00", true);
        listOfDebugTimes.put("09:30", false);
        listOfDebugTimes.put("10:00", true);
        listOfDebugTimes.put("10:30", false);
        listOfDebugTimes.put("11:00", true);
        listOfDebugTimes.put("11:30", false);
        listOfDebugTimes.put("12:00", true);
        listOfDebugTimes.put("12:30", false);
        listOfDebugTimes.put("13:00", true);
        listOfDebugTimes.put("13:30", false);
        listOfDebugTimes.put("14:00", true);
        listOfDebugTimes.put("14:30", false);
        listOfDebugTimes.put("15:00", true);
        listOfDebugTimes.put("15:30", false);
        listOfDebugTimes.put("16:00", true);
        listOfDebugTimes.put("16:30", false);
        listOfDebugTimes.put("17:00", true);
        listOfDebugTimes.put("17:30", false);
        listOfDebugTimes.put("18:00", true);
        listOfDebugTimes.put("18:30", false);
        listOfDebugTimes.put("19:00", true);
        listOfDebugTimes.put("19:30", false);
        listOfDebugTimes.put("20:00", true);
        listOfDebugTimes.put("20:30", false);
        listOfDebugTimes.put("21:00", true);
        listOfDebugTimes.put("21:30", false);
        listOfDebugTimes.put("22:00", true);
        listOfDebugTimes.put("22:30", false);
        listOfDebugTimes.put("23:00", true);
        listOfDebugTimes.put("23:30", false);
    }

    public String checkOnDebugEvent(final String timezone, final String guildID, final String textChannelID) {
        if (isHeadUpTime(timezone)) {
            if (!isHeadUpEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, "HeadUp Message - Debug");
            return "HeadUp Message - Debug\n";
        } else {
            if (!isEventMessageEnabled(guildID, textChannelID)) {
                return "";
            }
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, "Event Message - Debug");
            return "Event Message - Debug\n";
        }
    }

    private boolean isEventMessageEnabled(final String guildID, final String textChannelID) {
        return clientCache.isEventMessageOnServerEnabled(guildID) || clientCache.isEventMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpEnabled(final String guildID, final String textChannelID) {
        return clientCache.isHeadUpOnServerEnabled(guildID) && clientCache.isHeadUpMessageOnChannelEnabled(textChannelID);
    }

    private boolean isHeadUpTime(final String timezone) {
        final String time = TimeAssistant.getTime(timezone);
        return listOfDebugTimes.get(time);
    }

}
