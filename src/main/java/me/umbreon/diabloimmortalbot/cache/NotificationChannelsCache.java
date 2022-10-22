package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.NotificationChannel;

import java.util.Map;

/**
 * @author Umbreon Majora
 * <p>
 * System cache for notification channels.
 */
public class NotificationChannelsCache {

    public Map<String, NotificationChannel> notifierChannelsList;

    public boolean isChannelRegistered(String textChannelID) {
        return notifierChannelsList.containsKey(textChannelID);
    }

    public void setNotifierChannelsList(Map<String, NotificationChannel> notifierChannelsList) {
        this.notifierChannelsList = notifierChannelsList;
    }

    public boolean isHeadUpMessageOnChannelEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isEventHeadUpEnabled();
    }

    public boolean isEventMessageOnChannelEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isEventMessageEnabled();
    }

    public boolean isAssemblyMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isAssemblyMessageEnabled();
    }

    public boolean isRaidVaultMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isRaidVaultMessageEnabled();
    }

    public boolean isDemonGatesMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isDemonGatesMessageEnabled();
    }

    public boolean isDefendVaultMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isDefendVaultMessageEnabled();
    }

    public boolean isAncientArenaMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isAncientArenaMessageEnabled();
    }

    public boolean isShadowLotteryMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isShadowLotteryMessageEnabled();
    }

    public boolean isBattlegroundMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isBattlegroundsMessageEnabled();
    }

    public boolean isHauntedCarriageMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isHauntedCarriageMessageEnabled();
    }

    public boolean isAncientNightmareMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isAncientNightmareMessageEnabled();
    }

    public boolean isWrathborneInvasionEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isWrathborneInvasionEnabled();
    }

    public boolean isDemonGatesEmbedMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isDemonGatesMessageEmbedEnabled();
    }

    public boolean isAncientArenaEmbedMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isAncientArenaMessageEmbedEnabled();
    }

    public boolean isHauntedCarriageEmbedMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isHauntedCarriageMessageEmbedEnabled();
    }

    public boolean isAncientNightmareEmbedMessageEnabled(String textChannelID) {
        return notifierChannelsList.get(textChannelID).isAncientNightmareMessageEmbedEnabled();
    }

    public String getRoleIdByChannelId(String textChannelID) {
        return notifierChannelsList.get(textChannelID).getRoleID();
    }

    public Map<String, NotificationChannel> getListWithNotifierChannels() {
        return notifierChannelsList;
    }

    public String getGuildIdByChannelID(String textChannelID) {
        return notifierChannelsList.get(textChannelID).getGuildID();
    }

    public void addNotifierChannelToList(NotificationChannel notificationChannel) {
        notifierChannelsList.put(notificationChannel.getTextChannelID(), notificationChannel);
    }

    public void setRoleID(String textChannelID, String roleID) {
        notifierChannelsList.get(textChannelID).setRoleID(roleID);
    }

    public void removeNotifierChannelFromList(String textChannelID) {
        notifierChannelsList.remove(textChannelID);
    }

    public void setNotificationsValue(String event, boolean value, String textChannelID) {
        switch (event) {
            case "message":
                notifierChannelsList.get(textChannelID).setEventMessageEnabled(value);
                break;
            case "headup":
                notifierChannelsList.get(textChannelID).setEventHeadUpEnabled(value);
                break;
            case "ancientarena":
                notifierChannelsList.get(textChannelID).setAncientArenaMessageEnabled(value);
                break;
            case "ancientnightmare":
                notifierChannelsList.get(textChannelID).setAncientNightmareMessageEnabled(value);
                break;
            case "assembly":
                notifierChannelsList.get(textChannelID).setAssemblyMessageEnabled(value);
                break;
            case "battlegrounds":
                notifierChannelsList.get(textChannelID).setBattlegroundsMessageEnabled(value);
                break;
            case "defendvault":
                notifierChannelsList.get(textChannelID).setDefendVaultMessageEnabled(value);
                break;
            case "raidvault":
                notifierChannelsList.get(textChannelID).setRaidVaultMessageEnabled(value);
                break;
            case "demongates":
                notifierChannelsList.get(textChannelID).setDemonGatesMessageEnabled(value);
                break;
            case "shadowlottery":
                notifierChannelsList.get(textChannelID).setShadowLotteryMessageEnabled(value);
                break;
            case "hauntedcarriage":
                notifierChannelsList.get(textChannelID).setHauntedCarriageMessageEnabled(value);
                break;
            case "hauntedcarriageembed":
                notifierChannelsList.get(textChannelID).setHauntedCarriageMessageEmbedEnabled(value);
                break;
            case "demongatesembed":
                notifierChannelsList.get(textChannelID).setDemonGatesMessageEmbedEnabled(value);
                break;
            case "ancientnightmareembed":
                notifierChannelsList.get(textChannelID).setAncientNightmareMessageEmbedEnabled(value);
                break;
            case "ancientarenaembed":
                notifierChannelsList.get(textChannelID).setAncientArenaMessageEmbedEnabled(value);
                break;
            case "wrathborneinvasion":
                notifierChannelsList.get(textChannelID).setWrathborneInvasionEnabled(value);
        }
    }

    public boolean doNotifierChannelExists(String textChannelID) {
        return notifierChannelsList.containsKey(textChannelID);
    }

    public int getNotificationChannelsAmount() {
        return notifierChannelsList.size();
    }

    public NotificationChannel getNotificationChannelByChannelID(String textChannelID) {
        return notifierChannelsList.get(textChannelID);
    }

    public void replaceNotificationChannel(NotificationChannel notificationChannel) {
        String textChannelID = notificationChannel.getTextChannelID();
        removeNotifierChannelFromList(textChannelID);
        addNotifierChannelToList(notificationChannel);
    }

}
