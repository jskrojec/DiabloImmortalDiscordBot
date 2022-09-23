package me.umbreon.diabloimmortalbot;

import me.umbreon.diabloimmortalbot.cache.*;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.database.MySQLDatabaseConnection;
import me.umbreon.diabloimmortalbot.events.*;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.notifier.CustomMessagesNotifier;
import me.umbreon.diabloimmortalbot.notifier.InfoNotifier;
import me.umbreon.diabloimmortalbot.notifier.Notifier;
import me.umbreon.diabloimmortalbot.cache.ClientCache;
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
        GuildsCache guildsCache = new GuildsCache();
        CustomMessagesCache customMessagesCache = new CustomMessagesCache();
        GameEventsCache gameEventsCache = new GameEventsCache();
        NotificationChannelsCache notificationChannelsCache = new NotificationChannelsCache();

        BasicConfigurator.configure();
        clientConfig.loadConfig();
        ClientLogger.checkIfLogFolderExists(clientConfig.getLogFolderPath());
        LanguageController.loadConfigurations();

        MySQLDatabaseConnection mySQLDatabaseConnection = new MySQLDatabaseConnection(clientConfig);
        DatabaseRequests databaseRequests = new DatabaseRequests(mySQLDatabaseConnection);

        ReactionRolesCache reactionRolesCache = new ReactionRolesCache();
        loadCache(clientCache, guildsCache, customMessagesCache, gameEventsCache, notificationChannelsCache, databaseRequests, reactionRolesCache);

        JDA jda;
        try {
            jda = JDABuilder.createDefault(clientConfig.getToken())
                    .addEventListeners(new ChannelDelete(clientCache, databaseRequests, notificationChannelsCache))
                    .addEventListeners(new SlashCommandInteraction(clientCache, databaseRequests, reactionRolesCache, guildsCache, notificationChannelsCache, customMessagesCache))
                    .addEventListeners(new GuildJoin())
                    .addEventListeners(new GuildReady())
                    .addEventListeners(new MessageReactionAdd(reactionRolesCache))
                    .addEventListeners(new MessageReactionRemove(reactionRolesCache))
                    .addEventListeners(new MessageDelete(reactionRolesCache, databaseRequests))
                    .build()
                    .awaitReady();
        } catch (LoginException | InterruptedException e) {
            ClientLogger.createNewErrorLogEntry(e);
            e.printStackTrace();
            return;
        }

        Notifier notifier = new Notifier(clientCache, notificationChannelsCache, gameEventsCache, guildsCache);
        CustomMessagesNotifier customMessagesNotifier = new CustomMessagesNotifier(clientCache, databaseRequests, guildsCache, customMessagesCache);
        InfoNotifier infoNotifier = new InfoNotifier();

        notifier.runNotificationScheduler(jda);
        customMessagesNotifier.runCustomMessagesNotifierScheduler(jda);
        infoNotifier.runScheduler(jda);
    }

    private static void loadCache(ClientCache clientCache, GuildsCache guildsCache, CustomMessagesCache customMessagesCache, GameEventsCache gameEventsCache, NotificationChannelsCache notificationChannelsCache, DatabaseRequests databaseRequests, ReactionRolesCache reactionRolesCache) {
        clientCache.fillListWithEvents();
        clientCache.fillListWithAvailableEventDays();

        notificationChannelsCache.setNotifierChannelsList(databaseRequests.getAllNotifierChannels());
        guildsCache.setListWithGuildInformation(databaseRequests.getAllGuilds());
        customMessagesCache.setCustomMessagesList(databaseRequests.getAllCustomMessages());
        reactionRolesCache.setReactionRolesCache(databaseRequests.getAllReactionRolesData());

        gameEventsCache.setListWithShadowLotteryTimes(databaseRequests.getEventTimes("event_shadow_lottery", true));
        gameEventsCache.setListWithVaultTimes(databaseRequests.getEventTimes("event_vault", true));
        gameEventsCache.setListWithHauntedCarriageTimes(databaseRequests.getEventTimes("event_haunted_carriage", false));
        gameEventsCache.setListWithDemonGatesTimes(databaseRequests.getEventTimes("event_demon_gates", false));
        gameEventsCache.setListWithBattlegroundTimes(databaseRequests.getEventTimes("event_battleground", true));
        gameEventsCache.setListWithAncientAreaTimes(databaseRequests.getEventTimes("event_ancient_area", false));
        gameEventsCache.setListWithAncientNightmareTimes(databaseRequests.getEventTimes("event_ancient_nightmare", false));
        gameEventsCache.setListWithAssemblyTimes(databaseRequests.getEventTimes("event_assembly", false));
        gameEventsCache.setListWithWrathborneInvasionTimes(databaseRequests.getEventTimes("event_wrathborne_invasion_event", true));

        gameEventsCache.setListWithHauntedCarriageEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_haunted_carriage"));
        gameEventsCache.setListWithAncientArenaEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_ancient_arena"));
        gameEventsCache.setListWithAncientNightmareEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_ancient_nightmare"));
        gameEventsCache.setListWithDemonGateEmbedTimes(databaseRequests.getOverworldEventTimes("overworld_demon_gates"));
    }

}