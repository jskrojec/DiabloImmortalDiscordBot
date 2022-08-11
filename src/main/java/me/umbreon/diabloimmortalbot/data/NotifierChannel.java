package me.umbreon.diabloimmortalbot.data;

import java.util.Objects;

public class NotifierChannel {

    String roleID;
    String guildID;
    String textChannelID;

    boolean eventHeadUpEnabled;
    boolean eventMessageEnabled;
    boolean assemblyMessageEnabled;
    boolean raidVaultMessageEnabled;
    boolean demonGatesMessageEnabled;
    boolean defendVaultMessageEnabled;
    boolean ancientArenaMessageEnabled;
    boolean shadowLotteryMessageEnabled;
    boolean battlegroundsMessageEnabled;
    boolean hauntedCarriageMessageEnabled;
    boolean ancientNightmareMessageEnabled;

    boolean demonGatesMessageEmbedEnabled;
    boolean ancientArenaMessageEmbedEnabled;
    boolean hauntedCarriageMessageEmbedEnabled;
    boolean ancientNightmareMessageEmbedEnabled;

    public NotifierChannel(String textChannelID, String guildID) {
        this.eventHeadUpEnabled = true;
        this.eventMessageEnabled = true;
        this.assemblyMessageEnabled = true;
        this.raidVaultMessageEnabled = true;
        this.demonGatesMessageEnabled = true;
        this.defendVaultMessageEnabled = false;
        this.ancientArenaMessageEnabled = true;
        this.shadowLotteryMessageEnabled = true;
        this.battlegroundsMessageEnabled = true;
        this.hauntedCarriageMessageEnabled = true;
        this.ancientNightmareMessageEnabled = true;

        this.demonGatesMessageEmbedEnabled = true;
        this.ancientArenaMessageEmbedEnabled = true;
        this.hauntedCarriageMessageEmbedEnabled = true;
        this.ancientNightmareMessageEmbedEnabled = true;

        this.roleID = "EVERYONE";
        this.guildID = guildID;
        this.textChannelID = textChannelID;
    }

