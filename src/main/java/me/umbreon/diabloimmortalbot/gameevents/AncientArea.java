package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class AncientArea {

    private final Map<String, Boolean> listAncientArea;

    public AncientArea(DatabaseRequests databaseRequests) {
        this.listAncientArea = databaseRequests.getEventTimes("event_ancient_area", false);
    }

    public String checkAncientArea(String timezone) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getAncientArenaHeadUpMessage("ENG") + "\n";
        } else {
            return LanguageController.getAncientArenaMessage("ENG") + "\n";
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

    public EmbedBuilder checkAncientArenaFormatted(String timezone) {
        if (!isTimeValid(timezone)) return null;

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Ancient Arena | World Event", "logo.png");
        embedBuilder.addField("Server Time" , "HIER SERVERZEIT", true);
        embedBuilder.addField("Spawn at" , "HIER WANN SPAWN", true);
        embedBuilder.addField("Location" , "HIER WO DER SPAWNT", true);
        embedBuilder.addField("Countdown", "COUNTDOWN TO SPAWN", true);
        embedBuilder.setThumbnail("ancient_arena.jpg");

        return embedBuilder;
    }

}
