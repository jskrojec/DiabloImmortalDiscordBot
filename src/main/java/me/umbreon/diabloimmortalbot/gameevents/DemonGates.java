package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
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
    private final ArrayList<String> listDemonGatesFormatted;

    public DemonGates(DatabaseRequests databaseRequests) {
        this.listDemonGates = databaseRequests.getEventTimes("event_demon_gates", false);
        this.listDemonGatesFormatted = databaseRequests.getOverworldEventTimes("overworld_demon_gates");
    }

    public String checkDemonGates(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getDemonGatesHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getDemonGatesMessage(language) + "\n";
        }
    }

    public MessageEmbed checkHauntedCarriageFormatted(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listDemonGatesFormatted.contains(time)) {
            return null;
        }

        long unix = convert(Time.getTime(timezone));

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Demon Gates | World Event", "logo.png");
        //embedBuilder.addField("Server Time" , "HIER SERVERZEIT", true);
        embedBuilder.addField("Spawn at", "<t:" + unix + 3600 + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + 3600 + ":R>", true);
        embedBuilder.addField("Location Realm of Damnation", "Realm of Damnation", true);
        embedBuilder.setThumbnail("https://assets.maxroll.gg/wordpress/ZoneEvents_Ashwold_v1.1.jpg");

        return embedBuilder.build();
    }

    public long convert(String time) {
        try {
            Date date = new SimpleDateFormat("HH:mm").parse(time);
            return date.toInstant().toEpochMilli();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
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
