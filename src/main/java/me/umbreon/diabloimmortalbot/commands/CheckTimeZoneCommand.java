package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Message;

public class CheckTimeZoneCommand {

    public void onCheckTimeZoneCommand(Message message) {
        message.delete().queue();
        String[] args = message.getContentRaw().split(" ");
        String timeZone = args[1].toUpperCase();
        message.getTextChannel().sendMessage(timeZone + " " + Time.getTimeWithWeekday(timeZone)).queue();
    }
}
