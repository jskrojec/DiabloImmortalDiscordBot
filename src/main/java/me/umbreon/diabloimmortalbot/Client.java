package me.umbreon.diabloimmortalbot;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.database.MySQLDatabaseConnection;
import me.umbreon.diabloimmortalbot.events.MessageReceived;
import me.umbreon.diabloimmortalbot.events.TextChannelDelete;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.notifier.CustomMessagesNotifier;
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

        ClientLogger.checkIfLogFolderExists(clientConfig.getLogFolderPath());

        LanguageController.loadConfigurations();

        MySQLDatabaseConnection mySQLDatabaseConnection = new MySQLDatabaseConnection(clientConfig);
        DatabaseRequests databaseRequests = new DatabaseRequests(mySQLDatabaseConnection);

        clientCache.fillListWithEvents();
        clientCache.fillListWithAvailableEventDays();

        clientCache.setNotifierChannelsList(databaseRequests.getAllNotifierChannels());
        clientCache.setListWithGuildInformation(databaseRequests.getAllGuilds());
        clientCache.setCustomMessagesList(databaseRequests.getAllCustomMessages());

        clientCache.setListWithShadowLotteryTimes(databaseRequests.getEventTimes("event_shadow_lottery", true));
        clientCache.setListWithVaultTimes(databaseRequests.getEventTimes("event_vault", true));
        clientCache.setListWithHauntedCarriageTimes(databaseRequests.getEventTimes("event_haunted_carriage", false));
        clientCache.setListWithDemonGatesTimes(databaseRequests.getEventTimes("event_demon_gates", false));
        clientCache.setListWithBattlegroundTimes(databaseRequests.getEventTimes("event_battleground", true));
        clientCache.setListWithAncientAreaTimes(databaseRequests.getEventTimes("event_ancient_area", false));
        clientCache.setListWithAncientNightmareTimes(databaseRequests.getEventTimes("event_ancient_nightmare", false));
        clientCache.setListWithAssemblyTimes(databaseRequests.getEventTimes("event_assembly", false));

        clientCache.setListWithHauntedCarriageEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_haunted_carriage"));
        clientCache.setListWithAncientArenaEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_ancient_arena"));
        clientCache.setListWithAncientNightmareEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_ancient_nightmare"));
        clientCache.setListWithDemonGateEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_demon_gates"));

        JDA jda;
        try {
            jda = JDABuilder.createDefault(clientConfig.getToken())
                    .addEventListeners(new MessageReceived(databaseRequests, clientCache))
                    .addEventListeners(new TextChannelDelete(clientCache, databaseRequests))
                    .build()
                    .awaitReady();
        } catch (LoginException | InterruptedException e) {
            ClientLogger.createNewErrorLogEntry(e);
            return;
        }

        Notifier notifier = new Notifier(clientCache);
        CustomMessagesNotifier customMessagesNotifier = new CustomMessagesNotifier(clientCache, databaseRequests);
        BasicConfigurator.configure();

        notifier.runScheduler(jda);
        customMessagesNotifier.runCustomMessagesNotifierScheduler(jda);

    }
}