package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

/**
 * Command: >cm create TEXTCHANNEL DAY TIME REPEAT MESSAGE
 */
public class CustomMessageCreate {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessageCreate(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessageCreateCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String weekday = args[3];
        String time = args[4];
        if (!areArgumentsValid(weekday, time, args)) {
            textChannel.sendMessageEmbeds(buildInvalidCommandUsageEmbed()).queue();
            return;
        }

        //Replaces non numbers with empty space to get the clear id
        String textchannelID = args[2].replaceAll("[^\\d.]", "");
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);
        TextChannel targetTextChannel;
        try {
            targetTextChannel = message.getGuild().getTextChannelById(textchannelID);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equalsIgnoreCase("ID may not be empty")) {
                textChannel.sendMessageEmbeds(createChannelDoesNotExistEmbed(language)).queue();
            } else {
                textChannel.sendMessage("An error has occurred. Please report error \"0001\". No action " +
                        "has been performed.").queue();
                ClientLogger.createNewErrorLogEntry(e);
                e.printStackTrace();
            }
            return;
        }

        String repeatValue = args[5];
        boolean repeat;
        if (BooleanAssistant.isValueTrue(repeatValue)) {
            repeat = true;
        } else if (BooleanAssistant.isValueFalse(repeatValue)) {
            repeat = false;
        } else {
            textChannel.sendMessageEmbeds(buildInvalidCommandUsageEmbed()).queue();
            return;
        }

        String notificationMessage = getNotificationMessage(args);
        CustomMessage customMessage = new CustomMessage(textchannelID, guildID, notificationMessage, weekday, time, repeat);
        clientCache.addCustomMessageToList(customMessage);
        databaseRequests.createNewCustomMessageEntry(customMessage);
        //todo: remove this.
        clientCache.setCustomMessagesList(databaseRequests.getAllCustomMessages());

        textChannel.sendMessageEmbeds(buildNewCustomMessageCreatedMessage(language)).queue();
    }

    private String getNotificationMessage(String[] args) {
        StringBuilder notificationMessageBuilder = new StringBuilder();
        for (int i = 6; i < args.length; i++) {
            notificationMessageBuilder.append(args[i]).append(" ");
        }
        return notificationMessageBuilder.toString();
    }

    private boolean areArgumentsValid(String weekday, String time, String[] args) {
        if (args.length < 6) {
            return false;
        }

        if (!args[1].equalsIgnoreCase("create")) {
            return false;
        }


        if (!isWeekdayValid(weekday)) {
            return false;
        }


        if (!isTimeInPattern(time)) {
            return false;
        }

        return true;
    }

    //todo: that's an ugly way to to that :(
    private boolean isWeekdayValid(String weekday) {
        switch (weekday.toLowerCase()) {
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
            case "saturday":
            case "sunday":
                return true;
            default:
                return false;
        }
    }

    private boolean isTimeInPattern(String time) {
        //Checks if time is valid
        return time.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    private MessageEmbed buildInvalidCommandUsageEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.RED);
        embedBuilder.addField("Invalid command", "Command example: >cm create #YOUR_TEXTCHANNEL " +
                "Tuesday 16:30 Yes Here's your custom message.", false);
        return embedBuilder.build();
    }

    private MessageEmbed createChannelDoesNotExistEmbed(String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.RED);
        embedBuilder.addField(LanguageController.getChannelNotFoundMessage(language), LanguageController.getDoBotGotRightsMessage(language), false);
        return embedBuilder.build();
    }

    private MessageEmbed buildNewCustomMessageCreatedMessage(String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setTitle(LanguageController.getCustomMessageCreated(language));
        return embedBuilder.build();
    }

}
