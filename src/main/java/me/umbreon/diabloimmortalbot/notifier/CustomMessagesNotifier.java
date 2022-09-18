package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CustomMessagesNotifier {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessagesNotifier(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessagesNotifierScheduler(final JDA jda) {
        final Date date = Calendar.getInstance().getTime();
        date.setMinutes(date.getMinutes() + 1);
        date.setSeconds(0);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                clientCache.getAllCustomMessages().forEach((integer, customMessage) -> {
                    String channel = customMessage.getChannelID();

                    if (!clientCache.doNotifierChannelExists(channel)) {
                        return; //Needs to be registered to send messages.
                    }

                    String guildID = customMessage.getGuildID();
                    String timezone = clientCache.getGuildTimeZone(guildID);
                    String day = customMessage.getDay();
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


                    if (!customMessage.isRepeat()) {
                        clientCache.deleteCustomMessageByID(customMessage.getCustomMessageID());
                        databaseRequests.deleteCustomMessageEntry(customMessage.getCustomMessageID());
                    }
                });

            }
        }, date, 60 * 1000);
    }

    private boolean isFulltimeValid(final String timezone, final String fullTime) {
        final String time = TimeAssistant.getTimeWithWeekday(timezone);
        return time.equalsIgnoreCase(fullTime);
    }

    private boolean isTimeValid(final String timezone, final String time) {
        final String timeOnly = TimeAssistant.getTime(timezone);
        return time.equalsIgnoreCase(timeOnly);
    }
}
