package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

/**
 * Aliases: "ctz", "checktz", "checktimezone"
 * @author Umbreon Majora
 */

public class CheckTimeZoneCommand {

    private final ClientCache clientCache;

    public CheckTimeZoneCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runCheckTimezoneCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String[] args = message.getContentRaw().split(" ");

        if (args.length == 1) {
            String responseMessage = "Invalid command. Use >help";
            message.getTextChannel().sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            createLogEntry(message, responseMessage);
            return;
        }

        Guild guild = message.getGuild();
        String timeZone = args[1].toUpperCase();
        String time = Time.getTimeWithWeekday(timeZone);
        String guildID = guild.getId();
        String language = clientCache.getLanguage(guildID);

        if (time.equalsIgnoreCase("INVALID_TIMEZONE")) {
            String responseMessage = LanguageController.getUnknownTimezoneMessage(language);
            textChannel.sendMessage(responseMessage).queue();
            createLogEntry(message, responseMessage);
            return;
        }

        textChannel.sendMessage(timeZone + " " + Time.getTimeWithWeekday(timeZone)).queue();
    }

    private void createLogEntry(Message message, String responseMessage) {
        String channelName = message.getTextChannel().getName();
        String guildName = message.getGuild().getName();
        String logMessage = "Sended message " + responseMessage + " to " + channelName + " in guild " + guildName + ".";
        ClientLogger.createNewInfoLogEntry(logMessage);
    }
}
