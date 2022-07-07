package me.umbreon.diabloimmortalbot.data;

public class NotificationData {

    public String channelId;
    public String timezone;
    public int status;
    public String role;

    public NotificationData(String channelId, String timezone, int status, String role) {
        this.channelId = channelId;
        this.timezone = timezone;
        this.status = status;
        this.role = role;
    }

    public String getTimezone() {
        return timezone;
    }

    public int getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }
}
