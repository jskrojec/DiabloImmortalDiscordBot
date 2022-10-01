package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Umbreon Majora
 * <p>
 * Command /register <CHANNEL>
 * Description: Registers that given channel as a notifier-channel.
 */
public class RegisterCommand {

    private final DatabaseRequests databaseRequests;

    private final GuildsCache guildsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(RegisterCommand.class);

    public RegisterCommand(DatabaseRequests databaseRequests, GuildsCache guildsCache, NotificationChannelsCache notificationChannelsCache) {
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void runRegisterCommand(final SlashCommandInteraction event) {
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
            String log = event.getUser().getName() + " tried to register " + textChannel.getName() + " but failed because that wasn't a text channel.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            //todo: Add new error message: Given channel is not a text channel.
            event.reply(LanguageController.getInvalidCommandMessage(language)).setEphemeral(true).queue();
            return;
        }

        String targetTextChannelId = textChannel.getId();
        if (isChannelRegistered(targetTextChannelId)) {
            String log = event.getUser().getName() + " tried to register " + textChannel.getName() + " but failed because that text channel was already registered.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            event.reply(String.format(LanguageController.getChannelAlreadyRegisteredMessage(language), textChannel.getAsMention())).setEphemeral(true).queue();
            return;
        }

        Guild guild = textChannel.getGuild();
        TextChannel targetTextChannel = guild.getTextChannelById(targetTextChannelId);
        if (targetTextChannel == null) {
            String log = event.getUser().getName() + " tried to register " + textChannel.getName() + " but failed because that text channel couldn't be found.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, event.getTextChannel().getId(), log);
            event.reply(LanguageController.getInvalidCommandMessage(language)).setEphemeral(true).queue();
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(targetTextChannelId, guildID);
        createNotifierChannel(notificationChannel);
        event.reply(String.format(LanguageController.getChannelRegisteredMessage(language), targetTextChannel.getAsMention())).setEphemeral(true).queue();
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return notificationChannelsCache.doNotifierChannelExists(textChannelID);
    }

    public void createNotifierChannel(final NotificationChannel notificationChannel) {
        databaseRequests.createNewNotifierChannel(notificationChannel);
        notificationChannelsCache.addNotifierChannelToList(notificationChannel);
    }

    private boolean isChannelTypeTextChannel(TextChannel textChannel) {
        return textChannel.getType().isMessage();
    }
}
