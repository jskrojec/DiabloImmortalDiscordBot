package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

public interface ClientCommand {

    void runCommand(SlashCommandInteraction event);

    default void replyEphemeralToUser(SlashCommandInteraction event, String message) {
        event.reply(message).setEphemeral(true).queue();
    }

    default void replyEmbedEphemeralToUser(SlashCommandInteraction event, MessageEmbed embed) {
        event.replyEmbeds(embed).setEphemeral(true).queue();
    }

}
