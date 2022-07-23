package me.umbreon.diabloimmortalbot.commands.help_commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class InstructionCommand {

    public void runInstructionCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        textChannel.sendMessageEmbeds(buildHelpMessage()).queue();
    }

    private MessageEmbed buildHelpMessage() {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Diablo Immortal Notifier Instructions");
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");
        embedBuilder.addField("1.", "Add the Bot to your Discord Server using: https://discord.com/oauth2/authorize?client_id=527511535309029407&scope=bot&permissions=8", false);
        embedBuilder.addField("2.", "Create a role on your discord server called \"Bot Admin\". People with that role can control the bot.", false);
        embedBuilder.addField("3.", "Assign the created role (Bot Admin) to yourself! Not to the bot!", false);
        embedBuilder.addField("4.", "Create a textchannel you like to get the notifications in.", false);

        embedBuilder.setFooter("Diablo Immortal Notifier - Created by Umbreon.");
        return embedBuilder.build();
    }
}
