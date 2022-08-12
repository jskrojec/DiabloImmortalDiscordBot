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
import org.jetbrains.annotations.Nullable;

/**
 * Command: >info
 * Command: >info #Channel
 **/
public class InfoCommand {

    public ClientCache clientCache;

    public InfoCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runInfoCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();
        String language = clientCache.getGuildLanguage(guildID);

        String textChannelID = getTextChannelID(message, args);
        if (textChannelID == null) {
            textChannel.sendMessage(LanguageController.getChannelNotFoundMessage(language)).queue();
            return;
        }

        if (!isChannelRegistered(textChannelID)) {
            textChannel.sendMessage(String.format(LanguageController.getNotRegisteredMessage(language), textChannel.getAsMention())).queue();
            return;
        }

        String roleName;
        String textChannelName;
        Guild guild = message.getGuild();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        try {
            roleName = guild.getRoleById(clientCache.getRoleID(textChannelID)).getName();
            textChannelName = guild.getTextChannelById(textChannelID).getName();
        } catch (NullPointerException e) {
            textChannel.sendMessage(LanguageController.getErrorOccurredMessage(guildLanguage) +
                    " " + LanguageController.getReportToDevMessage(guildLanguage)).queue();
            return;
        }

        textChannel.sendMessageEmbeds(buildInfoEmbed(textChannelID, textChannelName, roleName, guildID)).queue();
    }

    @Nullable
    private String getTextChannelID(Message message, String[] args) {
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

    private boolean isChannelRegistered(String textChannelID) {
        return clientCache.doNotifierChannelExists(textChannelID);
    }

    private MessageEmbed buildInfoEmbed(String textChannelID, String textChannelName, String mentionedRoleName, String guildID) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        NotifierChannel notifierChannel = clientCache.getListWithNotifierChannels().get(textChannelID);
        embedBuilder.setTitle(textChannelName);


        String timezone = clientCache.getGuildTimeZone(notifierChannel.getGuildID());

        embedBuilder.addField("Timezone:", timezone, true);
        embedBuilder.addField("Current time:", TimeAssistant.getTimeWithWeekday(timezone), true);
        embedBuilder.addField("ChannelID:", notifierChannel.getTextChannelID(), false);
        embedBuilder.addField("Mentioned Role:", mentionedRoleName, false);

        String guildLanguage = clientCache.getGuildLanguage(guildID);
        String yes = LanguageController.getYesMessage(guildLanguage);
        String no = LanguageController.getNoMessage(guildLanguage);

        String eventMessageEnabled = notifierChannel.isEventMessageEnabled() ? yes : no;
        embedBuilder.addField("Event message", eventMessageEnabled, true);

        String eventHeadUpEnabled = notifierChannel.isEventHeadUpEnabled() ? yes : no;
        embedBuilder.addField("Head up message", eventHeadUpEnabled, true);

        String eventAncientNightmareEnabled = notifierChannel.isAncientNightmareMessageEnabled() ? yes : no;
        embedBuilder.addField("Ancient Nightmare", eventAncientNightmareEnabled, true);

        String eventAssemblyEnabled = notifierChannel.isAssemblyMessageEnabled() ? yes : no;
        embedBuilder.addField("Assembly", eventAssemblyEnabled, true);

        String eventBattlegroundsEnabled = notifierChannel.isBattlegroundsMessageEnabled() ? yes : no;
        embedBuilder.addField("Battlegrounds", eventBattlegroundsEnabled, true);

        String eventDefendVaultEnabled = notifierChannel.isDefendVaultMessageEnabled() ? yes : no;
        embedBuilder.addField("Defend the vault", eventDefendVaultEnabled, true);

        String eventRaidVaultEnabled = notifierChannel.isRaidVaultMessageEnabled() ? yes : no;
        embedBuilder.addField("Raid the vault", eventRaidVaultEnabled, true);

        String eventDemonGatesEnabled = notifierChannel.isDemonGatesMessageEnabled() ? yes : no;
        embedBuilder.addField("Demon Gates", eventDemonGatesEnabled, true);

        String eventShadowLotteryEnabled = notifierChannel.isShadowLotteryMessageEnabled() ? yes : no;
        embedBuilder.addField("Shadow Lottery", eventShadowLotteryEnabled, true);

        String eventHauntedCarriageEnabled = notifierChannel.isEventMessageEnabled() ? yes : no;
        embedBuilder.addField("Haunted Carriage", eventHauntedCarriageEnabled, true);

        String eventHauntedCarriageEmbedEnabled = notifierChannel.isHauntedCarriageMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField("Haunted Carriage Embed", eventHauntedCarriageEmbedEnabled, true);

        String eventDemonGatesEmbedEnabled = notifierChannel.isDemonGatesMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField("Demon Gates Embed", eventDemonGatesEmbedEnabled, true);

        String eventAncientNightmareEmbedEnabled = notifierChannel.isAncientArenaMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField("Ancient Nightmare Embed", eventAncientNightmareEmbedEnabled, true);

        String eventAncientArenaEmbedEnabled = notifierChannel.isAncientArenaMessageEmbedEnabled() ? yes : no;
        embedBuilder.addField("Ancient Arena Embed", eventAncientArenaEmbedEnabled, true);

        return embedBuilder.build();
    }
}