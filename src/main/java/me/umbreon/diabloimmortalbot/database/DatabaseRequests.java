package me.umbreon.diabloimmortalbot.database;

import me.umbreon.diabloimmortalbot.data.NotificationData;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseRequests {

    private final DatabaseConnection databaseConnection;

    public DatabaseRequests(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createNewNotificationChannelEntry(String channelId) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO channel_notification (channel, timezone, status, role) VALUES (?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, channelId);
                preparedStatement.setString(2, "PST");
                preparedStatement.setInt(3, 0);
                preparedStatement.setString(4, null);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
    }

    public boolean doNotificationChannelExists(String channelId) {
        boolean exists = false;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT channel FROM channel_notification WHERE channel = ?")) {
            preparedStatement.setString(1, channelId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    exists = true;
                }
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
        return exists;
    }

    public Map<String, NotificationData> getAllNotificationChannels() {
        Map<String, NotificationData> listWithNotificationChannels = new ConcurrentHashMap<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM channel_notification")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String channelId = resultSet.getString("channel");
                    String timezone = resultSet.getString("timezone");
                    int status = resultSet.getInt("status");
                    String role = resultSet.getString("role");
                    NotificationData notificationData = new NotificationData(channelId, timezone, status, role);
                    listWithNotificationChannels.put(channelId, notificationData);
                }
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
        return listWithNotificationChannels;
    }

    public Map<String, Boolean> getEventTimes(String table, boolean everyDay) {
        Map<String, Boolean> listEventTimeTables = new ConcurrentHashMap<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    boolean headup = resultSet.getBoolean("headup");
                    String time = resultSet.getString("time");
                    String day;
                    String finalTime;
                    if (!everyDay) {
                        day = resultSet.getString("day");
                        finalTime = day + " " + time;
                    } else {
                        finalTime = time;
                    }

                    listEventTimeTables.put(finalTime, headup);
                }
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
        return listEventTimeTables;
    }

    public String getWeeklyResetTime(String table) {
        String weeklyResetTime = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String time = resultSet.getString("time");
                    String day = resultSet.getString("day");
                    weeklyResetTime = day + " " + time;
                }
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
        return weeklyResetTime;
    }

    public void setTimezone(String messageId, String timezone) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET timezone = ? WHERE channel = ?")) {
            try {
                preparedStatement.setString(1, timezone);
                preparedStatement.setString(2, messageId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
    }

    public void setStatus(String messageId, int status) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET status = ? WHERE channel = ?")) {
            try {
                preparedStatement.setInt(1, status);
                preparedStatement.setString(2, messageId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
    }

    public void setRole(String messageId, String roleId) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET role = ? WHERE channel = ?")) {
            try {
                preparedStatement.setString(1, roleId);
                preparedStatement.setString(2, messageId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
    }

    public void deleteNotificationChannelEntry(String channelid) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM channel_notification WHERE channel = ?")) {
            try {
                preparedStatement.setString(1, channelid);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry(e.getMessage());
            }
            ClientLogger.createNewLogEntry(preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }
    }


}
