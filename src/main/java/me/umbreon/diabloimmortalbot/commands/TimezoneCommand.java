package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.TextChannel;

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

    public TimezoneCommand(final DatabaseRequests databaseRequests, final ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public String runTimezoneCommand(final String[] args, final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        final String timezone = args[1].toUpperCase();
        if (!isTimeZoneValid(timezone)) {
            return LanguageController.getInvalidTimezoneMessage(guildLanguage);
        }

        setGuildTimeZone(guildID, timezone);
        return String.format(LanguageController.getTimezoneChangedMessage(guildLanguage), textChannel.getAsMention(), timezone);
    }

    private boolean areArgumentsValid(final String[] args) {
        return args.length == 2;
    }

    private boolean isTimeZoneValid(final String timezone) {
        if (StringAssistant.isStringSingleDashWithDigits(timezone)) {
            return false;
        }

        try {
            final Instant timeStamp = Instant.now();
            final ZonedDateTime dateTime = timeStamp.atZone(ZoneId.of(timezone));
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