    public NotifierChannel(String roleID, String guildID, String textChannelID,
                           boolean eventHeadUpEnabled, boolean eventMessageEnabled, boolean assemblyMessageEnabled,
                           boolean raidVaultMessageEnabled, boolean demonGatesMessageEnabled,
                           boolean defendVaultMessageEnabled, boolean ancientArenaMessageEnabled,
                           boolean shadowLotteryMessageEnabled, boolean battlegroundsMessageEnabled,
                           boolean hauntedCarriageMessageEnabled, boolean ancientNightmareMessageEnabled,
                           boolean demonGatesMessageEmbedEnabled, boolean ancientArenaMessageEmbedEnabled,
                           boolean hauntedCarriageMessageEmbedEnabled, boolean ancientNightmareMessageEmbedEnabled) {
        this.roleID = roleID;
        this.guildID = guildID;
        this.textChannelID = textChannelID;
        this.eventHeadUpEnabled = eventHeadUpEnabled;
        this.eventMessageEnabled = eventMessageEnabled;
        this.assemblyMessageEnabled = assemblyMessageEnabled;
        this.raidVaultMessageEnabled = raidVaultMessageEnabled;
        this.demonGatesMessageEnabled = demonGatesMessageEnabled;
        this.defendVaultMessageEnabled = defendVaultMessageEnabled;
        this.ancientArenaMessageEnabled = ancientArenaMessageEnabled;
        this.shadowLotteryMessageEnabled = shadowLotteryMessageEnabled;
        this.battlegroundsMessageEnabled = battlegroundsMessageEnabled;
        this.hauntedCarriageMessageEnabled = hauntedCarriageMessageEnabled;
        this.ancientNightmareMessageEnabled = ancientNightmareMessageEnabled;
        this.demonGatesMessageEmbedEnabled = demonGatesMessageEmbedEnabled;
        this.ancientArenaMessageEmbedEnabled = ancientArenaMessageEmbedEnabled;
        this.hauntedCarriageMessageEmbedEnabled = hauntedCarriageMessageEmbedEnabled;
        this.ancientNightmareMessageEmbedEnabled = ancientNightmareMessageEmbedEnabled;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getTextChannelID() {
        return textChannelID;
    }

    public void setTextChannelID(String textChannelID) {
        this.textChannelID = textChannelID;
    }

    public boolean isEventHeadUpEnabled() {
        return eventHeadUpEnabled;
    }

    public void setEventHeadUpEnabled(boolean eventHeadUpEnabled) {
        this.eventHeadUpEnabled = eventHeadUpEnabled;
    }

    public boolean isEventMessageEnabled() {
        return eventMessageEnabled;
    }

    public void setEventMessageEnabled(boolean eventMessageEnabled) {
        this.eventMessageEnabled = eventMessageEnabled;
    }

    public boolean isAssemblyMessageEnabled() {
        return assemblyMessageEnabled;
    }

    public void setAssemblyMessageEnabled(boolean assemblyMessageEnabled) {
        this.assemblyMessageEnabled = assemblyMessageEnabled;
    }

    public boolean isRaidVaultMessageEnabled() {
        return raidVaultMessageEnabled;
    }

    public void setRaidVaultMessageEnabled(boolean raidVaultMessageEnabled) {
        this.raidVaultMessageEnabled = raidVaultMessageEnabled;
    }

    public boolean isDemonGatesMessageEnabled() {
        return demonGatesMessageEnabled;
    }

    public void setDemonGatesMessageEnabled(boolean demonGatesMessageEnabled) {
        this.demonGatesMessageEnabled = demonGatesMessageEnabled;
    }

    public boolean isDefendVaultMessageEnabled() {
        return defendVaultMessageEnabled;
    }

    public void setDefendVaultMessageEnabled(boolean defendVaultMessageEnabled) {
        this.defendVaultMessageEnabled = defendVaultMessageEnabled;
    }

    public boolean isAncientArenaMessageEnabled() {
        return ancientArenaMessageEnabled;
    }

    public void setAncientArenaMessageEnabled(boolean ancientArenaMessageEnabled) {
        this.ancientArenaMessageEnabled = ancientArenaMessageEnabled;
    }

    public boolean isShadowLotteryMessageEnabled() {
        return shadowLotteryMessageEnabled;
    }

    public void setShadowLotteryMessageEnabled(boolean shadowLotteryMessageEnabled) {
        this.shadowLotteryMessageEnabled = shadowLotteryMessageEnabled;
    }

    public boolean isBattlegroundsMessageEnabled() {
        return battlegroundsMessageEnabled;
    }

    public void setBattlegroundsMessageEnabled(boolean battlegroundsMessageEnabled) {
        this.battlegroundsMessageEnabled = battlegroundsMessageEnabled;
    }

    public boolean isHauntedCarriageMessageEnabled() {
        return hauntedCarriageMessageEnabled;
    }

    public void setHauntedCarriageMessageEnabled(boolean hauntedCarriageMessageEnabled) {
        this.hauntedCarriageMessageEnabled = hauntedCarriageMessageEnabled;
    }

    public boolean isAncientNightmareMessageEnabled() {
        return ancientNightmareMessageEnabled;
    }

    public void setAncientNightmareMessageEnabled(boolean ancientNightmareMessageEnabled) {
        this.ancientNightmareMessageEnabled = ancientNightmareMessageEnabled;
    }

    public boolean isDemonGatesMessageEmbedEnabled() {
        return demonGatesMessageEmbedEnabled;
    }

    public void setDemonGatesMessageEmbedEnabled(boolean demonGatesMessageEmbedEnabled) {
        this.demonGatesMessageEmbedEnabled = demonGatesMessageEmbedEnabled;
    }

    public boolean isAncientArenaMessageEmbedEnabled() {
        return ancientArenaMessageEmbedEnabled;
    }

    public void setAncientArenaMessageEmbedEnabled(boolean ancientArenaMessageEmbedEnabled) {
        this.ancientArenaMessageEmbedEnabled = ancientArenaMessageEmbedEnabled;
    }

    public boolean isHauntedCarriageMessageEmbedEnabled() {
        return hauntedCarriageMessageEmbedEnabled;
    }

    public void setHauntedCarriageMessageEmbedEnabled(boolean hauntedCarriageMessageEmbedEnabled) {
        this.hauntedCarriageMessageEmbedEnabled = hauntedCarriageMessageEmbedEnabled;
    }

    public boolean isAncientNightmareMessageEmbedEnabled() {
        return ancientNightmareMessageEmbedEnabled;
    }

    public void setAncientNightmareMessageEmbedEnabled(boolean ancientNightmareMessageEmbedEnabled) {
        this.ancientNightmareMessageEmbedEnabled = ancientNightmareMessageEmbedEnabled;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }
}
