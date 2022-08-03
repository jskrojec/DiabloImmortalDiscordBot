package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Command: /notifications battlegrounds on/off
 * batlegrund
 * Possible events: AncientArena, AncientNightmare, Assembly, Battlegrounds, DefendVault, RaidVault, DemonGates,
 * ShadowLottery, HauntedCarriage, HeadUpMessage, EventMessage
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
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String selectedEvent = args[1];

        if (!listWithEvents.contains(selectedEvent)) {
            textChannel.sendMessageEmbeds(eventNotAvailableEmbed).queue();
            return;
        }

        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getLanguage(guildID);
        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventValue(guildID, true, selectedEvent);
            textChannel.sendMessageEmbeds(buildEventUpdatedMessageEmbed(selectedEvent, true, language)).queue();
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventValue(guildID, false, selectedEvent);
            textChannel.sendMessageEmbeds(buildEventUpdatedMessageEmbed(selectedEvent, false, language)).queue();
            return;
        }

        textChannel.sendMessageEmbeds(invalidCommandEmbed).queue();
    }

    private void fillListWithEvents() {
        listWithEvents.add("battlegrounds");
        listWithEvents.add("headup");
        listWithEvents.add("AncientArena");
        listWithEvents.add("AncientNightmare");
        listWithEvents.add("Assembly");
        listWithEvents.add("DefendVault");
        listWithEvents.add("RaidVault");
        listWithEvents.add("DemonGates");
        listWithEvents.add("ShadowLottery");
        listWithEvents.add("HauntedCarriage");
        listWithEvents.add("message");

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
        clientCache.setEventValue(event, guildID, value);
        databaseRequests.setEventValue(event, value, guildID);
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
