package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;
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
        String[] args = message.getContentRaw().split(" ");

        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        String channelID = textChannel.getId();
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        if (!clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention());
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        String timezone = args[1].toUpperCase();

        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime dateTime = timeStamp.atZone(ZoneId.of(timezone));
        } catch (ZoneRulesException e) {
            String responseMessage = "Invalid timezone.";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        databaseRequests.setTimezone(channelID, timezone);
        clientCache.setTimezone(channelID, timezone);
        String responseMessage = String.format(LanguageController.getTimezoneSetToMessage(language), textChannel.getAsMention(), timezone);
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
        createLogEntry(message, responseMessage);
    }

    private void createLogEntry(Message message, String responseMessage) {
        String channelName = message.getTextChannel().getName();
        String guildName = message.getGuild().getName();
        String logMessage = "Sended message " + responseMessage + " to " + channelName + " in guild " + guildName + ".";
        ClientLogger.createNewInfoLogEntry(logMessage);
    }
}

