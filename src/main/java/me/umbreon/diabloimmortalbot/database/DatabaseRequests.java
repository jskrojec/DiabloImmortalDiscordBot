package me.umbreon.diabloimmortalbot.database;

import me.umbreon.diabloimmortalbot.data.NotificationChannel;
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

    public void createNewNotificationChannelEntry(NotificationChannel notificationChannel) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO channel_notification (channel, timezone, status, role, debug) VALUES (?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, notificationChannel.channelId);
                preparedStatement.setString(2, notificationChannel.timezone);
                preparedStatement.setInt(3, notificationChannel.status);
                preparedStatement.setString(4, notificationChannel.role);
                preparedStatement.setBoolean(5, notificationChannel.inDebugMode);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
        }
    }

    public Map<String, NotificationChannel> getAllNotificationChannels() {
        Map<String, NotificationChannel> listWithNotificationChannels = new ConcurrentHashMap<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM channel_notification")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String channelId = resultSet.getString("channel");
                    String timezone = resultSet.getString("timezone");
                    int status = resultSet.getInt("status");
                    String role = resultSet.getString("role");
                    int debugInt = resultSet.getInt("debug");
                    boolean debug = (debugInt == 1);
                    NotificationChannel notificationChannel = new NotificationChannel(channelId, timezone, status, role, debug);
                    listWithNotificationChannels.put(channelId, notificationChannel);
                }
            } catch (Exception e) {
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
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
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
        }
        return listEventTimeTables;
    }

    public void setTimezone(String messageId, String timezone) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET timezone = ? WHERE channel = ?")) {
            try {
                preparedStatement.setString(1, timezone);
                preparedStatement.setString(2, messageId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
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
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
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
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
        }
    }

    public void deleteNotificationChannelEntry(String channelid) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM channel_notification WHERE channel = ?")) {
            try {
                preparedStatement.setString(1, channelid);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
        }
    }

    public void setDebugModeValue(String messageId, boolean debugMode) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET debug = ? WHERE channel = ?")) {
            try {
                preparedStatement.setBoolean(1, debugMode);
                preparedStatement.setString(2, messageId);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
            ClientLogger.createNewLogEntry("sql-log", "MySQL-Statements", "Umbreon", preparedStatement.toString());
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
        }
    }
}
