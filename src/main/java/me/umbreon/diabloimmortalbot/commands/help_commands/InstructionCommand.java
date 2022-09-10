package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class InstructionCommand {

    private final ClientCache clientCache;

    public InstructionCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runInstructionCommand(final TextChannel textChannel) {
        final String guildID = textChannel.getGuild().getId();
        final String guildLanguage = clientCache.getGuildLanguage(guildID);

        sendMessage(guildID, guildLanguage, textChannel);
    }

    private MessageEmbed buildHelpMessage(final String guildLanguage) {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier " + LanguageController.getInstructionsMessage(guildLanguage));
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());
        embedBuilder.addField("1.", LanguageController.getInstall1Message(guildLanguage), false);
        embedBuilder.addField("2.", LanguageController.getInstall2Message(guildLanguage), false);
        embedBuilder.addField("3.", LanguageController.getInstall3Message(guildLanguage), false);
        embedBuilder.addField("4.", LanguageController.getInstall4Message(guildLanguage), false);
        embedBuilder.addField("5.", LanguageController.getInstall5Message(guildLanguage), false);
        embedBuilder.setFooter(String.format(LanguageController.getFooterCreatedByMessage(guildLanguage), "Diablo Immortal Notifier - ", "Umbreon"));
        return embedBuilder.build();
    }

    private void sendMessage(final String guildID, final String guildLanguage, final TextChannel textChannel) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessageEmbeds(buildHelpMessage(guildLanguage)).queue(message1 -> {
                message1.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessageEmbeds(buildHelpMessage(guildLanguage)).queue();
    }
}
