package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Command: >server autodelete on/off
 * Command: >server autodelete 24/48/72
 */
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

        if (BooleanAssistant.isValueTrue(value)) {
            clientCache.setAutoDeleteBoolValue(guildID, true);
            databaseRequests.setAutoDeleteEnabled(guildID, true);
            textChannel.sendMessage("Message auto delete enabled.").queue();
            return;
        }

        if (BooleanAssistant.isValueFalse(value)) {
            clientCache.setAutoDeleteBoolValue(guildID, false);
            databaseRequests.setAutoDeleteEnabled(guildID, false);
            textChannel.sendMessage("Message auto delete disabled.").queue();
            return;
        }

        int s;
        try {
            s = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            textChannel.sendMessage("Invalid command input. Command Example: >server autodelete on\n" +
                    "Possible values: on/off").queue();
            return;
        }

        switch (s) {
            case 24:
            case 48:
            case 72:
                setAutoDeleteValue(guildID, s);
                textChannel.sendMessage(String.format("Auto delete timer set to %s hours.", s)).queue();
                break;
            default:
                textChannel.sendMessage("Invalid command input. Command Example: >server autodelete 24\n" +
                        "Possible values: 24, 48 & 72.").queue();
        }
    }

    private void setAutoDeleteValue(String guildID, int autoDeleteValue) {
        clientCache.setAutoDeleteIntValue(guildID, autoDeleteValue);
        databaseRequests.setAutoDeleteValue(guildID, autoDeleteValue);
    }
}
