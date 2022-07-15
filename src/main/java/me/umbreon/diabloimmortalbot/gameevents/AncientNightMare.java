package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class AncientNightMare {

    private final Map<String, Boolean> listAncientNightmare;
    private final ArrayList<String> listListAncientNightmareFormatted;

    public AncientNightMare(DatabaseRequests databaseRequests) {
        listAncientNightmare = databaseRequests.getEventTimes("event_ancient_nightmare", false);
        listListAncientNightmareFormatted = databaseRequests.getOverworldEventTimes("overworld_ancient_nightmare");
    }

    public String checkAncientNightMare(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAncientNightmareHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getAncientNightmareMessage(language) + "\n";
        }
    }

    public MessageEmbed checkAncientNightMareFormatted(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listListAncientNightmareFormatted.contains(time)) {
            return null;
        }

        long unix = convert(Time.getTime(timezone));

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Ancient Nightmare | World Event", "logo.png");
        //embedBuilder.addField("Server Time" , "HIER SERVERZEIT", true);
        embedBuilder.addField("Spawn at", "<t:" + unix + 3600 + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + 3600 + ":R>", true);
        embedBuilder.addField("Location Mount Zavian", "Misty Valley", true);
        embedBuilder.setThumbnail("https://assets.maxroll.gg/wordpress/ZoneEvents_Ancient_v1.1.jpg");

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
        return listAncientNightmare.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientNightmare.get(time);
    }

}
