package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /timezones
 * Description: Show's the user a list with all GMT times so the user can pick that timezone which matches
 */
public class TimezonesCommand {

    private final ClientCache clientCache;

    public TimezonesCommand(final ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runTimezonesCommand(final SlashCommandInteractionEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Timezones");
        embedBuilder.setColor(Color.RED);

        String timezone = "GMT";
        String guildID = event.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        for (int i = 12; i > -12; i--) {
            final String timezoneMessage;
            if (i > 0) {
                timezoneMessage = timezone + "+" + i;
            } else if (i == 0) {
                timezoneMessage = timezone;
            } else {
                timezoneMessage = timezone + i;
            }

            final String time = TimeAssistant.getTimeWithWeekday(timezoneMessage);

            if (time.equalsIgnoreCase("INVALID_TIMEZONE")) {
                event.reply(LanguageController.getUnknownTimezoneMessage(guildLanguage)).setEphemeral(true).queue();
                return;
            }

            embedBuilder.addField(timezoneMessage, time, true);
        }
        embedBuilder.setFooter(LanguageController.getFooterTimesIn24HrsFormatMessage(guildLanguage));
        event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
    }

}
