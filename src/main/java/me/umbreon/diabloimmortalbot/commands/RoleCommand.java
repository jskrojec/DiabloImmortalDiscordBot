package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.configuration.LanguageEnglish;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class RoleCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RoleCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runRoleCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getLanguage(guildID);

        if (!clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getNotRegisteredMessage(guildLanguage)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        String[] args = message.getContentRaw().split(" ");
        String roleID = args[1].replaceAll("[^\\d.]", "");
        Guild guild = message.getGuild();
        Role role = getRoleByRoleID(roleID, guild);

        if (args[1].equalsIgnoreCase("@here")) {
            setRoleToHere(message, guildLanguage);
            return;
        }

        if (role == null) {
            textChannel.sendMessage(LanguageController.getRoleNotFoundMessage(guildLanguage)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        clientCache.setRole(channelID, roleID);
        databaseRequests.setRole(channelID, roleID);
        message.getTextChannel().sendMessage(role.getAsMention() +
                LanguageController.getIsSetMessage(guildLanguage)).queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });
    }

    private void setRoleToHere(Message message, String language) {
        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();
        String role = "@here";

        clientCache.setRole(channelID, role);
        databaseRequests.setRole(channelID, role);
        message.getTextChannel().sendMessage("Here " + LanguageController.getIsSetMessage(language)).queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });
    }

    private Role getRoleByRoleID(String roleID, Guild guild) {
        try {
            return guild.getRoleById(roleID);
        } catch (NullPointerException | IllegalAccessError e) { //TODO: What is IllegalAccessError?
            ClientLogger.createNewLogEntry(guild.getId(), guild.getName(), guild.getOwnerId(), e.toString());
            return null;
        }
    }
}
