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

    public DemonGatesEmbed(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void checkDemonGatesFormatted(TextChannel textChannel, String timezone, String language) {
        String time = TimeAssistant.getTimeWithWeekday(timezone);
        String textChannelID = textChannel.getId();

        if (!clientCache.getListWithDemonGateEmbedTimes().contains(time) || !clientCache.isDemonGatesEmbedMessageEnabled(textChannelID)) {
            return;
        }

        String guildID = textChannel.getGuild().getId();

        if (clientCache.isAutoDeleteEnabled(guildID)) {

            int autoDeleteValue = clientCache.getAutoDeleteValue(guildID);
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

    private MessageEmbed buildDemonGatesEmbed(String timezone, String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        long unix = TimeAssistant.getTimeInUnix(timezone) + (3600 * 2);

        String eventTitle = LanguageController.getDemonGatesEmbedMessage(language);
        String worldEventMessage = LanguageController.getEmbedWorldEventMessage(language);
        String spawnAtMessage = LanguageController.getEmbedSpawnAtMessage(language);
        String countdownMessage = LanguageController.getEmbedCountdownMessage(language);
        String locationMessage1 = LanguageController.getLocationDemonGatesEmbedMessage1(language);
        String locationMessage2 = LanguageController.getLocationDemonGatesEmbedMessage2(language);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(ImageAssistant.getDiabloDemonGatesImage());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}
