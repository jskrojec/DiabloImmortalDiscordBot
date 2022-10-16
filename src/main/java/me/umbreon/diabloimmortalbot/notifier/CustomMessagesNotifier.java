package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.cache.CustomMessagesCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CustomMessagesNotifier {

    private final DatabaseRequests databaseRequests;
    private final GuildsCache guildsCache;
    private final CustomMessagesCache customMessagesCache;

    public CustomMessagesNotifier(final DatabaseRequests databaseRequests, final GuildsCache guildsCache, CustomMessagesCache customMessagesCache) {
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
        this.customMessagesCache = customMessagesCache;
    }

    public void runCustomMessagesNotifierScheduler(final JDA jda) {
        final Date date = Calendar.getInstance().getTime();
        date.setMinutes(date.getMinutes() + 1);
        date.setSeconds(0);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                customMessagesCache.getAllCustomMessages().forEach((integer, customMessage) -> {
                    String channel = customMessage.getChannelID();
                    String guildID = customMessage.getGuildID();
                    String timezone = guildsCache.getGuildTimeZone(guildID);
                    String day = customMessage.getWeekday();
                    String time = customMessage.getTime();
                    String fullTime = day + " " + time;

                    if (day.equalsIgnoreCase("everyday")) {
                        if (!isTimeValid(timezone, time)) return; //Invalid time message
                    } else {
                        if (!isFulltimeValid(timezone, fullTime)) return; //Invalid time message
                    }

                    TextChannel textChannel;

                    try {
                        textChannel = jda.getTextChannelById(channel);
                    } catch (final NullPointerException e) {
                        return;
                    }

                    final String message = customMessage.getMessage();


                    if (textChannel != null) textChannel.sendMessage(message).queue();


                    if (!customMessage.isRepeating()) {
                        customMessagesCache.deleteCustomMessageByID(customMessage.getCustomMessageID());
                        databaseRequests.deleteCustomMessageEntry(customMessage.getCustomMessageID());
                    }
                });

            }
        }, date, 60 * 1000);
    }

    private boolean isFulltimeValid(final String timezone, final String fullTime) {
        final String time = TimeUtils.getTimeWithWeekday(timezone);
        return time.equalsIgnoreCase(fullTime);
    }

    private boolean isTimeValid(final String timezone, final String time) {
        final String timeOnly = TimeUtils.getTime(timezone);
        return time.equalsIgnoreCase(timeOnly);
    }
}
