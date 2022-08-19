package me.umbreon.diabloimmortalbot.commands.channel_commands;

import me.umbreon.diabloimmortalbot.data.NotifierChannel;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.TimeUnit;

public class InfoCommand {

    public ClientCache clientCache;

    public InfoCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runInfoCommand(final Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        String textChannelID = getTextChannelID(message, args);
        if (textChannelID == null) {
            sendMessageToTextChannel(guildID, textChannel, LanguageController.getChannelNotFoundMessage(guildLanguage));
            return;
        }

        if (!isChannelRegistered(textChannelID)) {
            sendMessageToTextChannel(guildID, textChannel, String.format(LanguageController.getChannelNotRegisteredMessage(guildLanguage), textChannel.getAsMention()));
            return;
        }

        String roleName;
        String textChannelName;
        Guild guild = message.getGuild();

        try {
            roleName = getRoleName(textChannelID, guild);
            textChannelName = guild.getTextChannelById(textChannelID).getName();
        } catch (NullPointerException e) {
            String errorMessage = LanguageController.getErrorOccurredMessage(guildLanguage) +
                    " " + LanguageController.getFooterReportToDevMessage(guildLanguage);
            sendMessageToTextChannel(guildID, textChannel, errorMessage);
            return;
        }

        sendEmbedMessageToTextChannel(guildID, textChannel, buildInfoEmbed(textChannelID, textChannelName, roleName, guildID));
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
    private String getTextChannelID(final Message message, final String[] args) {
        String textChannelID;
        if (args.length == 2) {
            textChannelID = StringAssistant.removeAllNonNumbers(args[1]);
        } else if (args.length == 1) {
            textChannelID = message.getTextChannel().getId();
        } else {
            return null;
        }
        return textChannelID;
    }

    private boolean isChannelRegistered(final String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private void sendMessageToTextChannel(final String guildID, final TextChannel textChannel, final String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }

    private void sendEmbedMessageToTextChannel(final String guildID, TextChannel textChannel, MessageEmbed message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessageEmbeds(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessageEmbeds(message).queue();
    }

    private MessageEmbed buildInfoEmbed(String textChannelID, String textChannelName, String mentionedRoleName, String guildID) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        NotifierChannel notifierChannel = clientCache.getListWithNotifierChannels().get(textChannelID);
        embedBuilder.setTitle(textChannelName);

        String timezone = clientCache.getGuildTimeZone(notifierChannel.getGuildID());
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        embedBuilder.addField(LanguageController.getInfoTimezoneMessage(guildLanguage), timezone, true);
        embedBuilder.addField(LanguageController.getInfoCurrentTimeMessage(guildLanguage), TimeAssistant.getTimeWithWeekday(timezone), true);
        embedBuilder.addField(LanguageController.getInfoTextChannelIDMessage(guildLanguage), notifierChannel.getTextChannelID(), false);
        embedBuilder.addField(LanguageController.getInfoMentionedRoleMessage(guildLanguage), mentionedRoleName, false);

        String yes = LanguageController.getInfoYesMessage(guildLanguage);
        String no = LanguageController.getInfoNoMessage(guildLanguage);

        String eventMessageEnabled = notifierChannel.isEventMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoEventMessageMessage(guildLanguage), eventMessageEnabled, true);

        String eventHeadUpEnabled = notifierChannel.isEventHeadUpEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoHeadUpMessageMessage(guildLanguage), eventHeadUpEnabled, true);

        String eventAncientNightmareEnabled = notifierChannel.isAncientNightmareMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientNightmareMessage(guildLanguage), eventAncientNightmareEnabled, true);

        String eventAssemblyEnabled = notifierChannel.isAssemblyMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAssemblyMessage(guildLanguage), eventAssemblyEnabled, true);

        String eventBattlegroundsEnabled = notifierChannel.isBattlegroundsMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoBattlegroundMessage(guildLanguage), eventBattlegroundsEnabled, true);

        String eventDefendVaultEnabled = notifierChannel.isDefendVaultMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoDefendTheVaultMessage(guildLanguage), eventDefendVaultEnabled, true);

        String eventRaidVaultEnabled = notifierChannel.isRaidVaultMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoRaidTheVaultMessage(guildLanguage), eventRaidVaultEnabled, true);

        String eventDemonGatesEnabled = notifierChannel.isDemonGatesMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoDemonGatesMessage(guildLanguage), eventDemonGatesEnabled, true);

        String eventShadowLotteryEnabled = notifierChannel.isShadowLotteryMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoShadowLotteryMessage(guildLanguage), eventShadowLotteryEnabled, true);

        String eventHauntedCarriageEnabled = notifierChannel.isEventMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoHauntedCarriageMessage(guildLanguage), eventHauntedCarriageEnabled, true);

        String eventWrathborneInvasionEnabled = notifierChannel.isWrathborneInvasionEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoWrathborneInvasionMessage(guildLanguage), eventWrathborneInvasionEnabled, true);

        String eventAncientArenaEnabled = notifierChannel.isAncientArenaMessageEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientArenaMessage(guildLanguage), eventAncientArenaEnabled, true);

        String eventHauntedCarriageEmbedEnabled = notifierChannel.isHauntedCarriageMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoHauntedCarriageEmbedMessage(guildLanguage), eventHauntedCarriageEmbedEnabled, true);

        String eventDemonGatesEmbedEnabled = notifierChannel.isDemonGatesMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoDemonGatesEmbedMessage(guildLanguage), eventDemonGatesEmbedEnabled, true);

        String eventAncientNightmareEmbedEnabled = notifierChannel.isAncientArenaMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientNightmareEmbedMessage(guildLanguage), eventAncientNightmareEmbedEnabled, true);

        String eventAncientArenaEmbedEnabled = notifierChannel.isAncientArenaMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField(LanguageController.getInfoAncientArenaEmbedMessage(guildLanguage), eventAncientArenaEmbedEnabled, true);

        return embedBuilder.build();
    }

}