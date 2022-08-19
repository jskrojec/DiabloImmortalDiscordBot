package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TimezonesCommand {

    private final ClientCache clientCache;

    public TimezonesCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runTimezonesCommand(Message message) {
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

        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        for (int i = 12; i > -12; i--) {
            String timezoneMessage;
            if (i > 0) {
                timezoneMessage = timezone + "+" + i;
            } else if (i == 0) {
                timezoneMessage = timezone;
            } else {
                timezoneMessage = timezone + i;
            }

            String time = TimeAssistant.getTimeWithWeekday(timezoneMessage);

            if (time.equalsIgnoreCase("INVALID_TIMEZONE")) {
                sendMessageToTextChannel(guildID, textChannel, LanguageController.getUnknownTimezoneMessage(guildLanguage));
                return;
            }

            embedBuilder.addField(timezoneMessage, time, true);
        }
        embedBuilder.setFooter(LanguageController.getFooterTimesIn24HrsFormatMessage(guildLanguage));
        textChannel.sendMessageEmbeds(embedBuilder.build()).queue();
    }

    private void sendMessageToTextChannel(final String guildID, TextChannel textChannel, String message) {
        if (clientCache.isAutoDeleteEnabled(guildID)) {
            textChannel.sendMessage(message).queue(sendMessage -> {
                sendMessage.delete().queueAfter(clientCache.getAutoDeleteValue(guildID), TimeUnit.HOURS);
            });
        } else textChannel.sendMessage(message).queue();
    }

}
