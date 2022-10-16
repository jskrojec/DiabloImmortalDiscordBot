package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private String timezone;
    private boolean isHeadUpEnabled;
    private boolean eventMessageEnabled;

    /**
     * Register a new guild.
     *
     * @param guildID
     */
    public GuildInformation(String guildID) {
        this.guildID = guildID;
        this.language = "ENG";
        this.timezone = "GMT";
        this.isHeadUpEnabled = true;
        this.eventMessageEnabled = true;
    }

    /**
     * Load a guild from database.
     *
     * @param guildID
     * @param language
     * @param timezone
     * @param isHeadUpEnabled
     * @param eventMessageEnabled
     */
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

}
