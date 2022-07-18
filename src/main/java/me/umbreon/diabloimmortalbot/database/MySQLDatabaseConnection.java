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
            String channel_notification = "CREATE TABLE IF NOT EXISTS channel_notification (" +
                    "channel VARCHAR(50) PRIMARY KEY," +
                    "timezone VARCHAR(10)," +
                    "status INT," +
                    "role VARCHAR(20)," +
                    "debug TINYINT(1)" +
                    ")";

            String guilds = "CREATE TABLE IF NOT EXISTS guilds (" +
                    "guildID VARCHAR(20)," +
                    "language VARCHAR(5)," +
                    "enable_headup TINYINT(1)" + ")";

            connection.createStatement().execute(channel_notification);
            connection.createStatement().execute(guilds);
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
        }
        return true;
    }

    public void closeConnection() {
        if (dataSource != null) {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            }
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            ClientLogger.createNewLogEntry("sql-err", "MySQL-Errors", "Umbreon", e.toString());
            return null;
        }
    }
}
