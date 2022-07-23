package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Command: /notifications battlegrounds on/off
 */
public class NotificationsCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;
    private final ArrayList<String> listWithEvents = new ArrayList<>();
    private MessageEmbed eventNotAvailableEmbed;

    private String availableEventsString;
    private MessageEmbed invalidCommandEmbed;

    public NotificationsCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        fillListWithEvents();
        buildEventNotAvailableString();
        buildEventNotAvailableMessageEmbed();
        buildInvalidCommandEmbed();
    }

    public void runNotificationsCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String selectedEvent = args[1];

        if (!listWithEvents.contains(selectedEvent)) {
            textChannel.sendMessageEmbeds(eventNotAvailableEmbed).queue();
            return;
        }

        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getLanguage(guildID);
        if (isArgumentTrue(args[2])) {
            setEventValue(guildID, true, selectedEvent);
            textChannel.sendMessageEmbeds(buildEventUpdatedMessageEmbed(selectedEvent, true, language)).queue();
            return;
        }

        if (isArgumentFalse(args[2])) {
            setEventValue(guildID, false, selectedEvent);
            textChannel.sendMessageEmbeds(buildEventUpdatedMessageEmbed(selectedEvent, false, language)).queue();
            return;
        }

        textChannel.sendMessageEmbeds(invalidCommandEmbed).queue();
    }

    private void fillListWithEvents() {
        listWithEvents.add("battlegrounds");
    }

    private void buildEventNotAvailableMessageEmbed() {
        EmbedBuilder eventNotAvailableEmbedBuilder = new EmbedBuilder();

        eventNotAvailableEmbedBuilder.setColor(Color.RED);
        eventNotAvailableEmbedBuilder.addField("You cannot disable this event.", "This event does not exist or is not listed as event.", false);
        eventNotAvailableEmbedBuilder.addField("Available events:", availableEventsString, false);

        this.eventNotAvailableEmbed = eventNotAvailableEmbedBuilder.build();
    }

    private void buildEventNotAvailableString() {
        StringBuilder eventNotAvailableStringBuilder = new StringBuilder();

        for (String event : listWithEvents) {
            eventNotAvailableStringBuilder.append(event).append(", ");
        }

        this.availableEventsString = eventNotAvailableStringBuilder.toString();
    }

    private void setEventValue(String guildID, boolean value, String event) {
        clientCache.setBattlegroundsNotificationsEnabled(guildID, value);
        databaseRequests.setEventValue(event, value, guildID);
    }

    private boolean isArgumentTrue(String arg) {
        switch (arg.toLowerCase()) {
            case "true":
            case "on":
                return true;
            default:
                return false;
        }
    }

    private boolean isArgumentFalse(String arg) {
        switch (arg.toLowerCase()) {
            case "false":
            case "off":
                return true;
            default:
                return false;
        }
    }

    private void buildInvalidCommandEmbed() {
        EmbedBuilder invalidCommandEmbedBuilder = new EmbedBuilder();
        invalidCommandEmbedBuilder.setColor(Color.RED);
        invalidCommandEmbedBuilder.addField("Invalid Command", "Command example: >notifications battlegrounds off", false);
        this.invalidCommandEmbed = invalidCommandEmbedBuilder.build();
    }

    private MessageEmbed buildEventUpdatedMessageEmbed(String event, boolean value, String language) {
        EmbedBuilder eventUpdatedMessageEmbedBuilder = new EmbedBuilder();

        eventUpdatedMessageEmbedBuilder.setColor(Color.GREEN);

        String responseMessage;

        if (value) {
            responseMessage = String.format(LanguageController.getEventEnabledMessage(language), event);
        } else {
            responseMessage = String.format(LanguageController.getEventDisabledMessage(language), event);
        }

        eventUpdatedMessageEmbedBuilder.setTitle(responseMessage);

        return eventUpdatedMessageEmbedBuilder.build();
    }
}
