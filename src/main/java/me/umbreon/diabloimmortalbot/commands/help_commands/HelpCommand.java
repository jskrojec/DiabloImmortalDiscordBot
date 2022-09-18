package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /help
 * Description: Sent's the user a help message with all commands.
 */
public class HelpCommand {

    private final ClientCache clientCache;

    public HelpCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runHelpCommand(final SlashCommandInteractionEvent event) {
        String guildID = event.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);
        event.replyEmbeds(buildHelpMessage(guildLanguage)).setEphemeral(true).queue();
    }

    private MessageEmbed buildHelpMessage(final String guildLanguage) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier Commands");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());
        embedBuilder.addField("/register", LanguageController.getHelpRegistersChannelMessage(guildLanguage), false);
        embedBuilder.addField("/unregister", LanguageController.getHelpUnregistersChannelMessage(guildLanguage), false);
        embedBuilder.addField("/mentionrole @YOUR_ROLE", LanguageController.getHelpSetRoleMessage(guildLanguage), false);
        embedBuilder.addField("/info", LanguageController.getHelpShowInfoMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("/createcustommessage <WEEKDAY> <TIME> <BOOL_REPEATING> <MESSAGE>", LanguageController.getHelpCreateCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField("/deletecustommessage <ID>", LanguageController.getHelpDeleteCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField("/listcustommessages", LanguageController.getHelpShowAllCustomMessagesMessage(guildLanguage), false);
        embedBuilder.addField("/custommessageinfo <ID>", LanguageController.getHelpShowCustomMessageInfoMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("/server headup on/off", LanguageController.getHelpServerHeadUpMessage(guildLanguage), false);
        embedBuilder.addField("/server message on/off", LanguageController.getHelpServerMessagesMessage(guildLanguage), false);
        embedBuilder.addField("/config", LanguageController.getHelpServerConfigMessage(guildLanguage), false);
        embedBuilder.addField("/language <language>", LanguageController.getHelpServerLanguageMessage(guildLanguage), false);
        embedBuilder.addField("/timezone <timezone>", LanguageController.getHelpServerTimezoneMessage(guildLanguage), false);
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
