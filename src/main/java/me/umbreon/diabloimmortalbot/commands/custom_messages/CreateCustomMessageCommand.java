package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.cache.CustomMessagesCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /createcustommessage <WEEKDAY> <TIME> <BOOL_REPEATING> <MESSAGE>
 */
public class CreateCustomMessageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;
    private final CustomMessagesCache customMessagesCache;

    private final GuildsCache guildsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(CreateCustomMessageCommand.class);

    public CreateCustomMessageCommand(ClientCache clientCache, DatabaseRequests databaseRequests, CustomMessagesCache customMessagesCache, GuildsCache guildsCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        this.customMessagesCache = customMessagesCache;
        this.guildsCache = guildsCache;
    }

    public void runCreateCustomMessageCommand(final SlashCommandInteractionEvent event) {
        String guildID = event.getGuild().getId();
        String textChannelID = event.getChannel().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);

        OptionMapping weekdayOption = event.getOption("custommessageweekday");
        String weekday;
        if (weekdayOption != null) {
            weekday = weekdayOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because weekday was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!isGivenWeekdayValid(weekday)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because weekday was invalid.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, log);
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
            ClientLogger.createNewServerLogEntry(guildID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!StringUtils.isStringInTimePattern(time)) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to create a custom message but it failed because time was invalid.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, log);
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
            ClientLogger.createNewServerLogEntry(guildID, log);
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
            ClientLogger.createNewServerLogEntry(guildID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        int nextAutoIncrementNumber = databaseRequests.getGetCustomMessageNextAutoIncrementValue();

        CustomMessage customMessage = new CustomMessage(textChannelID, guildID, message, weekday, time, repeating);
        databaseRequests.createNewCustomMessageEntry(customMessage);

        customMessage.setCustomMessageID(nextAutoIncrementNumber);
        customMessagesCache.addCustomMessageToList(customMessage);

        event.reply(LanguageController.getCustomMessageCreatedMessage(guildLanguage)).setEphemeral(true).queue();
    }

    private boolean isGivenWeekdayValid(String givenWeekday) {
        return clientCache.getListOfAvailableEventDays().contains(givenWeekday.toLowerCase());
    }

}
