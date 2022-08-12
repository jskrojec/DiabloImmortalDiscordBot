package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class CustomMessageCommand {

    private final CustomMessageCreate customMessageCreate;
    private final CustomMessageDelete customMessageDelete;
    private final CustomMessageList customMessageList;
    private final CustomMessageInfo customMessageInfo;

    public CustomMessageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        customMessageCreate = new CustomMessageCreate(clientCache, databaseRequests);
        customMessageDelete = new CustomMessageDelete(clientCache, databaseRequests);
        customMessageList = new CustomMessageList(clientCache);
        customMessageInfo = new CustomMessageInfo(clientCache);
    }

    public void runCustomMessageCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");

        switch (args[1].toLowerCase()) {
            case "create":
            case "c":
                customMessageCreate.runCustomMessageCreateCommand(message);
                break;
            case "delete":
            case "d":
            case "del":
                customMessageDelete.runCustomMessageDelete(message);
                break;
            case "list":
            case "l":
                customMessageList.runCustomMessageList(message);
                break;
            case "info":
            case "i":
                customMessageInfo.runCustomMessageInfoCommand(message);
                break;
        }
    }

    public CustomMessageCreate getCustomMessageCreate() {
        return customMessageCreate;
    }
}
