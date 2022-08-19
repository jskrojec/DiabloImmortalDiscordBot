package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class LanguagesCommand {

    private MessageEmbed languagesMessageEmbed;

    public LanguagesCommand() {
        buildLanguagesMessageEmbed();
    }

    public void runLanguagesCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        textChannel.sendMessageEmbeds(languagesMessageEmbed).queue();
    }

    private void buildLanguagesMessageEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Languages:");
        embedBuilder.setColor(Color.ORANGE);
        embedBuilder.addField("GER (German)", LanguageController.getLanguageMessage("GER"), false);
        embedBuilder.addField("ENG (English)", LanguageController.getLanguageMessage("ENG"), false);
        embedBuilder.addField("ESP (Spanish)", LanguageController.getLanguageMessage("ESP"), false);
        embedBuilder.addField("FRA (French)", LanguageController.getLanguageMessage("FRA"), false);
        embedBuilder.addField("POL (Polish)", LanguageController.getLanguageMessage("POL"), false);
        embedBuilder.addField("ITA (Italian)", LanguageController.getLanguageMessage("ITA"), false);
        embedBuilder.addField("IND (Indonesia)", LanguageController.getLanguageMessage("IND"), false);
        embedBuilder.addField("RUS (Russian)", LanguageController.getLanguageMessage("RUS"), false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("Request new languages:", "Languages are added to the bot with" +
                " the help of the community. Request a language on my Discord.", false);
        languagesMessageEmbed = embedBuilder.build();
    }
}
