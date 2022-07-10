package me.umbreon.diabloimmortalbot.commands;

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
        String[] args = message.getContentRaw().split(" ");
        String timezone = args[1].toUpperCase();
        TextChannel textChannel = message.getTextChannel();
        String channelId = textChannel.getId();
        message.delete().queue();

        if (!databaseRequests.doNotificationChannelExists(channelId)) {
            message.reply("TextChannel is not registered.").queue(message1 -> {
                message1.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }


        if (Time.isTimeZoneCEST(timezone)) {
            textChannel.sendMessage("CEST is not supported.").queue();
            return;
        }

        if (!Time.isTimeZoneEST(timezone) && !(Time.isTimeZoneGMT(timezone))) {
            textChannel.sendMessage("We detected that you're not using on of known working timezones.\n" +
                    "Known working timezones are GMT & EST. Use >checktimezone " + timezone + " to see if your timezone" +
                    "is supported.").queue();
        }


        databaseRequests.setTimezone(channelId, timezone);

        message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " Timezone now set to " + timezone + ".").queue(message1 -> {
            message1.delete().queueAfter(10, TimeUnit.SECONDS);
        });

        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());

    }
}

