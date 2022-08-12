package me.umbreon.diabloimmortalbot.commands.guilds_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

/**
 * Command: >server timezone GMT+2
 **/
public class ServerTimezoneCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public ServerTimezoneCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void runTimezoneCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        TextChannel textChannel = message.getTextChannel();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!areArgumentsValid(args)) {
            textChannel.sendMessage(LanguageController.getInvalidCommandMessage(guildLanguage)).queue();
            return;
        }

        String timezone = args[2].toUpperCase();
        if (!isTimeZoneValid(timezone)) {
            message.getTextChannel().sendMessage(LanguageController.getInvalidTimezoneMessage(guildLanguage)).queue();
            return;
        }

        setGuildTimeZone(guildID, timezone);
        textChannel.sendMessage(String.format(LanguageController.getTimezoneSetToMessage(guildLanguage), textChannel.getAsMention(), timezone)).queue();
    }

    // -

    private boolean areArgumentsValid(String[] args) {
        return args.length == 3;
    }

    private boolean isTimeZoneValid(String timezone) {
        if (StringAssistant.isStringSingleDashWithDigits(timezone)) { //e.g. -7
            return false;
        }

        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime dateTime = timeStamp.atZone(ZoneId.of(timezone));
            return true;
        } catch (ZoneRulesException e) {
            return false;
        }
    }

    private void setGuildTimeZone(String guildID, String timeZone) {
        databaseRequests.setGuildTimezone(guildID, timeZone);
        clientCache.setGuildTimeZone(guildID, timeZone);
    }
}
