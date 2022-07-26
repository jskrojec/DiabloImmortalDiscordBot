package me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;

public class AncientArenaEmbed {

    private final ArrayList<String> listAncientArenaFormatted;

    public AncientArenaEmbed(DatabaseRequests databaseRequests) {
        this.listAncientArenaFormatted = databaseRequests.getOverworldEventTimes("overworld_ancient_arena");
    }

    public void checkAncientArenaFormatted(TextChannel textChannel, String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listAncientArenaFormatted.contains(time)) {
            return;
        }

        long unix = Time.getTimeInUnix(timezone) + (3600 * 2);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Ancient Arena | World Event");
        embedBuilder.setImage("https://assets.maxroll.gg/wordpress/ZoneEvents_Arena_v1.1.jpg");
        embedBuilder.addField("Spawn at", "<t:" + unix + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + ":R>", true);
        embedBuilder.addField("Location Bilefen", "Ancient Arena", false);
        embedBuilder.setThumbnail("https://img.game8.co/3538126/8b47d33ca42b94d1177e9e0ee2fc7550.png/show");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

}
