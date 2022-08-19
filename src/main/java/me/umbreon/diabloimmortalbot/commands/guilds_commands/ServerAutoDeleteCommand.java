package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class ServerAutoDeleteCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ServerAutoDeleteCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runServerAutoDeleteCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        String value = args[2];
        String guildID = message.getGuild().getId();
        TextChannel textChannel = message.getTextChannel();
        String guildLanugage = clientCache.getGuildLanguage(guildID);

        if (BooleanAssistant.isValueTrue(value)) {
            setAutoDeleteValue(guildID, true);
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getAutoDeleteEnabledMessage(guildLanugage));
            return;
        }

        if (BooleanAssistant.isValueFalse(value)) {
            setAutoDeleteValue(guildID, false);
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getAutoDeleteDisabledMessage(guildLanugage));
            return;
        }

        int autoDeleteValue;
        try {
            autoDeleteValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanugage));
            return;
        }

        if (isAutoSaveValueValid(autoDeleteValue)) {
            setAutoDeleteValue(guildID, autoDeleteValue);
            String autoDeleteValueUpdatedMessage = String.format(LanguageController.getAutoDeleteValueSetMessage(guildLanugage), autoDeleteValue);
            sendMessageToTextChannel(guildID, textChannel, autoDeleteValueUpdatedMessage);
            return;
        }

        sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanugage));
    }

    private void setAutoDeleteValue(String guildID, int autoDeleteValue) {
        clientCache.setAutoDeleteIntValue(guildID, autoDeleteValue);
        databaseRequests.setAutoDeleteValue(guildID, autoDeleteValue);
    }

    private void setAutoDeleteValue(String guildID, boolean value) {
        clientCache.setAutoDeleteBoolValue(guildID, value);
        databaseRequests.setAutoDeleteEnabled(guildID, value);
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }

    private boolean isAutoSaveValueValid(int autoSaveValue) {
        return (autoSaveValue == 24 || autoSaveValue == 48 || autoSaveValue == 72);
    }
}
