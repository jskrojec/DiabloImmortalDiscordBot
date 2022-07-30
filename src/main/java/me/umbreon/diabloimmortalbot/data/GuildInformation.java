package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private boolean isHeadUpEnabled;
    private boolean battlegroundsNotificationsEnabled;
    private boolean eventMessageEnabled;

    public GuildInformation(String guildID, String language, boolean isHeadUpEnabled, boolean battlegroundsNotificationsEnabled, boolean eventMessageEnabled) {
        this.guildID = guildID;
        this.language = language;
        this.isHeadUpEnabled = isHeadUpEnabled;
        this.battlegroundsNotificationsEnabled = battlegroundsNotificationsEnabled;
        this.eventMessageEnabled = eventMessageEnabled;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHeadUpEnabled() {
        return isHeadUpEnabled;
    }

    public void setHeadUpEnabled(boolean headUpEnabled) {
        isHeadUpEnabled = headUpEnabled;
    }

    public boolean isBattlegroundsNotificationsEnabled() {
        return battlegroundsNotificationsEnabled;
    }

    public void setBattlegroundsNotificationsEnabled(boolean battlegroundsNotificationsEnabled) {
        this.battlegroundsNotificationsEnabled = battlegroundsNotificationsEnabled;
    }

    public boolean isEventMessageEnabled() {
        return eventMessageEnabled;
    }

    public void setEventMessageEnabled(boolean eventMessageEnabled) {
        this.eventMessageEnabled = eventMessageEnabled;
    }
}
