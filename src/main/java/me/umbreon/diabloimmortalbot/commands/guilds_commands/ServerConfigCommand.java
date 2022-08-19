package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServerConfigCommand {

    public ClientCache clientCache;

    public ServerConfigCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runServerConfigCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        Member member = message.getMember();
        String guildID = member != null ? member.getGuild().getId() : null;
        boolean hasBotAdminRole = findBotRole(member) != null;
        sendMessageEmbedToTextChannel(guildID, textChannel, buildServerInfoEmbed(guildID, hasBotAdminRole));
    }

    public MessageEmbed buildServerInfoEmbed(String guildID, boolean hasBotAdminRole) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        embedBuilder.setTitle("Server Configurations:");
        GuildInformation guildInformation = clientCache.getGuildInformation(guildID);
        embedBuilder.addField(LanguageController.getInfoLanguageMessage(guildLanguage), guildInformation.getLanguage(), true);
        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), guildInformation.getTimezone(), true);
        embedBuilder.addField(LanguageController.getInfoGuildIdMessage(guildLanguage), guildInformation.getGuildID(), true);

        String yesMessage = LanguageController.getInfoYesMessage(guildLanguage);
        String noMessage = LanguageController.getInfoNoMessage(guildLanguage);

        String eventMessageEnabled = guildInformation.isEventMessageEnabled() ? yesMessage : noMessage;
        String headUpMessagesEnabled = guildInformation.isHeadUpEnabled() ? yesMessage : noMessage;
        String doUserGotBotAdminRole = hasBotAdminRole ? yesMessage : noMessage;
        String isAutoSaveEnabled = clientCache.isAutoDeleteEnabled(guildID) ? yesMessage : noMessage;

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

    private Role findBotRole(Member member) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
    }

    private void sendMessageEmbedToTextChannel(String guildID, TextChannel textChannel, MessageEmbed message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessageEmbeds(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessageEmbeds(message).queue();
    }
}
