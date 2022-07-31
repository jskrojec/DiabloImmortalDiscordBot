package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Timer;
import java.util.TimerTask;

public class CustomMessagesNotifier {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessagesNotifier(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessagesNotifierScheduler(JDA jda) {

        new Timer().schedule(new TimerTask() {
            public void run() {
                clientCache.customMessagesList.forEach((integer, customMessage) -> {
                    String channel = customMessage.getChannelID();

                    if (!clientCache.doNotificationChannelExists(channel)) {
                        //Needs to be registered to send messages, could use status 6 for private messages.
                        return;
                    }

                    String timezone = clientCache.getTimezone(channel);
                    String day = customMessage.getDay();
                    String time = customMessage.getTime();
                    String fullTime = day + " " + time;

                    if (day.equalsIgnoreCase("everyday")) {
                        if (!isTimeValid(timezone, time)) {
                            //Invalid time message
                            return;
                        }
                    } else {
                        if (!isFulltimeValid(timezone, fullTime)) {
                            //Invalid time message
                            return;
                        }
                    }

                    TextChannel textChannel;

                    try {
                        textChannel = jda.getTextChannelById(channel);
                    } catch (NullPointerException e) {
                        return;
                    }

                    String message = customMessage.getMessage();
                    if (textChannel != null) textChannel.sendMessage(message).queue();

                    if (!customMessage.isRepeat()) {
                        clientCache.deleteCustomMessageByID(customMessage.getCustomMessageID());
                        databaseRequests.deleteCustomMessageEntry(customMessage.getCustomMessageID());
                    }
                });

            }
        }, 0, 60 * 1000);
    }

    private boolean isFulltimeValid(String timezone, String fullTime) {
        String time = Time.getTimeWithWeekday(timezone);
        return time.equals(fullTime);
    }

    private boolean isTimeValid(String timezone, String time) {
        String timeOnly = Time.getTime(timezone);
        return time.equals(timeOnly);
    }
}
