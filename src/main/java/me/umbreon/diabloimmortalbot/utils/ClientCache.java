package me.umbreon.diabloimmortalbot.utils;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ClientCache {

    // NOTIFICATIONS CHANNELS CACHE

    private Map<String, NotificationChannel> listWithNotificationChannels;

    public void setListWithNotificationChannels(Map<String, NotificationChannel> listWithNotificationChannels) {
        this.listWithNotificationChannels = listWithNotificationChannels;
    }

    public Map<String, NotificationChannel> getListWithNotificationChannels() {
        return listWithNotificationChannels;
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

    public void createNewNotificationChannelEntry(NotificationChannel notificationChannel) {
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

    // GUILDS CACHE

    private Map<String, GuildInformation> listWithGuildInformation;

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

    public boolean getHeadUpValue(String guildID) {
        return listWithGuildInformation.get(guildID).isHeadUpEnabled();
    }

    public boolean isEventMessageEnabled(String guildID) {
        return listWithGuildInformation.get(guildID).isEventMessageEnabled();
    }

    public boolean isBattlegroundsNotificationsEnabled(String guildID) {
        return listWithGuildInformation.get(guildID).isBattlegroundsNotificationsEnabled();
    }

    public void setEventValue(String event, String guildID, boolean value) {
        switch (event.toLowerCase()) {
            case "battlegrounds":
                listWithGuildInformation.get(guildID).setBattlegroundsNotificationsEnabled(value);
                break;
            case "message":
                listWithGuildInformation.get(guildID).setEventMessageEnabled(value);
                break;
            case "headup":
                listWithGuildInformation.get(guildID).setHeadUpEnabled(value);
                break;
        }
    }

    // CUSTOM MESSAGES CACHE

    public Map<Integer, CustomMessage> customMessagesList;

    public void setCustomMessagesList(Map<Integer, CustomMessage> customMessagesList) {
        this.customMessagesList = customMessagesList;
    }

    public void deleteCustomMessageByID(int customMessageID) {
        customMessagesList.forEach((key, customMessage) -> {
            if (customMessage.getCustomMessageID() == customMessageID) {
                customMessagesList.remove(key);
            }
        });
    }

    public List<CustomMessage> getAllCustomMessagesByGuildID(String guildID) {
        List<CustomMessage> guildCustomMessagesList = new ArrayList<>();
        this.customMessagesList.forEach((key, customMessage) -> {
            if (customMessage.getGuildID().equalsIgnoreCase(guildID)) {
                guildCustomMessagesList.add(customMessage);
            }
        });

        return guildCustomMessagesList;
    }

    public Collection<CustomMessage> getAllCustomMessages() {
        return this.customMessagesList.values();
    }

    public CustomMessage getCustomMessageByID(int customMessageID) {
        return customMessagesList.get(customMessageID);
    }

    public void addCustomMessageToList(CustomMessage customMessage) {
        this.customMessagesList.put(customMessage.getCustomMessageID(), customMessage);
    }

}
