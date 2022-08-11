package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.util.List;
/**
 * Command: >server config
 */
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
        textChannel.sendMessageEmbeds(buildServerInfoEmbed(guildID, hasBotAdminRole)).queue();
    }

    public MessageEmbed buildServerInfoEmbed(String guildID, boolean hasBotAdminRole) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Server Configurations:");
        GuildInformation guildInformation = clientCache.getGuildInformation(guildID);
        embedBuilder.addField("Language:", guildInformation.getLanguage(), true);
        embedBuilder.addField("Timezone:", guildInformation.getTimezone(), true);
        embedBuilder.addField("GuildID:", guildInformation.getGuildID(), true);

        String headUpMessagesEnabled = guildInformation.isHeadUpEnabled() ? "Yes" : "No";
        embedBuilder.addField("Event messages", headUpMessagesEnabled, true);

        String eventMessageEnabled = guildInformation.isEventMessageEnabled() ? "Yes" : "No";
        embedBuilder.addField("Head up messages", eventMessageEnabled, true);

        String doUserGotBotAdminRole = hasBotAdminRole ? "Yes" : "No";
        embedBuilder.addField("Is user Bot Admin", doUserGotBotAdminRole, true);
        return embedBuilder.build();
    }

    private Role findBotRole(Member member) {
        List<Role> roles = member.getRoles();
        return roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
    }
}
