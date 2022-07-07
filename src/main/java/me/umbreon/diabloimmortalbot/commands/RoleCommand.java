package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class RoleCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RoleCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void onRoleCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        message.delete().queue();
        String channelId = textChannel.getId();
        String roleNonReplaced = args[1];
        String roleId = roleNonReplaced.replaceAll("[^\\d.]", "");

        if (!databaseRequests.doNotificationChannelExists(channelId)) {
            textChannel.sendMessage(textChannel.getAsMention() + " is not registered.").queue();
            return;
        }

        Role role1;
        try {
            role1 = message.getGuild().getRoleById(roleId);
        } catch (NullPointerException e) {
            message.getTextChannel().sendMessage("Role does not exist.").queue();
            ClientLogger.createNewLogEntry(e.getMessage());
            return;
        } catch (IllegalAccessError e) {
            message.getTextChannel().sendMessage("Unkown error occured, please check log file.").queue();
            ClientLogger.createNewLogEntry(e.getMessage());
            return;
        }

        databaseRequests.setRole(textChannel.getId(), roleId);
        message.getTextChannel().sendMessage(role1.getAsMention() + " is now set.").queue();
        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());
    }
}
