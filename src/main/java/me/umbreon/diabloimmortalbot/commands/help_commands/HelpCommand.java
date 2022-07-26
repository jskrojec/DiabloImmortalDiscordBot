package me.umbreon.diabloimmortalbot.commands.help_commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class HelpCommand {

    public void runHelpCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();

        textChannel.sendMessageEmbeds(buildHelpMessage()).queue();
    }

    private MessageEmbed buildHelpMessage() {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Diablo Immortal Notifier Commands");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setThumbnail("https://blz-contentstack-images.akamaized.net/v3/assets/blt77f4425de611b362/blt7b64284fbcdfaa77/60e75dd92d26525ef67ac8c5/nav-icon.png");
        embedBuilder.addField(">register", "Registers that channel as notifier-channel.", false);
        embedBuilder.addField(">unregister", "Unregisters that channel.", false);
        embedBuilder.addField(">timezone [Timezone]", "Sets your timezone.", false);
        embedBuilder.addField(">timezones", "Message with GMT times to see what timezone would fit you.", false);
        embedBuilder.addField(">status [STATUS]", "Select what messages you like to get.", false);
        embedBuilder.addField(">role [Role]", "Set what role should be mentioned in this textchannel. If you dont set the role everyone will be mentioned.", false);
        embedBuilder.addField(">language [Language]", "Sets bot language for this server.", false);
        embedBuilder.addField(">headup on/off", "Enable or disable 15 minutes prewarning message.", false);
        embedBuilder.addField(">checktimezone", "Helps you find the right timezone for your server", false);
        embedBuilder.addField(">whatismychannelid", "Shows you your channelid.", false);
        embedBuilder.addField(">instructions", "Shows the bot instructions.", false);
        embedBuilder.addField(">help", "Shows this message.", false);
        embedBuilder.addBlankField(false);
        embedBuilder.addField("Possible Codes for status:",
                "0 = All messages.\n" +
                        "1 = Only overworld.\n" +
                        "2 = Only Immortal\n" +
                        "3 = Only Shadow\n" +
                        "4 = Immortal with overworld\n" +
                        "5 = Shadow with overworld\n" +
                        "7 = Immortal with Overworld Embed Messages\n" +
                        "8 = Shadow with Overworld Embed Messages\n" +
                        "9 = Overworld Events with Embed (No ping!)\n" +
                        "128 = Debug Mode - Used for testing purposes: E.g.: Check if channel retrives messages.", false);

        embedBuilder.addField("Support on Discord:", "https://discord.gg/hpBHYkffS3", false);
        embedBuilder.setFooter("Diablo Immortal Notifier - Created by Umbreon.");
        return embedBuilder.build();
    }
}
