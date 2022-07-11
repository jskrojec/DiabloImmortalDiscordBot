package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class DebugCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public DebugCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void onDebugCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        if (clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() + LanguageController.getAlreadyRegisteredMessage("ENG")).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        String[] args = message.getContentRaw().split(" ");

        if (args[1].equalsIgnoreCase("on")) {
            databaseRequests.setDebugModeValue(channelID, true);
            clientCache.setDebugValue(channelID, true);
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getNowInDebugMessage("ENG")).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
        } else {
            databaseRequests.setDebugModeValue(channelID, false);
            clientCache.setDebugValue(channelID, false);
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getNoLongerDebugMessage("ENG")).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
        }
    }
}
