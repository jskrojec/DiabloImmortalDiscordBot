package me.umbreon.diabloimmortalbot.utils;

import me.umbreon.diabloimmortalbot.data.NotificationChannel;

import java.util.Map;

public class ClientCache {

    private Map<String, NotificationChannel> listWithNotificationChannels;

    public Map<String, NotificationChannel> getListWithNotificationChannels() {
        return listWithNotificationChannels;
    }

    public void setListWithNotificationChannels(Map<String, NotificationChannel> listWithNotificationChannels) {
        this.listWithNotificationChannels = listWithNotificationChannels;
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

    public boolean isChannelInDebugMode(String channelId) {
        return listWithNotificationChannels.get(channelId).isInDebugMode();
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

    public void setDebugValue(String channelID, boolean debugValue) {
        listWithNotificationChannels.get(channelID).setInDebugMode(debugValue);
    }

}
