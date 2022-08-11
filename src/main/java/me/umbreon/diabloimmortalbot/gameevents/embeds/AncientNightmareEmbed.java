package me.umbreon.diabloimmortalbot.gameevents.embeds;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class AncientNightmareEmbed {

    private final ClientCache clientCache;

    public AncientNightmareEmbed(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void checkAncientNightmareFormatted(TextChannel textChannel, String timezone, String language) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        String textChannelID = textChannel.getId();

        if (!clientCache.getListWithAncientNightmareEmbedTimes().contains(time) || !clientCache.isAncientNightmareEmbedMessageEnabled(textChannelID)) {
            return;
        }

        textChannel.sendMessageEmbeds(buildAncientNightmareEmbed(timezone, language)).queue();
    }

    private MessageEmbed buildAncientNightmareEmbed(String timezone, String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        String eventTitle = LanguageController.getAncientNightmareEmbedMessage(language);
        String worldEventMessage = LanguageController.getWorldEventEmbedMessage(language);
        String spawnAtMessage = LanguageController.getSpawnAtMessage(language);
        String countdownMessage = LanguageController.getCountdownEmbedMessage(language);
        String locationMessage1 = LanguageController.getLocationAncientNightmareEmbedMessage1(language);
        String locationMessage2 = LanguageController.getLocationAncientNightmareEmbedMessage2(language);

        long unix = TimeAssistant.getTimeInUnix(timezone) + (3600 * 2);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(ImageAssistant.getDiabloAncientNightmareImage());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}

