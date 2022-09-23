package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.cache.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.List;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /config
 * Description: Show's an embed containing all guild settings
 */
public class ConfigCommand {

    public ClientCache clientCache;
    private final GuildsCache guildsCache;

    public ConfigCommand(final ClientCache clientCache, GuildsCache guildsCache) {
        this.clientCache = clientCache;
        this.guildsCache = guildsCache;
    }

    public void runConfigCommand(final SlashCommandInteractionEvent event) {
        String guildID = event.getGuild().getId();
        Member member = event.getMember();
        boolean hasBotAdminRole = findBotRole(member) != null;
        event.replyEmbeds(buildServerInfoEmbed(guildID, hasBotAdminRole)).setEphemeral(true).queue();
    }

    private MessageEmbed buildServerInfoEmbed(final String guildID, final boolean hasBotAdminRole) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);

        embedBuilder.setTitle("Server Configurations:");
        GuildInformation guildInformation = guildsCache.getGuildInformation(guildID);
        embedBuilder.addField(LanguageController.getInfoLanguageMessage(guildLanguage), guildInformation.getLanguage(), true);
        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), guildInformation.getTimezone(), true);
        embedBuilder.addField(LanguageController.getInfoGuildIdMessage(guildLanguage), guildInformation.getGuildID(), true);

        String yesMessage = LanguageController.getInfoYesMessage(guildLanguage);
        String noMessage = LanguageController.getInfoNoMessage(guildLanguage);

        String eventMessageEnabled = guildInformation.isEventMessageEnabled() ? yesMessage : noMessage;
        String headUpMessagesEnabled = guildInformation.isHeadUpEnabled() ? yesMessage : noMessage;
        String doUserGotBotAdminRole = hasBotAdminRole ? yesMessage : noMessage;

        embedBuilder.addField("Event messages", eventMessageEnabled, true);
        embedBuilder.addField("Head up messages", headUpMessagesEnabled, true);
        embedBuilder.addField("Is user Bot Admin", doUserGotBotAdminRole, true);

        return embedBuilder.build();
    }

    private Role findBotRole(final Member member) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
    }
}
