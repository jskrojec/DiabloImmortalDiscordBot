package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
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
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");

        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        String channelID = textChannel.getId();
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        if (!clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention());
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        String timezone = args[1].toUpperCase();

        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime dateTime = timeStamp.atZone(ZoneId.of(timezone));
        } catch (ZoneRulesException e) {
            String responseMessage = "Invalid timezone.";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        databaseRequests.setTimezone(channelID, timezone);
        clientCache.setTimezone(channelID, timezone);
        textChannel.sendMessage(String.format(LanguageController.getTimezoneSetToMessage(language), textChannel.getAsMention(), timezone)).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
    }

    /**
     * Command: >timezone GMT+2 #Channel
     * Command: >timezone GMT+2
     **/
    public void runTimezoneCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        if (!areArgumentsValid(args)) {
            textChannel.sendMessage(LanguageController.getInvalidCommandMessage(language)).queue();
            return;
        }

        String textChannelID = getTextChannelID(textChannel, args);
        if (!isChannelRegistered(textChannelID)) {
            textChannel.sendMessage(String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention())).queue();
            return;
        }

        String timezone = args[1].toUpperCase();
        if (!isTimeZoneValid(timezone)) {
            String responseMessage = "Invalid timezone.";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        setTimezone(textChannelID, timezone);
        textChannel.sendMessage(String.format(LanguageController.getTimezoneSetToMessage(language), textChannel.getAsMention(), timezone)).queue();
    }

    // -

    private String getTextChannelID(TextChannel textChannel, String[] args) {
        String textChannelID = null;
        if (args.length == 3) {
            textChannelID = args[2].replaceAll("[^\\d.]", "");
        } else if (args.length == 2) {
            textChannelID = textChannel.getId();
        }
        return textChannelID;
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length >= 2 && args.length <= 3;
    }

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotificationChannelExists(textChannelID);
    }

    private boolean isTimeZoneValid(String timezone) {
        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime dateTime = timeStamp.atZone(ZoneId.of(timezone));
            return true;
        } catch (ZoneRulesException e) {
            return false;
        }
    }

    private void setTimezone(String textChannelID, String timezone) {
        databaseRequests.setTimezone(textChannelID, timezone);
        clientCache.setTimezone(textChannelID, timezone);
    }
}
