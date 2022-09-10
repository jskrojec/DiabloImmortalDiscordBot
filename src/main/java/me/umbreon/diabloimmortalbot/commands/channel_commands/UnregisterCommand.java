package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.Nullable;

public class UnregisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public UnregisterCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runUnregisterCommand(final String[] args, final TextChannel textChannel, final Guild guild) {
        final String guildID = guild.getId();
        final String language = clientCache.getGuildLanguage(guildID);

        final String textChannelID = getTextChannelID(textChannel, args);
        if (!isChannelRegistered(textChannelID))
            return String.format(LanguageController.getChannelNotRegisteredMessage(language), textChannel.getAsMention());

        removeNotificationChannel(textChannelID);
        return String.format(LanguageController.getChannelUnregisteredMessage(language), textChannel.getAsMention());
    }

    @Nullable
    private String getTextChannelID(final TextChannel textChannel, final String[] args) {
        if (args.length == 2) return StringAssistant.removeAllNonNumbers(args[1]);
        else if (args.length == 1) return textChannel.getId();
        return null;
    }

    private void removeNotificationChannel(final String textChannelID) {
        databaseRequests.deleteNotifierChannelEntry(textChannelID);
        clientCache.removeNotifierChannelFromList(textChannelID);
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }
}
