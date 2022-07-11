package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class TimezoneCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public TimezoneCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void onTimezoneCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        if (!clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getNotRegisteredMessage("ENG")).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        String[] args = message.getContentRaw().split(" ");
        String timezone = args[1].toUpperCase();

        if (!timezone.substring(0, 3).equalsIgnoreCase("GMT") || !timezone.substring(0, 3).equalsIgnoreCase("EST")) {
            textChannel.sendMessage(String.format(LanguageController.getUnknownTimezoneMessage("ENG"), timezone)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
        }

        databaseRequests.setTimezone(channelID, timezone);
        clientCache.setTimezone(channelID, timezone);

        message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() +
                LanguageController.getTimezoneSetToMessage("ENG") + timezone + ".").queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });
    }
}

