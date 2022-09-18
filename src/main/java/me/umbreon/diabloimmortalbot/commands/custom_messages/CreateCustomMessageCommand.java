package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /createcustommessage <WEEKDAY> <TIME> <BOOL_REPEATING> <MESSAGE>
 */
public class CreateCustomMessageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public CreateCustomMessageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCreateCustomMessageCommand(final SlashCommandInteractionEvent event) {
        String guildID = event.getGuild().getId();
        String textChannelID = event.getTextChannel().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        OptionMapping weekdayOption = event.getOption("custommessageweekday");
        String weekday;
        if (weekdayOption != null) {
            weekday = weekdayOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because weekday was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!isGivenWeekdayValid(weekday)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because weekday was invalid.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        weekday = weekday.substring(0, 1).toUpperCase() + weekday.substring(1);

        OptionMapping timeOption = event.getOption("custommessagetime");
        String time;

        if (timeOption != null) {
            time = timeOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because time was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!StringAssistant.isStringInTimePattern(time)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because time was invalid.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        OptionMapping repeatingOption = event.getOption("custommessagerepeating");
        boolean repeating;
        if (repeatingOption != null) {
            repeating = repeatingOption.getAsBoolean();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because repeating was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        OptionMapping messageOption = event.getOption("custommessagemessage");
        String message;

        if (messageOption != null) {
            message = messageOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because message was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        CustomMessage customMessage = new CustomMessage(textChannelID, guildID, message, weekday, time, repeating);
        databaseRequests.createNewCustomMessageEntry(customMessage);
        try {
            //Todo: have to wait to get the id from the db, or the id will be 0.
            TimeUnit.SECONDS.sleep(1);
            clientCache.setCustomMessagesList(databaseRequests.getAllCustomMessages());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Todo: Need to reload all custom message because of the id's the db is giving the cm, find a fix
        event.reply(LanguageController.getCustomMessageCreatedMessage(guildLanguage)).setEphemeral(true).queue();
    }

    private boolean isGivenWeekdayValid(String givenWeekday) {
        return clientCache.getListOfAvailableEventDays().contains(givenWeekday.toLowerCase());
    }

}
