package me.umbreon.diabloimmortalbot.commands.server_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

/**
 * @author Umbreon Majora
 * <p>
 * Command example: /timezone <timezone>
 * Description: Set's the timezone for that guild.
 * <p>
 * CommandOption 1: (timezone)
 */
public class TimezoneCommand {

    private final DatabaseRequests databaseRequests;
    private final GuildsCache guildsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(TimezoneCommand.class);

    public TimezoneCommand(final DatabaseRequests databaseRequests, GuildsCache guildsCache) {
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
    }

    public void runTimezoneCommand(final SlashCommandInteractionEvent event) {
        event.deferReply().queue();
        String log;
        String textChannelID = event.getTextChannel().getId();
        User user = event.getUser();

        Guild guild = event.getGuild();
        if (!isGuildValid(guild)) {
            log = "Failed to run " + getClass().getSimpleName() + " because guild was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry("global", textChannelID, log);
            event.getHook().sendMessage("Failed to change timezone because the guild was null.").setEphemeral(true).queue();
            return;
        }

        String guildID = guild.getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);

        OptionMapping timezoneOption = event.getOption("timezone");
        String givenTimezone;
        if (timezoneOption != null) {
            givenTimezone = timezoneOption.getAsString();
        } else {
            log = user.getName() + "#" + user.getDiscriminator() + " tried to change timezone but given timezone was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.getHook().sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!isTimeZoneValid(givenTimezone)) {
            log = user.getName() + "#" + user.getDiscriminator() + " tried to change timezone but given timezone was not supported.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.getHook().sendMessage(LanguageController.getInvalidTimezoneMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        setGuildTimeZone(guildID, givenTimezone);
        event.getHook().sendMessage(String.format(LanguageController.getTimezoneChangedMessage(guildLanguage), "Server wide", givenTimezone)).setEphemeral(true).queue();
    }

    private boolean isTimeZoneValid(final String timezone) {
        if (StringAssistant.isStringSingleDashWithDigits(timezone)) {
            return false;
        }

        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime dateTime = timeStamp.atZone(ZoneId.of(timezone));
            return true;
        } catch (final ZoneRulesException e) {
            return false;
        }
    }

    private void setGuildTimeZone(final String guildID, final String timeZone) {
        databaseRequests.setGuildTimezone(guildID, timeZone);
        guildsCache.setGuildTimeZone(guildID, timeZone);
    }

    private boolean isGuildValid(Guild guild) {
        return guild != null;
    }

}
