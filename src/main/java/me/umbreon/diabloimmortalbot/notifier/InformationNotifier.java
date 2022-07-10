package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class InformationNotifier {

    public ClientCache clientCache;

    public InformationNotifier(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void sendInformationMessage(String message, JDA jda) {
        for (String channel : clientCache.getListWithNotificationChannels().keySet()) {
            if (clientCache.getStatus(channel) == 256) {
                TextChannel textChannel = jda.getTextChannelById(channel);

                if (textChannel == null) {
                    return;
                }

                textChannel.sendMessage(message).queue();
            }
        }
    }
}
