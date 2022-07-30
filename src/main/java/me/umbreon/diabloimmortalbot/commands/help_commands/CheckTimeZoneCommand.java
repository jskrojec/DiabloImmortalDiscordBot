package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.concurrent.TimeUnit;
/**
 * Command: >checktimezone GMT+2
 * Aliases: "ctz", "checktz", "checktimezone"
 */
public class CheckTimeZoneCommand {

    private final ClientCache clientCache;

    public CheckTimeZoneCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runCheckTimezoneCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        if (!areArgumentsValid(args)) {
            textChannel.sendMessageEmbeds(buildInvalidCommandEmbed(language)).queue();
            return;
        }

        String timeZone = args[1].toUpperCase();
        String time = Time.getTimeWithWeekday(timeZone);

        if (!isTimeZoneValid(time)) {
            textChannel.sendMessageEmbeds(buildUnknownTimezoneEmbed(language)).queue();
            return;
        }

        textChannel.sendMessageEmbeds(buildCheckTimezoneReturnEmbed(timeZone, time)).queue();
    }

    private MessageEmbed buildInvalidCommandEmbed(String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.RED);
        embedBuilder.setTitle(LanguageController.getInvalidCommandMessage(language));
        return embedBuilder.build();
    }

    private boolean areArgumentsValid(String[] args) {
        return args.length == 1;
    }

    private boolean isTimeZoneValid(String time) {
        return time.equalsIgnoreCase("INVALID_TIMEZONE");
    }

    private MessageEmbed buildUnknownTimezoneEmbed(String language) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.RED);
        embedBuilder.setTitle(LanguageController.getUnknownTimezoneMessage(language));
        return embedBuilder.build();
    }

    private MessageEmbed buildCheckTimezoneReturnEmbed(String timezone, String time) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.ORANGE);
        embedBuilder.setTitle("Timezone: " + timezone + "\nTime: " + time);
        return embedBuilder.build();
    }
}
