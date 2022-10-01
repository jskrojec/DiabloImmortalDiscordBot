package me.umbreon.diabloimmortalbot.commands.server_commands;

import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /language <LANGUAGE>
 * Description: Changes the bot's language.
 */
public class LanguageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;
    private final GuildsCache guildsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(LanguageCommand.class);

    public LanguageCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests, GuildsCache guildsCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
    }

    public void runLanguageCommand(final SlashCommandInteractionEvent event) {
        OptionMapping languageOption = event.getOption("language");

        String guildID = event.getGuild().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);
        String textChannelID = event.getTextChannel().getId();
        String language;

        if (languageOption != null) {
            language = languageOption.getAsString().toUpperCase();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change the bots language but the language was null.";
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            LOGGER.info(log);
            event.reply(LanguageController.getLanguageNotSupportedMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!isLanguageSupported(language)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change the bots language to " + language + " but the language is not supported.";
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            LOGGER.info(log);
            event.reply(LanguageController.getLanguageNotSupportedMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        setGuildLanguage(guildID, language);
        event.reply(String.format(LanguageController.getLanguageUpdatedMessage(guildLanguage), language)).setEphemeral(true).queue();
    }

    private boolean isLanguageSupported(final String lang) {
        return clientCache.getListWithSupportedLanguage().contains(lang.toLowerCase());
    }

    private void setGuildLanguage(final String guildID, final String guildLanguage) {
        databaseRequests.setGuildLanguage(guildID, guildLanguage);
        guildsCache.setGuildLanguage(guildID, guildLanguage);
    }
}
