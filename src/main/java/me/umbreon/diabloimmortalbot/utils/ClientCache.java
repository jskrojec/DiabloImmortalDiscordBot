package me.umbreon.diabloimmortalbot.utils;

import me.umbreon.diabloimmortalbot.data.NotificationData;

import java.util.Map;

public class ClientCache {

    private Map<String, NotificationData> listWithNotificationChannels;

    public Map<String, NotificationData> getListWithNotificationChannels() {
        return listWithNotificationChannels;
    }

    public void setListWithNotificationChannels(Map<String, NotificationData> listWithNotificationChannels) {
        this.listWithNotificationChannels = listWithNotificationChannels;
    }

    public int getStatus(String channelId) {
        return listWithNotificationChannels.get(channelId).getStatus();
    }

    public String getTimezone(String channelId) {
        return listWithNotificationChannels.get(channelId).getTimezone();
    }

    public String getRoleId(String channelId) {
        return listWithNotificationChannels.get(channelId).getRole();
    }

}
