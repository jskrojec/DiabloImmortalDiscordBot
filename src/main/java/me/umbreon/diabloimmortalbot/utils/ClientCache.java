package me.umbreon.diabloimmortalbot.utils;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;

import java.util.Map;

public class ClientCache {

    private Map<String, NotificationChannel> listWithNotificationChannels;
    private Map<String, GuildInformation> listWithGuildInformation;
    private Map<String, CustomMessage> listWithCustomMessages;

    public void setListWithCustomMessages(Map<String, CustomMessage> listWithCustomMessages) {
        this.listWithCustomMessages = listWithCustomMessages;
    }

    public Map<String, CustomMessage> getListWithCustomMessages() {
        return listWithCustomMessages;
    }

    public CustomMessage getCustomMessageByChannelID(String channelID) {
        return listWithCustomMessages.get(channelID);
    }

    public String getCustomMessageFullTimeByChannelID(String channelID) {
        String day = listWithCustomMessages.get(channelID).getDay();
        String time = listWithCustomMessages.get(channelID).getTime();
        return day + " " + time;
    }

    public void setListWithNotificationChannels(Map<String, NotificationChannel> listWithNotificationChannels) {
        this.listWithNotificationChannels = listWithNotificationChannels;
    }

    public Map<String, NotificationChannel> getListWithNotificationChannels() {
        return listWithNotificationChannels;
    }

    public String getCustomMessageMessageByChannelID(String channelID) {
        return listWithCustomMessages.get(channelID).getMessage();
    }

    public int getStatus(String channelId) {
        return listWithNotificationChannels.get(channelId).getStatus();
    }

    public String getTimezone(String channelId) {
        return listWithNotificationChannels.get(channelId).getTimezone();
    }

    public String getMentionRoleID(String channelId) {
        return listWithNotificationChannels.get(channelId).getRole();
    }

    public boolean doNotificationChannelExists(String channelID) {
        return listWithNotificationChannels.containsKey(channelID);
    }

    public void addNotificationChannel(NotificationChannel notificationChannel) {
        listWithNotificationChannels.put(notificationChannel.channelId, notificationChannel);
    }

    public void setRole(String channelID, String roleID) {
        listWithNotificationChannels.get(channelID).setRole(roleID);
    }

    public void setStatus(String channelID, int status) {
        listWithNotificationChannels.get(channelID).setStatus(status);
    }

    public void setTimezone(String channelID, String timezone) {
        listWithNotificationChannels.get(channelID).setTimezone(timezone);
    }

    public void deleteNotificationChannel(String channelID) {
        listWithNotificationChannels.remove(channelID);
    }



    public void setListWithGuildInformation(Map<String, GuildInformation> listWithGuildInformation) {
        this.listWithGuildInformation = listWithGuildInformation;
    }

    public String getLanguage(String guildID) {
        String language;
        try {
            language = listWithGuildInformation.get(guildID).getLanguage();
        } catch (NullPointerException e) {
            language = "ENG";
        }
        return language;
    }

    public void setLanguage(String guildID, String language) {
        listWithGuildInformation.get(guildID).setLanguage(language);
    }

    public boolean doGuildExists(String guildID) {
        return listWithGuildInformation.containsKey(guildID);
    }

    public void addGuildInformation(GuildInformation guildInformation) {
        this.listWithGuildInformation.put(guildInformation.getGuildID(), guildInformation);
    }

    public void setHeadUpValue(String guildID, boolean headUpValue) {
        listWithGuildInformation.get(guildID).setHeadUpEnabled(headUpValue);
    }

    public boolean getHeadUpValue(String guildID) {
        return listWithGuildInformation.get(guildID).isHeadUpEnabled();
    }

}
