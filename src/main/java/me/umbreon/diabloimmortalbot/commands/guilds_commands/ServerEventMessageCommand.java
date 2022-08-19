package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class ServerEventMessageCommand {

    public ClientCache clientCache;
    public DatabaseRequests databaseRequests;

    public ServerEventMessageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runServerEventMessageCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        String guildID = textChannel.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanguage));
            return;
        }

        if (clientCache.isEventMessageOnServerEnabled(guildID) && BooleanAssistant.isValueTrue(args[2])) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getEventMessagesAlreadyOnMessage(guildLanguage));
            return;
        }

        if (!clientCache.isEventMessageOnServerEnabled(guildID) && BooleanAssistant.isValueFalse(args[2])) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getEventMessagesAlreadyOffMessage(guildLanguage));
            return;
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventMessageOnServerValue(guildID, true);
            textChannel.sendMessage(String.format(LanguageController.getEventEnabledMessage(guildLanguage), "Event messages")).queue();
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventMessageOnServerValue(guildID, false);
            textChannel.sendMessage(String.format(LanguageController.getEventDisabledMessage(guildLanguage), "Event messages")).queue();
            return;
        }

        textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length == 3;
    }

    private void setEventMessageOnServerValue(String guildID, boolean value) {
        databaseRequests.setEventMessageOnServerValue(value, guildID);
        clientCache.setEventMessageOnServerValue(guildID, value);
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }
}
