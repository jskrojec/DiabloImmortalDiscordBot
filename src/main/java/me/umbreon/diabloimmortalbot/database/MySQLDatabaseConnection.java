package me.umbreon.diabloimmortalbot.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDatabaseConnection implements DatabaseConnection {

    private MysqlDataSource dataSource;
    private final ClientConfig clientConfig;

    public MySQLDatabaseConnection(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        createConnection();
    }

    public boolean createConnection() {
        String host = clientConfig.getHost();
        String database = clientConfig.getDatabase();
        String username = clientConfig.getUsername();
        String password = clientConfig.getPassword();
        int port = Integer.parseInt(clientConfig.getPort());

        dataSource = new MysqlDataSource();
        dataSource.setServerName(host);
        dataSource.setPortNumber(port);
        dataSource.setDatabaseName(database);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + database + "?verifyServerCertificate=false&useSSL=true");

        try (Connection connection = dataSource.getConnection()) {

            String guilds = "CREATE TABLE IF NOT EXISTS guilds (" +
                    "guildID VARCHAR(20) PRIMARY KEY NOT NULL," +
                    "language VARCHAR(5) DEFAULT 'ENG'," +
                    "timezone VARCHAR(10) DEFAULT 'GMT'," +
                    "event_headup TINYINT(1) DEFAULT 1 NOT NULL," +
                    "event_message TINYINT(1) DEFAULT 1 NOT NULL" + ")";

            String custom_messages = "CREATE TABLE IF NOT EXISTS custom_messages (" +
                    "guildID VARCHAR(50) NOT NULL," +
                    "channelID VARCHAR(50) NOT NULL," +
                    "message VARCHAR(2000) NOT NULL," +
                    "day VARCHAR(10) NOT NULL," +
                    "time VARCHAR(10) NOT NULL," +
                    "message_repeat TINYINT(1) NOT NULL," +
                    "message_id int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "autodelete TINYINT(2) DEFAULT 24 NOT NULL," +
                    "autodelete_value TINYINT(1) DEFAULT 0 NOT NULL" + ")";

            String channel_notification = "CREATE TABLE IF NOT EXISTS channel_notification (" +
                    "textChannelID VARCHAR(20) NOT NULL PRIMARY KEY," +
                    "guildID VARCHAR(20) NOT NULL," +
                    "roleID VARCHAR(20) NOT NULL DEFAULT 'EVERYONE'," +
                    "message TINYINT(1) DEFAULT 0 NOT NULL," +
                    "headUp TINYINT(1) DEFAULT 0 NOT NULL," +
                    "ancientarena TINYINT(1) DEFAULT 0 NOT NULL," +
                    "ancientnightmare TINYINT(1) DEFAULT 0 NOT NULL," +
                    "assembly TINYINT(1) DEFAULT 0 NOT NULL," +
                    "battlegrounds TINYINT(1) DEFAULT 0 NOT NULL," +
                    "defendvault TINYINT(1) DEFAULT 0 NOT NULL," +
                    "raidvault TINYINT(1) DEFAULT 0 NOT NULL," +
                    "demongates TINYINT(1) DEFAULT 0 NOT NULL," +
                    "shadowlottery TINYINT(1) DEFAULT 0 NOT NULL," +
                    "hauntedcarriage TINYINT(1) DEFAULT 0 NOT NULL," +
                    "hauntedcarriageembed TINYINT(1) DEFAULT 0 NOT NULL," +
                    "demongatesembed TINYINT(1) DEFAULT 0 NOT NULL," +
                    "ancientnightmareembed TINYINT(1) DEFAULT 0 NOT NULL," +
                    "ancientarenaembed TINYINT(1) DEFAULT 0 NOT NULL" + ")";

            connection.createStatement().execute(channel_notification);
            connection.createStatement().execute(guilds);
            connection.createStatement().execute(custom_messages);

        } catch (SQLException e) {
            ClientLogger.createNewErrorLogEntry(e);
            e.printStackTrace();
        }
        return true;
    }

    public void closeConnection() {
        if (dataSource != null) {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                ClientLogger.createNewErrorLogEntry(e);
            }
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            ClientLogger.createNewErrorLogEntry(e);
            return null;
        }
    }
}
