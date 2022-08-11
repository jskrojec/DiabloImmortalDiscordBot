package me.umbreon.diabloimmortalbot.commands.notifier_commands;

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
 * Command: >role @Role #Channel
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

        String textChannelID = getTextChannelID(textChannel, args);
        if (!isChannelRegistered(textChannelID)) {
            textChannel.sendMessage(String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention())).queue();
            return;
        }

        String roleID = StringAssistant.removeAllNonNumbers(args[1]);
        Guild guild = textChannel.getGuild();
        if (!doRoleExistInGuild(guild, roleID)) {
            textChannel.sendMessage(LanguageController.getRoleNotFoundMessage(language)).queue();
            return;
        }

        setRole(textChannelID, roleID);
        textChannel.sendMessage(String.format(LanguageController.getIsSetMessage(language), guild.getTextChannelById(roleID).getAsMention())).queue();
    }

    public boolean areArgumentsValid(String[] args) {
        return args.length > 1 && args.length <= 3;
    }

    private String getTextChannelID(TextChannel textChannel, String[] args) {
        String textChannelID = null;
        if (args.length == 3) {
            textChannelID = StringAssistant.removeAllNonNumbers(args[1]);
        } else if (args.length == 2) {
            textChannelID = textChannel.getId();
        }
        return textChannelID;
    }

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private boolean doRoleExistInGuild(Guild guild, String roleID) {
        List<Role> roles = guild.getRoles();
        Role tempRole = roles.stream().filter(role -> Objects.equals(role.getId(), roleID))
                .findFirst()
                .orElse(null);
        return tempRole != null;
    }

    private void setRole(String textChannelID, String roleID) {
        clientCache.setRoleID(textChannelID, roleID);
        databaseRequests.updateNotifierChannelRole(textChannelID, roleID);
    }

}
