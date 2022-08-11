package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.data.NotifierChannel;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
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

        String textChannelName = message.getGuild().getTextChannelById(textChannelID).getName();
        textChannel.sendMessageEmbeds(buildInfoEmbed(textChannelID, textChannelName)).queue();
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

    private MessageEmbed buildInfoEmbed(String textChannelID, String textChannelName) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        NotifierChannel notifierChannel = clientCache.getListWithNotifierChannels().get(textChannelID);
        embedBuilder.setTitle(textChannelName);
        String timezone = clientCache.getGuildTimeZone(notifierChannel.getGuildID());
        embedBuilder.addField("Timezone:", timezone, true);
        embedBuilder.addField("Current time:", TimeAssistant.getTimeWithWeekday(timezone), true);
        embedBuilder.addField("ChannelID:", notifierChannel.getTextChannelID(), false);
        embedBuilder.addField("Event message", notifierChannel.isEventMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Head up message", notifierChannel.isEventHeadUpEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Ancient Nightmare", notifierChannel.isAncientNightmareMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Assembly", notifierChannel.isAssemblyMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Battlegrounds", notifierChannel.isBattlegroundsMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Defend the vault", notifierChannel.isDefendVaultMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Raid the vault", notifierChannel.isRaidVaultMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Demon Gates", notifierChannel.isDemonGatesMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Shadow Lottery", notifierChannel.isShadowLotteryMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Haunted Carriage", notifierChannel.isHauntedCarriageMessageEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Haunted Carriage Embed", notifierChannel.isHauntedCarriageMessageEmbedEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Demon Gates Embed", notifierChannel.isDemonGatesMessageEmbedEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Ancient Nightmare Embed", notifierChannel.isAncientArenaMessageEmbedEnabled() ? "Yes" : "No", true);
        embedBuilder.addField("Ancient Arena Embed", notifierChannel.isAncientArenaMessageEmbedEnabled() ? "Yes" : "No", true);
        return embedBuilder.build();
    }
}