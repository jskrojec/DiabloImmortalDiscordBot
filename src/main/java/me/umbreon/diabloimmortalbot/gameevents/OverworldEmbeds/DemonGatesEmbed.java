package me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;

public class DemonGatesEmbed {

    private final ArrayList<String> listDemonGatesFormatted;

    public DemonGatesEmbed(DatabaseRequests databaseRequests) {
        this.listDemonGatesFormatted = databaseRequests.getOverworldEventTimes("overworld_demon_gates");
    }

    public void checkAncientArenaFormatted(TextChannel textChannel, String timezone) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listDemonGatesFormatted.contains(time)) {
            return;
        }

        long unix = Time.getTimeInUnix(timezone) + (3600 * 2);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Demon Gates | World Event");
        embedBuilder.setImage("https://media.diablofans.com/attachments/23/560/screenshot-2022-05-28-204043.jpg");
        embedBuilder.addField("Spawn at", "<t:" + unix + ">", true);
        embedBuilder.addField("Countdown", "<t:" + unix + ":R>", true);
        embedBuilder.addField("Location Realm of Damnation", "Realm of Damnation", false);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

}
