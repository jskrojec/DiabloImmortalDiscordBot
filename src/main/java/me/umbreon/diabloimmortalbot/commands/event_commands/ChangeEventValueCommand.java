package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Umbreon Majora
 * <p>
 * Command example: /event <game_event> ON/OFF
 * Description: Allows the user to enable or disable each event for the channel the command is sent in.
 */
public class ChangeEventValueCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public ChangeEventValueCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runChangeEventValueCommand(final SlashCommandInteractionEvent event) {
        OptionMapping eventOption = event.getOption("event");
        OptionMapping activationOption = event.getOption("eventvalue");

        String guildID = event.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);
        String textChannelID = event.getTextChannel().getId();

        String eventName;
        if (eventOption != null) {
            eventName = eventOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change event value but it failed because the event name was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        boolean activation;
        if (activationOption != null) {
            activation = activationOption.getAsBoolean();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change event value but it failed because the event value was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getInvalidCommandMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!doEventExist(eventName.toLowerCase())) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change event value but it failed because the given event does not exist.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getErrorCannotDisableEventMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (activation) {
            setEventValue(true, eventName, textChannelID);
            event.reply(String.format(LanguageController.getEventEnabledMessage(guildLanguage), eventName)).setEphemeral(true).queue();
        } else {
            setEventValue(false, eventName, textChannelID);
            event.reply(String.format(LanguageController.getEventDisabledMessage(guildLanguage), eventName)).setEphemeral(true).queue();
        }
    }

    private boolean doEventExist(final String event) {
        return clientCache.getListWithAvailableNotifications().contains(event);
    }

    private void setEventValue(final boolean value, final String event, final String textChannelID) {
        databaseRequests.updateNotifierChannelEventMessage(event, textChannelID, value);
        clientCache.setNotificationsValue(event, value, textChannelID);
    }

}
