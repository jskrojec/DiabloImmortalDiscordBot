package me.umbreon.diabloimmortalbot.data;

public class NotificationChannel {

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
    boolean wrathborneInvasionEnabled;

    boolean demonGatesMessageEmbedEnabled;
    boolean ancientArenaMessageEmbedEnabled;
    boolean hauntedCarriageMessageEmbedEnabled;
    boolean ancientNightmareMessageEmbedEnabled;

    public NotificationChannel(final String textChannelID, final String guildID) {
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
        this.wrathborneInvasionEnabled = true;

        this.demonGatesMessageEmbedEnabled = false;
        this.ancientArenaMessageEmbedEnabled = false;
        this.hauntedCarriageMessageEmbedEnabled = false;
        this.ancientNightmareMessageEmbedEnabled = false;

        this.roleID = "EVERYONE";
        this.guildID = guildID;
        this.textChannelID = textChannelID;
    }

    public NotificationChannel(final String roleID, final String guildID, final String textChannelID,
                               final boolean eventHeadUpEnabled, final boolean eventMessageEnabled, final boolean assemblyMessageEnabled,
                               final boolean raidVaultMessageEnabled, final boolean demonGatesMessageEnabled,
                               final boolean defendVaultMessageEnabled, final boolean ancientArenaMessageEnabled,
                               final boolean shadowLotteryMessageEnabled, final boolean battlegroundsMessageEnabled,
                               final boolean hauntedCarriageMessageEnabled, final boolean ancientNightmareMessageEnabled,
                               final boolean demonGatesMessageEmbedEnabled, final boolean ancientArenaMessageEmbedEnabled,
                               final boolean hauntedCarriageMessageEmbedEnabled, final boolean ancientNightmareMessageEmbedEnabled,
                               final boolean wrathborneInvasionEnabled) {
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
        this.wrathborneInvasionEnabled = wrathborneInvasionEnabled;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(final String roleID) {
        this.roleID = roleID;
    }

    public String getTextChannelID() {
        return textChannelID;
    }

    public void setTextChannelID(final String textChannelID) {
        this.textChannelID = textChannelID;
    }

    public boolean isEventHeadUpEnabled() {
        return eventHeadUpEnabled;
    }

    public void setEventHeadUpEnabled(final boolean eventHeadUpEnabled) {
        this.eventHeadUpEnabled = eventHeadUpEnabled;
    }

    public boolean isEventMessageEnabled() {
        return eventMessageEnabled;
    }

    public void setEventMessageEnabled(final boolean eventMessageEnabled) {
        this.eventMessageEnabled = eventMessageEnabled;
    }

    public boolean isAssemblyMessageEnabled() {
        return assemblyMessageEnabled;
    }

    public void setAssemblyMessageEnabled(final boolean assemblyMessageEnabled) {
        this.assemblyMessageEnabled = assemblyMessageEnabled;
    }

    public boolean isRaidVaultMessageEnabled() {
        return raidVaultMessageEnabled;
    }

    public void setRaidVaultMessageEnabled(final boolean raidVaultMessageEnabled) {
        this.raidVaultMessageEnabled = raidVaultMessageEnabled;
    }

    public boolean isDemonGatesMessageEnabled() {
        return demonGatesMessageEnabled;
    }

    public void setDemonGatesMessageEnabled(final boolean demonGatesMessageEnabled) {
        this.demonGatesMessageEnabled = demonGatesMessageEnabled;
    }

    public boolean isDefendVaultMessageEnabled() {
        return defendVaultMessageEnabled;
    }

    public void setDefendVaultMessageEnabled(final boolean defendVaultMessageEnabled) {
        this.defendVaultMessageEnabled = defendVaultMessageEnabled;
    }

    public boolean isAncientArenaMessageEnabled() {
        return ancientArenaMessageEnabled;
    }

    public void setAncientArenaMessageEnabled(final boolean ancientArenaMessageEnabled) {
        this.ancientArenaMessageEnabled = ancientArenaMessageEnabled;
    }

    public boolean isShadowLotteryMessageEnabled() {
        return shadowLotteryMessageEnabled;
    }

    public void setShadowLotteryMessageEnabled(final boolean shadowLotteryMessageEnabled) {
        this.shadowLotteryMessageEnabled = shadowLotteryMessageEnabled;
    }

    public boolean isBattlegroundsMessageEnabled() {
        return battlegroundsMessageEnabled;
    }

    public void setBattlegroundsMessageEnabled(final boolean battlegroundsMessageEnabled) {
        this.battlegroundsMessageEnabled = battlegroundsMessageEnabled;
    }

    public boolean isHauntedCarriageMessageEnabled() {
        return hauntedCarriageMessageEnabled;
    }

    public void setHauntedCarriageMessageEnabled(final boolean hauntedCarriageMessageEnabled) {
        this.hauntedCarriageMessageEnabled = hauntedCarriageMessageEnabled;
    }

    public boolean isAncientNightmareMessageEnabled() {
        return ancientNightmareMessageEnabled;
    }

    public void setAncientNightmareMessageEnabled(final boolean ancientNightmareMessageEnabled) {
        this.ancientNightmareMessageEnabled = ancientNightmareMessageEnabled;
    }

    public boolean isDemonGatesMessageEmbedEnabled() {
        return demonGatesMessageEmbedEnabled;
    }

    public void setDemonGatesMessageEmbedEnabled(final boolean demonGatesMessageEmbedEnabled) {
        this.demonGatesMessageEmbedEnabled = demonGatesMessageEmbedEnabled;
    }

    public boolean isAncientArenaMessageEmbedEnabled() {
        return ancientArenaMessageEmbedEnabled;
    }

    public void setAncientArenaMessageEmbedEnabled(final boolean ancientArenaMessageEmbedEnabled) {
        this.ancientArenaMessageEmbedEnabled = ancientArenaMessageEmbedEnabled;
    }

    public boolean isHauntedCarriageMessageEmbedEnabled() {
        return hauntedCarriageMessageEmbedEnabled;
    }

    public void setHauntedCarriageMessageEmbedEnabled(final boolean hauntedCarriageMessageEmbedEnabled) {
        this.hauntedCarriageMessageEmbedEnabled = hauntedCarriageMessageEmbedEnabled;
    }

    public boolean isAncientNightmareMessageEmbedEnabled() {
        return ancientNightmareMessageEmbedEnabled;
    }

    public void setAncientNightmareMessageEmbedEnabled(final boolean ancientNightmareMessageEmbedEnabled) {
        this.ancientNightmareMessageEmbedEnabled = ancientNightmareMessageEmbedEnabled;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(final String guildID) {
        this.guildID = guildID;
    }

    public boolean isWrathborneInvasionEnabled() {
        return wrathborneInvasionEnabled;
    }

    public void setWrathborneInvasionEnabled(final boolean wrathborneInvasionEnabled) {
        this.wrathborneInvasionEnabled = wrathborneInvasionEnabled;
    }
}
