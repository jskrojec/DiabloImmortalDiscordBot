package me.umbreon.diabloimmortalbot.gameevents.embeds;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class DemonGatesEmbed {

    private final ClientCache clientCache;

    public DemonGatesEmbed(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void checkDemonGatesFormatted(final TextChannel textChannel, final String timezone, final String language) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        final String textChannelID = textChannel.getId();

        if (!clientCache.getListWithDemonGateEmbedTimes().contains(time) || !clientCache.isDemonGatesEmbedMessageEnabled(textChannelID)) {
            return;
        }

        final String guildID = textChannel.getGuild().getId();

        if (clientCache.isAutoDeleteEnabled(guildID)) {

            final int autoDeleteValue = clientCache.getAutoDeleteValue(guildID);
            switch (autoDeleteValue) {
                case 24:
                case 48:
                case 72:
                    textChannel.sendMessageEmbeds(buildDemonGatesEmbed(timezone, language)).queue(sendMessage -> {
                        sendMessage.delete().queueAfter(autoDeleteValue, TimeUnit.HOURS);
                    });
                    break;
            }
        } else {
            textChannel.sendMessageEmbeds(buildDemonGatesEmbed(timezone, language)).queue();
        }


    }

    private MessageEmbed buildDemonGatesEmbed(final String timezone, final String language) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();

        final long unix = TimeAssistant.getTimeInUnix(timezone) + (3600 * 2);

        final String eventTitle = LanguageController.getDemonGatesEmbedMessage(language);
        final String worldEventMessage = LanguageController.getEmbedWorldEventMessage(language);
        final String spawnAtMessage = LanguageController.getEmbedSpawnAtMessage(language);
        final String countdownMessage = LanguageController.getEmbedCountdownMessage(language);
        final String locationMessage1 = LanguageController.getLocationDemonGatesEmbedMessage1(language);
        final String locationMessage2 = LanguageController.getLocationDemonGatesEmbedMessage2(language);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(ImageAssistant.getDiabloDemonGatesImage());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}
