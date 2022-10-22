package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.commands.ClientCommand;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.CommandsUtil;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Umbreon Majora
 * <p>
 * Description:
 * Preset command provides sets which contains channel settings. These sets disabls or enables specific game event
 * notification.
 * <p>
 * Command:
 * /preset <preset> [channel]
 */
public class PresetCommand implements ClientCommand {

    private final Logger LOGGER = LoggerFactory.getLogger(PresetCommand.class);

    private final NotificationChannelsCache notificationChannelsCache;
    private final GuildsCache guildsCache;

    private final DatabaseRequests databaseRequests;

    public PresetCommand(NotificationChannelsCache notificationChannelsCache, GuildsCache guildsCache, DatabaseRequests databaseRequests) {
        this.notificationChannelsCache = notificationChannelsCache;
        this.guildsCache = guildsCache;
        this.databaseRequests = databaseRequests;
    }

    @Override
    public void runCommand(SlashCommandInteraction event) {
        OptionMapping channelOption = event.getOption("targetchannel");
        TextChannel textChannel;
        if (channelOption != null) {
            textChannel = channelOption.getAsChannel().asTextChannel();
        } else {
            textChannel = event.getChannel().asTextChannel();
        }

        String targetTextChannelId = textChannel.getId();
        String guildID = event.getGuild().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);
        if (!isChannelRegistered(targetTextChannelId)) {
            String log = event.getUser().getName() + " tried to run preset command on " + textChannel.getName() + " but failed because that text channel was not registered.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, log);
            event.reply(String.format(LanguageController.getChannelNotRegisteredMessage(guildLanguage), textChannel.getAsMention())).setEphemeral(true).queue();
            return;
        }

        OptionMapping presetOption = event.getOption("preset");
        String preset;
        if (presetOption != null) {
            preset = presetOption.getAsString();
        } else {
            String log = event.getUser().getName() + " tried to run preset command on " + textChannel.getName() + " but failed because that preset was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, log);
            event.reply(String.format(LanguageController.getChannelNotRegisteredMessage(guildLanguage), textChannel.getAsMention())).setEphemeral(true).queue();
            return;
        }

        NotificationChannel notificationChannel = notificationChannelsCache.getNotificationChannelByChannelID(targetTextChannelId);
        switch (preset) {
            case CommandsUtil.PRESET_IMMORTAL:
                setImmortalPreset(notificationChannel);
                break;
            case CommandsUtil.PRESET_SHADOW:
                setShadowPreset(notificationChannel);
                break;
            case CommandsUtil.PRESET_OVERWORLD_ON:
                setOverworldOnPreset(notificationChannel);
                break;
            case CommandsUtil.PRESET_OVERWORLD_OFF:
                setOverworldOffPreset(notificationChannel);
                break;
            case CommandsUtil.PRESET_DAILY_ON:
                setDailyEventOnPreset(notificationChannel);
                break;
            case CommandsUtil.PRESET_DAILY_OFF:
                setDailyEventOffPreset(notificationChannel);
                break;
            default:
                ClientLogger.createNewServerLogEntry(guildID, String.format(StringUtils.invalidPresetMessage, preset));
                LOGGER.info(String.format(StringUtils.invalidPresetMessage, preset, preset, targetTextChannelId));
                event.reply(String.format(StringUtils.invalidPresetMessage, preset, textChannel.getAsMention())).setEphemeral(true).queue();
                return;
        }

        notificationChannelsCache.replaceNotificationChannel(notificationChannel);
        databaseRequests.replaceNotificationChannel(notificationChannel);

        ClientLogger.createNewServerLogEntry(guildID, String.format(StringUtils.presetSetMessage, preset, targetTextChannelId));
        LOGGER.info(String.format(StringUtils.presetSetMessage, preset, targetTextChannelId));
        event.reply(String.format(StringUtils.presetSetMessage, preset, textChannel.getAsMention())).setEphemeral(true).queue();
    }

    private boolean isChannelRegistered(String textChannelID) {
        return notificationChannelsCache.doNotifierChannelExists(textChannelID);
    }

    /*
     * Immortal preset:
     * Assembly - OFF, DefendVault - ON, ShadowLottery - OFF, RaidVault - OFF
     */
    private void setImmortalPreset(NotificationChannel notificationChannel) {
        notificationChannel.setAssemblyMessageEnabled(false);
        notificationChannel.setDefendVaultMessageEnabled(true);
        notificationChannel.setShadowLotteryMessageEnabled(false);
        notificationChannel.setRaidVaultMessageEnabled(false);
    }

    /*
     * Shadow preset:
     * Assembly - ON, DefendVault - OFF, ShadowLottery - ON, RaidVault - ON
     */
    private void setShadowPreset(NotificationChannel notificationChannel) {
        notificationChannel.setAssemblyMessageEnabled(true);
        notificationChannel.setDefendVaultMessageEnabled(false);
        notificationChannel.setShadowLotteryMessageEnabled(true);
        notificationChannel.setRaidVaultMessageEnabled(true);
    }

    /*
     * Overworld on preset:
     * Ancient Arena - ON, Ancient Nightmare - ON, Demon Gates - ON, Haunted Carriage - ON
     */
    private void setOverworldOnPreset(NotificationChannel notificationChannel) {
        notificationChannel.setAncientArenaMessageEnabled(true);
        notificationChannel.setAncientNightmareMessageEnabled(true);
        notificationChannel.setDemonGatesMessageEnabled(true);
        notificationChannel.setHauntedCarriageMessageEnabled(true);
    }

    /*
     * Overworld off preset:
     * Ancient Arena - OFF, Ancient Nightmare - OFF, Demon Gates - OFF, Haunted Carriage - OFF
     */
    private void setOverworldOffPreset(NotificationChannel notificationChannel) {
        notificationChannel.setAncientArenaMessageEnabled(false);
        notificationChannel.setAncientNightmareMessageEnabled(false);
        notificationChannel.setDemonGatesMessageEnabled(false);
        notificationChannel.setHauntedCarriageMessageEnabled(false);
    }

    /*
     * Daily event on preset:
     * Battleground - ON, Wrathborne Invasion - ON
     */
    private void setDailyEventOnPreset(NotificationChannel notificationChannel) {
        notificationChannel.setBattlegroundsMessageEnabled(true);
        notificationChannel.setWrathborneInvasionEnabled(true);
    }

    /*
     * Daily event off preset:
     * Battleground - OFF, Wrathborne Invasion - OFF
     */
    private void setDailyEventOffPreset(NotificationChannel notificationChannel) {
        notificationChannel.setBattlegroundsMessageEnabled(false);
        notificationChannel.setWrathborneInvasionEnabled(false);
    }

}
