package me.umbreon.diabloimmortalbot.commands.guilds_commands;

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
 * Command /server <SERVER_SETTING> <ON/OFF>
 * Description: Allow's the user to enable or turn off headup or event messages server wide.
 */
public class ChangeServerValueCommand {

    private final DatabaseRequests databaseRequests;

    private final GuildsCache guildsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(ChangeServerValueCommand.class);

    public ChangeServerValueCommand(DatabaseRequests databaseRequests, GuildsCache guildsCache) {
        this.databaseRequests = databaseRequests;
        this.guildsCache = guildsCache;
    }

    public void runChangeServerValueCommand(final SlashCommandInteractionEvent event) {
        OptionMapping serverSettingOption = event.getOption("serversetting");
        OptionMapping serverValueOption = event.getOption("servervalue");

        String guildID = event.getGuild().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);

        String serverSetting;
        if (serverSettingOption != null) {
            serverSetting = serverSettingOption.getAsString();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change server setting but it failed because server setting was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            return;
        }

        boolean serverValue;
        if (serverValueOption != null) {
            serverValue = serverValueOption.getAsBoolean();
        } else {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change server setting but it failed because server value was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            return;
        }

        if (serverSetting.equalsIgnoreCase("headup")) {
            changeServerHeadUpValue(event, guildID, guildLanguage, serverSetting, serverValue);
        } else if (serverSetting.equalsIgnoreCase("message")) {
            changeServerMessageValue(event, guildID, guildLanguage, serverSetting, serverValue);
        }
    }

    private void changeServerHeadUpValue(SlashCommandInteractionEvent event, String guildID, String guildLanguage, String serverSetting, boolean serverValue) {
        if (guildsCache.isHeadUpOnServerEnabled(guildID) && serverValue) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change server headup value to true but it failed because it is already set to true.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            event.reply(LanguageController.getHeadUpMessagesAlreadyOnMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!guildsCache.isHeadUpOnServerEnabled(guildID) && !serverValue) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change server headup value to false but it failed because it is already set to false.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            event.reply(LanguageController.getHeadUpMessagesAlreadyOffMessages(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        databaseRequests.updateGuildHeadUp(guildID, serverValue);
        guildsCache.setHeadUpOnServerValue(guildID, serverValue);

        if (serverValue) {
            event.reply(String.format(LanguageController.getEventEnabledMessage(guildLanguage), serverSetting)).setEphemeral(true).queue();
        } else {
            event.reply(String.format(LanguageController.getEventDisabledMessage(guildLanguage), serverSetting)).setEphemeral(true).queue();
        }
    }

    private void changeServerMessageValue(SlashCommandInteractionEvent event, String guildID, String guildLanguage, String serverSetting, boolean serverValue) {
        if (guildsCache.isEventMessageOnServerEnabled(guildID) && serverValue) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change server message value to true but it failed because it is already set to true.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            event.reply(LanguageController.getEventMessagesAlreadyOnMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        if (!guildsCache.isEventMessageOnServerEnabled(guildID) && !serverValue) {
            String log = event.getMember().getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to change server message value to false but it failed because it is already set to false.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            event.reply(LanguageController.getEventMessagesAlreadyOffMessage(guildLanguage)).setEphemeral(true).queue();
            return;
        }

        databaseRequests.updateGuildMessage(serverValue, guildID);
        guildsCache.setEventMessageOnServerValue(guildID, serverValue);

        if (serverValue) {
            event.reply(String.format(LanguageController.getEventEnabledMessage(guildLanguage), serverSetting)).setEphemeral(true).queue();
        } else {
            event.reply(String.format(LanguageController.getEventDisabledMessage(guildLanguage), serverSetting)).setEphemeral(true).queue();
        }
    }

}
