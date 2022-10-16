package me.umbreon.diabloimmortalbot.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDatabaseConnection implements DatabaseConnection {

    private MysqlDataSource dataSource;
    private final ClientConfig clientConfig;

    public MySQLDatabaseConnection(final ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        createConnection();
    }

    @Override
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
            connection.createStatement().execute(SQLStatements.getCreateChannelTableIfNotExists());
            connection.createStatement().execute(SQLStatements.getCreateGuildsTableIfNotExists());
            connection.createStatement().execute(SQLStatements.getCreateCustomMessagesTableIfNotExists());
            connection.createStatement().execute(SQLStatements.getCreateReactionRolesTableIfNotExists());
        } catch (SQLException e) {
            ClientLogger.createNewErrorLogEntry(e);
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void closeConnection() {
        if (dataSource != null) {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                ClientLogger.createNewErrorLogEntry(e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            ClientLogger.createNewErrorLogEntry(e);
            e.printStackTrace();
            return null;
        }
    }
}
