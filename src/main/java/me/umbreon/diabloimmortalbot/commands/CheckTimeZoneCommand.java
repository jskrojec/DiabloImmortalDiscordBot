package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Message;

public class CheckTimeZoneCommand {

    public void onCheckTimeZoneCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        String timeZone = args[1].toUpperCase();
        message.getTextChannel().sendMessage(Time.getFullTime(timeZone)).queue();
    }
}
