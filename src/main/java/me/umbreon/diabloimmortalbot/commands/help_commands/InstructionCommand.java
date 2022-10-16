package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /install
 * Description: Show's the user a step by step instruction on how to install the bot.
 */
public class InstructionCommand {

    private final ClientCache clientCache;
    private final GuildsCache guildsCache;

    public InstructionCommand(final ClientCache clientCache, GuildsCache guildsCache) {
        this.clientCache = clientCache;
        this.guildsCache = guildsCache;
    }

    public void runInstructionCommand(final SlashCommandInteractionEvent event) {
        String guildID = event.getGuild().getId();
        String guildLanguage = guildsCache.getGuildLanguage(guildID);
        event.replyEmbeds(buildHelpMessage(guildLanguage)).setEphemeral(true).queue();
    }

    private MessageEmbed buildHelpMessage(final String guildLanguage) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier " + LanguageController.getInstructionsMessage(guildLanguage));
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setThumbnail(StringUtils.getDiabloImmortalLogo());
        embedBuilder.addField("1.", LanguageController.getInstall1Message(guildLanguage), false);
        embedBuilder.addField("2.", LanguageController.getInstall2Message(guildLanguage), false);
        embedBuilder.addField("3.", LanguageController.getInstall3Message(guildLanguage), false);
        embedBuilder.addField("4.", LanguageController.getInstall4Message(guildLanguage), false);
        embedBuilder.addField("5.", LanguageController.getInstall5Message(guildLanguage), false);
        embedBuilder.setFooter(String.format(LanguageController.getFooterCreatedByMessage(guildLanguage), "Diablo Immortal Notifier - ", "Umbreon"));
        return embedBuilder.build();
    }
}
