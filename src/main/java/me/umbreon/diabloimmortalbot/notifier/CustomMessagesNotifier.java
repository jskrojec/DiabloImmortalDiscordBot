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
import java.util.concurrent.TimeUnit;

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
                    final String channel = customMessage.getChannelID();

                    if (!clientCache.doNotifierChannelExists(channel)) {
                        return; //Needs to be registered to send messages.
                    }

                    final String guildID = customMessage.getGuildID();
                    final String timezone = clientCache.getGuildTimeZone(guildID);
                    final String day = customMessage.getDay();
                    final String time = customMessage.getTime();
                    final String fullTime = day + " " + time;

                    if (day.equalsIgnoreCase("everyday")) {
                        if (!isTimeValid(timezone, time)) return; //Invalid time message
                    } else {
                        if (!isFulltimeValid(timezone, fullTime)) return; //Invalid time message
                    }

                    final TextChannel textChannel;

                    try {
                        textChannel = jda.getTextChannelById(channel);
                    } catch (final NullPointerException e) {
                        return;
                    }

                    final String message = customMessage.getMessage();

                    if (clientCache.isAutoDeleteEnabled(guildID)) {

                        final int autoDeleteValue = clientCache.getAutoDeleteValue(guildID);
                        switch (autoDeleteValue) {
                            case 24:
                            case 48:
                            case 72:
                                if (textChannel != null)
                                    textChannel.sendMessage(message).queue(sendMessage -> {
                                        sendMessage.delete().queueAfter(autoDeleteValue, TimeUnit.HOURS);
                                    });
                                break;
                        }

                    } else {
                        if (textChannel != null) textChannel.sendMessage(message).queue();
                    }

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
        return time.equals(fullTime);
    }

    private boolean isTimeValid(final String timezone, final String time) {
        final String timeOnly = TimeAssistant.getTime(timezone);
        return time.equals(timeOnly);
    }
}
