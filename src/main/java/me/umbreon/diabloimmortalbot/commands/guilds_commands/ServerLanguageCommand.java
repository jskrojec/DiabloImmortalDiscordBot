package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.TextChannel;

public class ServerLanguageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public ServerLanguageCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runLanguageCommand(final String[] args, final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        final String language = args[2].toLowerCase();
        if (!isLanguageSupported(language)) {
            return LanguageController.getLanguageNotSupportedMessage(guildLanguage);
        }

        setGuildLanguage(guildID, language);
        return String.format(LanguageController.getLanguageUpdatedMessage(guildLanguage), language);
    }

    private boolean isLanguageSupported(final String lang) {
        return clientCache.getListWithSupportedLanguage().contains(lang);
    }

    private boolean areArgumentsValid(final String[] args) {
        return args.length == 3;
    }

    private void setGuildLanguage(final String guildID, final String guildLanguage) {
        databaseRequests.setGuildLanguage(guildID, guildLanguage);
        clientCache.setGuildLanguage(guildID, guildLanguage);
    }
}
