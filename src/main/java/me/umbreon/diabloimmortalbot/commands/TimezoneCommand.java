package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class TimezoneCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public TimezoneCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.databaseRequests = databaseRequests;
        this.clientCache = clientCache;
    }

    public void onTimezoneCommand(Message message) {
        message.delete().queue();

        TextChannel textChannel = message.getTextChannel();
        String channelID = textChannel.getId();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getLanguage(guildID);

        if (!clientCache.doNotificationChannelExists(channelID)) {
            textChannel.sendMessage(textChannel.getAsMention() +
                    LanguageController.getNotRegisteredMessage(guildLanguage)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
            return;
        }

        String[] args = message.getContentRaw().split(" ");
        String timezone = args[1].toUpperCase();

        if (!timezone.substring(0, 3).equalsIgnoreCase("GMT") || !timezone.substring(0, 3).equalsIgnoreCase("EST")) {
            textChannel.sendMessage(String.format(LanguageController.getUnknownTimezoneMessage(guildLanguage), timezone)).queue(sendMessage -> {
                sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
            });
        }

        databaseRequests.setTimezone(channelID, timezone);
        clientCache.setTimezone(channelID, timezone);

        message.getTextChannel().sendMessage(message.getTextChannel().getAsMention() +
                LanguageController.getTimezoneSetToMessage(guildLanguage) + timezone + ".").queue(sendMessage -> {
            sendMessage.delete().queueAfter(10, TimeUnit.SECONDS);
        });


    }

    public void runTimezoneCommand(Message message) {
        message.delete().queue();
        String[] args = message.getContentRaw().split(" ");
        String timezone = args[1].toUpperCase();

        Guild guild = message.getGuild();
        String guildID = guild.getId();


        if (!clientCache.doGuildExists(guildID)) {
            GuildInformation guildInformation = new GuildInformation(guildID, "GMT", timezone);
            createNewGuildAndSetTimezone(guildInformation);
        } else {
            setNewTimezone(guildID, timezone);
        }

        //updated guild timezone
    }

    private void createNewGuildAndSetTimezone(GuildInformation guildInformation) {
        databaseRequests.createNewGuildEntry(guildInformation);
        clientCache.addGuildInformation(guildInformation);
    }

    private void setNewTimezone(String guildID, String timezone) {
        databaseRequests.setGuildTimezone(guildID, timezone);
        clientCache.setTimezoneFromGuild(guildID, timezone);
    }
}

