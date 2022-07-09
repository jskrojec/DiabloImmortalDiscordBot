package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class DebugCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public DebugCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void onDebugCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        message.delete().queue();
        String channelId = textChannel.getId();

        if (!databaseRequests.doNotificationChannelExists(channelId)) {
            textChannel.sendMessage(textChannel.getAsMention() + " is not registered.").queue();
            return;
        }

        String[] args = message.getContentRaw().split(" ");

        if (args[1].equalsIgnoreCase("off")) {
            databaseRequests.setDebugModeValue(textChannel.getId(), false);
            message.getTextChannel().sendMessage(textChannel.getAsMention() + " is no longer in debug mode.").queue();
        } else if (args[1].equalsIgnoreCase("on")) {
            databaseRequests.setDebugModeValue(textChannel.getId(), true);
            message.getTextChannel().sendMessage(textChannel.getAsMention() + " is now in debug mode.").queue();
        }

        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
    }

}
