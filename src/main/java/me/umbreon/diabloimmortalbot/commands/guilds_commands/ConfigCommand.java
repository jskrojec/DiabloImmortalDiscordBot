package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.commands.ClientCommand;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.util.List;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /config
 * Description: Show's an embed containing all guild settings
 */
public class ConfigCommand implements ClientCommand {

    private final GuildsCache guildsCache;

    public ConfigCommand(GuildsCache guildsCache) {
        this.guildsCache = guildsCache;
    }

    @Override
    public void runCommand(SlashCommandInteraction event) {
        String guildID = event.getGuild().getId();
        Member member = event.getMember();
        replyEmbedEphemeralToUser(event, buildServerInfoEmbed(guildID, member));
    }

    private MessageEmbed buildServerInfoEmbed(String guildID, Member member) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Server Configurations:");

        String guildLanguage = guildsCache.getGuildLanguage(guildID);
        GuildInformation guildInformation = guildsCache.getGuildInformation(guildID);

        embedBuilder.addField(LanguageController.getInfoLanguageMessage(guildLanguage), guildInformation.getLanguage(), true);
        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), guildInformation.getTimezone(), true);
        embedBuilder.addField(LanguageController.getInfoGuildIdMessage(guildLanguage), guildInformation.getGuildID(), true);

        String yesMessage = LanguageController.getInfoYesMessage(guildLanguage);
        String noMessage = LanguageController.getInfoNoMessage(guildLanguage);
        String eventMessageEnabled = guildInformation.isEventMessageEnabled() ? yesMessage : noMessage;
        embedBuilder.addField("Event messages", eventMessageEnabled, true);

        String headUpMessagesEnabled = guildInformation.isHeadUpEnabled() ? yesMessage : noMessage;
        embedBuilder.addField("Head up messages", headUpMessagesEnabled, true);

        String adminRoleID = guildsCache.getAdminRoleID(guildID);
        String botAdminRole = adminRoleID == null ? "Default" : adminRoleID;
        embedBuilder.addField("Bot Admin role", botAdminRole, true);

        String doUserGotBotAdminRole = hasUserAdminPrivileges(member, adminRoleID) ? yesMessage : noMessage;
        embedBuilder.addField("Is user Bot Admin", doUserGotBotAdminRole, true);

        return embedBuilder.build();
    }

    private boolean hasUserAdminPrivileges(Member member, String adminRoleID) {
        List<Role> roles = member.getRoles();
        Role tempRole;

        if (adminRoleID == null) {
            tempRole = roles.stream().filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                    .findFirst().orElse(null);
            return tempRole != null;
        }

        tempRole = roles.stream().filter(role -> role.getId().equals(adminRoleID))
                .findFirst().orElse(null);
        return tempRole != null;
    }

}
