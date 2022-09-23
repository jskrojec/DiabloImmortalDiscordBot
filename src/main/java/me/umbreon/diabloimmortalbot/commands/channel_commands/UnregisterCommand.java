package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /unregister <CHANNEL>
 * Description: Removes given channel as notifier-channel from the system.
 */
public class UnregisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    private final GuildsCache guildsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public UnregisterCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache, GuildsCache guildsCache, NotificationChannelsCache notificationChannelsCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void runUnregisterCommand(final SlashCommandInteractionEvent event) {
        OptionMapping optionMapping = event.getOption("targetchannel");

        TextChannel textChannel;
        if (optionMapping != null) {
            textChannel = optionMapping.getAsTextChannel();
        } else {
            textChannel = event.getTextChannel();
        }

        String guildID = textChannel.getGuild().getId();
        String language = guildsCache.getGuildLanguage(guildID);
        if (!isChannelTypeTextChannel(textChannel)) {
            String log = event.getUser().getName() + " tried to unregister " + textChannel.getName() + " but failed because that wasn't a text channel.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            //todo: Add new error message: Given channel is not a text channel.
            event.reply(LanguageController.getInvalidCommandMessage(language)).setEphemeral(true).queue();
            return;
        }

        String targetTextChannelId = textChannel.getId();
        if (!isChannelRegistered(targetTextChannelId)) {
            String log = event.getUser().getName() + " tried to unregister " + textChannel.getName() + " but failed because that text channel was not registered.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            event.reply(String.format(LanguageController.getChannelNotRegisteredMessage(language), textChannel.getAsMention())).setEphemeral(true).queue();
            return;
        }

        Guild guild = textChannel.getGuild();
        TextChannel targetTextChannel = guild.getTextChannelById(targetTextChannelId);
        if (targetTextChannel == null) {
            String log = event.getUser().getName() + " tried to unregister " + textChannel.getName() + " but failed because that text channel couldn't be found.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            event.reply(LanguageController.getInvalidCommandMessage(language)).setEphemeral(true).queue();
            return;
        }

        removeNotificationChannel(targetTextChannelId);
        event.reply(String.format(LanguageController.getChannelUnregisteredMessage(language), textChannel.getAsMention())).setEphemeral(true).queue();
    }

    private void removeNotificationChannel(final String textChannelID) {
        databaseRequests.deleteNotifierChannelEntry(textChannelID);
        notificationChannelsCache.removeNotifierChannelFromList(textChannelID);
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return notificationChannelsCache.doNotifierChannelExists(textChannelID);
    }

    private boolean isChannelTypeTextChannel(TextChannel textChannel) {
        return textChannel.getType().isMessage();
    }
}
