package me.umbreon.diabloimmortalbot.commands;

import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.utils.ClientCache;

public class DebugCommand {

    private final ClientCache clientCache;

    public DebugCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public String debugMessage1(String textChannelID) {
        NotificationChannel notificationChannel = clientCache.getListWithNotifierChannels().get(textChannelID);
        if (notificationChannel == null) {
            return null;
        }
        return "G_ID:" +
                notificationChannel.getGuildID() +
                "\nT_ID:" +
                notificationChannel.getTextChannelID() +
                "\nR_ID:" +
                notificationChannel.getRoleID();
    }

    public String debugMessage2(String guildID) {
        GuildInformation guildInformation = clientCache.getGuildInformation(guildID);
        if (guildInformation == null) {
            return null;
        }
        return "G_ID:" +
                guildInformation.getGuildID() +
                "\nLANG:" +
                guildInformation.getLanguage() +
                "\nTZ:" +
                guildInformation.getTimezone();
    }

    public String debugMessage3(String textChannelID) {
        if (clientCache.isDebugEnabled(textChannelID)) {
            clientCache.removeDebugChannel(textChannelID);
            return textChannelID + " debug is disabled.";
        } else {
            clientCache.addDebugChannel(textChannelID);
            return textChannelID + " debug is enabled.";
        }
    }
}
