package me.umbreon.diabloimmortalbot.database;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
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
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
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
                    NotificationChannel notificationChannel = new NotificationChannel(channelId, timezone, status, role);
                    listWithNotificationChannels.put(channelId, notificationChannel);
                }
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
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
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return listEventTimeTables;
    }

    public ArrayList<String> getOverworldEventTimes(String table) {
        ArrayList<String> listEventTimeTables = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String time = resultSet.getString("time");
                    String day = resultSet.getString("day");
                    String finalTime = day + " " + time;
                    listEventTimeTables.add(finalTime);
                }
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
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
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
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
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
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
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void deleteNotificationChannelEntry(String channelid) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM channel_notification WHERE channel = ?")) {
            try {
                preparedStatement.setString(1, channelid);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    // Guilds

    public void createNewGuildEntry(GuildInformation guildInformation) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO guilds (guildID, language, event_headup) VALUES (?, ?, ?)")) {
            try {
                preparedStatement.setString(1, guildInformation.getGuildID());
                preparedStatement.setString(2, guildInformation.getLanguage());
                preparedStatement.setBoolean(3, guildInformation.isHeadUpEnabled());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void setGuildLanguage(String guildID, String language) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET language = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setString(1, language);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public Map<String, GuildInformation> getAllGuilds() {
        Map<String, GuildInformation> listWithGuildInformation = new ConcurrentHashMap<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM guilds")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String guildID = resultSet.getString("guildID");
                    String language = resultSet.getString("language");
                    boolean isHeadUpEnabled = (resultSet.getInt("event_headup") == 1);
                    boolean battlegroundNotificationsEnabled = (resultSet.getInt("event_battlegrounds") == 1);
                    boolean eventMessagesEnabled = (resultSet.getInt("event_message") == 1);
                    GuildInformation guildInformation = new GuildInformation(guildID, language, isHeadUpEnabled, battlegroundNotificationsEnabled, eventMessagesEnabled);
                    listWithGuildInformation.put(guildID, guildInformation);
                }
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return listWithGuildInformation;
    }

    public void setEventValue(String event, boolean enabled, String guildID) {
        String finalEventString = "event_" + event;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET " + finalEventString + " = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setBoolean(1, enabled);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public Map<Integer, CustomMessage> getAllCustomMessages() {
        Map<Integer, CustomMessage> customMessagesList = new ConcurrentHashMap<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM custom_messages")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String guildID = resultSet.getString("guildID");
                    String channelID = resultSet.getString("channelID");
                    String message = resultSet.getString("message");
                    String day = resultSet.getString("day");
                    String time = resultSet.getString("time");
                    boolean repeat = (resultSet.getInt("message_repeat") == 1);
                    int id = resultSet.getInt("message_id");
                    CustomMessage customMessage = new CustomMessage(channelID, guildID, message, day, time, id, repeat);
                    customMessagesList.put(id, customMessage);
                }
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return customMessagesList;
    }

    public void deleteCustomMessageEntry(int customMessageID) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM custom_messages WHERE message_id = ?")) {
            try {
                preparedStatement.setInt(1, customMessageID);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void createNewCustomMessageEntry(CustomMessage customMessage) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO custom_messages " +
                     "(guildID, channelID, message, day, time, message_repeat) VALUES (?, ?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, customMessage.getGuildID());
                preparedStatement.setString(2, customMessage.getChannelID());
                preparedStatement.setString(3, customMessage.getMessage());
                preparedStatement.setString(4, customMessage.getDay());
                preparedStatement.setString(5, customMessage.getTime());
                preparedStatement.setBoolean(6, customMessage.isRepeat());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }
}
