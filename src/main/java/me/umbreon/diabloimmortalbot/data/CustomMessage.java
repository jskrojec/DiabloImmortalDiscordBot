package me.umbreon.diabloimmortalbot.data;

public class CustomMessage {

    private final String channelID;
    private String guildID;
    private String message;
    private String weekday;
    private String time;
    private int customMessageID;
    private boolean repeating;

    public CustomMessage(String channelID, String guildID, String message, String weekday, String time, int customMessageID, boolean repeating) {
        this.channelID = channelID;
        this.guildID = guildID;
        this.message = message;
        this.weekday = weekday;
        this.time = time;
        this.customMessageID = customMessageID;
        this.repeating = repeating;
    }

    public CustomMessage(String channelID, String guildID, String message, String weekday, String time, boolean repeating) {
        this.channelID = channelID;
        this.guildID = guildID;
        this.message = message;
        this.weekday = weekday;
        this.time = time;
        this.repeating = repeating;
    }

    public String getChannelID() {
        return channelID;
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

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(final String weekday) {
        this.weekday = weekday;
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

    public boolean isRepeating() {
        return repeating;
    }

    public void setRepeating(final boolean repeat) {
        this.repeating = repeat;
    }
}
