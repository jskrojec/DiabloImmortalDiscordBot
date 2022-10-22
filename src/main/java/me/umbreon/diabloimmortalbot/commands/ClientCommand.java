package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

public interface ClientCommand {

    void runCommand(SlashCommandInteraction event);
}
