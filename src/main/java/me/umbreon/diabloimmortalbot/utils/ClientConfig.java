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
    private String vaultHeadUpMessage;
    private String vaultMessage;
    private String hauntedCarriageHeadUpMessage;
    private String hauntedCarriageMessage;
    private String demonGatesHeadUpMessage;
    private String demonGatesMessage;
    private String battlegroundHeadUpMessage;
    private String battlegroundMessage;
    private String ancientNightmareHeadUpMessage;
    private String ancientNightmareMessage;
    private String ancientAreaHeadUpMessage;
    private String ancientAreaMessage;
    private String assemblyMessage;
    private String assemblyHeadUpMessage;
    private String shadowLotteryMessage;
    private String shadowLotteryHeadUpMessage;
    private String logFolderPath;
    private String prefix;

    public ClientConfig() {
        loadConfig();
    }

    public void loadConfig() {
        try {
            String configFilePath = "/home/discord/config.properties";
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
        this.vaultHeadUpMessage = properties.getProperty("VAULT_HEADUP");
        this.vaultMessage = properties.getProperty("VAULT");
        this.hauntedCarriageHeadUpMessage = properties.getProperty("HAUNTED_CARRIAGE_HEADUP");
        this.hauntedCarriageMessage = properties.getProperty("HAUNTED_CARRIAGE");
        this.demonGatesHeadUpMessage = properties.getProperty("DEMON_GATES_HEADUP");
        this.demonGatesMessage = properties.getProperty("DEMON_GATES");
        this.battlegroundHeadUpMessage = properties.getProperty("BATTLEGROUND_HEADUP");
        this.battlegroundMessage = properties.getProperty("BATTLEGROUND");
        this.ancientNightmareHeadUpMessage = properties.getProperty("ANCIENT_NIGHTMARE_HEADUP");
        this.ancientNightmareMessage = properties.getProperty("ANCIENT_NIGHTMARE");
        this.ancientAreaHeadUpMessage = properties.getProperty("ANCIENT_AREA_HEADUP");
        this.ancientAreaMessage = properties.getProperty("ANCIENT_AREA");
        this.assemblyMessage = properties.getProperty("ASSEMBLY");
        this.assemblyHeadUpMessage = properties.getProperty("ASSEMBLY_HEADUP");
        this.shadowLotteryMessage = properties.getProperty("SHADOW_LOTTERY");
        this.shadowLotteryHeadUpMessage = properties.getProperty("SHADOW_LOTTERY_HEADUP");
        this.logFolderPath = properties.getProperty("LOG_FOLDER_PATH");
        this.prefix = properties.getProperty("PREFIX");
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

    public String getVaultHeadUpMessage() {
        return vaultHeadUpMessage;
    }

    public String getVaultMessage() {
        return vaultMessage;
    }

    public String getHauntedCarriageHeadUpMessage() {
        return hauntedCarriageHeadUpMessage;
    }

    public String getHauntedCarriageMessage() {
        return hauntedCarriageMessage;
    }

    public String getDemonGatesHeadUpMessage() {
        return demonGatesHeadUpMessage;
    }

    public String getDemonGatesMessage() {
        return demonGatesMessage;
    }

    public String getBattlegroundHeadUpMessage() {
        return battlegroundHeadUpMessage;
    }

    public String getBattlegroundMessage() {
        return battlegroundMessage;
    }

    public String getAncientNightmareHeadUpMessage() {
        return ancientNightmareHeadUpMessage;
    }

    public String getAncientNightmareMessage() {
        return ancientNightmareMessage;
    }

    public String getAncientAreaHeadUpMessage() {
        return ancientAreaHeadUpMessage;
    }

    public String getAncientAreaMessage() {
        return ancientAreaMessage;
    }

    public String getAssemblyMessage() {
        return assemblyMessage;
    }

    public String getAssemblyHeadUpMessage() {
        return assemblyHeadUpMessage;
    }

    public String getShadowLotteryMessage() {
        return shadowLotteryMessage;
    }

    public String getShadowLotteryHeadUpMessage() {
        return shadowLotteryHeadUpMessage;
    }

    public String getLogFolderPath() {
        return logFolderPath;
    }

    public String getPrefix() {
        return prefix;
    }
}
