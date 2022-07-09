package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.entities.Message;
/*
AYST = Are you still there?
 */
public class AYSTCommand {

    public void onAYSTCommand(Message message) {
        message.getTextChannel().sendMessage("Yes, I am still there.").queue();
    }
}
