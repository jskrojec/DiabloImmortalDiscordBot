package me.umbreon.diabloimmortalbot.data;

public class NotificationChannel {

    public String channelId;
    public String timezone;
    public int status;
    public String role;

    public NotificationChannel(String channelId, String timezone, int status, String role) {
        this.channelId = channelId;
        this.timezone = timezone;
        this.status = status;
        this.role = role;
    }

    public NotificationChannel(String channelId) {
        this.channelId = channelId;
        this.timezone = "GMT";
        this.status = 0;
        this.role = null;
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

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
