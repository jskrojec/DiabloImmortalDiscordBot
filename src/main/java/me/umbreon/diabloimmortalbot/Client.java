package me.umbreon.diabloimmortalbot;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.database.MySQLDatabaseConnection;
import me.umbreon.diabloimmortalbot.events.ChannelDelete;
import me.umbreon.diabloimmortalbot.events.GuildJoin;
import me.umbreon.diabloimmortalbot.events.GuildReady;
import me.umbreon.diabloimmortalbot.events.SlashCommandInteraction;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.notifier.CustomMessagesNotifier;
import me.umbreon.diabloimmortalbot.notifier.InfoNotifier;
import me.umbreon.diabloimmortalbot.notifier.Notifier;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.security.auth.login.LoginException;

public class Client {

    public static void main(final String[] args) {
        Logger.getRootLogger().setLevel(Level.INFO);

        ClientCache clientCache = new ClientCache();
        ClientConfig clientConfig = new ClientConfig();

        BasicConfigurator.configure();
        clientConfig.loadConfig();
        ClientLogger.checkIfLogFolderExists(clientConfig.getLogFolderPath());
        LanguageController.loadConfigurations();

        MySQLDatabaseConnection mySQLDatabaseConnection = new MySQLDatabaseConnection(clientConfig);
        DatabaseRequests databaseRequests = new DatabaseRequests(mySQLDatabaseConnection);

        loadClientCache(clientCache, databaseRequests);

        JDA jda;
        try {
            jda = JDABuilder.createDefault(clientConfig.getToken())
                    .addEventListeners(new ChannelDelete(clientCache, databaseRequests))
                    .addEventListeners(new SlashCommandInteraction(clientCache, databaseRequests))
                    .addEventListeners(new GuildJoin())
                    .addEventListeners(new GuildReady())
                    .build()
                    .awaitReady();
        } catch (LoginException | InterruptedException e) {
            ClientLogger.createNewErrorLogEntry(e);
            e.printStackTrace();
            return;
        }

        Notifier notifier = new Notifier(clientCache);
        CustomMessagesNotifier customMessagesNotifier = new CustomMessagesNotifier(clientCache, databaseRequests);
        InfoNotifier infoNotifier = new InfoNotifier();

        notifier.runScheduler(jda);
        customMessagesNotifier.runCustomMessagesNotifierScheduler(jda);
        infoNotifier.runScheduler(jda);
    }

    private static void loadClientCache(ClientCache clientCache, DatabaseRequests databaseRequests) {
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
        clientCache.setListWithWrathborneInvasionTimes(databaseRequests.getEventTimes("event_wrathborne_invasion_event", true));

        clientCache.setListWithHauntedCarriageEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_haunted_carriage"));
        clientCache.setListWithAncientArenaEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_ancient_arena"));
        clientCache.setListWithAncientNightmareEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_ancient_nightmare"));
        clientCache.setListWithDemonGateEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_demon_gates"));
    }
}