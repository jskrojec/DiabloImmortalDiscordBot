package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @author Umbreon Majora
 *
 * Command: /info <CHANNEL>
 * Description: Show's all information about that channel.
 */
public class InfoCommand {

    public ClientCache clientCache;

    public InfoCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runInfoCommand(final String[] args, final TextChannel textChannel,
                               final SlashCommandInteraction event) {
        String guildID = textChannel.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);
        String textChannelID = getTextChannelID(textChannel, args);
        Guild guild = textChannel.getGuild();

        if (textChannelID == null) {
            ClientLogger.createNewServerLogEntry(guildID, "global", "Failed to run info command. TextChannelID was null.");
            event.reply(LanguageController.getChannelNotFoundMessage(guildLanguage)).queue();
            return;
        }

        if (!isChannelRegistered(textChannelID)) {
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, "Failed to run info command. Given channel was not registered.");
            event.reply(String.format(LanguageController.getChannelNotRegisteredMessage(guildLanguage), textChannel.getAsMention())).queue();
            return;
        }

        String roleName;
        String textChannelName;

        try {
            roleName = getRoleName(textChannelID, guild);
            textChannelName = guild.getTextChannelById(textChannelID).getName();
        } catch (NullPointerException e) {
            event.reply(LanguageController.getErrorOccurredMessage(guildLanguage) +
                    " " + LanguageController.getFooterReportToDevMessage(guildLanguage)).queue();
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, "Failed to run info command. Role name or channel name was null.");
            return;
        }

        event.replyEmbeds(buildInfoEmbed(textChannelID, textChannelName, roleName, guildID)).queue();
    }

    @NotNull
    private String getRoleName(final String textChannelID, final Guild guild) {
        String roleName;
        String tmpRole = clientCache.getRoleID(textChannelID);

        if (tmpRole.equalsIgnoreCase("everyone")) {
            roleName = "EVERYONE";
        } else if (tmpRole.equalsIgnoreCase("here")) {
            roleName = "HERE";
        } else {
            roleName = guild.getRoleById(tmpRole).getAsMention();
        }
        return roleName;
    }

    @Nullable
    private String getTextChannelID(final TextChannel textChannel, final String[] args) {
        String textChannelID;
        if (args.length == 2) {
            textChannelID = StringAssistant.removeAllNonNumbers(args[1]);
        } else if (args.length == 1) {
            textChannelID = textChannel.getId();
        } else {
            return null;
        }
        return textChannelID;
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private MessageEmbed buildInfoEmbed(final String textChannelID, final String textChannelName, final String mentionedRoleName, final String guildID) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        NotificationChannel notificationChannel = clientCache.getListWithNotifierChannels().get(textChannelID);
        embedBuilder.setTitle(textChannelName);

        String timezone = clientCache.getGuildTimeZone(notificationChannel.getGuildID());
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), timezone, true);
        embedBuilder.addField(LanguageController.getInfoCurrentTimeMessage(guildLanguage), TimeAssistant.getTimeWithWeekday(timezone), true);
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

}