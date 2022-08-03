package me.umbreon.diabloimmortalbot.commands.help_commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
/**
 * Command: >WhatIsMyChannelID
 * Alias: >WhatsMyChannelID
 * returns: The channel id of the channel where the message was sent.
 */
public class WhatsMyChannelIdCommand {

    public void runWhatsMyChannelIdCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();
        textChannel.sendMessage(channelID).queue();
    }

}