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

public class HauntedCarriage {

    private final Map<String, Boolean> listHauntedCarriage;
    private final ArrayList<String> listHauntedCarriageFormatted;

    public HauntedCarriage(DatabaseRequests databaseRequests) {
        this.listHauntedCarriage = databaseRequests.getEventTimes("event_haunted_carriage", false);
        this.listHauntedCarriageFormatted = databaseRequests.getOverworldEventTimes("overworld_haunted_carriage");
    }

    public String checkHauntedCarriage(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getHauntedCarriageHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getHauntedCarriageMessage(language) + "\n";
        }
    }

    public MessageEmbed checkHauntedCarriageFormatted(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listHauntedCarriageFormatted.contains(time)) {
            return null;
        }

        long unix = convert(Time.getTime(timezone));

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Haunted Carriage | World Event", "logo.png");
        //embedBuilder.addField("Server Time" , "HIER SERVERZEIT", true);
        embedBuilder.addField("Spawn at", "<t:" + unix + 3600 + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + 3600 + ":R>", true);
        embedBuilder.addField("Location Ashwold Cemetery", "Carriage Landing", true);
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
        return listHauntedCarriage.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTimeWithWeekday(timezone);
        return listHauntedCarriage.get(time);
    }

}
