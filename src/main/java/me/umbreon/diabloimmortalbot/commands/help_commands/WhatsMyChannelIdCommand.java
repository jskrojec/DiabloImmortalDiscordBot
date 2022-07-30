package me.umbreon.diabloimmortalbot.commands.help_commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
/**
 * Command: >WhatIsMyChannelID
 * Alias: >WhatsMyChannelID
 * returns: The channel id of the channel where the message was sent.
 */
public class WhatsMyChannelIdCommand {

    public void runWhatsMyChannelIdCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();
        textChannel.sendMessageEmbeds(buildChannelIdEmbed(channelID)).queue();
    }

    private MessageEmbed buildChannelIdEmbed(String channelID) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.GRAY);
        embedBuilder.addField("Your channel ID:", channelID, true);
        return embedBuilder.build();
    }

}