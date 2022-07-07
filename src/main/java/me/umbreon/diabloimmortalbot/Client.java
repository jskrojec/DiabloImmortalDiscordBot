package me.umbreon.diabloimmortalbot;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.database.MySQLDatabaseConnection;
import me.umbreon.diabloimmortalbot.events.EventHandler;
import me.umbreon.diabloimmortalbot.gameevents.Notifier;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.apache.log4j.BasicConfigurator;

import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;

public class Client {

    public static void main(String[] args) {
        ClientCache clientCache = new ClientCache();
        ClientConfig clientConfig = new ClientConfig();

        try {
            clientConfig.loadConfig();
        } catch (NullPointerException e) {
            System.out.println("config.properties is null! Shutting down...");
            return;
        }

        MySQLDatabaseConnection mySQLDatabaseConnection = new MySQLDatabaseConnection(clientConfig);
        DatabaseRequests databaseRequests = new DatabaseRequests(mySQLDatabaseConnection);

        clientCache.setListWithNotificationChannels(databaseRequests.getAllNotificationChannels());

        Notifier notifier = new Notifier(databaseRequests, clientConfig, clientCache);
        EventHandler eventHandler = new EventHandler(databaseRequests, clientCache);
        setupJDALogger();

        JDA jda = null;
        try {
            jda = JDABuilder.createDefault(clientConfig.getToken()).addEventListeners(eventHandler).build();
        } catch (LoginException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
            return;
        }

        try {
            jda.awaitReady();
            setClientActivity(jda);
        } catch (InterruptedException e) {
            ClientLogger.createNewLogEntry(e.getMessage());
        }

        notifier.runNotifierScheduler(jda);

    }

    private static void setupJDALogger() {
        BasicConfigurator.configure();
    }

    public static void setClientActivity(JDA jda) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                int counter = jda.getGuilds().size();
                jda.getPresence().setActivity(Activity.playing("Diablo Immortal (" + counter + ")"));

            }
        }, 0, 60 * (60 * 1000)); //every hour
    }

}