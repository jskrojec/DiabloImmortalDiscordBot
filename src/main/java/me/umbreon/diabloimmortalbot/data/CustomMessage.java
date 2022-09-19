package me.umbreon.diabloimmortalbot.data;

public class CustomMessage {

    private String channelID;
    private String guildID;
    private String message;
    private String day;
    private String time;
    private int customMessageID;
    private boolean repeat;

    public CustomMessage(final String channelID, final String guildID, final String message, final String day, final String time, final int customMessageID, final boolean repeat) {
        this.channelID = channelID;
        this.guildID = guildID;
        this.message = message;
        this.day = day;
        this.time = time;
        this.customMessageID = customMessageID;
        this.repeat = repeat;
    }

    public CustomMessage(final String channelID, final String guildID, final String message, final String day, final String time, final boolean repeat) {
        this.channelID = channelID;
        this.guildID = guildID;
        this.message = message;
        this.day = day;
        this.time = time;
        this.repeat = repeat;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(final String channelID) {
        this.channelID = channelID;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(final String guildID) {
        this.guildID = guildID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDay() {
        return day;
    }

    public void setDay(final String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(final String time) {
        this.time = time;
    }

    public int getCustomMessageID() {
        return customMessageID;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeating(final boolean repeat) {
        this.repeat = repeat;
    }
}
