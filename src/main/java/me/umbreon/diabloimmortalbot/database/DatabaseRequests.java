package me.umbreon.diabloimmortalbot.database;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotificationChannel;
import me.umbreon.diabloimmortalbot.data.ReactionRole;

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

    public DatabaseRequests(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public Map<String, Boolean> getEventTimes(String table, boolean everyDay) {
        Map<String, Boolean> listEventTimeTables = new ConcurrentHashMap<>();
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    boolean headup = resultSet.getBoolean("headup");
                    String time = resultSet.getString("time");
                    String day;
                    String Time;
                    if (!everyDay) {
                        day = resultSet.getString("day");
                        Time = day + " " + time;
                    } else {
                        Time = time;
                    }

                    listEventTimeTables.put(Time, headup);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEventTimeTables;
    }

    public ArrayList<String> getOverworldEventTimes(String table) {
        ArrayList<String> listEventTimeTables = new ArrayList<>();
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + table)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String time = resultSet.getString("time");
                    String day = resultSet.getString("day");
                    String Time = day + " " + time;
                    listEventTimeTables.add(Time);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEventTimeTables;
    }

    //TODO: removoe this
    public void updateNotifierChannelEventMessage(final String eventMessage, final String textChannelID, final boolean value) {
        try (final Connection connection = databaseConnection.getConnection();
             final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE channel_notification SET " + eventMessage + " = ? WHERE textChannelID = ?")) {
            preparedStatement.setBoolean(1, value);
            preparedStatement.setString(2, textChannelID);
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }


    /*
     * Guild Statements
     */

    public Map<String, GuildInformation> getAllGuilds() {
        Map<String, GuildInformation> listWithGuildInformation = new ConcurrentHashMap<>();
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getGetAllGuildsStatement())
        ) {
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
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listWithGuildInformation;
    }

    public void createNewGuildEntry(GuildInformation guildInformation) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getCreateNewGuildStatement())
        ) {
            preparedStatement.setString(1, guildInformation.getGuildID());
            preparedStatement.setString(2, guildInformation.getLanguage());
            preparedStatement.setString(3, guildInformation.getTimezone());
            preparedStatement.setBoolean(4, guildInformation.isHeadUpEnabled());
            preparedStatement.setBoolean(5, guildInformation.isEventMessageEnabled());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuildLanguage(String guildID, String language) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getUpdateGuildLanguageStatement())
        ) {
            try {
                preparedStatement.setString(1, language);
                preparedStatement.setString(2, guildID);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuildTimezone(String guildID, String timezone) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getUpdateGuildTimezoneStatement())
        ) {
            preparedStatement.setString(1, timezone);
            preparedStatement.setString(2, guildID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuildMessage(boolean enabled, String guildID) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getUpdateGuildMessageStatement())
        ) {
            preparedStatement.setBoolean(1, enabled);
            preparedStatement.setString(2, guildID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuildHeadUp(String guildID, boolean value) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getUpdateGuildHeadUpStatement())
        ) {
            preparedStatement.setBoolean(1, value);
            preparedStatement.setString(2, guildID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Custom Messages Statements
     */

    public Map<Integer, CustomMessage> getAllCustomMessages() {
        Map<Integer, CustomMessage> customMessagesList = new ConcurrentHashMap<>();
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getGetAllCustomMessagesStatement())
        ) {
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
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customMessagesList;
    }

    public void deleteCustomMessageEntry(int customMessageID) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getDeleteCustomMessageByIdStatement())
        ) {
            preparedStatement.setInt(1, customMessageID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGetCustomMessageNextAutoIncrementValue() {
        int nextAutoIncrementNumber = 0;
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getGetCustomMessageNextAutoIncrementValue())
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    nextAutoIncrementNumber = resultSet.getInt("AUTO_INCREMENT");
                } else {
                    throw new SQLException("Failed to get next auto increment number for custom messages");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextAutoIncrementNumber;
    }

    public void createNewCustomMessageEntry(CustomMessage customMessage) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getCreateCustomMessageStatement())
        ) {
            preparedStatement.setString(1, customMessage.getGuildID());
            preparedStatement.setString(2, customMessage.getChannelID());
            preparedStatement.setString(3, customMessage.getMessage());
            preparedStatement.setString(4, customMessage.getWeekday());
            preparedStatement.setString(5, customMessage.getTime());
            preparedStatement.setBoolean(6, customMessage.isRepeating());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * Channel Statements
     */

    public void deleteNotifierChannelEntry(String textChannelID) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getDeleteChannelByIdStatement())
        ) {
            preparedStatement.setString(1, textChannelID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNotifierChannelRole(String textChannelID, String roleID) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getUpdateChannelRoleStatement())
        ) {
            preparedStatement.setString(1, roleID);
            preparedStatement.setString(2, textChannelID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void replaceNotificationChannel(NotificationChannel notificationChannel) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getReplaceChannelStatement())
        ) {
            preparedStatement.setBoolean(1, notificationChannel.isAncientArenaMessageEnabled());
            preparedStatement.setBoolean(2, notificationChannel.isAncientNightmareMessageEnabled());
            preparedStatement.setBoolean(3, notificationChannel.isAssemblyMessageEnabled());
            preparedStatement.setBoolean(4, notificationChannel.isBattlegroundsMessageEnabled());
            preparedStatement.setBoolean(5, notificationChannel.isDefendVaultMessageEnabled());
            preparedStatement.setBoolean(6, notificationChannel.isRaidVaultMessageEnabled());
            preparedStatement.setBoolean(7, notificationChannel.isDemonGatesMessageEnabled());
            preparedStatement.setBoolean(8, notificationChannel.isShadowLotteryMessageEnabled());
            preparedStatement.setBoolean(9, notificationChannel.isHauntedCarriageMessageEnabled());
            preparedStatement.setBoolean(10, notificationChannel.isWrathborneInvasionEnabled());
            preparedStatement.setString(11, notificationChannel.getTextChannelID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNewNotifierChannel(NotificationChannel notificationChannel) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getCreateChannelStatement())
        ) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, NotificationChannel> getAllNotifierChannels() {
        Map<String, NotificationChannel> notifierChannelList = new ConcurrentHashMap<>();
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getGetAllChannelsStatement())
        ) {
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
                    boolean wrathborneInvasionEnabled = (resultSet.getInt("wrathborneinvasion") == 1);

                    NotificationChannel notificationChannel = new NotificationChannel(roleID, guildID, textChannelID,
                            headup, message, assembly, raidvault, demongates, defendvault, ancientarena, shadowlottery,
                            battlegrounds, hauntedcarriage, ancientnightmare, demongatesembed, ancientarenaembed,
                            hauntedcarriageembed, ancientnightmareembed, wrathborneInvasionEnabled);

                    notifierChannelList.put(textChannelID, notificationChannel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifierChannelList;
    }

    /*
     * Reaction roles Statements
     */

    public void createNewReactionRole(ReactionRole reactionRole) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getCreateReactionRoleStatement())
        ) {
            preparedStatement.setString(1, reactionRole.getMessageID());
            preparedStatement.setString(2, reactionRole.getGuildID());
            preparedStatement.setString(3, reactionRole.getReactionID());
            preparedStatement.setString(4, reactionRole.getReactionType());
            preparedStatement.setString(5, reactionRole.getRoleID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReactionRoleMessage(String messageID) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getDeleteReactionRoleByMessageIdStatement())
        ) {
            preparedStatement.setString(1, messageID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReactionRole(String messageID, String codifiedEmote) {
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getDeleteReactionRoleByMessageIdAndEmojiStatement())
        ) {
            preparedStatement.setString(1, messageID);
            preparedStatement.setString(2, codifiedEmote);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ReactionRole> getAllReactionRolesData() {
        List<ReactionRole> reactionRolesMap = new ArrayList<>();
        try (
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLStatements.getGetAllReactionRolesStatement())
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String messageID = resultSet.getString("messageID");
                    String guildID = resultSet.getString("guildID");
                    String roleID = resultSet.getString("roleID");
                    String emojiCode = resultSet.getString("emojiCode");
                    String emojiType = resultSet.getString("emojiType");
                    ReactionRole reactionRole = new ReactionRole(messageID, guildID, emojiCode, emojiType, roleID);
                    reactionRolesMap.add(reactionRole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reactionRolesMap;
    }

}
