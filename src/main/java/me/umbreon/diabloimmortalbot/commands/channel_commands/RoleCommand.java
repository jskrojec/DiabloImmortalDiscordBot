package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Objects;

public class RoleCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RoleCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public String runRoleCommand(final String[] args, final TextChannel textChannel, final Guild guild) {
        final String guildID = guild.getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!isCommandValid(args)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        final String textChannelID = textChannel.getId();
        if (!isChannelRegistered(textChannelID)) {
            return String.format(LanguageController.getChannelNotRegisteredMessage(guildLanguage), textChannel.getAsMention());
        }

        if (args[1].equalsIgnoreCase("@here") || args[1].equalsIgnoreCase("here")) {
            setRole(textChannelID, args[1]);
            return String.format(LanguageController.getRoleChangedMessage(guildLanguage), args[1]);
        }

        final Role mentionedRole = getRoleFromMessage(args, textChannel);
        if (mentionedRole == null) {
            return LanguageController.getRoleNotFoundMessage(guildLanguage);
        }

        final String roleID = mentionedRole.getId();
        setRole(textChannelID, roleID);
        return String.format(LanguageController.getRoleChangedMessage(guildLanguage), mentionedRole.getAsMention());
    }

    private Role getRoleFromMessage(final String[] args, final TextChannel textChannel) {
        final String rawRoleName = args[1];
        final char firstCharFromRoleName = rawRoleName.charAt(0);
        final Guild guild = textChannel.getGuild();

        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(args[i]);
            if (i != args.length - 1) {
                stringBuilder.append(" ");
            }
        }

        final String roleName = stringBuilder.toString();
        if (String.valueOf(firstCharFromRoleName).equalsIgnoreCase("@")) {
            return getRoleByName(guild, roleName.substring(1));
        }

        return null;
    }

    private boolean isCommandValid(final String[] args) {
        return args.length > 1;
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private Role getRoleByName(final Guild guild, final String roleName) {
        return guild.getRoles().stream().filter(role -> Objects.equals(role.getName(), roleName))
                .findFirst()
                .orElse(null);
    }

    private void setRole(final String textChannelID, final String roleID) {
        clientCache.setRoleID(textChannelID, roleID);
        databaseRequests.updateNotifierChannelRole(textChannelID, roleID);
    }
}
