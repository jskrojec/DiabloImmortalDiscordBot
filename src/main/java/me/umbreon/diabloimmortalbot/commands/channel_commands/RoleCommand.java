package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /mentionrole <ROLE> <CHANNEL>
 * Description: Set's the role that should get mentioned in that channel.
 */
public class RoleCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;
    private final GuildsCache guildsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public RoleCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache, GuildsCache guildsCache, NotificationChannelsCache notificationChannelsCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
        this.guildsCache = guildsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void runMentionRoleCommand(final SlashCommandInteractionEvent event) {
        OptionMapping roleOption = event.getOption("mentionrole");
        OptionMapping channelOption = event.getOption("targetchannel");

        Role role;
        if (roleOption != null) {
            role = roleOption.getAsRole();
        } else {
            //todo: is this error thrown? add error message?
            return;
        }

        TextChannel textChannel;
        if (channelOption != null) {
            textChannel = channelOption.getAsTextChannel();
        } else {
            textChannel = event.getTextChannel();
        }

        String guildID = textChannel.getGuild().getId();
        String language = guildsCache.getGuildLanguage(guildID);
        if (!isChannelTypeTextChannel(textChannel)) {
            String log = event.getUser().getName() + " tried to change mention role for " + textChannel.getName() + " but failed because that wasn't a text channel.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            //todo: Add new error message: Given channel is not a text channel.
            event.reply(LanguageController.getInvalidCommandMessage(language)).setEphemeral(true).queue();
            return;
        }

        String targetTextChannelId = textChannel.getId();
        if (!isChannelRegistered(targetTextChannelId)) {
            String log = event.getUser().getName() + " tried to change mention role for " + textChannel.getName() + " but failed because that text channel was not registered.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, targetTextChannelId, log);
            event.reply(String.format(LanguageController.getChannelNotRegisteredMessage(language), textChannel.getAsMention())).setEphemeral(true).queue();
            return;
        }

        Guild guild = textChannel.getGuild();
        TextChannel targetTextChannel = guild.getTextChannelById(targetTextChannelId);
        if (targetTextChannel == null) {
            LOGGER.info(event.getUser().getName() + " tried to register " + textChannel.getName() + " but failed because that text channel couldn't be found.");
            ClientLogger.createNewServerLogEntry(guildID, targetTextChannelId, event.getUser().getName() + " tried to register " + textChannel.getName() + " but failed because that text channel couldn't be found.");
            event.reply(LanguageController.getInvalidCommandMessage(language)).setEphemeral(true).queue();
            return;
        }

        String roleID = role.getId();
        setRole(targetTextChannel.getId(), roleID);
        event.reply(String.format(LanguageController.getRoleChangedMessage(language), role.getAsMention())).setEphemeral(true).queue();
        //todo: add new message ROLE is now set as mention role for TEXTCHANNEL
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return notificationChannelsCache.doNotifierChannelExists(textChannelID);
    }

    private void setRole(final String textChannelID, final String roleID) {
        notificationChannelsCache.setRoleID(textChannelID, roleID);
        databaseRequests.updateNotifierChannelRole(textChannelID, roleID);
    }

    private boolean isChannelTypeTextChannel(TextChannel textChannel) {
        return textChannel.getType().isMessage();
    }
}
