package me.umbreon.diabloimmortalbot.database;

import java.sql.Connection;

public interface DatabaseConnection {

    boolean createConnection();

    void closeConnection();

    Connection getConnection();

}
