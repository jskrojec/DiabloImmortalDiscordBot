package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.data.NotifierChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.Nullable;

public class RegisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RegisterCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runRegisterCommand(final String[] args, final TextChannel textChannel, final Guild guild) {
        final String guildID = guild.getId();
        final String language = clientCache.getGuildLanguage(guildID);

        final String textChannelID = getTextChannelID(textChannel, args);
        if (textChannelID == null)
            return LanguageController.getChannelNotFoundMessage(language);

        if (isChannelRegistered(textChannelID))
            return String.format(LanguageController.getChannelAlreadyRegisteredMessage(language), textChannel.getAsMention());

        final TextChannel targetTextChannel = guild.getTextChannelById(textChannelID);
        if (targetTextChannel == null)
            return null;
        
        final NotifierChannel notifierChannel = new NotifierChannel(textChannelID, guildID);
        createNotifierChannel(notifierChannel);
        return String.format(LanguageController.getChannelRegisteredMessage(language), targetTextChannel.getAsMention());
    }

    @Nullable
    private String getTextChannelID(final TextChannel textChannel, final String[] args) {
        final String textChannelID;
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

    public void createNotifierChannel(final NotifierChannel notifierChannel) {
        databaseRequests.createNewNotifierChannel(notifierChannel);
        clientCache.addNotifierChannelToList(notifierChannel);
    }
}
