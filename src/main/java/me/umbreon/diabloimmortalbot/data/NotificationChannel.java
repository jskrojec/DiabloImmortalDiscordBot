package me.umbreon.diabloimmortalbot.data;

public class NotificationChannel {

    public String channelId;
    public String timezone;
    public int status;
    public String role;
    public boolean inDebugMode;

    public NotificationChannel(String channelId, String timezone, int status, String role, boolean inDebugMode) {
        this.channelId = channelId;
        this.timezone = timezone;
        this.status = status;
        this.role = role;
        this.inDebugMode = inDebugMode;
    }

    public NotificationChannel(String channelId) {
        this.channelId = channelId;
        this.timezone = "GMT";
        this.status = 0;
        this.role = null;
        this.inDebugMode = false;
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

    public boolean isInDebugMode() {
        return inDebugMode;
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

    public void setInDebugMode(boolean inDebugMode) {
        this.inDebugMode = inDebugMode;
    }
}
