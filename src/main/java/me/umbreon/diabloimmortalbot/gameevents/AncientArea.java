package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class AncientArea {

    private final Map<String, Boolean> listAncientArea;
    private final ArrayList<String> listAncientArenaFormatted;

    public AncientArea(DatabaseRequests databaseRequests) {
        this.listAncientArea = databaseRequests.getEventTimes("event_ancient_area", false);
        this.listAncientArenaFormatted = databaseRequests.getOverworldEventTimes("overworld_ancient_arena");
    }

    public String checkAncientArea(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAncientArenaHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getAncientArenaMessage(language) + "\n";
        }
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientArea.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listAncientArea.get(time);
    }

    public MessageEmbed checkAncientArenaFormatted(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listAncientArenaFormatted.contains(time)) {
            return null;
        }

        long unix = convert(Time.getTime(timezone));

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Ancient Arena | World Event", "logo.png");
        //embedBuilder.addField("Server Time" , "HIER SERVERZEIT", true);
        embedBuilder.addField("Spawn at", "<t:" + unix + 3600 + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + 3600 + ":R>", true);
        embedBuilder.addField("Location Bilefen", "Ancient Arena", true);
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

}
