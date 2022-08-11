package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private String timezone;
    private boolean isHeadUpEnabled;
    private boolean eventMessageEnabled;

    public GuildInformation(String guildID) {
        this.guildID = guildID;
        this.language = "ENG";
        this.timezone = "GMT";
        this.isHeadUpEnabled = true;
        this.eventMessageEnabled = true;
    }

    public GuildInformation(String guildID, String language, String timezone, boolean isHeadUpEnabled, boolean eventMessageEnabled) {
        this.guildID = guildID;
        this.language = language;
        this.timezone = timezone;
        this.isHeadUpEnabled = isHeadUpEnabled;
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

    public boolean isEventMessageEnabled() {
        return eventMessageEnabled;
    }

    public void setEventMessageEnabled(boolean eventMessageEnabled) {
        this.eventMessageEnabled = eventMessageEnabled;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
