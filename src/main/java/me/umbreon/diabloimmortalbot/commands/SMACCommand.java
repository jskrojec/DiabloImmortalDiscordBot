package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.data.NotificationData;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.concurrent.TimeUnit;

/**
 * SMAC = Show me all channels
 */
public class SMACCommand {

    private final ClientCache clientCache;

    public SMACCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void onSMACCommand(User user, TextChannel textChannel) {
        if (!user.getId().equals("154279200432324608")) {
            return;
        }

        for (String channel : clientCache.getListWithNotificationChannels().keySet()) {
            NotificationData notificationData = clientCache.getListWithNotificationChannels().get(channel);
            String message = notificationData.channelId + "\n" +
                    notificationData.role + "\n" +
                    notificationData.timezone + "\n" +
                    notificationData.status + "\n" +
                    notificationData.inDebugMode + "\n-------";
            textChannel.sendMessage(message).queue(message1 -> {
                message1.delete().queueAfter(1, TimeUnit.HOURS);
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        textChannel.sendMessage("Done.").queue();
    }
}
