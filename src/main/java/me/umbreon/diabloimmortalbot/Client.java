package me.umbreon.diabloimmortalbot;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.database.MySQLDatabaseConnection;
import me.umbreon.diabloimmortalbot.events.ChannelDelete;
import me.umbreon.diabloimmortalbot.events.GuildJoin;
import me.umbreon.diabloimmortalbot.events.GuildReady;
import me.umbreon.diabloimmortalbot.events.SlashCommandInteraction;
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
import java.util.List;

public class Client {

    public static void main(final String[] args) {

        final ClientCache clientCache = new ClientCache();
        final ClientConfig clientConfig = new ClientConfig();
        BasicConfigurator.configure();
        try {
            clientConfig.loadConfig();
        } catch (final Exception e) {
            System.out.println("config.properties is null! Shutting down...");
            return;
        }

        ClientLogger.checkIfLogFolderExists(clientConfig.getLogFolderPath());

        LanguageController.loadConfigurations();

        final MySQLDatabaseConnection mySQLDatabaseConnection = new MySQLDatabaseConnection(clientConfig);
        final DatabaseRequests databaseRequests = new DatabaseRequests(mySQLDatabaseConnection);

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

        final JDA jda;
        try {
            jda = JDABuilder.createDefault(clientConfig.getToken())
                    //.addEventListeners(new MessageReceived(databaseRequests, clientCache))
                    .addEventListeners(new ChannelDelete(clientCache, databaseRequests))
                    .addEventListeners(new SlashCommandInteraction(clientCache, databaseRequests))
                    .addEventListeners(new GuildJoin())
                    .addEventListeners(new GuildReady())
                    .build()
                    .awaitReady();
        } catch (final LoginException | InterruptedException e) {
            ClientLogger.createNewErrorLogEntry(e);
            return;
        }

        final Notifier notifier = new Notifier(clientCache);
        final CustomMessagesNotifier customMessagesNotifier = new CustomMessagesNotifier(clientCache, databaseRequests);
        BasicConfigurator.configure();

        notifier.runScheduler(jda);
        customMessagesNotifier.runCustomMessagesNotifierScheduler(jda);

        //checkAllStrings(clientCache.getListWithSupportedLanguage());
    }

