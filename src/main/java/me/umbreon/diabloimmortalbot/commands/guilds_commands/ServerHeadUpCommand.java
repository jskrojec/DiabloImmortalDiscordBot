package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

/**
 * Command: >server headup on/off
 */
public class ServerHeadUpCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ServerHeadUpCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runServerHeadUpCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        TextChannel textChannel = message.getTextChannel();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getInvalidCommandMessage(guildLanguage));
            return;
        }

        if (clientCache.isHeadUpOnServerEnabled(guildID) && BooleanAssistant.isValueTrue(args[2])) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getHeadUpMessagesAlreadyOnMessage(guildLanguage));
            return;
        }

        if (!clientCache.isHeadUpOnServerEnabled(guildID) && BooleanAssistant.isValueFalse(args[2])) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getHeadUpMessagesAlreadyOffMessages(guildLanguage));
            return;
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            setEventHeadUpOnServerValue(guildID, false);
            sendMessageToTextChannel(guildID, textChannel, String.format(LanguageController.getEventEnabledMessage(guildLanguage), "Head up"));
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            setEventHeadUpOnServerValue(guildID, false);
            sendMessageToTextChannel(guildID, textChannel, String.format(LanguageController.getEventDisabledMessage(guildLanguage), "Head up"));
            return;
        }

        textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length == 3;
    }

    private void sendMessageToTextChannel(String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }

    private void setEventHeadUpOnServerValue(String guildID, boolean value) {
        databaseRequests.setEventHeadUpOnServerValue(value, guildID);
        clientCache.setHeadUpOnServerValue(guildID, value);
    }
}
