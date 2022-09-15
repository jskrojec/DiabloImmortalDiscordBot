package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /createcustommessage <WEEKDAY> <TIME> <BOOL_REPEATING> <MESSAGE>
 */
public class CreateCustomMessageCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CreateCustomMessageCommand(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public String runCreateCustomMessageCommand(final String[] args, final TextChannel textChannel) {
        String guildID = textChannel.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (!isCommandValid(args)) {
            return LanguageController.getInvalidCommandMessage(guildLanguage);
        }

        String textChannelID = textChannel.getId();
        String weekday = args[1].toLowerCase();
        String time = args[2];
        boolean repeating = Boolean.parseBoolean(args[3]);
        String message = getGivenMessage(args);

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
        return LanguageController.getCustomMessageCreatedMessage(guildLanguage);
    }

    private String getGivenMessage(String[] args) {
        StringBuilder message = new StringBuilder();
        for (int i = 4; args.length - 1 >= i; i++) {
            message.append(args[i]).append(" ");
        }
        return message.toString();
    }

    private boolean isGivenWeekdayValid(String givenWeekday) {
        return clientCache.getListOfAvailableEventDays().contains(givenWeekday);
    }

    private boolean isCommandValid(String[] args) {
        if (args.length < 4) {
            return false;
        }

        String givenWeekday = args[1].toLowerCase();
        //Todo: Add Error message: Invalid weekday
        if (!isGivenWeekdayValid(givenWeekday)) {
            return false;
        }

        String givenTime = args[2];
        if (!StringAssistant.isStringInTimePattern(givenTime)) {
            //Todo: add error message: invalid time
            return false;
        }

        String isRepeat = args[3];
        if (!BooleanAssistant.isValueTrue(isRepeat) && !BooleanAssistant.isValueFalse(isRepeat)) {
            //todo: add error message: invalid value / yes no?
            return false;
        }

        return true;
    }

}
