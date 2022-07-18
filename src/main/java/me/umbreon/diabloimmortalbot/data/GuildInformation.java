package me.umbreon.diabloimmortalbot.data;

public class GuildInformation {

    private String guildID;
    private String language;
    private boolean isHeadUpEnabled;

    public GuildInformation(String guildID, String language, boolean isHeadUpEnabled) {
        this.guildID = guildID;
        this.language = language;
        this.isHeadUpEnabled = isHeadUpEnabled;
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
}
