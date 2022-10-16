package me.umbreon.diabloimmortalbot.gameevents.embeds;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class AncientNightmareEmbed {

    private final GameEventsCache gameEventsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    public AncientNightmareEmbed(final GameEventsCache gameEventsCache, final NotificationChannelsCache notificationChannelsCache) {
        this.gameEventsCache = gameEventsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void checkAncientNightmareFormatted(final TextChannel textChannel, final String timezone, final String language) {
        String time = TimeUtils.getTimeWithWeekday(timezone);
        String textChannelID = textChannel.getId();

        if (!gameEventsCache.getListWithAncientNightmareEmbedTimes().contains(time) || !notificationChannelsCache.isAncientNightmareEmbedMessageEnabled(textChannelID)) {
            return;
        }

        textChannel.sendMessageEmbeds(buildAncientNightmareEmbed(timezone, language)).queue();
    }

    private MessageEmbed buildAncientNightmareEmbed(final String timezone, final String language) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();

        final String eventTitle = LanguageController.getAncientNightmareEmbedMessage(language);
        final String worldEventMessage = LanguageController.getEmbedWorldEventMessage(language);
        final String spawnAtMessage = LanguageController.getEmbedSpawnAtMessage(language);
        final String countdownMessage = LanguageController.getEmbedCountdownMessage(language);
        final String locationMessage1 = LanguageController.getLocationAncientNightmareEmbedMessage1(language);
        final String locationMessage2 = LanguageController.getLocationAncientNightmareEmbedMessage2(language);

        final long unix = TimeUtils.getTimeInUnix(timezone) + (3600 * 2);

        embedBuilder.setTitle(eventTitle + " | " + worldEventMessage);
        embedBuilder.setImage(StringUtils.getDiabloAncientNightmare());
        embedBuilder.addField(spawnAtMessage, "<t:" + unix + ">", true);
        embedBuilder.addField(countdownMessage, "<t:" + unix + ":R>", true);
        embedBuilder.addField(locationMessage1, locationMessage2, false);
        embedBuilder.setThumbnail(StringUtils.getDiabloImmortalLogo());

        return embedBuilder.build();
    }

}

