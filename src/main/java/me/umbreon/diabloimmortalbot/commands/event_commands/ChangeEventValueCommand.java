package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
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
 * Command example: /event <game_event> ON/OFF
 * Description: Allows the user to enable or disable each event for the channel the command is sent in.
 */
public class ChangeEventValueCommand {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    private final GuildsCache guildsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(ChangeEventValueCommand.class);

    public ChangeEventValueCommand(final ClientCache clientCache, final DatabaseRequests databaseRequests, GuildsCache guildsCache, NotificationChannelsCache notificationChannelsCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void runChangeEventValueCommand(final SlashCommandInteractionEvent event) {
        OptionMapping eventOption = event.getOption("event");
        OptionMapping activationOption = event.getOption("eventvalue");

        String guildID = event.getGuild().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);
        String textChannelID = event.getChannel().getId();

        if (!notificationChannelsCache.isChannelRegistered(textChannelID)) {
            event.reply("This channel is not registered. Use /register to register this channel.").setEphemeral(true).queue();
            return;
        }

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
        notificationChannelsCache.setNotificationsValue(event, value, textChannelID);
    }

}
