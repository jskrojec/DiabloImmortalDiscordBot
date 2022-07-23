package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Command: >cm create TEXTCHANNEL TIME DAY MESSAGE REPEAT
 */
public class CustomMessageCreate {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessageCreate(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessageCreateCommand(Message message) {
        message.delete().queue();

        String[] args = message.getContentRaw().split(" ");


    }
}
