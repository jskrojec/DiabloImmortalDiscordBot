package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

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
        String channelId = message.getTextChannel().getId();
        message.delete().queue();

        if (!databaseRequests.doNotificationChannelExists(channelId)) {
            message.reply("TextChannel is not registered.").queue();
        } else {
            databaseRequests.setTimezone(channelId, timezone);
            message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " Timezone now set to " + timezone + ".").queue();
            clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
        }

    }

}

