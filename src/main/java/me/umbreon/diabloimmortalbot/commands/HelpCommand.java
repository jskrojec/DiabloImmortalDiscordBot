package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand {

    public void onHelpCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();

        String helpMessage = "'>notifier - Register that channel as Notifier-Channel'\n" +
                "'>unnotifier - Unregisters that channel.'\n" +
                "'>timezone EST - Set your timezone'\n" +
                "'>status 0 to select what messages you like to get.'\n" +
                "'>role @Role to set what role should be mentioned in this textchannel. If you dont set the role everyone will be mentioned.'\n" +
                "'>checktimetone GMT+2 - Helps you find the right timezone for your server'\n\n" +
                "Possible Codes for status:\n" +
                "0 = All messages.\n" +
                "1 = Only overworld.\n" +
                "2 = Only Immortal\n" +
                "3 = Only Shadow\n" +
                "4 = Immortal with overworld\n" +
                "5 = Shadow with overworld";

        textChannel.sendMessage(message).queue();
    }
}
