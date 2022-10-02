package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /info <CHANNEL>
 * Description: Show's all information about that channel.
 */
public class InfoCommand {
    // new strings -> to stringUtils
    String channelNotTextChannelError = "%s isn't a TextChannel. Only text channels can be registered.";
    String guildIsNullError = "An error occurred. Your guild couldn't be found.";
    String textChannelIsNullError = "An error occurred. Your text channel couldn't be found.";

    private final GuildsCache guildsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    private final Logger LOGGER = LoggerFactory.getLogger(InfoCommand.class);

    public InfoCommand(GuildsCache guildsCache, NotificationChannelsCache notificationChannelsCache) {
        this.guildsCache = guildsCache;
        this.notificationChannelsCache = notificationChannelsCache;
    }

    public void runInfoCommand(final SlashCommandInteraction event) {
        String log;
        Guild guild = event.getGuild();
        User user = event.getUser();
        String textChannelID = event.getChannel().getId();

        if (!isGuildValid(guild)) {
            log = user.getName() + "#" + user.getDiscriminator() + " tried to use /info command but it failed because guild is null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry("unknown", textChannelID, log);
            event.getHook().sendMessage(guildIsNullError).setEphemeral(true).queue();
            return;
        }

        String guildID = guild.getId();
        String language = guildsCache.getGuildLanguage(guildID);

        TextChannel textChannel = getTextChannel(event);

        if (!isChannelTypeTextChannel(textChannel)) {
            log = event.getUser().getName() + " tried to use /info command on " + textChannel.getName() + " but failed because that wasn't a text channel.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannel.getId(), log);
            event.reply(textChannelIsNullError).setEphemeral(true).queue();
            return;
        }

        if (!isChannelRegistered(textChannelID)) {
            log = event.getUser().getName() + " tried to use /info on " + textChannel.getName() + " but failed because that text channel is not registered.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(String.format(LanguageController.getChannelNotRegisteredMessage(language), textChannel.getAsMention())).setEphemeral(true).queue();
            return;
        }

        TextChannel targetTextChannel = guild.getTextChannelById(textChannelID);
        if (targetTextChannel == null) {
            log = "Failed to run info command. TextChannelID was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            event.reply(LanguageController.getChannelNotFoundMessage(language)).queue();
            return;
        }
        String targetChannelID = targetTextChannel.getId();
        String roleID = notificationChannelsCache.getRoleIdByChannelId(targetChannelID);
        event.replyEmbeds(buildInfoEmbed(textChannel, roleID, guildID)).setEphemeral(true).queue();
    }

    private @NotNull TextChannel getTextChannel(SlashCommandInteraction event) {
        OptionMapping channelOption = event.getOption("targetchannel");
        TextChannel textChannel;
        if (channelOption != null) {
            textChannel = channelOption.getAsChannel().asTextChannel();
        } else {
            textChannel = event.getChannel().asTextChannel();
        }
        return textChannel;
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return notificationChannelsCache.doNotifierChannelExists(textChannelID);
    }

    private MessageEmbed buildInfoEmbed(final TextChannel textChannel, final String mentionedRoleName, final String guildID) {
        String textChannelID = textChannel.getId();
        String textChannelName = textChannel.getName();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        NotificationChannel notificationChannel = notificationChannelsCache.getListWithNotifierChannels().get(textChannelID);
        embedBuilder.setTitle(textChannelName);

        String timezone = guildsCache.getGuildTimeZone(notificationChannel.getGuildID());
        String guildLanguage = guildsCache.getGuildLanguage(guildID);

        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), timezone, true);
        embedBuilder.addField(LanguageController.getInfoCurrentTimeMessage(guildLanguage), TimeUtils.getTimeWithWeekday(timezone), true);
        embedBuilder.addField(LanguageController.getInfoTextChannelIDMessage(guildLanguage), notificationChannel.getTextChannelID(), false);
        embedBuilder.addField(LanguageController.getInfoMentionedRoleMessage(guildLanguage), mentionedRoleName, false);

        String yes = LanguageController.getInfoYesMessage(guildLanguage);
        String no = LanguageController.getInfoNoMessage(guildLanguage);

        String eventMessageEnabled = notificationChannel.isEventMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoEventMessageMessage(guildLanguage), eventMessageEnabled, true);

        String eventHeadUpEnabled = notificationChannel.isEventHeadUpEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoHeadUpMessageMessage(guildLanguage), eventHeadUpEnabled, true);

        String eventAncientNightmareEnabled = notificationChannel.isAncientNightmareMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientNightmareMessage(guildLanguage), eventAncientNightmareEnabled, true);

        String eventAssemblyEnabled = notificationChannel.isAssemblyMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAssemblyMessage(guildLanguage), eventAssemblyEnabled, true);

        String eventBattlegroundsEnabled = notificationChannel.isBattlegroundsMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoBattlegroundMessage(guildLanguage), eventBattlegroundsEnabled, true);

        String eventDefendVaultEnabled = notificationChannel.isDefendVaultMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoDefendTheVaultMessage(guildLanguage), eventDefendVaultEnabled, true);

        String eventRaidVaultEnabled = notificationChannel.isRaidVaultMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoRaidTheVaultMessage(guildLanguage), eventRaidVaultEnabled, true);

        String eventDemonGatesEnabled = notificationChannel.isDemonGatesMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoDemonGatesMessage(guildLanguage), eventDemonGatesEnabled, true);

        String eventShadowLotteryEnabled = notificationChannel.isShadowLotteryMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoShadowLotteryMessage(guildLanguage), eventShadowLotteryEnabled, true);

        String eventHauntedCarriageEnabled = notificationChannel.isHauntedCarriageMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoHauntedCarriageMessage(guildLanguage), eventHauntedCarriageEnabled, true);

        String eventWrathborneInvasionEnabled = notificationChannel.isWrathborneInvasionEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoWrathborneInvasionMessage(guildLanguage), eventWrathborneInvasionEnabled, true);

        String eventAncientArenaEnabled = notificationChannel.isAncientArenaMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientArenaMessage(guildLanguage), eventAncientArenaEnabled, true);

        String eventHauntedCarriageEmbedEnabled = notificationChannel.isHauntedCarriageMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoHauntedCarriageEmbedMessage(guildLanguage), eventHauntedCarriageEmbedEnabled, true);

        String eventDemonGatesEmbedEnabled = notificationChannel.isDemonGatesMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoDemonGatesEmbedMessage(guildLanguage), eventDemonGatesEmbedEnabled, true);

        String eventAncientNightmareEmbedEnabled = notificationChannel.isAncientNightmareMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientNightmareEmbedMessage(guildLanguage), eventAncientNightmareEmbedEnabled, true);

        String eventAncientArenaEmbedEnabled = notificationChannel.isAncientArenaMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientArenaEmbedMessage(guildLanguage), eventAncientArenaEmbedEnabled, true);

        return embedBuilder.build();
    }

    private boolean isChannelTypeTextChannel(TextChannel textChannel) {
        return textChannel.getType().isMessage();
    }

    private boolean isGuildValid(Guild guild) {
        return guild != null;
    }
}