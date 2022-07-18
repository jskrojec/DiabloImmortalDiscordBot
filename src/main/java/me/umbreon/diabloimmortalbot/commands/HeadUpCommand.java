package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;
/**
 * Command >headup [on/off]
 * Alternative: >headup [true/false]
 */
public class HeadUpCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public HeadUpCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runHeadUpCommand(Message message) {
        message.delete().queue();

        String[] args = message.getContentRaw().split(" ");

        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        String guildID = message.getGuild().getId();
        TextChannel textChannel = message.getTextChannel();
        String language = clientCache.getLanguage(guildID);

        if (isArgumentFalse(args[1])) {
            setHeadUpValue(guildID, false);
            sendResponseMessage(message, textChannel, language, "disabled");
            return;
        }

        if (isArgumentTrue(args[1])) {
            setHeadUpValue(guildID, true);
            sendResponseMessage(message, textChannel, language, "enabled");
        }
    }

    private void sendResponseMessage(Message message, TextChannel textChannel, String language, String disabled) {
        String responseMessage;
        responseMessage = String.format(LanguageController.getHeadUpValueSetToMessage(language), disabled);
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
        createLogEntry(message, responseMessage);
    }

    private void setHeadUpValue(String guildID, boolean headUpValue) {
        clientCache.setHeadUpValue(guildID, headUpValue);
        databaseRequests.setHeadUpValue(guildID, headUpValue);
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

    private void createLogEntry(Message message, String responseMessage) {
        String channelName = message.getTextChannel().getName();
        String guildName = message.getGuild().getName();
        String logMessage = "Sended message " + responseMessage + " to " + channelName + " in guild " + guildName + ".";
        ClientLogger.createNewInfoLogEntry(logMessage);
    }
}
