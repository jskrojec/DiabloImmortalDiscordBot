package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

/**
 * Command: /help
 */
public class HelpCommand {

    private final ClientCache clientCache;

    public HelpCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runHelpCommand(final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);
        textChannel.sendMessageEmbeds(buildHelpMessage(guildLanguage)).queue();
    }

    private MessageEmbed buildHelpMessage(final String guildLanguage) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier Commands");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());
        embedBuilder.addField("/register", LanguageController.getHelpRegistersChannelMessage(guildLanguage), false);
        embedBuilder.addField("/unregister", LanguageController.getHelpUnregistersChannelMessage(guildLanguage), false);
        embedBuilder.addField("/role @YOUR_ROLE", LanguageController.getHelpSetRoleMessage(guildLanguage), false);
        embedBuilder.addField("/info", LanguageController.getHelpShowInfoMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("/cm create", LanguageController.getHelpCreateCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField("/cm delete ID", LanguageController.getHelpDeleteCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField("/cm list", LanguageController.getHelpShowAllCustomMessagesMessage(guildLanguage), false);
        embedBuilder.addField("/cm info ID", LanguageController.getHelpShowCustomMessageInfoMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("/server headup on/off", LanguageController.getHelpServerHeadUpMessage(guildLanguage), false);
        embedBuilder.addField("/server message on/off", LanguageController.getHelpServerMessagesMessage(guildLanguage), false);
        embedBuilder.addField("/server config", LanguageController.getHelpServerConfigMessage(guildLanguage), false);
        embedBuilder.addField("/server language <language>", LanguageController.getHelpServerLanguageMessage(guildLanguage), false);
        embedBuilder.addField("/timezone <timezone>", LanguageController.getHelpServerTimezoneMessage(guildLanguage), false);
        embedBuilder.addField("/server autodelete on/off", LanguageController.getHelpServerAutoDeleteSetMessage(guildLanguage), false);
        embedBuilder.addField("/server autodelete 24/48/72", LanguageController.getHelpServerAutoDeleteValueMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("/event battlegrounds on/off", LanguageController.getHelpEventSetMessage(guildLanguage), false);
        embedBuilder.addField("/event list", LanguageController.getHelpEventListMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("/install", LanguageController.getShowsBotInstallMessage(guildLanguage), false);
        embedBuilder.addField("/help", LanguageController.getShowsThisMessageMessage(guildLanguage), false);
        embedBuilder.addField("/languages", "Shows you all available languages.", false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField(LanguageController.getSupportDiscordMessage(guildLanguage), "https://discord.gg/hpBHYkffS3", false);
        embedBuilder.setFooter(String.format(LanguageController.getFooterCreatedByMessage(guildLanguage), "Diablo Immortal Notifier - ", "Umbreon"));
        return embedBuilder.build();
    }
}
