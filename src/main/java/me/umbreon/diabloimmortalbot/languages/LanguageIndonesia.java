package me.umbreon.diabloimmortalbot.languages;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LanguageIndonesia {

    private static final Map<String, Object> messages;

    static {
        Yaml yaml = new Yaml();
        InputStream inputStream = LanguageIndonesia.class.getClassLoader().getResourceAsStream("languages/indonesia.yaml");
        messages = yaml.load(inputStream);
    }

    private LanguageIndonesia() {
        //All static methods.
    }

    // Event messages
    static String getHauntedCarriageMessage() {
        return messages.get("event-haunted-carriage").toString();
    }

    static String getHauntedCarriageHeadUpMessage() {
        return messages.get("event-haunted-carriage-headup").toString();
    }

    static String getDemonGatesMessage() {
        return messages.get("event-demon-gates").toString();
    }

    static String getDemonGatesHeadUpMessage() {
        return messages.get("event-demon-gates-headup").toString();
    }

    static String getBattlegroundMessage() {
        return messages.get("event-battleground").toString();
    }

    static String getBattlegroundHeadUpMessage() {
        return messages.get("event-battleground-headup").toString();
    }

    static String getAncientNightmareMessage() {
        return messages.get("event-ancient-nightmare").toString();
    }

    static String getAncientNightmareHeadUpMessage() {
        return messages.get("event-ancient-nightmare-headup").toString();
    }

    static String getRaidTheVaultMessage() {
        return messages.get("event-raid-vault").toString();
    }

    static String getRaidTheVaultHeadUpMessage() {
        return messages.get("event-raid-vault-headup").toString();
    }

    static String getDefendTheVaultMessage() {
        return messages.get("event-defend-vault").toString();
    }

    static String getDefendTheVaultHeadUpMessage() {
        return messages.get("event-defend-vault-headup").toString();
    }

    static String getAncientArenaMessage() {
        return messages.get("event-ancient-arena").toString();
    }

    static String getAncientArenaHeadUpMessage() {
        return messages.get("event-ancient-arena-headup").toString();
    }

    static String getAssemblyMessage() {
        return messages.get("event-assembly").toString();
    }

    static String getAssemblyHeadUpMessage() {
        return messages.get("event-assembly-headup").toString();
    }

    static String getShadowLotteryMessage() {
        return messages.get("event-shadow-lottery").toString();
    }

    static String getShadowLotteryHeadUpMessage() {
        return messages.get("event-shadow-lottery-headup").toString();
    }

    static String getWrathborneInvasionMessage() {
        return messages.get("event-wrathborne-invasion").toString();
    }

    static String getWrathborneInvasionHeadUpMessage() {
        return messages.get("event-wrathborne-invasion-headup").toString();
    }

    static String getEventEnabledMessage() {
        return messages.get("event-enabled").toString();
    }

    static String getEventDisabledMessage() {
        return messages.get("event-disabled").toString();
    }

    //Command Messages

    static String getChannelRegisteredMessage() {
        return messages.get("channel-registered").toString();
    }

    static String getChannelAlreadyRegisteredMessage() {
        return messages.get("channel-already-registered").toString();
    }

    static String getRoleNotFoundMessage() {
        return messages.get("role-not-found").toString();
    }

    static String getChannelNotRegisteredMessage() {
        return messages.get("channel-not-registered").toString();
    }

    static String getTimezoneChangedMessage() {
        return messages.get("timezone-changed").toString();
    }

    static String getChannelUnregisteredMessage() {
        return messages.get("channel-unregistered").toString();
    }

    static String getChannelNotFoundMessage() {
        return messages.get("channel-not-found").toString();
    }

    static String getUnknownTimezoneMessage() {
        return messages.get("unknown-timezone").toString();
    }

    static String getRoleChangedMessage() {
        return messages.get("role-changed").toString();
    }

    static String getLanguageNotSupportedMessage() {
        return messages.get("language-not-supported").toString();
    }

    static String getLanguageUpdatedMessage() {
        return messages.get("language-updated").toString();
    }

    static String getLanguageMessage() {
        return messages.get("language").toString();
    }

    // Custom Message Messages

    static String getCustomMessageCreatedMessage() {
        return messages.get("custom-message-created").toString();
    }

    static String getNoCustomMessagesMessage() {
        return messages.get("no-custom-messages").toString();
    }

    static String getShowAllCustomMessages() {
        return messages.get("show-all-custom-messages").toString();
    }

    static String getCustomMessageWithIdDeleted() {
        return messages.get("custom-message-with-id-deleted").toString();
    }


    static String getEmbedSpawnAtMessage() {
        return messages.get("embed-spawn-at").toString();
    }

    static String getEmbedCountdownMessage() {
        return messages.get("embed-countdown").toString();
    }

    static String getEmbedWorldEventMessage() {
        return messages.get("embed-world-event").toString();
    }

    static String getInvalidTimezoneMessage() {
        return messages.get("invalid-timezone").toString();
    }

    static String getInvalidCommandMessage() {
        return messages.get("invalid-command").toString();
    }

    static String getCustomMessageWhatChannelMessage() {
        return messages.get("custom-message-what-channel").toString();
    }


    static String getCustomMessageWhatDayMessage() {
        return messages.get("custom-message-what-day").toString();
    }

    static String getCustomMessageWhatTimeMessage() {
        return messages.get("custom-message-what-time").toString();
    }

    static String getCustomMessageWhatMessageMessage() {
        return messages.get("custom-message-what-message").toString();
    }

    static String getCustomMessageIsRepeatingMessage() {
        return messages.get("custom-message-is-repeating").toString();
    }

    static String getYesOrNoMessage() {
        return messages.get("yes-or-no").toString();
    }

    static String getCustomMessageInvalidDayMessage() {
        return messages.get("custom-message-invalid-day").toString();
    }

    static String getShowsBotInstallMessage() {
        return messages.get("help-show-bot-install").toString();
    }

    static String getShowsThisMessageMessage() {
        return messages.get("help-show-help").toString();
    }

    static String getSupportDiscordMessage() {
        return messages.get("footer-support-on-discord").toString();
    }

    static String getShortHoursMessage() {
        return messages.get("short-hours").toString();
    }

    static String getErrorOccurredMessage() {
        return messages.get("error-occurred").toString();
    }

    //Help Messages

    static String getHelpRegistersChannelMessage() {
        return messages.get("help-registers-channel").toString();
    }

    static String getHelpUnregistersChannelMessage() {
        return messages.get("help-unregister-channel").toString();
    }

    static String getHelpSetRoleMessage() {
        return messages.get("help-set-role").toString();
    }

    static String getHelpShowInfoMessage() {
        return messages.get("help-show-info").toString();
    }

    static String getHelpCreateCustomMessageMessage() {
        return messages.get("help-create-cm").toString();
    }

    static String getHelpDeleteCustomMessageMessage() {
        return messages.get("help-delete-cm").toString();
    }

    static String getHelpShowAllCustomMessagesMessage() {
        return messages.get("help-show-all-cm").toString();
    }

    static String getHelpShowCustomMessageInfoMessage() {
        return messages.get("help-show-cm-info").toString();
    }

    static String getHelpServerHeadUpMessage() {
        return messages.get("help-server-headup").toString();
    }

    static String getHelpServerMessagesMessage() {
        return messages.get("help-server-messages").toString();
    }

    static String getHelpServerConfigMessage() {
        return messages.get("help-server-config").toString();
    }

    static String getHelpServerLanguageMessage() {
        return messages.get("help-server-language").toString();
    }

    static String getHelpServerTimezoneMessage() {
        return messages.get("help-server-timezone").toString();
    }

    static String getHelpServerAutoDeleteSetMessage() {
        return messages.get("help-server-autodelete-set").toString();
    }

    static String getHelpServerAutoDeleteValueMessage() {
        return messages.get("help-server-autodelete-value").toString();
    }

    static String getAncientArenaEmbedMessage() {
        return messages.get("event-ancient-arena-embed").toString();
    }

    static String getLocationAncientArenaEmbedMessage1() {
        return messages.get("event-ancient-arena-location1").toString();
    }

    static String getLocationAncientArenaEmbedMessage2() {
        return messages.get("event-ancient-arena-location2").toString();
    }

    static String getAncientNightmareEmbedMessage() {
        return messages.get("event-ancient-nightmare-embed").toString();
    }

    static String getLocationAncientNightmareEmbedMessage1() {
        return messages.get("event-ancient-nightmare-location1").toString();
    }

    static String getLocationAncientNightmareEmbedMessage2() {
        return messages.get("event-ancient-nightmare-location2").toString();
    }

    static String getDemonGatesEmbedMessage() {
        return messages.get("event-demon-gates-embed").toString();
    }

    static String getLocationDemonGatesEmbedMessage1() {
        return messages.get("event-demon-gates-location1").toString();
    }

    static String getLocationDemonGatesEmbedMessage2() {
        return messages.get("event-demon-gates-location2").toString();
    }

    static String getHauntedCarriageEmbedMessage() {
        return messages.get("event-haunted-carriage-embed").toString();
    }

    static String getLocationHauntedCarriageEmbedMessage1() {
        return messages.get("event-haunted-carriage-location1").toString();
    }

    static String getLocationHauntedCarriageEmbedMessage2() {
        return messages.get("event-haunted-carriage-location2").toString();
    }

    static String getInstall1Message() {
        return messages.get("install-first").toString();
    }

    static String getInstall2Message() {
        return messages.get("install-second").toString();
    }

    static String getInstall3Message() {
        return messages.get("install-third").toString();
    }

    static String getInstall4Message() {
        return messages.get("install-fourth").toString();
    }

    static String getInstall5Message() {
        return messages.get("install-fifth").toString();
    }

    static String getInstructionsMessage() {
        return messages.get("install").toString();
    }

    static String getInfoTimezoneMessage() {
        return messages.get("info-timezone").toString();
    }

    static String getInfoCurrentTimeMessage() {
        return messages.get("info-current-time").toString();
    }

    static String getInfoTextChannelIDMessage() {
        return messages.get("info-text-channel-id").toString();
    }

    static String getInfoMentionedRoleMessage() {
        return messages.get("info-mentioned-role").toString();
    }

    static String getInfoYesMessage() {
        return messages.get("info-yes").toString();
    }

    static String getInfoNoMessage() {
        return messages.get("info-no").toString();
    }

    static String getInfoEventMessageMessage() {
        return messages.get("info-event-message").toString();
    }

    static String getInfoHeadUpMessageMessage() {
        return messages.get("info-headup-message").toString();
    }

    static String getInfoAncientNightmareMessage() {
        return messages.get("info-ancient-nightmare").toString();
    }

    static String getInfoAncientArenaMessage() {
        return messages.get("info-ancient-arena").toString();
    }

    static String getInfoAssemblyMessage() {
        return messages.get("info-assembly").toString();
    }

    static String getInfoBattlegroundMessage() {
        return messages.get("info-battlegrounds").toString();
    }

    static String getInfoDefendTheVaultMessage() {
        return messages.get("info-defend-the-vault").toString();
    }

    static String getInfoRaidTheVaultMessage() {
        return messages.get("info-raid-the-vault").toString();
    }

    static String getInfoDemonGatesMessage() {
        return messages.get("info-demon-gates").toString();
    }

    static String getInfoShadowLotteryMessage() {
        return messages.get("info-shadow-lottery").toString();
    }

    static String getInfoHauntedCarriageMessage() {
        return messages.get("info-haunted-carriage").toString();
    }

    static String getInfoWrathborneInvasionMessage() {
        return messages.get("info-wrathborne-invasion").toString();
    }

    static String getInfoHauntedCarriageEmbedMessage() {
        return messages.get("info-haunted-carriage-embed").toString();
    }

    static String getInfoDemonGatesEmbedMessage() {
        return messages.get("info-demon-gates-embed").toString();
    }

    static String getInfoAncientNightmareEmbedMessage() {
        return messages.get("info-ancient-nightmare-embed").toString();
    }

    static String getInfoAncientArenaEmbedMessage() {
        return messages.get("info-ancient-arena-embed").toString();
    }

    static String getErrorCannotDisableEventMessage() {
        return messages.get("error-cannot-disable-event").toString();
    }

    static String getFooterCreatedByMessage() {
        return messages.get("footer-created-by").toString();
    }

    static String getFooterReportToDevMessage() {
        return messages.get("footer-report-to-dev").toString();
    }

    static String getAutoDeleteEnabledMessage() {
        return messages.get("autodelete-enabled").toString();
    }

    static String getAutoDeleteDisabledMessage() {
        return messages.get("autodelete-disabled").toString();
    }

    static String getAutoDeleteValueSetMessage() {
        return messages.get("autodelete-value-set").toString();
    }

    static String getInfoLanguageMessage() {
        return messages.get("info-language").toString();
    }

    static String getInfoGuildIdMessage() {
        return messages.get("info-guild-id").toString();
    }

    static String getEventMessagesAlreadyOnMessage() {
        return messages.get("event-messages-already-on").toString();
    }

    static String getEventMessagesAlreadyOffMessage() {
        return messages.get("event-messages-already-off").toString();
    }

    static String getHeadUpMessagesAlreadyOnMessage() {
        return messages.get("headup-messages-already-on").toString();
    }

    static String getHeadUpMessagesAlreadyOffMessages() {
        return messages.get("headup-messages-already-off").toString();
    }

    static String getFooterTimesIn24HrsFormatMessage() {
        return messages.get("footer-times-in-24h-format").toString();
    }

    static String getHelpEventListMessage() {
        return messages.get("help-event-list").toString();
    }

    static String getHelpEventSetMessage() {
        return messages.get("help-event-set").toString();
    }
}
