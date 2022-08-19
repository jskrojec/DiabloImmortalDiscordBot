package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class EventSetCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public EventSetCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runNotificationsCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String selectedEvent = args[1].toLowerCase();
        String guildID = textChannel.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!doEventExist(selectedEvent)) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getErrorCannotDisableEventMessage(guildLanguage));
            return;
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventValue(true, selectedEvent, textChannel.getId());
            String eventEnabledMessage = String.format(LanguageController.getEventEnabledMessage(guildLanguage), selectedEvent);
            sendMessageToTextChannel(guildID, textChannel, eventEnabledMessage);
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventValue(false, selectedEvent, textChannel.getId());
            String eventDisableMessage = String.format(LanguageController.getEventDisabledMessage(guildLanguage), selectedEvent);
            sendMessageToTextChannel(guildID, textChannel, eventDisableMessage);
            return;
        }

        sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanguage));
    }

    private boolean doEventExist(String event) {
        return clientCache.getListWithAvailableNotifications().contains(event);
    }

    private void setEventValue(boolean value, String event, String textChannelID) {
        databaseRequests.updateNotifierChannelEventMessage(event, textChannelID, value);
        clientCache.setNotificationsValue(event, value, textChannelID);
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }
}
