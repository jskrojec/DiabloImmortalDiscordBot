package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private String timezone;

    public GuildInformation(String guildID, String language, String timezone) {
        this.guildID = guildID;
        this.language = language;
        this.timezone = timezone;
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

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
