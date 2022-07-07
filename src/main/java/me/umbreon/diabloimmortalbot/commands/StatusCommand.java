package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class StatusCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public StatusCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runStatusCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        String channelId = message.getTextChannel().getId();
        TextChannel textChannel = message.getTextChannel();

        if (!databaseRequests.doNotificationChannelExists(channelId)) {
            textChannel.sendMessage(textChannel.getAsMention() + " is not registered.").queue();
            return;
        }

        switch (args[1].toLowerCase()) {
            case "a":
            case "all":
            case "0":
                databaseRequests.setStatus(channelId, 0);
                message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " now receives all messages.").queue();
                message.delete().queue();
                break;
            case "o":
            case "overworld":
            case "1":
                databaseRequests.setStatus(channelId, 1);
                message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " now receives overworld event messages.").queue();
                message.delete().queue();
                break;
            case "i":
            case "immportal":
            case "2":
                databaseRequests.setStatus(channelId, 2);
                message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " now receives immortal clan messages.").queue();
                message.delete().queue();
                break;
            case "s":
            case "shadow":
            case "3":
                databaseRequests.setStatus(channelId, 3);
                message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " now receives shadow clan messages.").queue();
                message.delete().queue();
                break;
            case "io":
            case "immortaloverworld":
            case "4":
                databaseRequests.setStatus(channelId, 4);
                message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " now receives immortal clan and overworld messages.").queue();
                message.delete().queue();
                break;
            case "so":
            case "shadowoverworld ":
            case "5":
                databaseRequests.setStatus(channelId, 5);
                message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() + " now receives shadow clan and overworld messages.").queue();
                message.delete().queue();
                break;
            default:
                message.getTextChannel().sendMessage("Invalid Status! Valid types: I for Immortal. S for Shadow. A for all messages.").queue();
                message.delete().queue();
        }

        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
    }



}
