package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Command: >server message on/off
 */
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
            textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
            return;
        }

        if (clientCache.isEventMessageOnServerEnabled(guildID) && BooleanAssistant.isValueTrue(args[2])) {
            textChannel.sendMessage("Event messages are already enabled on your server.").queue();
            return;
        }

        if (!clientCache.isEventMessageOnServerEnabled(guildID) && BooleanAssistant.isValueFalse(args[2])) {
            textChannel.sendMessage("Event messages are already disabled on your server.").queue();
            return;
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            databaseRequests.setEventMessageOnServerValue(true, guildID);
            clientCache.setEventMessageOnServerValue(guildID, true);
            textChannel.sendMessage(String.format(LanguageController.getEventEnabledMessage(guildLanguage), "Event messages")).queue();
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            databaseRequests.setEventMessageOnServerValue(false, guildID);
            clientCache.setEventMessageOnServerValue(guildID, false);
            textChannel.sendMessage(String.format(LanguageController.getEventDisabledMessage(guildLanguage), "Event messages")).queue();
            return;
        }

        //Todo: add useful invalid command message
        textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length == 3;
    }
}
