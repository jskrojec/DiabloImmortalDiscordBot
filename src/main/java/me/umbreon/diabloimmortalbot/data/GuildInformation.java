package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private String timezone;
    private boolean isHeadUpEnabled;
    private boolean eventMessageEnabled;
    private boolean autoDeleteEnabled;
    private int autoDeleteValue;

    public GuildInformation(final String guildID) {
        this.guildID = guildID;
        this.language = "ENG";
        this.timezone = "GMT";
        this.isHeadUpEnabled = true;
        this.eventMessageEnabled = true;
        this.autoDeleteEnabled = false;
        this.autoDeleteValue = 24;
    }

    public GuildInformation(final String guildID, final String language, final String timezone, final boolean isHeadUpEnabled, final boolean eventMessageEnabled, final boolean autoDeleteEnabled, final int autoDeleteValue) {
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

    public void setGuildID(final String guildID) {
        this.guildID = guildID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public boolean isHeadUpEnabled() {
        return isHeadUpEnabled;
    }

    public void setHeadUpEnabled(final boolean headUpEnabled) {
        isHeadUpEnabled = headUpEnabled;
    }

    public boolean isEventMessageEnabled() {
        return eventMessageEnabled;
    }

    public void setEventMessageEnabled(final boolean eventMessageEnabled) {
        this.eventMessageEnabled = eventMessageEnabled;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(final String timezone) {
        this.timezone = timezone;
    }

    public boolean isAutoDeleteEnabled() {
        return autoDeleteEnabled;
    }

    public void setAutoDeleteEnabled(final boolean autoDeleteEnabled) {
        this.autoDeleteEnabled = autoDeleteEnabled;
    }

    public int getAutoDeleteValue() {
        return autoDeleteValue;
    }

    public void setAutoDeleteValue(final int autoDeleteValue) {
        this.autoDeleteValue = autoDeleteValue;
    }
}
