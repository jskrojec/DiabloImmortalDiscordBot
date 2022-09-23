package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.NotificationChannel;

import java.util.Map;

public class NotificationChannelsCache {

    public Map<String, NotificationChannel> notifierChannelsList;

    public boolean isChannelRegistered(String textChannelID) {
        return notifierChannelsList.containsKey(textChannelID);
    }

    public void setNotifierChannelsList(final Map<String, NotificationChannel> notifierChannelsList) {
        this.notifierChannelsList = notifierChannelsList;
    }

    public boolean isHeadUpMessageOnChannelEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isEventHeadUpEnabled();
    }

    public boolean isEventMessageOnChannelEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isEventMessageEnabled();
    }

    public boolean isAssemblyMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAssemblyMessageEnabled();
    }

    public boolean isRaidVaultMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isRaidVaultMessageEnabled();
    }

    public boolean isDemonGatesMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isDemonGatesMessageEnabled();
    }

    public boolean isDefendVaultMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isDefendVaultMessageEnabled();
    }

    public boolean isAncientArenaMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientArenaMessageEnabled();
    }

    public boolean isShadowLotteryMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isShadowLotteryMessageEnabled();
    }

    public boolean isBattlegroundMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isBattlegroundsMessageEnabled();
    }

    public boolean isHauntedCarriageMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isHauntedCarriageMessageEnabled();
    }

    public boolean isAncientNightmareMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientNightmareMessageEnabled();
    }

    public boolean isWrathborneInvasionEnabled(final String textChannelID) {
        return notifierChannelsList.get(textChannelID).isWrathborneInvasionEnabled();
    }

    public boolean isDemonGatesEmbedMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isDemonGatesMessageEmbedEnabled();
    }

    public boolean isAncientArenaEmbedMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientArenaMessageEmbedEnabled();
    }

    public boolean isHauntedCarriageEmbedMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isHauntedCarriageMessageEmbedEnabled();
    }

    public boolean isAncientNightmareEmbedMessageEnabled(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientNightmareMessageEmbedEnabled();
    }

    public String getRoleID(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).getRoleID();
    }

    public Map<String, NotificationChannel> getListWithNotifierChannels() {
        return notifierChannelsList;
    }

    public String getGuildIdByChannelID(final String textchannelID) {
        return notifierChannelsList.get(textchannelID).getGuildID();
    }

    public void addNotifierChannelToList(final NotificationChannel notificationChannel) {
        notifierChannelsList.put(notificationChannel.getTextChannelID(), notificationChannel);
    }

    public void setRoleID(final String textChannelID, final String roleID) {
        notifierChannelsList.get(textChannelID).setRoleID(roleID);
    }

    public void removeNotifierChannelFromList(final String textChannelID) {
        notifierChannelsList.remove(textChannelID);
    }

    public void setNotificationsValue(final String event, final boolean value, final String textChannelID) {
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

    public boolean doNotifierChannelExists(final String textChannelID) {
        return notifierChannelsList.containsKey(textChannelID);
    }

    public int getNotificationChannelsAmount() {
        return notifierChannelsList.size();
    }

}
