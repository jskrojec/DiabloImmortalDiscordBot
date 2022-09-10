package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

public class CustomMessageCommand {

    private final CustomMessageCreate customMessageCreate;
    private final CustomMessageDelete customMessageDelete;
    private final CustomMessageList customMessageList;
    private final CustomMessageInfo customMessageInfo;

    public CustomMessageCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        customMessageCreate = new CustomMessageCreate(clientCache, databaseRequests);
        customMessageDelete = new CustomMessageDelete(clientCache, databaseRequests);
        customMessageList = new CustomMessageList(clientCache);
        customMessageInfo = new CustomMessageInfo(clientCache);
    }

    public String runCustomMessageCommand(final String[] args, final TextChannel textChannel) {
        switch (args[1].toLowerCase()) {
            case "delete":
            case "d":
            case "del":
                return customMessageDelete.runCustomMessageDelete(args, textChannel);
            case "list":
            case "l":
                customMessageList.runCustomMessageList(textChannel);
                return null;
            case "info":
            case "i":
                customMessageInfo.runCustomMessageInfoCommand(args, textChannel);
                return null;
            default:
                return null;
        }
    }

    public CustomMessageCreate getCustomMessageCreate() {
        return customMessageCreate;
    }
}
