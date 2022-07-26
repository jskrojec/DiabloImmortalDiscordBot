package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Timer;
import java.util.TimerTask;

public class CustomMessagesNotifier {

    private final ClientCache clientCache;

    public CustomMessagesNotifier(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runCustomMessagesNotifierScheduler(JDA jda) {

        new Timer().schedule(new TimerTask() {
            public void run() {
                for (String channel : clientCache.getListWithCustomMessages().keySet()) {

                    if (!clientCache.doNotificationChannelExists(channel)) {
                        return;
                    }

                    String timezone = clientCache.getTimezone(channel);
                    String fullTime = clientCache.getCustomMessageFullTimeByChannelID(channel);

                    if (!isTimeValid(timezone, fullTime)) {
                        return;
                    }

                    TextChannel textChannel;

                    try {
                        textChannel = jda.getTextChannelById(channel);
                    } catch (NullPointerException e) {
                        return;
                    }

                    String message = clientCache.getCustomMessageMessageByChannelID(channel);

                    textChannel.sendMessage(message).queue();
                }
            }
        }, 0, 60 * 1000);
    }

    private boolean isTimeValid(String timezone, String fullTime) {
        String time = Time.getTimeWithWeekday(timezone);
        return time.equals(fullTime);
    }
}
