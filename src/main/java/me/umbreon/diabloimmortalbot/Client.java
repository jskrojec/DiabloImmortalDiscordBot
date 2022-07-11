package me.umbreon.diabloimmortalbot;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.database.MySQLDatabaseConnection;
import me.umbreon.diabloimmortalbot.events.EventHandler;
import me.umbreon.diabloimmortalbot.notifier.Notifier;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.apache.log4j.BasicConfigurator;

import javax.security.auth.login.LoginException;

public class Client {

    public static void main(String[] args) {

        ClientCache clientCache = new ClientCache();
        ClientConfig clientConfig = new ClientConfig();

        try {
            clientConfig.loadConfig();
        } catch (Exception e) {
            System.out.println("config.properties is null! Shutting down...");
            return;
        }

        ClientLogger.startTimer(clientConfig.getLogFolderPath());

        LanguageController.loadConfigurations();

        MySQLDatabaseConnection mySQLDatabaseConnection = new MySQLDatabaseConnection(clientConfig);
        DatabaseRequests databaseRequests = new DatabaseRequests(mySQLDatabaseConnection);

        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());

        Notifier notifier = new Notifier(databaseRequests, clientCache);
        EventHandler eventHandler = new EventHandler(databaseRequests, clientCache);
        BasicConfigurator.configure();

        JDA jda = null;
        try {
            jda = JDABuilder.createDefault(clientConfig.getToken()).addEventListeners(eventHandler).build().awaitReady();
        } catch (LoginException | InterruptedException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
            return;
        }

        notifier.runNotifierScheduler(jda);
    }
}