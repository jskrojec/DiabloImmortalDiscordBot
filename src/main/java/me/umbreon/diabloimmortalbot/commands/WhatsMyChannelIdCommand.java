package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.entities.Message;

public class WhatsMyChannelIdCommand {

    public void runWhatsMyChannelIdCommand(Message message) {
        message.delete().queue();
        message.getTextChannel().sendMessage("Your channel identifier is: " + message.getTextChannel().getId()).queue();
    }
}
