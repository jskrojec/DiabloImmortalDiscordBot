package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private String timezone;
    private boolean isHeadUpEnabled;
    private boolean eventMessageEnabled;
    private boolean autoDeleteEnabled;
    private int autoDeleteValue;

    public GuildInformation(String guildID) {
        this.guildID = guildID;
        this.language = "ENG";
        this.timezone = "GMT";
        this.isHeadUpEnabled = true;
        this.eventMessageEnabled = true;
        this.autoDeleteEnabled = false;
        this.autoDeleteValue = 24;
    }

    public GuildInformation(String guildID, String language, String timezone, boolean isHeadUpEnabled, boolean eventMessageEnabled, boolean autoDeleteEnabled, int autoDeleteValue) {
        this.guildID = guildID;
        this.language = language;
        this.timezone = timezone;
        this.isHeadUpEnabled = isHeadUpEnabled;
        this.eventMessageEnabled = eventMessageEnabled;
        this.autoDeleteEnabled = autoDeleteEnabled;
        this.autoDeleteValue = autoDeleteValue;
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

    public boolean isAutoDeleteEnabled() {
        return autoDeleteEnabled;
    }

    public void setAutoDeleteEnabled(boolean autoDeleteEnabled) {
        this.autoDeleteEnabled = autoDeleteEnabled;
    }

    public int getAutoDeleteValue() {
        return autoDeleteValue;
    }

    public void setAutoDeleteValue(int autoDeleteValue) {
        this.autoDeleteValue = autoDeleteValue;
    }
}
