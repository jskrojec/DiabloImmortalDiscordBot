package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class DemonGates {

    private final Map<String, Boolean> listDemonGates;
    private final ClientCache clientCache;

    public DemonGates(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listDemonGates = databaseRequests.getEventTimes("event_demon_gates", false);
        this.clientCache = clientCache;
    }

    public String checkDemonGates(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone) && clientCache.getHeadUpValue(guildID)) {
            return LanguageController.getDemonGatesHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getDemonGatesMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listDemonGates.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listDemonGates.get(time);
    }
}
