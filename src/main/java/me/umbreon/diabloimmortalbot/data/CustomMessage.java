package me.umbreon.diabloimmortalbot.data;

public class CustomMessage {

    private String channelID;
    private String guildID;
    private String message;
    private String day;
    private String time;

    public CustomMessage(String channelID, String guildID, String message, String day, String time) {
        this.channelID = channelID;
        this.guildID = guildID;
        this.message = message;
        this.day = day;
        this.time = time;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
