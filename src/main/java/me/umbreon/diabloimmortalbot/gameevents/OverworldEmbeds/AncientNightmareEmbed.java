package me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;

public class AncientNightmareEmbed {

    private final ArrayList<String> listListAncientNightmareFormatted;

    public AncientNightmareEmbed(DatabaseRequests databaseRequests) {
        this.listListAncientNightmareFormatted = databaseRequests.getOverworldEventTimes("overworld_ancient_nightmare");
    }

    public void checkAncientNightmareFormatted(TextChannel textChannel, String timezone, String language) {
        String time = Time.getTimeWithWeekday(timezone);

        if (!listListAncientNightmareFormatted.contains(time)) {
            return;
        }

        long unix = Time.getTimeInUnix(timezone) + (3600 * 2);

        String eventTitle = LanguageController.getAncientNightmareEmbedMessage(language);
        String worldEventMessage = LanguageController.getWorldEventEmbedMessage(language);
        String spawnAtMessage = LanguageController.getSpawnAtMessage(language);
        String countdownMessage = LanguageController.getCountdownEmbedMessage(language);
        String locationMessage1 = LanguageController.getLocationAncientNightmareEmbedMessage1(language);
        String locationMessage2 = LanguageController.getLocationAncientNightmareEmbedMessage2(language);

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage("https://assets.maxroll.gg/wordpress/ZoneEvents_Ancient_v1.1.jpg");
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

}

