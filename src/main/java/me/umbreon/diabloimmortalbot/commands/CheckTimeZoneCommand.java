package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Message;

public class CheckTimeZoneCommand {

    public void runCheckTimezoneCommand(Message message) {
        message.delete().queue();
        String[] args = message.getContentRaw().split(" ");
        String timeZone;
        try {
            timeZone = args[1].toUpperCase();
        } catch (NullPointerException e) {
            message.getTextChannel().sendMessage("Invalid entry.").queue();
            return;
        }

        message.getTextChannel().sendMessage(timeZone + " " + Time.getTimeWithWeekday(timeZone)).queue();
    }
}
