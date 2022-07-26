package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class TimezonesCommand {

    public void runTimezonesCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Timezones");
        embedBuilder.setColor(Color.RED);
        String[] args = message.getContentRaw().split(" ");

        String timezone;
        if (args.length == 1) {
            timezone = "GMT";
        } else {
            timezone = args[1];
        }

        for (int i = 12; i > -12; i--) {
            String timezoneMessage;
            if (i > 0) {
                timezoneMessage = timezone + "+" + i;
            } else if (i == 0) {
                timezoneMessage = timezone;
            } else {
                timezoneMessage = timezone + i;
            }

            String time = Time.getTimeWithWeekday(timezoneMessage);

            if (time.equalsIgnoreCase("INVALID_TIMEZONE")) {
                textChannel.sendMessage("Unknown Timezone. Known timezones are UTC, GMT & ET.").queue();
                return;
            }

            embedBuilder.addField(timezoneMessage, time, true);
        }
        embedBuilder.setFooter("These times are in 24HRS format!");
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
