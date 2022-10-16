package me.umbreon.diabloimmortalbot.gameevents.embeds;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class DemonGatesEmbed {

    private final GameEventsCache gameEventsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    public DemonGatesEmbed(final GameEventsCache gameEventsCache, final NotificationChannelsCache notificationChannelsCache) {
        this.gameEventsCache = gameEventsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void checkDemonGatesFormatted(final TextChannel textChannel, final String timezone, final String language) {
        final String time = TimeUtils.getTimeWithWeekday(timezone);
        final String textChannelID = textChannel.getId();

        if (!gameEventsCache.getListWithDemonGateEmbedTimes().contains(time) || !notificationChannelsCache.isDemonGatesEmbedMessageEnabled(textChannelID)) {
            return;
        }

        textChannel.sendMessageEmbeds(buildDemonGatesEmbed(timezone, language)).queue();
    }

    private MessageEmbed buildDemonGatesEmbed(final String timezone, final String language) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();

        final long unix = TimeUtils.getTimeInUnix(timezone) + (3600 * 2);

        final String eventTitle = LanguageController.getDemonGatesEmbedMessage(language);
        final String worldEventMessage = LanguageController.getEmbedWorldEventMessage(language);
        final String spawnAtMessage = LanguageController.getEmbedSpawnAtMessage(language);
        final String countdownMessage = LanguageController.getEmbedCountdownMessage(language);
        final String locationMessage1 = LanguageController.getLocationDemonGatesEmbedMessage1(language);
        final String locationMessage2 = LanguageController.getLocationDemonGatesEmbedMessage2(language);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(StringUtils.getDiabloDemonGates());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(StringUtils.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}
