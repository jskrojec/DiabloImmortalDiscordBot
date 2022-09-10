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

    public DatabaseRequests(final DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public Map<String, Boolean> getEventTimes(final String table, final boolean everyDay) {
        final Map<String, Boolean> listEventTimeTables = new ConcurrentHashMap<>();
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final boolean headup = resultSet.getBoolean("headup");
                    final String time = resultSet.getString("time");
                    final String day;
                    final String finalTime;
                    if (!everyDay) {
                        day = resultSet.getString("day");
                        finalTime = day + " " + time;
                    } else {
                        finalTime = time;
                    }

                    listEventTimeTables.put(finalTime, headup);
                }
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return listEventTimeTables;
    }

    public ArrayList<String> getOverworldEventTimes(final String table) {
        final ArrayList<String> listEventTimeTables = new ArrayList<>();
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final String time = resultSet.getString("time");
                    final String day = resultSet.getString("day");
                    final String finalTime = day + " " + time;
                    listEventTimeTables.add(finalTime);
                }
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return listEventTimeTables;
    }

    // Guilds

    public void createNewGuildEntry(final GuildInformation guildInformation) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO guilds (guildID, language, timezone, event_headup, event_message) VALUES (?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, guildInformation.getGuildID());
                preparedStatement.setString(2, guildInformation.getLanguage());
                preparedStatement.setString(3, guildInformation.getTimezone());
                preparedStatement.setBoolean(4, guildInformation.isHeadUpEnabled());
                preparedStatement.setBoolean(5, guildInformation.isEventMessageEnabled());
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void setGuildLanguage(final String guildID, final String language) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET language = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setString(1, language);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void setGuildTimezone(final String guildID, final String timezone) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET timezone = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setString(1, timezone);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public Map<String, GuildInformation> getAllGuilds() {
        final Map<String, GuildInformation> listWithGuildInformation = new ConcurrentHashMap<>();
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM guilds")) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final String guildID = resultSet.getString("guildID");
                    final String language = resultSet.getString("language");
                    final String timezone = resultSet.getString("timezone");
                    final boolean isHeadUpEnabled = (resultSet.getInt("event_headup") == 1);
                    final boolean eventMessagesEnabled = (resultSet.getInt("event_message") == 1);
                    final int autoDeleteValue = resultSet.getInt("autodelete_value");
                    final boolean isAutoDeleteEnabled = (resultSet.getInt("autodelete") == 1);
                    final GuildInformation guildInformation = new GuildInformation(guildID, language, timezone, isHeadUpEnabled, eventMessagesEnabled, isAutoDeleteEnabled, autoDeleteValue);
                    listWithGuildInformation.put(guildID, guildInformation);
                }
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return listWithGuildInformation;
    }

    public void setEventHeadUpOnServerValue(final boolean enabled, final String guildID) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET event_headup = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setBoolean(1, enabled);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void setEventMessageOnServerValue(final boolean enabled, final String guildID) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET event_message = ? WHERE guildID = ?")) {
            try {
                preparedStatement.setBoolean(1, enabled);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public Map<Integer, CustomMessage> getAllCustomMessages() {
        final Map<Integer, CustomMessage> customMessagesList = new ConcurrentHashMap<>();
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM custom_messages")) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final String guildID = resultSet.getString("guildID");
                    final String channelID = resultSet.getString("channelID");
                    final String message = resultSet.getString("message");
                    final String day = resultSet.getString("day");
                    final String time = resultSet.getString("time");
                    final boolean repeat = (resultSet.getInt("message_repeat") == 1);
                    final int id = resultSet.getInt("message_id");
                    final CustomMessage customMessage = new CustomMessage(channelID, guildID, message, day, time, id, repeat);
                    customMessagesList.put(id, customMessage);
                }
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return customMessagesList;
    }

    public void deleteCustomMessageEntry(final int customMessageID) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM custom_messages WHERE message_id = ?")) {
            try {
                preparedStatement.setInt(1, customMessageID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void createNewCustomMessageEntry(final CustomMessage customMessage) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO custom_messages " +
                     "(guildID, channelID, message, day, time, message_repeat) VALUES (?, ?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, customMessage.getGuildID());
                preparedStatement.setString(2, customMessage.getChannelID());
                preparedStatement.setString(3, customMessage.getMessage());
                preparedStatement.setString(4, customMessage.getDay());
                preparedStatement.setString(5, customMessage.getTime());
                preparedStatement.setBoolean(6, customMessage.isRepeat());
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }


    //NOTIFIER CHANNELS

    public void updateNotifierChannelEventMessage(final String eventMessage, final String textChannelID, final boolean value) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET " + eventMessage + " = ? WHERE textChannelID = ?")) {
            try {
                preparedStatement.setBoolean(1, value);
                preparedStatement.setString(2, textChannelID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void deleteNotifierChannelEntry(final String textChannelID) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM channel_notification WHERE textChannelID = ?")) {
            try {
                preparedStatement.setString(1, textChannelID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void updateNotifierChannelRole(final String textChannelID, final String roleID) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET roleID = ? WHERE textChannelID = ?")) {
            try {
                preparedStatement.setString(1, roleID);
                preparedStatement.setString(2, textChannelID);
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void createNewNotifierChannel(final NotifierChannel notifierChannel) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO channel_notification (textChannelID, guildID, roleID, message, headUp, ancientarena, ancientnightmare, assembly, battlegrounds, defendvault, raidvault, demongates, shadowlottery, hauntedcarriage, demongatesembed, ancientarenaembed, hauntedcarriageembed, ancientnightmareembed, wrathborneinvasion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
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
                preparedStatement.setBoolean(19, notifierChannel.isWrathborneInvasionEnabled());
                preparedStatement.executeUpdate();
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public Map<String, NotifierChannel> getAllNotifierChannels() {
        final Map<String, NotifierChannel> notifierChannelList = new ConcurrentHashMap<>();
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM channel_notification")) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    final String textChannelID = resultSet.getString("textChannelID");
                    final String guildID = resultSet.getString("guildID");
                    final String roleID = resultSet.getString("roleID");

                    final boolean message = (resultSet.getInt("message") == 1);
                    final boolean headup = (resultSet.getInt("headUp") == 1);
                    final boolean ancientarena = (resultSet.getInt("ancientarena") == 1);
                    final boolean ancientnightmare = (resultSet.getInt("ancientnightmare") == 1);
                    final boolean assembly = (resultSet.getInt("assembly") == 1);
                    final boolean battlegrounds = (resultSet.getInt("battlegrounds") == 1);
                    final boolean defendvault = (resultSet.getInt("defendvault") == 1);
                    final boolean raidvault = (resultSet.getInt("raidvault") == 1);
                    final boolean demongates = (resultSet.getInt("demongates") == 1);
                    final boolean shadowlottery = (resultSet.getInt("shadowlottery") == 1);
                    final boolean hauntedcarriage = (resultSet.getInt("hauntedcarriage") == 1);
                    final boolean hauntedcarriageembed = (resultSet.getInt("hauntedcarriageembed") == 1);
                    final boolean demongatesembed = (resultSet.getInt("demongatesembed") == 1);
                    final boolean ancientnightmareembed = (resultSet.getInt("ancientnightmareembed") == 1);
                    final boolean ancientarenaembed = (resultSet.getInt("ancientarenaembed") == 1);
                    final boolean wrathborneInvasionEnabled = (resultSet.getInt("wrathborneinvasion") == 1);

                    final NotifierChannel notificationChannel = new NotifierChannel(roleID, guildID, textChannelID,
                            headup, message, assembly, raidvault, demongates, defendvault, ancientarena, shadowlottery,
                            battlegrounds, hauntedcarriage, ancientnightmare, demongatesembed, ancientarenaembed,
                            hauntedcarriageembed, ancientnightmareembed, wrathborneInvasionEnabled);

                    notifierChannelList.put(textChannelID, notificationChannel);
                }
            } catch (final Exception e) {
                ClientLogger.createNewSqlLogEntry(e);
                e.printStackTrace();
            }
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
        return notifierChannelList;
    }

    public void setAutoDeleteEnabled(final String guildID, final boolean autoDeleteValue) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET autodelete = ? WHERE guildID = ?")) {
            preparedStatement.setBoolean(1, autoDeleteValue);
            preparedStatement.setString(2, guildID);
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void setAutoDeleteValue(final String guildID, final int autoDeleteValue) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE guilds SET autodelete_value = ? WHERE guildID = ?")) {
            preparedStatement.setInt(1, autoDeleteValue);
            preparedStatement.setString(2, guildID);
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void deleteEverythingFromDatabase(final String guildID) {
        try (final Connection connection = databaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM guilds WHERE guildID = ?");
            preparedStatement.setString(1, guildID);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM channel_notification WHERE guildID = ?");
            preparedStatement.setString(1, guildID);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM custom_messages WHERE guildID = ?");
            preparedStatement.setString(1, guildID);
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

}
