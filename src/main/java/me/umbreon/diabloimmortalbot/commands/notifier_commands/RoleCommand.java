package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.IdentifierConverter;
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
        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();

        String[] args = message.getContentRaw().split(" ");
        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);
        if (!clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention());
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        String roleID = IdentifierConverter.removeAllNonNumbers(args[1]);
        Guild guild = message.getGuild();
        if (args[1].equalsIgnoreCase("@here")) {
            setRoleToHere(message, language);
            return;
        }

        Role role = getRoleByRoleID(roleID, guild);
        if (role == null) {
            String responseMessage = LanguageController.getRoleNotFoundMessage(language);
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        clientCache.setRole(channelID, roleID);
        databaseRequests.setRole(channelID, roleID);
        String response = String.format(LanguageController.getIsSetMessage(language), role.getAsMention());
        textChannel.sendMessage(response).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
    }

    private void setRoleToHere(Message message, String language) {
        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();
        String role = "@here";

        clientCache.setRole(channelID, role);
        databaseRequests.setRole(channelID, role);
        String responseMessage = String.format(LanguageController.getIsSetMessage(language), "Here");
        message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
    }

    private Role getRoleByRoleID(String roleID, Guild guild) {
        try {
            return guild.getRoleById(roleID);
        } catch (NullPointerException | IllegalAccessError e) {
            return null;
        }

    }
}
