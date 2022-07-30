package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
/**
 * Command: >instructions
 * Alias: >instruction
 * Return: Instruction to install the bot.
 */
public class InstructionCommand {

    public void runInstructionCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        textChannel.sendMessageEmbeds(buildHelpMessage()).queue();
    }

    private MessageEmbed buildHelpMessage() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier Instructions");
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());
        embedBuilder.addField("1.", "Add the Bot to your Discord Server using: https://discord.com/oauth2/authorize?client_id=527511535309029407&scope=bot&permissions=8", true);
        embedBuilder.addField("2.", "Create a role on your discord server called \"Bot Admin\". People with that role can control the bot.", true);
        embedBuilder.addField("3.", "Assign the created role (Bot Admin) to yourself! Not to the bot!", true);
        embedBuilder.addField("4.", "Create a textchannel you like to get the notifications in.", true);
        embedBuilder.setFooter("Diablo Immortal Notifier - Created by Umbreon.");
        return embedBuilder.build();
    }
}