    private static void checkAllStrings(final List<String> e) {
        for (final String lang : e) {
            System.out.println(lang);
            System.out.println(LanguageController.getHauntedCarriageMessage(lang));
            System.out.println(LanguageController.getHauntedCarriageHeadUpMessage(lang));
            System.out.println(LanguageController.getDemonGatesMessage(lang));
            System.out.println(LanguageController.getDemonGatesHeadUpMessage(lang));
            System.out.println(LanguageController.getBattlegroundMessage(lang));
            System.out.println(LanguageController.getBattlegroundHeadUpMessage(lang));
            System.out.println(LanguageController.getAncientNightmareMessage(lang));
            System.out.println(LanguageController.getAncientNightmareHeadUpMessage(lang));
            System.out.println(LanguageController.getRaidTheVaultMessage(lang));
            System.out.println(LanguageController.getRaidTheVaultHeadUpMessage(lang));
            System.out.println(LanguageController.getDefendTheVaultMessage(lang));
            System.out.println(LanguageController.getDefendTheVaultHeadUpMessage(lang));
            System.out.println(LanguageController.getAncientArenaMessage(lang));
            System.out.println(LanguageController.getAncientArenaHeadUpMessage(lang));
            System.out.println(LanguageController.getAssemblyMessage(lang));
            System.out.println(LanguageController.getAssemblyHeadUpMessage(lang));
            System.out.println(LanguageController.getShadowLotteryMessage(lang));
            System.out.println(LanguageController.getShadowLotteryHeadUpMessage(lang));
            System.out.println(LanguageController.getWrathborneInvasionMessage(lang));
            System.out.println(LanguageController.getWrathborneInvasionHeadUpMessage(lang));
            System.out.println(LanguageController.getEventEnabledMessage(lang));
            System.out.println(LanguageController.getEventDisabledMessage(lang));
            System.out.println(LanguageController.getChannelRegisteredMessage(lang));
            System.out.println(LanguageController.getChannelAlreadyRegisteredMessage(lang));
            System.out.println(LanguageController.getRoleNotFoundMessage(lang));
            System.out.println(LanguageController.getChannelNotRegisteredMessage(lang));
            System.out.println(LanguageController.getTimezoneChangedMessage(lang));
            System.out.println(LanguageController.getChannelUnregisteredMessage(lang));
            System.out.println(LanguageController.getChannelNotFoundMessage(lang));
            System.out.println(LanguageController.getUnknownTimezoneMessage(lang));
            System.out.println(LanguageController.getRoleChangedMessage(lang));
            System.out.println(LanguageController.getLanguageNotSupportedMessage(lang));
            System.out.println(LanguageController.getLanguageUpdatedMessage(lang));
            System.out.println(LanguageController.getLanguageMessage(lang));
            System.out.println(LanguageController.getCustomMessageCreatedMessage(lang));
            System.out.println(LanguageController.getNoCustomMessagesMessage(lang));
            System.out.println(LanguageController.getShowAllCustomMessages(lang));
            System.out.println(LanguageController.getCustomMessageWithIdDeleted(lang));
            System.out.println(LanguageController.getEmbedSpawnAtMessage(lang));
            System.out.println(LanguageController.getEmbedCountdownMessage(lang));
            System.out.println(LanguageController.getEmbedWorldEventMessage(lang));
            System.out.println(LanguageController.getInvalidTimezoneMessage(lang));
            System.out.println(LanguageController.getInvalidCommandMessage(lang));
            System.out.println(LanguageController.getCustomMessageWhatChannelMessage(lang));
            System.out.println(LanguageController.getCustomMessageWhatDayMessage(lang));
            System.out.println(LanguageController.getCustomMessageWhatTimeMessage(lang));
            System.out.println(LanguageController.getCustomMessageWhatMessageMessage(lang));
            System.out.println(LanguageController.getCustomMessageIsRepeatingMessage(lang));
            System.out.println(LanguageController.getYesOrNoMessage(lang));
            System.out.println(LanguageController.getCustomMessageInvalidDayMessage(lang));
            System.out.println(LanguageController.getShowsBotInstallMessage(lang));
            System.out.println(LanguageController.getShowsThisMessageMessage(lang));
            System.out.println(LanguageController.getSupportDiscordMessage(lang));
            System.out.println(LanguageController.getShortHoursMessage(lang));
            System.out.println(LanguageController.getErrorOccurredMessage(lang));
            System.out.println(LanguageController.getHelpRegistersChannelMessage(lang));
            System.out.println(LanguageController.getHelpUnregistersChannelMessage(lang));
            System.out.println(LanguageController.getHelpSetRoleMessage(lang));
            System.out.println(LanguageController.getHelpShowInfoMessage(lang));
            System.out.println(LanguageController.getHelpCreateCustomMessageMessage(lang));
            System.out.println(LanguageController.getHelpDeleteCustomMessageMessage(lang));
            System.out.println(LanguageController.getHelpShowAllCustomMessagesMessage(lang));
            System.out.println(LanguageController.getHelpShowCustomMessageInfoMessage(lang));
            System.out.println(LanguageController.getHelpServerHeadUpMessage(lang));
            System.out.println(LanguageController.getHelpServerMessagesMessage(lang));
            System.out.println(LanguageController.getHelpServerConfigMessage(lang));
            System.out.println(LanguageController.getHelpServerLanguageMessage(lang));
            System.out.println(LanguageController.getHelpServerTimezoneMessage(lang));
            System.out.println(LanguageController.getHelpServerAutoDeleteSetMessage(lang));
            System.out.println(LanguageController.getHelpServerAutoDeleteValueMessage(lang));
            System.out.println(LanguageController.getAncientArenaEmbedMessage(lang));
            System.out.println(LanguageController.getLocationAncientArenaEmbedMessage1(lang));
            System.out.println(LanguageController.getLocationAncientArenaEmbedMessage2(lang));
            System.out.println(LanguageController.getAncientNightmareEmbedMessage(lang));
            System.out.println(LanguageController.getLocationAncientNightmareEmbedMessage1(lang));
            System.out.println(LanguageController.getLocationAncientNightmareEmbedMessage2(lang));
            System.out.println(LanguageController.getDemonGatesEmbedMessage(lang));
            System.out.println(LanguageController.getLocationDemonGatesEmbedMessage1(lang));
            System.out.println(LanguageController.getLocationDemonGatesEmbedMessage2(lang));
            System.out.println(LanguageController.getHauntedCarriageEmbedMessage(lang));
            System.out.println(LanguageController.getLocationHauntedCarriageEmbedMessage1(lang));
            System.out.println(LanguageController.getLocationHauntedCarriageEmbedMessage2(lang));
            System.out.println(LanguageController.getInstall1Message(lang));
            System.out.println(LanguageController.getInstall2Message(lang));
            System.out.println(LanguageController.getInstall3Message(lang));
            System.out.println(LanguageController.getInstall4Message(lang));
            System.out.println(LanguageController.getInstall5Message(lang));
            System.out.println(LanguageController.getInstructionsMessage(lang));
            System.out.println(LanguageController.getInfoTimezoneMessage(lang));
            System.out.println(LanguageController.getInfoCurrentTimeMessage(lang));
            System.out.println(LanguageController.getInfoTextChannelIDMessage(lang));
            System.out.println(LanguageController.getInfoMentionedRoleMessage(lang));
            System.out.println(LanguageController.getInfoYesMessage(lang));
            System.out.println(LanguageController.getInfoNoMessage(lang));
            System.out.println(LanguageController.getInfoEventMessageMessage(lang));
            System.out.println(LanguageController.getInfoHeadUpMessageMessage(lang));
            System.out.println(LanguageController.getInfoAncientNightmareMessage(lang));
            System.out.println(LanguageController.getInfoAncientArenaMessage(lang));
            System.out.println(LanguageController.getInfoAssemblyMessage(lang));
            System.out.println(LanguageController.getInfoBattlegroundMessage(lang));
            System.out.println(LanguageController.getInfoDefendTheVaultMessage(lang));
            System.out.println(LanguageController.getInfoRaidTheVaultMessage(lang));
            System.out.println(LanguageController.getInfoDemonGatesMessage(lang));
            System.out.println(LanguageController.getInfoShadowLotteryMessage(lang));
            System.out.println(LanguageController.getInfoHauntedCarriageMessage(lang));
            System.out.println(LanguageController.getInfoWrathborneInvasionMessage(lang));
            System.out.println(LanguageController.getInfoHauntedCarriageEmbedMessage(lang));
            System.out.println(LanguageController.getInfoDemonGatesEmbedMessage(lang));
            System.out.println(LanguageController.getInfoAncientNightmareEmbedMessage(lang));
            System.out.println(LanguageController.getInfoAncientArenaEmbedMessage(lang));
            System.out.println(LanguageController.getErrorCannotDisableEventMessage(lang));
            System.out.println(LanguageController.getFooterCreatedByMessage(lang));
            System.out.println(LanguageController.getFooterReportToDevMessage(lang));
            System.out.println(LanguageController.getAutoDeleteEnabledMessage(lang));
            System.out.println(LanguageController.getAutoDeleteDisabledMessage(lang));
            System.out.println(LanguageController.getAutoDeleteValueSetMessage(lang));
            System.out.println(LanguageController.getInfoLanguageMessage(lang));
            System.out.println(LanguageController.getInfoGuildIdMessage(lang));
            System.out.println(LanguageController.getEventMessagesAlreadyOnMessage(lang));
            System.out.println(LanguageController.getEventMessagesAlreadyOffMessage(lang));
            System.out.println(LanguageController.getHeadUpMessagesAlreadyOnMessage(lang));
            System.out.println(LanguageController.getHeadUpMessagesAlreadyOffMessages(lang));
            System.out.println(LanguageController.getFooterTimesIn24HrsFormatMessage(lang));
            System.out.println(LanguageController.getHelpEventListMessage(lang));
            System.out.println(LanguageController.getHelpEventSetMessage(lang));
        }
    }
}