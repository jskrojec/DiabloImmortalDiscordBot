package me.umbreon.diabloimmortalbot.commands.notifier_commands;

import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.*;

import java.util.concurrent.TimeUnit;
/**
 * Command: >register (TextChannelMention)
 * Alias: >notifier (TextChannelMention)
 * L:2
 * (Optional)
 */
public class RegisterCommand {

    private final DatabaseRequests databaseRequests;
    private final ClientCache clientCache;

    public RegisterCommand(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runRegisterCommand(Message message) {
        String[] args = message.getContentRaw().split(" ");
        Guild guild = message.getGuild();
        //String channelID = args[1].replaceAll("[^\\d.]", ""); //Replaces non numbers with empty space
        String channelID = message.getTextChannel().getId();
        TextChannel targetTextChannel;
        if (args.length == 2) {
            targetTextChannel = guild.getTextChannelById(args[1]);

        }

        TextChannel textChannel = message.getTextChannel();
        String guildID = message.getGuild().getId();
        String language = clientCache.getLanguage(guildID);

        if (clientCache.doNotificationChannelExists(channelID)) {
            String responseMessage = textChannel.getAsMention() + LanguageController.getAlreadyRegisteredMessage(language);
            textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
            return;
        }

        NotificationChannel notificationChannel = new NotificationChannel(channelID);
        databaseRequests.createNewNotificationChannelEntry(notificationChannel);
        clientCache.addNotificationChannel(notificationChannel);

        String responseMessage = String.format(LanguageController.getRegisteredMessage(language), textChannel.getAsMention());
        textChannel.sendMessage(responseMessage).queue(sendMessage -> sendMessage.delete().queueAfter(10, TimeUnit.SECONDS));
    }

}
