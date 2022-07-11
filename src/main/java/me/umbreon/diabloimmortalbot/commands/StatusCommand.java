package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.configuration.LanguageEnglish;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class StatusCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public StatusCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runStatusCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        if (!clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageEnglish.getNotRegisteredMessage()).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        String[] args = message.getContentRaw().split(" ");

        switch (args[1].toLowerCase()) {
            case "0":
                databaseRequests.setStatus(channelID, 0);
                clientCache.setStatus(channelID, 0);
                textChannel.sendMessage(textChannel.getAsMention() +
                        LanguageController.getReceiveAllMessagesMessage("ENG")).queue(sendMessage -> {
                    sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                break;
            case "1":
                databaseRequests.setStatus(channelID, 1);
                clientCache.setStatus(channelID, 1);
                textChannel.sendMessage(textChannel.getAsMention() +
                        LanguageController.getReceiveOverworldMessage("ENG")).queue(sendMessage -> {
                    sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                break;
            case "2":
                databaseRequests.setStatus(channelID, 2);
                clientCache.setStatus(channelID, 2);
                textChannel.sendMessage(textChannel.getAsMention() +
                        LanguageController.getReceiveImmortalMessage("ENG")).queue(sendMessage -> {
                    sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                break;
            case "3":
                databaseRequests.setStatus(channelID, 3);
                clientCache.setStatus(channelID, 3);
                textChannel.sendMessage(message.getTextChannel().getAsMention() +
                        LanguageController.getReceiveShadowMessage("ENG")).queue(sendMessage -> {
                    sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                break;
            case "4":
                databaseRequests.setStatus(channelID, 4);
                clientCache.setStatus(channelID, 4);
                textChannel.sendMessage(message.getTextChannel().getAsMention() +
                        LanguageController.getReceiveOwImmortalMessage("ENG")).queue(sendMessage -> {
                    sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                break;
            case "5":
                databaseRequests.setStatus(channelID, 5);
                clientCache.setStatus(channelID, 5);
                textChannel.sendMessage(message.getTextChannel().getAsMention() +
                        LanguageController.getReceiveOwShadowMessage("ENG")).queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                break;
            case "128": //TimeZone check todo:remove this
                message.getTextChannel().sendMessage("Status set to 128 Test-Mode.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                databaseRequests.setStatus(message.getTextChannel().getId(), 128);
                break;
            default:
                message.getTextChannel().sendMessage("Possible Codes for status:\n" + //TODO: maybe add to LC?
                        "0 = All messages.\n" +
                        "1 = Only overworld.\n" +
                        "2 = Only Immortal\n" +
                        "3 = Only Shadow\n" +
                        "4 = Immortal with overworld\n" +
                        "5 = Shadow with overworld").queue();
        }
    }


}
