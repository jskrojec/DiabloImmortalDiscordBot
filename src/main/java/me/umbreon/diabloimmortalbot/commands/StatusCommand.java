package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

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
            textChannel.sendMessage(textChannel.getAsMention() + " is not registered.").queue(message1 -> {
                message1.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        switch (args[1].toLowerCase()) {
            case "a":
            case "all":
            case "0":
                databaseRequests.setStatus(channelId, 0);
                textChannel.sendMessage(message.getTextChannel().getAsMention() + " now receives all messages.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                message.delete().queue();
                break;
            case "o":
            case "overworld":
            case "1":
                databaseRequests.setStatus(channelId, 1);
                textChannel.sendMessage(message.getTextChannel().getAsMention() + " now receives overworld event messages.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                message.delete().queue();
                break;
            case "i":
            case "immportal":
            case "2":
                databaseRequests.setStatus(channelId, 2);
                textChannel.sendMessage(message.getTextChannel().getAsMention() + " now receives immortal clan messages.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                message.delete().queue();
                break;
            case "s":
            case "shadow":
            case "3":
                databaseRequests.setStatus(channelId, 3);
                textChannel.sendMessage(message.getTextChannel().getAsMention() + " now receives shadow clan messages.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                message.delete().queue();
                break;
            case "io":
            case "immortaloverworld":
            case "4":
                databaseRequests.setStatus(channelId, 4);
                textChannel.sendMessage(message.getTextChannel().getAsMention() + " now receives immortal clan and overworld messages.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                message.delete().queue();
                break;
            case "so":
            case "shadowoverworld ":
            case "5":
                databaseRequests.setStatus(channelId, 5);
                textChannel.sendMessage(message.getTextChannel().getAsMention() + " now receives shadow clan and overworld messages.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                message.delete().queue();
                break;
            case "128": //TimeZone check
                message.delete().queue();
                message.getTextChannel().sendMessage("Status set to 128 Test-Mode.").queue(message1 -> {
                    message1.delete().queueAfter(10, TimeUnit.SECONDS);
                });
                databaseRequests.setStatus(message.getTextChannel().getId(), 128);
                break;
            case "255":
                if (message.getAuthor().getId().equals("154279200432324608")) {
                    message.delete().queue();
                    message.getTextChannel().sendMessage("Status set to 255.").queue(message1 -> {
                        message1.delete().queueAfter(10, TimeUnit.SECONDS);
                    });
                    databaseRequests.setStatus(message.getTextChannel().getId(), 255);
                }
                break;
            case "256":
                if (message.getAuthor().getId().equals("154279200432324608")) {
                    message.delete().queue();
                    message.getTextChannel().sendMessage("Status set to 256.").queue(message1 -> {
                        message1.delete().queueAfter(10, TimeUnit.SECONDS);
                    });
                    databaseRequests.setStatus(message.getTextChannel().getId(), 256);
                }
                break;
            default:
                message.getTextChannel().sendMessage("Possible Codes for status:\n" +
                        "0 = All messages.\n" +
                        "1 = Only overworld.\n" +
                        "2 = Only Immortal\n" +
                        "3 = Only Shadow\n" +
                        "4 = Immortal with overworld\n" +
                        "5 = Shadow with overworld").queue();
                message.delete().queue();
        }

        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
    }


}
