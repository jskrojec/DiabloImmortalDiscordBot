package me.umbreon.diabloimmortalbot.database;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public void createNewNotifierChannel(final NotificationChannel notificationChannel) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO channel_notification (textChannelID, guildID, roleID, message, headUp, ancientarena, ancientnightmare, assembly, battlegrounds, defendvault, raidvault, demongates, shadowlottery, hauntedcarriage, demongatesembed, ancientarenaembed, hauntedcarriageembed, ancientnightmareembed, wrathborneinvasion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, notificationChannel.getTextChannelID());
                preparedStatement.setString(2, notificationChannel.getGuildID());
                preparedStatement.setString(3, notificationChannel.getRoleID());
                preparedStatement.setBoolean(4, notificationChannel.isEventMessageEnabled());
                preparedStatement.setBoolean(5, notificationChannel.isEventHeadUpEnabled());
                preparedStatement.setBoolean(6, notificationChannel.isAncientArenaMessageEnabled());
                preparedStatement.setBoolean(7, notificationChannel.isAncientNightmareMessageEnabled());
                preparedStatement.setBoolean(8, notificationChannel.isAssemblyMessageEnabled());
                preparedStatement.setBoolean(9, notificationChannel.isBattlegroundsMessageEnabled());
                preparedStatement.setBoolean(10, notificationChannel.isDefendVaultMessageEnabled());
                preparedStatement.setBoolean(11, notificationChannel.isRaidVaultMessageEnabled());
                preparedStatement.setBoolean(12, notificationChannel.isDemonGatesMessageEnabled());
                preparedStatement.setBoolean(13, notificationChannel.isShadowLotteryMessageEnabled());
                preparedStatement.setBoolean(14, notificationChannel.isHauntedCarriageMessageEnabled());
                preparedStatement.setBoolean(15, notificationChannel.isDemonGatesMessageEmbedEnabled());
                preparedStatement.setBoolean(16, notificationChannel.isAncientArenaMessageEmbedEnabled());
                preparedStatement.setBoolean(17, notificationChannel.isHauntedCarriageMessageEmbedEnabled());
                preparedStatement.setBoolean(18, notificationChannel.isAncientNightmareMessageEmbedEnabled());
                preparedStatement.setBoolean(19, notificationChannel.isWrathborneInvasionEnabled());
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

    public Map<String, NotificationChannel> getAllNotifierChannels() {
        final Map<String, NotificationChannel> notifierChannelList = new ConcurrentHashMap<>();
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

                    final NotificationChannel notificationChannel = new NotificationChannel(roleID, guildID, textChannelID,
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

    public void createNewReactionRole(final ReactionRole reactionRole) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reaction_role (messageID, guildID, emojiID, roleID) VALUES (?, ?, ?, ?)")) {
            try {
                preparedStatement.setString(1, reactionRole.getMessageID());
                preparedStatement.setString(2, reactionRole.getGuildID());
                preparedStatement.setString(3, reactionRole.getReactionID());
                preparedStatement.setString(4, reactionRole.getRoleID());
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

    public void deleteReactionRoleMessage(final String messageID) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM reaction_role WHERE messageID = ?")) {
            preparedStatement.setString(1, messageID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public void deleteReactionRole(final String messageID, final String codifiedEmote) {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM reaction_role WHERE messageID = ? AND emojiID = ?")) {
            preparedStatement.setString(1, messageID);
            preparedStatement.setString(2, codifiedEmote);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ClientLogger.createNewSqlLogEntry(e);
            e.printStackTrace();
        }
    }

    public List<ReactionRole> getAllReactionRolesData() {
        List<ReactionRole> reactionRolesMap = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM reaction_role")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String messageID = resultSet.getString("messageID");
                    String guildID = resultSet.getString("guildID");
                    String roleID = resultSet.getString("roleID");
                    String emojiID = resultSet.getString("emojiID");
                    ReactionRole reactionRole = new ReactionRole(messageID, guildID, emojiID, roleID);
                    reactionRolesMap.add(reactionRole);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reactionRolesMap;
    }

}
