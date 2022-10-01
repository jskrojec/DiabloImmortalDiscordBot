package me.umbreon.diabloimmortalbot.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClientConfig {

    private Properties properties;
    private String host;
    private String database;
    private String username;
    private String password;
    private String port;
    private String token;
    private String logFolderPath;

    public ClientConfig(boolean testMode) {
        loadConfig(testMode);
    }

    public void loadConfig(boolean testMode) {
        try {
            String configFilePath;
            if (testMode) {
                configFilePath = "C:\\workspace\\config.properties";
            } else {
                configFilePath = "/home/discord/config.properties";
            }
            FileInputStream propsInput = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(propsInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.host = properties.getProperty("DATABASE_HOST");
        this.port = properties.getProperty("DATABASE_PORT");
        this.database = properties.getProperty("DATABASE_FILE");
        this.username = properties.getProperty("DATABASE_USER");
        this.password = properties.getProperty("DATABASE_PASSWORD");
        this.token = properties.getProperty("TOKEN_MAIN");
        this.logFolderPath = properties.getProperty("LOG_FOLDER_PATH");
    }

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getToken() {
        return token;
    }

    public String getLogFolderPath() {
        return logFolderPath;
    }

}
