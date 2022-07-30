package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class LanguagesCommand {

    private final EmbedBuilder languagesMessageEmbed = new EmbedBuilder();

    public LanguagesCommand() {
        buildLanguagesMessageEmbed();
    }

    public void runLanguagesCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        textChannel.sendMessageEmbeds(languagesMessageEmbed.build()).queue();
    }

    private void buildLanguagesMessageEmbed() {
        languagesMessageEmbed.setTitle("Languages:");
        languagesMessageEmbed.setColor(Color.ORANGE);
        languagesMessageEmbed.addField("GER (German)", LanguageController.getLanguageMessage("GER"), false);
        languagesMessageEmbed.addField("ENG (English)", LanguageController.getLanguageMessage("ENG"), false);
        languagesMessageEmbed.addField("ESP (Spanish)", LanguageController.getLanguageMessage("ESP"), false);
        languagesMessageEmbed.addField("FRA (French)", LanguageController.getLanguageMessage("FRA"), false);
        languagesMessageEmbed.addField("POL (Polish)", LanguageController.getLanguageMessage("POL"), false);
        languagesMessageEmbed.addField("ITA (Italian)", LanguageController.getLanguageMessage("ITA"), false);
        languagesMessageEmbed.addBlankField(false);
        languagesMessageEmbed.addField("Request new languages:", "Languages are added to the bot with" +
                " the help of the community. Request a language on my Discord.", false);
    }
}
