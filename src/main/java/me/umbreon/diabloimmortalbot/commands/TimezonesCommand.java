package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.time.Instant;

public class TimezonesCommand {

    public void runTimezonesCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Timezones");
        embedBuilder.setColor(Color.RED);

        long hourInSeconds = 3600;
        long unixTime = Instant.now().getEpochSecond() + (hourInSeconds * 10);

        for (int i = 12; i > -12; i--) {
            String timezoneMessage;
            if (i > 0) {
                timezoneMessage = "GMT+" + i;
            } else if (i == 0) {
                timezoneMessage = "GMT";
            } else {
                timezoneMessage = "GMT" + i;
            }

            embedBuilder.addField(timezoneMessage, "<t:" + unixTime + ">", true);
            unixTime = unixTime - hourInSeconds;
        }

        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
