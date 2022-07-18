package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand {

    public void runHelpCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();

        String helpMessage = "**Diablo Immortal Notifier Commands:**\n" +
                "'>register - Register that channel as Notifier-Channel'\n" +
                "'>unregister - Unregisters that channel.'\n" +
                "'>timezone GMT - Set your timezone. Known working timezones are GMT and EST.'\n" +
                "'>timeszones - Message with GMT times to see what timezone would fit you.\n" +
                "'>status 0 - Select what messages you like to get.'\n" +
                "'>role @Role - Set what role should be mentioned in this textchannel. If you dont set the role everyone will be mentioned.'\n" +
                "'>language ENG - DISABLED, there is no other than english, requst an language on my Discord server.\n" +
                "'>whatismychannelid - Shows you your channelid.\n" +
                "'>headup on/off - Enable or disable 15 minutes prewarning message.\n" +
                "'>checktimezone GMT+2 - Helps you find the right timezone for your server'\n\n" +
                "Possible Codes for status:\n" +
                "0 = All messages.\n" +
                "1 = Only overworld.\n" +
                "2 = Only Immortal\n" +
                "3 = Only Shadow\n" +
                "4 = Immortal with overworld\n" +
                "5 = Shadow with overworld\n" +
                "9 = Overworld Events with Embed (No ping!)";

        textChannel.sendMessage(helpMessage).queue();
    }
}
