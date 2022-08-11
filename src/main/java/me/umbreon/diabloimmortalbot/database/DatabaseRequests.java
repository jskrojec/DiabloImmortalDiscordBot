package me.umbreon.diabloimmortalbot.database;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotifierChannel;
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

    // Guilds

    public void createNewGuildEntry(GuildInformation guildInformation) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO guilds (guildID, language, timezone, event_headup, event_message) VALUES (?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, guildInformation.getGuildID());
                preparedStatement.setString(2, guildInformation.getLanguage());
                preparedStatement.setString(3, guildInformation.getTimezone());
                preparedStatement.setBoolean(4, guildInformation.isHeadUpEnabled());
                preparedStatement.setBoolean(5, guildInformation.isEventMessageEnabled());
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

    public void setGuildTimezone(String guildID, String timezone) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET timezone = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setString(1, timezone);
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
                    String timezone = resultSet.getString("timezone");
                    boolean isHeadUpEnabled = (resultSet.getInt("event_headup") == 1);
                    boolean eventMessagesEnabled = (resultSet.getInt("event_message") == 1);
                    GuildInformation guildInformation = new GuildInformation(guildID, language, timezone, isHeadUpEnabled, eventMessagesEnabled);
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

    public void setEventHeadUpOnServerValue(boolean enabled, String guildID) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET event_headup = ? WHERE guildID = ?")) {
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

    public void setEventMessageOnServerValue(boolean enabled, String guildID) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET event_message = ? WHERE guildID = ?")) {
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


    //NOTIFIER CHANNELS

    public void updateNotifierChannelEventMessage(String eventMessage, String textChannelID, boolean value) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET " + eventMessage + " = ? WHERE textChannelID = ?")) {
            try {
                preparedStatement.setBoolean(1, value);
                preparedStatement.setString(2, textChannelID);
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

    public void deleteNotifierChannelEntry(String textChannelID) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM channel_notification WHERE textChannelID = ?")) {
            try {
                preparedStatement.setString(1, textChannelID);
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

    public void updateNotifierChannelRole(String textChannelID, String roleID) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET roleID = ? WHERE textChannelID = ?")) {
            try {
                preparedStatement.setString(1, roleID);
                preparedStatement.setString(2, textChannelID);
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

    public void createNewNotifierChannel(NotifierChannel notifierChannel) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO channel_notification (textChannelID, guildID, roleID, message, headUp, ancientarena, ancientnightmare, assembly, battlegrounds, defendvault, raidvault, demongates, shadowlottery, hauntedcarriage, demongatesembed, ancientarenaembed, hauntedcarriageembed, ancientnightmareembed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, notifierChannel.getTextChannelID());
                preparedStatement.setString(2, notifierChannel.getGuildID());
                preparedStatement.setString(3, notifierChannel.getRoleID());
                preparedStatement.setBoolean(4, notifierChannel.isEventMessageEnabled());
                preparedStatement.setBoolean(5, notifierChannel.isEventHeadUpEnabled());
                preparedStatement.setBoolean(6, notifierChannel.isAncientArenaMessageEnabled());
                preparedStatement.setBoolean(7, notifierChannel.isAncientNightmareMessageEnabled());
                preparedStatement.setBoolean(8, notifierChannel.isAssemblyMessageEnabled());
                preparedStatement.setBoolean(9, notifierChannel.isBattlegroundsMessageEnabled());
                preparedStatement.setBoolean(10, notifierChannel.isDefendVaultMessageEnabled());
                preparedStatement.setBoolean(11, notifierChannel.isRaidVaultMessageEnabled());
                preparedStatement.setBoolean(12, notifierChannel.isDemonGatesMessageEnabled());
                preparedStatement.setBoolean(13, notifierChannel.isShadowLotteryMessageEnabled());
                preparedStatement.setBoolean(14, notifierChannel.isHauntedCarriageMessageEnabled());
                preparedStatement.setBoolean(15, notifierChannel.isDemonGatesMessageEmbedEnabled());
                preparedStatement.setBoolean(16, notifierChannel.isAncientArenaMessageEmbedEnabled());
                preparedStatement.setBoolean(17, notifierChannel.isHauntedCarriageMessageEmbedEnabled());
                preparedStatement.setBoolean(18, notifierChannel.isAncientNightmareMessageEmbedEnabled());
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

    public Map<String, NotifierChannel> getAllNotifierChannels() {
        Map<String, NotifierChannel> notifierChannelList = new ConcurrentHashMap<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM channel_notification")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    String textChannelID = resultSet.getString("textChannelID");
                    String guildID = resultSet.getString("guildID");
                    String roleID = resultSet.getString("roleID");

                    boolean message = (resultSet.getInt("message") == 1);
                    boolean headup = (resultSet.getInt("headUp") == 1);
                    boolean ancientarena = (resultSet.getInt("ancientarena") == 1);
                    boolean ancientnightmare = (resultSet.getInt("ancientnightmare") == 1);
                    boolean assembly = (resultSet.getInt("assembly") == 1);
                    boolean battlegrounds = (resultSet.getInt("battlegrounds") == 1);
                    boolean defendvault = (resultSet.getInt("defendvault") == 1);
                    boolean raidvault = (resultSet.getInt("raidvault") == 1);
                    boolean demongates = (resultSet.getInt("demongates") == 1);
                    boolean shadowlottery = (resultSet.getInt("shadowlottery") == 1);
                    boolean hauntedcarriage = (resultSet.getInt("hauntedcarriage") == 1);
                    boolean hauntedcarriageembed = (resultSet.getInt("hauntedcarriageembed") == 1);
                    boolean demongatesembed = (resultSet.getInt("demongatesembed") == 1);
                    boolean ancientnightmareembed = (resultSet.getInt("ancientnightmareembed") == 1);
                    boolean ancientarenaembed = (resultSet.getInt("ancientarenaembed") == 1);

                    NotifierChannel notificationChannel = new NotifierChannel(roleID, guildID, textChannelID,
                            headup, message, assembly, raidvault, demongates, defendvault, ancientarena, shadowlottery,
                            battlegrounds, hauntedcarriage, ancientnightmare, demongatesembed, ancientarenaembed,
                            hauntedcarriageembed, ancientnightmareembed);

                    notifierChannelList.put(textChannelID, notificationChannel);
                }
            } catch (Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return notifierChannelList;
    }

}
