package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServerConfigCommand {

    public ClientCache clientCache;

    public ServerConfigCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runServerConfigCommand(final Member member, final TextChannel textChannel) {
        final String guildID = member != null ? member.getGuild().getId() : null;
        final boolean hasBotAdminRole = findBotRole(member) != null;
        sendMessageEmbedToTextChannel(guildID, textChannel, buildServerInfoEmbed(guildID, hasBotAdminRole));
    }

    public MessageEmbed buildServerInfoEmbed(final String guildID, final boolean hasBotAdminRole) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        embedBuilder.setTitle("Server Configurations:");
        final GuildInformation guildInformation = clientCache.getGuildInformation(guildID);
        embedBuilder.addField(LanguageController.getInfoLanguageMessage(guildLanguage), guildInformation.getLanguage(), true);
        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), guildInformation.getTimezone(), true);
        embedBuilder.addField(LanguageController.getInfoGuildIdMessage(guildLanguage), guildInformation.getGuildID(), true);

        final String yesMessage = LanguageController.getInfoYesMessage(guildLanguage);
        final String noMessage = LanguageController.getInfoNoMessage(guildLanguage);

        final String eventMessageEnabled = guildInformation.isEventMessageEnabled() ? yesMessage : noMessage;
        final String headUpMessagesEnabled = guildInformation.isHeadUpEnabled() ? yesMessage : noMessage;
        final String doUserGotBotAdminRole = hasBotAdminRole ? yesMessage : noMessage;
        final String isAutoSaveEnabled = clientCache.isAutoDeleteEnabled(guildID) ? yesMessage : noMessage;

        embedBuilder.addField("Event messages", eventMessageEnabled, true);
        embedBuilder.addField("Head up messages", headUpMessagesEnabled, true);
        embedBuilder.addField("Is user Bot Admin", doUserGotBotAdminRole, true);
        embedBuilder.addField("Auto delete enabled", isAutoSaveEnabled, true);

        if (clientCache.isAutoDeleteEnabled(guildID)) {
            embedBuilder.addField("Auto delete value", clientCache.getAutoDeleteValue(guildID) +
                    LanguageController.getShortHoursMessage(guildID), true);
        }

        return embedBuilder.build();
    }

    private Role findBotRole(final Member member) {
        final List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
    }

    private void sendMessageEmbedToTextChannel(final String guildID, final TextChannel textChannel, final MessageEmbed message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessageEmbeds(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessageEmbeds(message).queue();
    }
}
