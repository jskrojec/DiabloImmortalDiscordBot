package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
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
        String guildID = message.getGuild().getId();
        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        String[] args = message.getContentRaw().split(" ");

        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        String language = clientCache.getLanguage(guildID);

        if (!clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention());
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        switch (args[1].toLowerCase()) {
            case "0":
                updateStatusFromNotificationChannel(channelID, 0, message, LanguageController.getReceiveAllMessagesMessage(language));
                break;
            case "1":
                updateStatusFromNotificationChannel(channelID, 1, message, LanguageController.getReceiveOverworldMessage(language));
                break;
            case "2":
                updateStatusFromNotificationChannel(channelID, 2, message, LanguageController.getReceiveImmortalMessage(language));
                break;
            case "3":
                updateStatusFromNotificationChannel(channelID, 3, message, LanguageController.getReceiveShadowMessage(language));
                break;
            case "4":
                updateStatusFromNotificationChannel(channelID, 4, message, LanguageController.getReceiveOwImmortalMessage(language));
                break;
            case "5":
                updateStatusFromNotificationChannel(channelID, 5, message, LanguageController.getReceiveOwShadowMessage(language));
                break;
            case "7":
                updateStatusFromNotificationChannel(channelID, 7, message, LanguageController.getReceiveOwImmortalMessage(language));
                break;
            case "8":
                updateStatusFromNotificationChannel(channelID, 8, message, LanguageController.getReceiveOwShadowMessage(language));
                break;
            case "9":
                updateStatusFromNotificationChannel(channelID, 9, message, LanguageController.getReceiveOverworldMessage(language));
                break;
            case "128":
                updateStatusFromNotificationChannel(channelID, 128, message, "This is debug mode.");
                break;
            default:
                message.getTextChannel().sendMessage(LanguageController.getUnknownStatusMessage(language)).queue();
        }
    }

    private void updateStatusFromNotificationChannel(String channelID, int status, Message message, String returnMessage) {
        TextChannel textChannel = message.getTextChannel();
        databaseRequests.setStatus(channelID, status);
        clientCache.setStatus(channelID, status);
        String responseMessage = String.format(returnMessage, message.getTextChannel().getAsMention());
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
        createLogEntry(message, responseMessage);
    }

    private void createLogEntry(Message message, String responseMessage) {
        String channelName = message.getTextChannel().getName();
        String guildName = message.getGuild().getName();
        String logMessage = "Sended message " + responseMessage + " to " + channelName + " in guild " + guildName + ".";
    }
}
