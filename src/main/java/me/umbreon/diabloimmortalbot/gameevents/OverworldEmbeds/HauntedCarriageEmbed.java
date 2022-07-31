package me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;

public class HauntedCarriageEmbed {

    private final ArrayList<String> listHauntedCarriageFormatted;

    public HauntedCarriageEmbed(DatabaseRequests databaseRequests) {
        this.listHauntedCarriageFormatted = databaseRequests.getOverworldEventTimes("overworld_haunted_carriage");
    }

    public void checkHauntedCarriageFormatted(TextChannel textChannel, String timezone, String language) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listHauntedCarriageFormatted.contains(time)) {
            return;
        }

        long unix = Time.getTimeInUnix(timezone) + (3600 * 2);

        String eventTitle = LanguageController.getHauntedCarriageEmbedMessage(language);
        String worldEventMessage = LanguageController.getWorldEventEmbedMessage(language);
        String spawnAtMessage = LanguageController.getSpawnAtMessage(language);
        String countdownMessage = LanguageController.getCountdownEmbedMessage(language);
        String locationMessage1 = LanguageController.getLocationHauntedCarriageEmbedMessage1(language);
        String locationMessage2 = LanguageController.getLocationHauntedCarriageEmbedMessage2(language);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage("https://assets.maxroll.gg/wordpress/ZoneEvents_Ashwold_v1.1.jpg");
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

}
