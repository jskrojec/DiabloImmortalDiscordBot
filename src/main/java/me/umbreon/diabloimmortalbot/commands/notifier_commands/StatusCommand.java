package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Command: >status I #Channel
 * Command: >status I
 **/
public class StatusCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;
    private final ArrayList<Integer> validStatuses = new ArrayList<>();

    public StatusCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
        fillValidStatusesArray();
    }

    public void runStatusCommand(Message message) {
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

        int status;
        try {
            status = Integer.parseInt(args[1]);
        } catch (NullPointerException e) {
            textChannel.sendMessage("Invalid status.").queue();
            return;
        }

        if (!isStatusValid(status)) {
            textChannel.sendMessage("Invalid status.").queue();
            return;
        }

        setStatus(textChannelID, status);
        String returnMessage = getReturnMessage(status, language);
        if (returnMessage != null) textChannel.sendMessage(returnMessage).queue();
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length >= 2 && args.length <= 3;
    }

    private boolean isStatusValid(int status) {
        return validStatuses.contains(status);
    }

    private String getTextChannelID(TextChannel textChannel, String[] args) {
        String textChannelID = null;
        if (args.length == 3) {
            textChannelID = args[2].replaceAll("[^\\d.]", "");
        } else if (args.length == 2) {
            textChannelID = textChannel.getId();
        }
        return textChannelID;
    }

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotificationChannelExists(textChannelID);
    }

    private void setStatus(String textChannelID, int status) {
        databaseRequests.setStatus(textChannelID, status);
        clientCache.setStatus(textChannelID, status);
    }

    private void fillValidStatusesArray() {
        for (int i = 0; i < 9; i++) {
            validStatuses.add(i);
        }
        validStatuses.add(128);
    }

    private String getReturnMessage(int status, String language) {
        String returnMessage = null;

        switch (status) {
            case 0:
                returnMessage = LanguageController.getReceiveAllMessagesMessage(language);
                break;
            case 1:
            case 9:
                returnMessage = LanguageController.getReceiveOverworldMessage(language);
                break;
            case 2:
                returnMessage = LanguageController.getReceiveImmortalMessage(language);
                break;
            case 3:
                returnMessage = LanguageController.getReceiveShadowMessage(language);
                break;
            case 4:
            case 7:
                returnMessage = LanguageController.getReceiveOwImmortalMessage(language);
                break;
            case 5:
            case 8:
                returnMessage = LanguageController.getReceiveOwShadowMessage(language);
                break;
            case 128:
                returnMessage = LanguageController.getUnknownStatusMessage(language);
        }

        return returnMessage;
    }
}
