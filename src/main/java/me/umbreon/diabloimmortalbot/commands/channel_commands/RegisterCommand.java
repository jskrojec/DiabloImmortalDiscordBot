package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.Nullable;

/**
 * @author Umbreon Majora
 *
 * Command /register <CHANNEL>
 * Description: Registers that given channel as a notifier-channel.
 */
public class RegisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RegisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runRegisterCommand(final String[] args, final TextChannel textChannel,
                                   final SlashCommandInteraction event) {
        String guildID = textChannel.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);
        String textChannelID = getTextChannelID(textChannel, args);

        if (textChannelID == null) {
            event.reply(LanguageController.getChannelNotFoundMessage(language)).queue();
            ClientLogger.createNewServerLogEntry(guildID, "global", "Failed to run register command. TextChannelID was null.");
            return;
        }

        if (isChannelRegistered(textChannelID)) {
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, "Failed to run register command. TextChannel is already registered.");
            event.reply(String.format(LanguageController.getChannelAlreadyRegisteredMessage(language), textChannel.getAsMention())).queue();
            return;
        }

        Guild guild = textChannel.getGuild();
        TextChannel targetTextChannel = guild.getTextChannelById(textChannelID);
        if (targetTextChannel == null) {
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, "Failed to run register command. Targeted TextChannel couldn't be found.");
            event.reply(LanguageController.getInvalidCommandMessage(language)).queue();
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(textChannelID, guildID);
        createNotifierChannel(notificationChannel);
        event.reply(String.format(LanguageController.getChannelRegisteredMessage(language), targetTextChannel.getAsMention())).queue();
    }

    @Nullable
    private String getTextChannelID(final TextChannel textChannel, final String[] args) {
        String textChannelID;
        if (args.length == 2) {
            textChannelID = StringAssistant.removeAllNonNumbers(args[1]);
        } else if (args.length == 1) {
            textChannelID = textChannel.getId();
        } else {
            return null;
        }
        return textChannelID;
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    public void createNotifierChannel(final NotificationChannel notificationChannel) {
        databaseRequests.createNewNotifierChannel(notificationChannel);
        clientCache.addNotifierChannelToList(notificationChannel);
    }

}
