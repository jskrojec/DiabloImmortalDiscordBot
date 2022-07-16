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
        String guildID = message.getGuild().getId();
        String guildLanguage = "ENG"; //clientCache.getLanguage(guildID);

        switch (args[1].toLowerCase()) {
            case "0":
                updateStatusFromNotificationChannel(channelID, 0, message, LanguageController.getReceiveAllMessagesMessage(guildLanguage));
                break;
            case "1":
                updateStatusFromNotificationChannel(channelID, 1, message, LanguageController.getReceiveOverworldMessage(guildLanguage));
                break;
            case "2":
                updateStatusFromNotificationChannel(channelID, 2, message, LanguageController.getReceiveImmortalMessage(guildLanguage));
                break;
            case "3":
                updateStatusFromNotificationChannel(channelID, 3, message, LanguageController.getReceiveShadowMessage(guildLanguage));
                break;
            case "4":
                updateStatusFromNotificationChannel(channelID, 4, message, LanguageController.getReceiveOwImmortalMessage(guildLanguage));
                break;
            case "5":
                updateStatusFromNotificationChannel(channelID, 5, message, LanguageController.getReceiveOwShadowMessage(guildLanguage));
                break;
            case "9":
                updateStatusFromNotificationChannel(channelID, 9, message, LanguageController.getReceiveOverworldMessage(guildLanguage));
                break;
            case "128":
                updateStatusFromNotificationChannel(channelID, 128, message, "This is debug mode.");
                break;
            default:
                message.getTextChannel().sendMessage(LanguageController.getUnknownStatusMessage(guildLanguage)).queue();
        }
    }

    private void updateStatusFromNotificationChannel(String channelID, int status, Message message, String returnMessage) {
        TextChannel textChannel = message.getTextChannel();

        databaseRequests.setStatus(channelID, status);
        clientCache.setStatus(channelID, status);
        textChannel.sendMessage(message.getTextChannel().getAsMention() + returnMessage).queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });

    }


}
