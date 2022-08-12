package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

/**
 * Command: >help
 */
public class HelpCommand {

    private final ClientCache clientCache;

    public HelpCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runHelpCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);
        textChannel.sendMessageEmbeds(buildHelpMessage(guildLanguage)).queue();
    }

    private MessageEmbed buildHelpMessage(String guildLanguage) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier Commands");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());
        embedBuilder.addField(">register", LanguageController.getRegistersChannelMessage(guildLanguage), false);
        embedBuilder.addField(">unregister", LanguageController.getUnregistersChannelMessage(guildLanguage), false);
        embedBuilder.addField(">role @YOUR_ROLE", LanguageController.getSetsChannelRoleMessage(guildLanguage), false);
        embedBuilder.addField(">info", LanguageController.getShowsChannelInfoMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField(">cm create", LanguageController.getCreateCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField(">cm delete ID", LanguageController.getDeleteCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField(">cm list", LanguageController.getShowsAllCustomMessageMessage(guildLanguage), false);
        embedBuilder.addField(">cm info ID", LanguageController.getShowsCustomMessageInfoMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField(">server headup on/off", LanguageController.getHeadUpActivationMessage(guildLanguage), false);
        embedBuilder.addField(">server message on/off", LanguageController.getMessageActivationMessage(guildLanguage), false);
        embedBuilder.addField(">server config", LanguageController.getShowsServerConfigMessage(guildLanguage), false);
        embedBuilder.addField(">server language", LanguageController.getSetsServerLanguageMessage(guildLanguage), false);
        embedBuilder.addField(">server timezone", LanguageController.getSetsTimezoneLanguageMessage(guildLanguage), false);
        embedBuilder.addField(">server autodelete on/off", LanguageController.getAutoDeleteActivationMessage(guildLanguage), false);
        embedBuilder.addField(">server autodelete 24/48/72", LanguageController.getAutoDeleteValueMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField(">install", LanguageController.getShowsBotInstallMessage(guildLanguage), false);
        embedBuilder.addField(">help", LanguageController.getShowsThisMessageMessage(guildLanguage), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField(LanguageController.getSupportDiscordMessage(guildLanguage), "https://discord.gg/hpBHYkffS3", false);
        embedBuilder.setFooter(String.format(LanguageController.getCreatedByMessage(guildLanguage), "Diablo Immortal Notifier - ", "Umbreon"));
        return embedBuilder.build();
    }
}
