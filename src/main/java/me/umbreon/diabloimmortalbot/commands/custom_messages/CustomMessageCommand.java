package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;

public class CustomMessageCommand {

    private final CustomMessageCreate customMessageCreate;
    private final CustomMessageDelete customMessageDelete;
    private final CustomMessageList customMessageList;

    public CustomMessageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        customMessageCreate = new CustomMessageCreate(clientCache, databaseRequests);
        customMessageDelete = new CustomMessageDelete(clientCache, databaseRequests);
        customMessageList = new CustomMessageList(clientCache);
    }

    public void runCustomMessageCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");

        switch (args[1].toLowerCase()) {
            case "create":
                customMessageCreate.runCustomMessageCreateCommand(message);
                break;
            case "delete":
                customMessageDelete.runCustomMessageDelete(message);
                break;
            case "list":
                customMessageList.runCustomMessageList(message);
                break;
        }
    }
}
