package me.umbreon.diabloimmortalbot.commands.server_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

/**
 * @author Umbreon Majora
 * <p>
 * Command example: /timezone <timezone>
 * Description: Set's the timezone for guild.
 */
public class TimezoneCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public TimezoneCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runTimezoneCommand(final SlashCommandInteractionEvent event) {
        OptionMapping timezoneOption = event.getOption("timezone");

        String guildID = event.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);
        String givenTimezone;
        String textChannelID = event.getTextChannel().getId();
        if (timezoneOption != null) {
            givenTimezone = timezoneOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + "tried to change timezone but given timezone was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!isTimeZoneValid(givenTimezone)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + "tried to change timezone but given timezone was not supported.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidTimezoneMessage(guildLanguage)).setEphemeral(true).queue();
        }

        setGuildTimeZone(guildID, givenTimezone);
        event.reply(String.format(LanguageController.getTimezoneChangedMessage(guildLanguage), "global", givenTimezone)).setEphemeral(true).queue();
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
        clientCache.setGuildTimeZone(guildID, timeZone);
    }

}
