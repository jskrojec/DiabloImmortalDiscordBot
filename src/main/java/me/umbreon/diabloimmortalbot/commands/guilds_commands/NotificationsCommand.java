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

/**
 * Command: /notifications battlegrounds on/off
 * Possible events: AncientArena, AncientNightmare, Assembly, Battlegrounds, DefendVault, RaidVault, DemonGates,
 * ShadowLottery, HauntedCarriage, HeadUpMessage, EventMessage
 */
public class NotificationsCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;
    private MessageEmbed eventNotAvailableEmbed;

    private String availableEventsString;
    private MessageEmbed invalidCommandEmbed;

    public NotificationsCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        buildEventNotAvailableString();
        buildEventNotAvailableMessageEmbed();
        buildInvalidCommandEmbed();
    }

    public void runNotificationsCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String selectedEvent = args[1].toLowerCase();

        if (!clientCache.getListWithAvailableNotifications().contains(selectedEvent)) {
            textChannel.sendMessageEmbeds(eventNotAvailableEmbed).queue();
            return;
        }

        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);
        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventValue(true, selectedEvent, textChannel.getId());
            textChannel.sendMessageEmbeds(buildEventUpdatedMessageEmbed(selectedEvent, true, language)).queue();
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventValue(false, selectedEvent, textChannel.getId());
            textChannel.sendMessageEmbeds(buildEventUpdatedMessageEmbed(selectedEvent, false, language)).queue();
            return;
        }

        textChannel.sendMessageEmbeds(invalidCommandEmbed).queue();
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

        for (String event : clientCache.getListWithAvailableNotifications()) {
            eventNotAvailableStringBuilder.append(event).append(", ");
        }

        this.availableEventsString = eventNotAvailableStringBuilder.toString();
    }

    private void setEventValue(boolean value, String event, String textChannelID) {
        databaseRequests.updateNotifierChannelEventMessage(event, textChannelID, value);
        clientCache.setNotificationsValue(event, value, textChannelID);
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
