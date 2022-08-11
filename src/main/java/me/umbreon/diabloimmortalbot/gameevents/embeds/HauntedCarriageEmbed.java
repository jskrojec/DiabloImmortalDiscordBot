package me.umbreon.diabloimmortalbot.gameevents.embeds;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class HauntedCarriageEmbed {

    private final ClientCache clientCache;

    public HauntedCarriageEmbed(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void checkHauntedCarriageFormatted(TextChannel textChannel, String timezone, String language) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        String textChannelID = textChannel.getId();

        if (!clientCache.getListWithHauntedCarriageEmbedTimes().contains(time) || !clientCache.isHauntedCarriageEmbedMessageEnabled(textChannelID)) {
            return;
        }

        textChannel.sendMessageEmbeds(buildHauntedCarriageEmbed(timezone, language)).queue();
    }

    private MessageEmbed buildHauntedCarriageEmbed(String timezone, String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        String eventTitle = LanguageController.getHauntedCarriageEmbedMessage(language);
        String worldEventMessage = LanguageController.getWorldEventEmbedMessage(language);
        String spawnAtMessage = LanguageController.getSpawnAtMessage(language);
        String countdownMessage = LanguageController.getCountdownEmbedMessage(language);
        String locationMessage1 = LanguageController.getLocationHauntedCarriageEmbedMessage1(language);
        String locationMessage2 = LanguageController.getLocationHauntedCarriageEmbedMessage2(language);

        long unix = TimeAssistant.getTimeInUnix(timezone) + (3600 * 2);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(ImageAssistant.getDiabloHauntedCarriageImage());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}
