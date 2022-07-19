package me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;

public class AncientNightmareEmbed {

    private final ArrayList<String> listListAncientNightmareFormatted;

    public AncientNightmareEmbed(DatabaseRequests databaseRequests) {
        this.listListAncientNightmareFormatted = databaseRequests.getOverworldEventTimes("overworld_ancient_nightmare");
    }

    public void checkAncientArenaFormatted(TextChannel textChannel, String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listListAncientNightmareFormatted.contains(time)) {
            return;
        }

        long unix = Time.getTimeInUnix(timezone) + (3600 * 6);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Ancient Nightmare | World Event");
        embedBuilder.setImage("https://assets.maxroll.gg/wordpress/ZoneEvents_Ancient_v1.1.jpg");
        embedBuilder.addField("Spawn at", "<t:" + unix + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + ":R>", true);
        embedBuilder.addField("Location Mount Zavian", "Misty Valley", false);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

}

