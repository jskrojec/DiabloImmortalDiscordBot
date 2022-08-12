package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.Objects;

/**
 * Command: >role @Role
 **/
public class RoleCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RoleCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runRoleCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            textChannel.sendMessage(LanguageController.getInvalidCommandMessage(language)).queue();
            return;
        }

        String textChannelID = textChannel.getId();
        if (!isChannelRegistered(textChannelID)) {
            textChannel.sendMessage(String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention())).queue();
            return;
        }

        Role mentionedRole = getRoleFromMessage(message, textChannel);
        if (mentionedRole == null) {
            textChannel.sendMessage(LanguageController.getRoleNotFoundMessage(language)).queue();
            return;
        }

        String roleID = mentionedRole.getId();
        setRole(textChannelID, roleID);
        textChannel.sendMessage(String.format(LanguageController.getIsSetMessage(language), mentionedRole.getAsMention())).queue();
    }

    // -

    private Role getRoleFromMessage(Message message, TextChannel textChannel) {
        String[] args = message.getContentRaw().split(" ");
        String role = args[1];
        String roleID = StringAssistant.removeAllNonNumbers(role);
        Guild guild = textChannel.getGuild();

        if (getRoleByID(guild, roleID) != null) {
            return getRoleByID(guild, roleID);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(args[i]);
            if (i != args.length - 1) {
                stringBuilder.append(" ");
            }
        }

        String roleName = stringBuilder.toString();
        if (getRoleByName(guild, roleName) != null) {
            return getRoleByName(guild, roleName);
        }

        return null;
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length > 1 && args.length <= 3;
    }

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private Role getRoleByID(Guild guild, String roleID) {
        List<Role> roles = guild.getRoles();
        return  roles.stream().filter(role -> Objects.equals(role.getId(), roleID))
                .findFirst()
                .orElse(null);
    }

    private Role getRoleByName(Guild guild, String roleName) {
        List<Role> roles = guild.getRoles();

        return roles.stream().filter(role -> Objects.equals(role.getName(), roleName))
                .findFirst()
                .orElse(null);
    }

    private void setRole(String textChannelID, String roleID) {
        clientCache.setRoleID(textChannelID, roleID);
        databaseRequests.updateNotifierChannelRole(textChannelID, roleID);
    }

}
