package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

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
            textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
            return;
        }

        if (clientCache.isHeadUpOnServerEnabled(guildID) && BooleanAssistant.isValueTrue(args[2])) {
            textChannel.sendMessage("Head up messages are already enabled on your server.").queue();
            return;
        }

        if (!clientCache.isHeadUpOnServerEnabled(guildID) && BooleanAssistant.isValueFalse(args[2])) {
            textChannel.sendMessage("Head up messages are already disabled on your server.").queue();
            return;
        }

        if (BooleanAssistant.isValueTrue(args[2])) {
            databaseRequests.setEventHeadUpOnServerValue(true, guildID);
            clientCache.setHeadUpOnServerValue(guildID, true);
            return;
        }

        if (BooleanAssistant.isValueFalse(args[2])) {
            databaseRequests.setEventHeadUpOnServerValue(false, guildID);
            clientCache.setHeadUpOnServerValue(guildID, false);
            return;
        }

        textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length == 3;
    }
}
