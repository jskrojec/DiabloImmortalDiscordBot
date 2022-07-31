package me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;

public class DemonGatesEmbed {

    private final ArrayList<String> listDemonGatesFormatted;

    public DemonGatesEmbed(DatabaseRequests databaseRequests) {
        this.listDemonGatesFormatted = databaseRequests.getOverworldEventTimes("overworld_demon_gates");
    }

    public void checkDemonGatesFormatted(TextChannel textChannel, String timezone, String language) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listDemonGatesFormatted.contains(time)) {
            return;
        }

        long unix = Time.getTimeInUnix(timezone) + (3600 * 2);

        String eventTitle = LanguageController.getDemonGatesEmbedMessage(language);
        String worldEventMessage = LanguageController.getWorldEventEmbedMessage(language);
        String spawnAtMessage = LanguageController.getSpawnAtMessage(language);
        String countdownMessage = LanguageController.getCountdownEmbedMessage(language);
        String locationMessage1 = LanguageController.getLocationDemonGatesEmbedMessage1(language);
        String locationMessage2 = LanguageController.getLocationDemonGatesEmbedMessage2(language);

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage("https://media.diablofans.com/attachments/23/560/screenshot-2022-05-28-204043.jpg");
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

}
