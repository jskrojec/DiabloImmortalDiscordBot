package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class EventListCommand {

    private final ClientCache clientCache;

    public EventListCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String runEventListCommand(final TextChannel textChannel, final String guildID) {
        return createListWithAvailableEvents();
        //sendMessageToTextChannel(guildID, textChannel, createListWithAvailableEvents());
    }

    @NotNull
    private String createListWithAvailableEvents() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < clientCache.getListWithAvailableNotifications().size(); i++) {
            if (i == clientCache.getListWithAvailableNotifications().size() - 2) {
                stringBuilder.append(clientCache.getListWithAvailableNotifications().get(i)).append(" & ");
            } else if (i == clientCache.getListWithAvailableNotifications().size() - 1) {
                stringBuilder.append(clientCache.getListWithAvailableNotifications().get(i));
            } else {
                stringBuilder.append(clientCache.getListWithAvailableNotifications().get(i)).append(", ");
            }
        }
        return stringBuilder.toString();
    }

    private void sendMessageToTextChannel(final String guildID, final TextChannel textChannel, final String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }
}
