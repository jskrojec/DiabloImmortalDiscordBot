package me.umbreon.diabloimmortalbot.gameevents.embeds;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class AncientNightmareEmbed {

    private final ClientCache clientCache;

    public AncientNightmareEmbed(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void checkAncientNightmareFormatted(final TextChannel textChannel, final String timezone, final String language) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        final String textChannelID = textChannel.getId();

        if (!clientCache.getListWithAncientNightmareEmbedTimes().contains(time) || !clientCache.isAncientNightmareEmbedMessageEnabled(textChannelID)) {
            return;
        }

        final String guildID = textChannel.getGuild().getId();

        if (clientCache.isAutoDeleteEnabled(guildID)) {

            final int autoDeleteValue = clientCache.getAutoDeleteValue(guildID);
            switch (autoDeleteValue) {
                case 24:
                case 48:
                case 72:
                    textChannel.sendMessageEmbeds(buildAncientNightmareEmbed(timezone, language)).queue(sendMessage -> {
                        sendMessage.delete().queueAfter(autoDeleteValue, TimeUnit.HOURS);
                    });
                    break;
            }
        } else {
            textChannel.sendMessageEmbeds(buildAncientNightmareEmbed(timezone, language)).queue();
        }


    }

    private MessageEmbed buildAncientNightmareEmbed(final String timezone, final String language) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();

        final String eventTitle = LanguageController.getAncientNightmareEmbedMessage(language);
        final String worldEventMessage = LanguageController.getEmbedWorldEventMessage(language);
        final String spawnAtMessage = LanguageController.getEmbedSpawnAtMessage(language);
        final String countdownMessage = LanguageController.getEmbedCountdownMessage(language);
        final String locationMessage1 = LanguageController.getLocationAncientNightmareEmbedMessage1(language);
        final String locationMessage2 = LanguageController.getLocationAncientNightmareEmbedMessage2(language);

        final long unix = TimeAssistant.getTimeInUnix(timezone) + (3600 * 2);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(ImageAssistant.getDiabloAncientNightmareImage());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}

