package me.umbreon.diabloimmortalbot.database;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SQLStatements {

    private static final String DEFAULT_PATH = "sql-scripts/";

    private static String GET_ALL_GUILDS_STATEMENT;
    private static String CREATE_NEW_GUILD_STATEMENT;
    private static String UPDATE_GUILD_LANGUAGE_STATEMENT;
    private static String UPDATE_GUILD_TIMEZONE_STATEMENT;
    private static String UPDATE_GUILD_HEAD_UP_STATEMENT;
    private static String UPDATE_GUILD_MESSAGE_STATEMENT;
    //TODO: DELETE_STATEMENT?

    private static String GET_ALL_CUSTOM_MESSAGES_STATEMENT;
    private static String CREATE_CUSTOM_MESSAGE_STATEMENT;
    //TODO: UPDATE_STATEMENTS?
    private static String DELETE_CUSTOM_MESSAGE_BY_ID_STATEMENT;

    private static String GET_ALL_CHANNELS_STATEMENT;
    private static String CREATE_CHANNEL_STATEMENT;
    private static String UPDATE_CHANNEL_MESSAGE_STATEMENT;
    private static String UPDATE_CHANNEL_HEAD_UP_VALUE_STATEMENT;
    private static String UPDATE_CHANNEL_ROLE_STATEMENT;
    private static String DELETE_CHANNEL_BY_ID_STATEMENT;

    private static String GET_ALL_REACTION_ROLES_STATEMENT;
    //TODO: UPDATE_STATEMENTS?
    private static String CREATE_REACTION_ROLE_STATEMENT;
    private static String DELETE_REACTION_ROLE_BY_MESSAGE_ID_STATEMENT;
    private static String DELETE_REACTION_ROLE_BY_MESSAGE_ID_AND_EMOJI_STATEMENT;

    private static String CREATE_CHANNEL_TABLE_IF_NOT_EXISTS;
    private static String CREATE_REACTION_ROLES_TABLE_IF_NOT_EXISTS;
    private static String CREATE_GUILDS_TABLE_IF_NOT_EXISTS;
    private static String CREATE_CUSTOM_MESSAGES_TABLE_IF_NOT_EXISTS;

    public SQLStatements() { // "channel-statements/" +
        GET_ALL_GUILDS_STATEMENT = loadResourceToString(DEFAULT_PATH + "get-all-guilds.sql");
        CREATE_NEW_GUILD_STATEMENT = loadResourceToString(DEFAULT_PATH + "create-new-guild.sql");
        UPDATE_GUILD_LANGUAGE_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-guild-language.sql");
        UPDATE_GUILD_TIMEZONE_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-guild-timezone.sql");
        UPDATE_GUILD_HEAD_UP_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-guild-head-up.sql");
        UPDATE_GUILD_MESSAGE_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-guild-message.sql");

        GET_ALL_CUSTOM_MESSAGES_STATEMENT = loadResourceToString(DEFAULT_PATH + "get-all-custom-messages.sql");
        CREATE_CUSTOM_MESSAGE_STATEMENT = loadResourceToString(DEFAULT_PATH + "create-custom-message.sql");
        DELETE_CUSTOM_MESSAGE_BY_ID_STATEMENT = loadResourceToString(DEFAULT_PATH + "delete-custom-message-by-id.sql");

        GET_ALL_CHANNELS_STATEMENT = loadResourceToString(DEFAULT_PATH + "get-all-channels.sql");
        CREATE_CHANNEL_STATEMENT = loadResourceToString(DEFAULT_PATH + "create-channel.sql");
        UPDATE_CHANNEL_MESSAGE_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-channel-message.sql");
        UPDATE_CHANNEL_HEAD_UP_VALUE_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-channel-head-up-value.sql");
        UPDATE_CHANNEL_ROLE_STATEMENT = loadResourceToString(DEFAULT_PATH + "update-channel-role.sql");
        DELETE_CHANNEL_BY_ID_STATEMENT = loadResourceToString(DEFAULT_PATH + "delete-channel-by-id.sql");

        GET_ALL_REACTION_ROLES_STATEMENT = loadResourceToString(DEFAULT_PATH + "get-all-reaction-roles.sql");
        CREATE_REACTION_ROLE_STATEMENT = loadResourceToString(DEFAULT_PATH + "create-reaction-role.sql");
        DELETE_REACTION_ROLE_BY_MESSAGE_ID_STATEMENT = loadResourceToString(DEFAULT_PATH + "delete-reaction-role-by-message-id.sql");
        DELETE_REACTION_ROLE_BY_MESSAGE_ID_AND_EMOJI_STATEMENT = loadResourceToString(DEFAULT_PATH + "delete-reaction-role-by-message-id-and-emoji.sql");

        CREATE_CHANNEL_TABLE_IF_NOT_EXISTS = loadResourceToString(DEFAULT_PATH + "create-channel-table-if-not-exists.sql");
        CREATE_REACTION_ROLES_TABLE_IF_NOT_EXISTS = loadResourceToString(DEFAULT_PATH + "create-reaction-roles-table-if-not-exists.sql");
        CREATE_GUILDS_TABLE_IF_NOT_EXISTS = loadResourceToString(DEFAULT_PATH + "create-guilds-table-if-not-exists.sql");
        CREATE_CUSTOM_MESSAGES_TABLE_IF_NOT_EXISTS = loadResourceToString(DEFAULT_PATH + "create-custom-messages-table-if-not-exists.sql");
    }

    public static String loadResourceToString(String path) {
        InputStream stream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(path);
        try {
            return IOUtils.toString(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    /*
     * Guilds Statements Getter
     */

    public static String getGetAllGuildsStatement() {
        return GET_ALL_GUILDS_STATEMENT;
    }

    public static String getCreateNewGuildStatement() {
        return CREATE_NEW_GUILD_STATEMENT;
    }

    public static String getUpdateGuildLanguageStatement() {
        return UPDATE_GUILD_LANGUAGE_STATEMENT;
    }

    public static String getUpdateGuildTimezoneStatement() {
        return UPDATE_GUILD_TIMEZONE_STATEMENT;
    }

    public static String getUpdateGuildHeadUpStatement() {
        return UPDATE_GUILD_HEAD_UP_STATEMENT;
    }

    public static String getUpdateGuildMessageStatement() {
        return UPDATE_GUILD_MESSAGE_STATEMENT;
    }

    /*
     * Custom Message Statements Getter
     */

    public static String getGetAllCustomMessagesStatement() {
        return GET_ALL_CUSTOM_MESSAGES_STATEMENT;
    }

    public static String getCreateCustomMessageStatement() {
        return CREATE_CUSTOM_MESSAGE_STATEMENT;
    }

    public static String getDeleteCustomMessageByIdStatement() {
        return DELETE_CUSTOM_MESSAGE_BY_ID_STATEMENT;
    }

    /*
     * Channel Statements Getter
     */

    public static String getGetAllChannelsStatement() {
        return GET_ALL_CHANNELS_STATEMENT;
    }

    public static String getCreateChannelStatement() {
        return CREATE_CHANNEL_STATEMENT;
    }

    public static String getUpdateChannelMessageStatement() {
        return UPDATE_CHANNEL_MESSAGE_STATEMENT;
    }

    public static String getUpdateChannelHeadUpValueStatement() {
        return UPDATE_CHANNEL_HEAD_UP_VALUE_STATEMENT;
    }

    public static String getUpdateChannelRoleStatement() {
        return UPDATE_CHANNEL_ROLE_STATEMENT;
    }

    public static String getDeleteChannelByIdStatement() {
        return DELETE_CHANNEL_BY_ID_STATEMENT;
    }

    /*
     * Reaction Roles Statements Getter
     */

    public static String getGetAllReactionRolesStatement() {
        return GET_ALL_REACTION_ROLES_STATEMENT;
    }

    public static String getCreateReactionRoleStatement() {
        return CREATE_REACTION_ROLE_STATEMENT;
    }

    public static String getDeleteReactionRoleByMessageIdStatement() {
        return DELETE_REACTION_ROLE_BY_MESSAGE_ID_STATEMENT;
    }

    public static String getDeleteReactionRoleByMessageIdAndEmojiStatement() {
        return DELETE_REACTION_ROLE_BY_MESSAGE_ID_AND_EMOJI_STATEMENT;
    }

    /*
     * Create table if not exists Getter
     */

    public static String getCreateChannelTableIfNotExists() {
        return CREATE_CHANNEL_TABLE_IF_NOT_EXISTS;
    }

    public static String getCreateReactionRolesTableIfNotExists() {
        return CREATE_REACTION_ROLES_TABLE_IF_NOT_EXISTS;
    }

    public static String getCreateGuildsTableIfNotExists() {
        return CREATE_GUILDS_TABLE_IF_NOT_EXISTS;
    }

    public static String getCreateCustomMessagesTableIfNotExists() {
        return CREATE_CUSTOM_MESSAGES_TABLE_IF_NOT_EXISTS;
    }

}
