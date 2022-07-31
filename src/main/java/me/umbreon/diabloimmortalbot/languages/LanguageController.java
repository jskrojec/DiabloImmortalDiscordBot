package me.umbreon.diabloimmortalbot.languages;

public class LanguageController {

    public static void loadConfigurations() {
        LanguageEnglish languageEnglish = new LanguageEnglish();
        languageEnglish.loadLanguageConfiguration();

        LanguageGerman languageGerman = new LanguageGerman();
        languageGerman.loadLanguageConfiguration();

        LanguageSpain languageSpain = new LanguageSpain();
        languageSpain.loadLanguageConfiguration();

        LanguagePolish languagePolish = new LanguagePolish();
        languagePolish.loadLanguageConfiguration();

        LanguageFrench languageFrench = new LanguageFrench();
        languageFrench.loadLanguageConfiguration();

        LanguageItalian languageItalian = new LanguageItalian();
        languageItalian.loadLanguageConfiguration();
    }

    public static String getHauntedCarriageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHauntedCarriageMessage();
            case "ESP":
                return LanguageSpain.getHauntedCarriageMessage();
            case "POL":
                return LanguagePolish.getHauntedCarriageMessage();
            case "FRA":
                return LanguageFrench.getHauntedCarriageMessage();
            case "ITA":
                return LanguageItalian.getHauntedCarriageMessage();
            default:
                return LanguageEnglish.getHauntedCarriageMessage();
        }
    }

    public static String getHauntedCarriageHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHauntedCarriageHeadUpMessage();
            case "ESP":
                return LanguageSpain.getHauntedCarriageHeadUpMessage();
            case "POL":
                return LanguagePolish.getHauntedCarriageHeadUpMessage();
            case "FRA":
                return LanguageFrench.getHauntedCarriageHeadUpMessage();
            case "ITA":
                return LanguageItalian.getHauntedCarriageHeadUpMessage();
            default:
                return LanguageEnglish.getHauntedCarriageHeadUpMessage();
        }
    }

    public static String getDemonGatesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDemonGatesMessage();
            case "ESP":
                return LanguageSpain.getDemonGatesMessage();
            case "POL":
                return LanguagePolish.getDemonGatesMessage();
            case "FRA":
                return LanguageFrench.getDemonGatesMessage();
            case "ITA":
                return LanguageItalian.getDemonGatesMessage();
            default:
                return LanguageEnglish.getDemonGatesMessage();
        }
    }

    public static String getDemonGatesHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDemonGatesHeadUpMessage();
            case "ESP":
                return LanguageSpain.getDemonGatesHeadUpMessage();
            case "POL":
                return LanguagePolish.getDemonGatesHeadUpMessage();
            case "FRA":
                return LanguageFrench.getDemonGatesHeadUpMessage();
            case "ITA":
                return LanguageItalian.getDemonGatesHeadUpMessage();
            default:
                return LanguageEnglish.getDemonGatesHeadUpMessage();
        }
    }

    public static String getBattlegroundMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getBattlegroundMessage();
            case "ESP":
                return LanguageSpain.getBattlegroundMessage();
            case "POL":
                return LanguagePolish.getBattlegroundMessage();
            case "FRA":
                return LanguageFrench.getBattlegroundMessage();
            case "ITA":
                return LanguageItalian.getBattlegroundMessage();
            default:
                return LanguageEnglish.getBattlegroundMessage();
        }
    }

    public static String getBattlegroundHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getBattlegroundHeadUpMessage();
            case "ESP":
                return LanguageSpain.getBattlegroundHeadUpMessage();
            case "POL":
                return LanguagePolish.getBattlegroundHeadUpMessage();
            case "FRA":
                return LanguageFrench.getBattlegroundHeadUpMessage();
            case "ITA":
                return LanguageItalian.getBattlegroundHeadUpMessage();
            default:
                return LanguageEnglish.getBattlegroundHeadUpMessage();
        }
    }

    public static String getAncientNightmareMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientNightmareMessage();
            case "ESP":
                return LanguageSpain.getAncientNightmareMessage();
            case "POL":
                return LanguagePolish.getAncientNightmareMessage();
            case "FRA":
                return LanguageFrench.getAncientNightmareMessage();
            case "ITA":
                return LanguageItalian.getAncientNightmareMessage();
            default:
                return LanguageEnglish.getAncientNightmareMessage();
        }
    }

    public static String getAncientNightmareHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientNightmareHeadUpMessage();
            case "ESP":
                return LanguageSpain.getAncientNightmareHeadUpMessage();
            case "POL":
                return LanguagePolish.getAncientNightmareHeadUpMessage();
            case "FRA":
                return LanguageFrench.getAncientNightmareHeadUpMessage();
            case "ITA":
                return LanguageItalian.getAncientNightmareHeadUpMessage();
            default:
                return LanguageEnglish.getAncientNightmareHeadUpMessage();
        }
    }

    public static String getAncientArenaMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientArenaMessage();
            case "ESP":
                return LanguageSpain.getAncientArenaMessage();
            case "POL":
                return LanguagePolish.getAncientArenaMessage();
            case "FRA":
                return LanguageFrench.getAncientArenaMessage();
            case "ITA":
                return LanguageItalian.getAncientArenaMessage();
            default:
                return LanguageEnglish.getAncientArenaMessage();
        }
    }

    public static String getAncientArenaHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientArenaHeadUpMessage();
            case "ESP":
                return LanguageSpain.getAncientArenaHeadUpMessage();
            case "POL":
                return LanguagePolish.getAncientArenaHeadUpMessage();
            case "FRA":
                return LanguageFrench.getAncientArenaHeadUpMessage();
            case "ITA":
                return LanguageItalian.getAncientArenaHeadUpMessage();
            default:
                return LanguageEnglish.getAncientArenaHeadUpMessage();
        }
    }

    public static String getAssemblyMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAssemblyMessage();
            case "ESP":
                return LanguageSpain.getAssemblyMessage();
            case "POL":
                return LanguagePolish.getAssemblyMessage();
            case "FRA":
                return LanguageFrench.getAssemblyMessage();
            case "ITA":
                return LanguageItalian.getAssemblyMessage();
            default:
                return LanguageEnglish.getAssemblyMessage();
        }
    }

    public static String getAssemblyHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAssemblyHeadUpMessage();
            case "ESP":
                return LanguageSpain.getAssemblyHeadUpMessage();
            case "POL":
                return LanguagePolish.getAssemblyHeadUpMessage();
            case "FRA":
                return LanguageFrench.getAssemblyHeadUpMessage();
            case "ITA":
                return LanguageItalian.getAssemblyHeadUpMessage();
            default:
                return LanguageEnglish.getAssemblyHeadUpMessage();
        }
    }

    public static String getShadowLotteryMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShadowLotteryMessage();
            case "ESP":
                return LanguageSpain.getShadowLotteryMessage();
            case "POL":
                return LanguagePolish.getShadowLotteryMessage();
            case "FRA":
                return LanguageFrench.getShadowLotteryMessage();
            case "ITA":
                return LanguageItalian.getShadowLotteryMessage();
            default:
                return LanguageEnglish.getShadowLotteryMessage();
        }
    }

    public static String getShadowLotteryHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShadowLotteryHeadUpMessage();
            case "ESP":
                return LanguageSpain.getShadowLotteryHeadUpMessage();
            case "POL":
                return LanguagePolish.getShadowLotteryHeadUpMessage();
            case "FRA":
                return LanguageFrench.getShadowLotteryHeadUpMessage();
            case "ITA":
                return LanguageItalian.getShadowLotteryHeadUpMessage();
            default:
                return LanguageEnglish.getShadowLotteryHeadUpMessage();
        }
    }

    public static String getRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRegisteredMessage();
            case "ESP":
                return LanguageSpain.getRegisteredMessage();
            case "POL":
                return LanguagePolish.getRegisteredMessage();
            case "FRA":
                return LanguageFrench.getRegisteredMessage();
            case "ITA":
                return LanguageItalian.getRegisteredMessage();
            default:
                return LanguageEnglish.getRegisteredMessage();
        }
    }

    public static String getAlreadyRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAlreadyRegisteredMessage();
            case "ESP":
                return LanguageSpain.getAlreadyRegisteredMessage();
            case "POL":
                return LanguagePolish.getAlreadyRegisteredMessage();
            case "FRA":
                return LanguageFrench.getAlreadyRegisteredMessage();
            case "ITA":
                return LanguageItalian.getAlreadyRegisteredMessage();
            default:
                return LanguageEnglish.getAlreadyRegisteredMessage();
        }
    }

    public static String getRoleNotFoundMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRoleNotFoundMessage();
            case "ESP":
                return LanguageSpain.getRoleNotFoundMessage();
            case "POL":
                return LanguagePolish.getRoleNotFoundMessage();
            case "FRA":
                return LanguageFrench.getRoleNotFoundMessage();
            case "ITA":
                return LanguageItalian.getRoleNotFoundMessage();
            default:
                return LanguageEnglish.getRoleNotFoundMessage();
        }
    }

    public static String getNotRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getNotRegisteredMessage();
            case "ESP":
                return LanguageSpain.getNotRegisteredMessage();
            case "POL":
                return LanguagePolish.getNotRegisteredMessage();
            case "FRA":
                return LanguageFrench.getNotRegisteredMessage();
            case "ITA":
                return LanguageItalian.getNotRegisteredMessage();
            default:
                return LanguageEnglish.getNotRegisteredMessage();
        }
    }

    public static String getReceiveAllMessagesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveAllMessagesMessage();
            case "ESP":
                return LanguageSpain.getReceiveAllMessagesMessage();
            case "POL":
                return LanguagePolish.getReceiveAllMessagesMessage();
            case "FRA":
                return LanguageFrench.getReceiveAllMessagesMessage();
            case "ITA":
                return LanguageItalian.getReceiveAllMessagesMessage();
            default:
                return LanguageEnglish.getReceiveAllMessagesMessage();
        }
    }

    public static String getReceiveImmortalMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveImmortalMessage();
            case "ESP":
                return LanguageSpain.getReceiveImmortalMessage();
            case "POL":
                return LanguagePolish.getReceiveImmortalMessage();
            case "FRA":
                return LanguageFrench.getReceiveImmortalMessage();
            case "ITA":
                return LanguageItalian.getReceiveImmortalMessage();
            default:
                return LanguageEnglish.getReceiveImmortalMessage();
        }
    }

    public static String getReceiveShadowMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveShadowMessage();
            case "ESP":
                return LanguageSpain.getReceiveShadowMessage();
            case "POL":
                return LanguagePolish.getReceiveShadowMessage();
            case "FRA":
                return LanguageFrench.getReceiveShadowMessage();
            case "ITA":
                return LanguageItalian.getReceiveShadowMessage();
            default:
                return LanguageEnglish.getReceiveShadowMessage();
        }
    }

    public static String getReceiveOwImmortalMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveOwImmortalMessage();
            case "ESP":
                return LanguageSpain.getReceiveOwImmortalMessage();
            case "POL":
                return LanguagePolish.getReceiveOwImmortalMessage();
            case "FRA":
                return LanguageFrench.getReceiveOwImmortalMessage();
            case "ITA":
                return LanguageItalian.getReceiveOwImmortalMessage();
            default:
                return LanguageEnglish.getReceiveOwImmortalMessage();
        }
    }

    public static String getReceiveOwShadowMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveOwShadowMessage();
            case "ESP":
                return LanguageSpain.getReceiveOwShadowMessage();
            case "POL":
                return LanguagePolish.getReceiveOwShadowMessage();
            case "FRA":
                return LanguageFrench.getReceiveOwShadowMessage();
            case "ITA":
                return LanguageItalian.getReceiveOwShadowMessage();
            default:
                return LanguageEnglish.getReceiveOwShadowMessage();
        }
    }

    public static String getReceiveOverworldMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveOverworldMessage();
            case "ESP":
                return LanguageSpain.getReceiveOverworldMessage();
            case "POL":
                return LanguagePolish.getReceiveOverworldMessage();
            case "FRA":
                return LanguageFrench.getReceiveOverworldMessage();
            case "ITA":
                return LanguageItalian.getReceiveOverworldMessage();
            default:
                return LanguageEnglish.getReceiveOverworldMessage();
        }
    }

    public static String getTimezoneSetToMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getTimezoneSetToMessage();
            case "ESP":
                return LanguageSpain.getTimezoneSetToMessage();
            case "POL":
                return LanguagePolish.getTimezoneSetToMessage();
            case "FRA":
                return LanguageFrench.getTimezoneSetToMessage();
            case "ITA":
                return LanguageItalian.getTimezoneSetToMessage();
            default:
                return LanguageEnglish.getTimezoneSetToMessage();
        }
    }

    public static String getUnregisteredChannel(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnregisteredChannel();
            case "ESP":
                return LanguageSpain.getUnregisteredChannel();
            case "POL":
                return LanguagePolish.getUnregisteredChannel();
            case "FRA":
                return LanguageFrench.getUnregisteredChannel();
            case "ITA":
                return LanguageItalian.getUnregisteredChannel();
            default:
                return LanguageEnglish.getUnregisteredChannel();
        }
    }

    public static String getUnknownTimezoneMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnknownTimezoneMessage();
            case "ESP":
                return LanguageSpain.getUnknownTimezoneMessage();
            case "POL":
                return LanguagePolish.getUnknownTimezoneMessage();
            case "FRA":
                return LanguageFrench.getUnknownTimezoneMessage();
            case "ITA":
                return LanguageItalian.getUnknownTimezoneMessage();
            default:
                return LanguageEnglish.getUnknownTimezoneMessage();
        }
    }

    public static String getUnknownStatusMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnknownStatusMessage();
            case "ESP":
                return LanguageSpain.getUnknownStatusMessage();
            case "POL":
                return LanguagePolish.getUnknownStatusMessage();
            case "FRA":
                return LanguageFrench.getUnknownStatusMessage();
            case "ITA":
                return LanguageItalian.getUnknownStatusMessage();
            default:
                return LanguageEnglish.getUnknownStatusMessage();
        }
    }

    public static String getIsSetMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getIsSetMessage();
            case "ESP":
                return LanguageSpain.getIsSetMessage();
            case "POL":
                return LanguagePolish.getIsSetMessage();
            case "FRA":
                return LanguageFrench.getIsSetMessage();
            case "ITA":
                return LanguageItalian.getIsSetMessage();
            default:
                return LanguageEnglish.getIsSetMessage();
        }
    }

    public static String getRaidTheVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRaidTheVaultMessage();
            case "ESP":
                return LanguageSpain.getRaidTheVaultMessage();
            case "POL":
                return LanguagePolish.getRaidTheVaultMessage();
            case "FRA":
                return LanguageFrench.getRaidTheVaultMessage();
            case "ITA":
                return LanguageItalian.getRaidTheVaultMessage();
            default:
                return LanguageEnglish.getRaidTheVaultMessage();
        }
    }

    public static String getRaidTheVaultHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRaidTheVaultHeadUpMessage();
            case "ESP":
                return LanguageSpain.getRaidTheVaultHeadUpMessage();
            case "POL":
                return LanguagePolish.getRaidTheVaultHeadUpMessage();
            case "FRA":
                return LanguageFrench.getRaidTheVaultHeadUpMessage();
            case "ITA":
                return LanguageItalian.getRaidTheVaultHeadUpMessage();
            default:
                return LanguageEnglish.getRaidTheVaultHeadUpMessage();
        }
    }

    public static String getDefendTheVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDefendTheVaultMessage();
            case "ESP":
                return LanguageSpain.getDefendTheVaultMessage();
            case "POL":
                return LanguagePolish.getDefendTheVaultMessage();
            case "FRA":
                return LanguageFrench.getDefendTheVaultMessage();
            case "ITA":
                return LanguageItalian.getDefendTheVaultMessage();
            default:
                return LanguageEnglish.getDefendTheVaultMessage();
        }
    }

    public static String getDefendTheVaultHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDefendTheVaultHeadUpMessage();
            case "ESP":
                return LanguageSpain.getDefendTheVaultHeadUpMessage();
            case "POL":
                return LanguagePolish.getDefendTheVaultHeadUpMessage();
            case "FRA":
                return LanguageFrench.getDefendTheVaultHeadUpMessage();
            case "ITA":
                return LanguageItalian.getDefendTheVaultHeadUpMessage();
            default:
                return LanguageEnglish.getDefendTheVaultHeadUpMessage();
        }
    }

    public static String getLanguageNotSupportedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLanguageNotSupportedMessage();
            case "ESP":
                return LanguageSpain.getLanguageNotSupportedMessage();
            case "POL":
                return LanguagePolish.getLanguageNotSupportedMessage();
            case "FRA":
                return LanguageFrench.getLanguageNotSupportedMessage();
            case "ITA":
                return LanguageItalian.getLanguageNotSupportedMessage();
            default:
                return LanguageEnglish.getLanguageNotSupportedMessage();
        }
    }

    public static String getLanguageUpdatedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLanguageUpdatedMessage();
            case "ESP":
                return LanguageSpain.getLanguageUpdatedMessage();
            case "POL":
                return LanguagePolish.getLanguageUpdatedMessage();
            case "FRA":
                return LanguageFrench.getLanguageUpdatedMessage();
            case "ITA":
                return LanguageItalian.getLanguageUpdatedMessage();
            default:
                return LanguageEnglish.getLanguageUpdatedMessage();
        }
    }

    public static String getHeadUpValueSetToMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpValueSetToMessage();
            case "ESP":
                return LanguageSpain.getHeadUpValueSetToMessage();
            case "POL":
                return LanguagePolish.getHeadUpValueSetToMessage();
            case "FRA":
                return LanguageFrench.getHeadUpValueSetToMessage();
            case "ITA":
                return LanguageItalian.getHeadUpValueSetToMessage();
            default:
                return LanguageEnglish.getHeadUpValueSetToMessage();
        }
    }

    public static String getLanguageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLanguageMessage();
            case "ESP":
                return LanguageSpain.getLanguageMessage();
            case "POL":
                return LanguagePolish.getLanguageMessage();
            case "FRA":
                return LanguageFrench.getLanguageMessage();
            case "ITA":
                return LanguageItalian.getLanguageMessage();
            default:
                return LanguageEnglish.getLanguageMessage();
        }
    }

    public static String getEventEnabledMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEventEnabledMessage();
            case "ESP":
                return LanguageSpain.getEventEnabledMessage();
            case "POL":
                return LanguagePolish.getEventEnabledMessage();
            case "FRA":
                return LanguageFrench.getEventEnabledMessage();
            case "ITA":
                return LanguageItalian.getEventEnabledMessage();
            default:
                return LanguageEnglish.getEventEnabledMessage();
        }
    }

    public static String getEventDisabledMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEventDisabledMessage();
            case "ESP":
                return LanguageSpain.getEventDisabledMessage();
            case "POL":
                return LanguagePolish.getEventDisabledMessage();
            case "FRA":
                return LanguageFrench.getEventDisabledMessage();
            case "ITA":
                return LanguageItalian.getEventDisabledMessage();
            default:
                return LanguageEnglish.getEventDisabledMessage();
        }
    }

    public static String getChannelNotFoundMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getChannelNotFoundMessage();
            case "ESP":
                return LanguageSpain.getChannelNotFoundMessage();
            case "POL":
                return LanguagePolish.getChannelNotFoundMessage();
            case "FRA":
                return LanguageFrench.getChannelNotFoundMessage();
            case "ITA":
                return LanguageItalian.getChannelNotFoundMessage();
            default:
                return LanguageEnglish.getChannelNotFoundMessage();
        }
    }

    public static String getDoBotGotRightsMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDoBotGotRightsMessage();
            case "ESP":
                return LanguageSpain.getDoBotGotRightsMessage();
            case "POL":
                return LanguagePolish.getDoBotGotRightsMessage();
            case "FRA":
                return LanguageFrench.getDoBotGotRightsMessage();
            case "ITA":
                return LanguageItalian.getDoBotGotRightsMessage();
            default:
                return LanguageEnglish.getDoBotGotRightsMessage();
        }
    }

    public static String getCustomMessageCreated(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageCreatedMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageCreatedMessage();
            case "POL":
                return LanguagePolish.getCustomMessageCreatedMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageCreatedMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageCreatedMessage();
            default:
                return LanguageEnglish.getCustomMessageCreatedMessage();
        }
    }

    public static String getNoCustomMessagesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getNoCustomMessagesMessage();
            case "ESP":
                return LanguageSpain.getNoCustomMessagesMessage();
            case "POL":
                return LanguagePolish.getNoCustomMessagesMessage();
            case "FRA":
                return LanguageFrench.getNoCustomMessagesMessage();
            case "ITA":
                return LanguageItalian.getNoCustomMessagesMessage();
            default:
                return LanguageEnglish.getNoCustomMessagesMessage();
        }
    }

    public static String getYourCustomMessagesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getYourCustomMessagesMessage();
            case "ESP":
                return LanguageSpain.getYourCustomMessagesMessage();
            case "POL":
                return LanguagePolish.getYourCustomMessagesMessage();
            case "FRA":
                return LanguageFrench.getYourCustomMessagesMessage();
            case "ITA":
                return LanguageItalian.getYourCustomMessagesMessage();
            default:
                return LanguageEnglish.getYourCustomMessagesMessage();
        }
    }

    public static String getCustomMessageDeletedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageDeletedMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageDeletedMessage();
            case "POL":
                return LanguagePolish.getCustomMessageDeletedMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageDeletedMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageDeletedMessage();
            default:
                return LanguageEnglish.getCustomMessageDeletedMessage();
        }
    }

    public static String getCustomMessageWithIdDeleted(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageWithIdDeleted();
            case "ESP":
                return LanguageSpain.getCustomMessageWithIdDeleted();
            case "POL":
                return LanguagePolish.getCustomMessageWithIdDeleted();
            case "FRA":
                return LanguageFrench.getCustomMessageWithIdDeleted();
            case "ITA":
                return LanguageItalian.getCustomMessageWithIdDeleted();
            default:
                return LanguageEnglish.getCustomMessageWithIdDeleted();
        }
    }

    public static String getInvalidCommandMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInvalidCommandMessage();
            case "ESP":
                return LanguageSpain.getInvalidCommandMessage();
            case "POL":
                return LanguagePolish.getInvalidCommandMessage();
            case "FRA":
                return LanguageFrench.getInvalidCommandMessage();
            case "ITA":
                return LanguageItalian.getInvalidCommandMessage();
            default:
                return LanguageEnglish.getInvalidCommandMessage();
        }
    }

    public static String getAncientArenaEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientArenaEmbedMessage();
            case "ESP":
                return LanguageSpain.getAncientArenaEmbedMessage();
            case "POL":
                return LanguagePolish.getAncientArenaEmbedMessage();
            case "FRA":
                return LanguageFrench.getAncientArenaEmbedMessage();
            case "ITA":
                return LanguageItalian.getAncientArenaEmbedMessage();
            default:
                return LanguageEnglish.getAncientArenaEmbedMessage();
        }
    }

    public static String getLocationAncientArenaEmbedMessage1(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationAncientArenaEmbedMessage1();
            case "ESP":
                return LanguageSpain.getLocationAncientArenaEmbedMessage1();
            case "POL":
                return LanguagePolish.getLocationAncientArenaEmbedMessage1();
            case "FRA":
                return LanguageFrench.getLocationAncientArenaEmbedMessage1();
            case "ITA":
                return LanguageItalian.getLocationAncientArenaEmbedMessage1();
            default:
                return LanguageEnglish.getLocationAncientArenaEmbedMessage1();
        }
    }

    public static String getLocationAncientArenaEmbedMessage2(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationAncientArenaEmbedMessage2();
            case "ESP":
                return LanguageSpain.getLocationAncientArenaEmbedMessage2();
            case "POL":
                return LanguagePolish.getLocationAncientArenaEmbedMessage2();
            case "FRA":
                return LanguageFrench.getLocationAncientArenaEmbedMessage2();
            case "ITA":
                return LanguageItalian.getLocationAncientArenaEmbedMessage2();
            default:
                return LanguageEnglish.getLocationAncientArenaEmbedMessage2();
        }
    }

    public static String getAncientNightmareEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientNightmareEmbedMessage();
            case "ESP":
                return LanguageSpain.getAncientNightmareEmbedMessage();
            case "POL":
                return LanguagePolish.getAncientNightmareEmbedMessage();
            case "FRA":
                return LanguageFrench.getAncientNightmareEmbedMessage();
            case "ITA":
                return LanguageItalian.getAncientNightmareEmbedMessage();
            default:
                return LanguageEnglish.getAncientNightmareEmbedMessage();
        }
    }

    public static String getLocationAncientNightmareEmbedMessage1(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationAncientNightmareEmbedMessage1();
            case "ESP":
                return LanguageSpain.getLocationAncientNightmareEmbedMessage1();
            case "POL":
                return LanguagePolish.getLocationAncientNightmareEmbedMessage1();
            case "FRA":
                return LanguageFrench.getLocationAncientNightmareEmbedMessage1();
            case "ITA":
                return LanguageItalian.getLocationAncientNightmareEmbedMessage1();
            default:
                return LanguageEnglish.getLocationAncientNightmareEmbedMessage1();
        }
    }

    public static String getLocationAncientNightmareEmbedMessage2(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationAncientNightmareEmbedMessage2();
            case "ESP":
                return LanguageSpain.getLocationAncientNightmareEmbedMessage2();
            case "POL":
                return LanguagePolish.getLocationAncientNightmareEmbedMessage2();
            case "FRA":
                return LanguageFrench.getLocationAncientNightmareEmbedMessage2();
            case "ITA":
                return LanguageItalian.getLocationAncientNightmareEmbedMessage2();
            default:
                return LanguageEnglish.getLocationAncientNightmareEmbedMessage2();
        }
    }

    public static String getDemonGatesEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDemonGatesEmbedMessage();
            case "ESP":
                return LanguageSpain.getDemonGatesEmbedMessage();
            case "POL":
                return LanguagePolish.getDemonGatesEmbedMessage();
            case "FRA":
                return LanguageFrench.getDemonGatesEmbedMessage();
            case "ITA":
                return LanguageItalian.getDemonGatesEmbedMessage();
            default:
                return LanguageEnglish.getDemonGatesEmbedMessage();
        }
    }

    public static String getLocationDemonGatesEmbedMessage1(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationDemonGatesEmbedMessage1();
            case "ESP":
                return LanguageSpain.getLocationDemonGatesEmbedMessage1();
            case "POL":
                return LanguagePolish.getLocationDemonGatesEmbedMessage1();
            case "FRA":
                return LanguageFrench.getLocationDemonGatesEmbedMessage1();
            case "ITA":
                return LanguageItalian.getLocationDemonGatesEmbedMessage1();
            default:
                return LanguageEnglish.getLocationDemonGatesEmbedMessage1();
        }
    }

    public static String getLocationDemonGatesEmbedMessage2(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationDemonGatesEmbedMessage2();
            case "ESP":
                return LanguageSpain.getLocationDemonGatesEmbedMessage2();
            case "POL":
                return LanguagePolish.getLocationDemonGatesEmbedMessage2();
            case "FRA":
                return LanguageFrench.getLocationDemonGatesEmbedMessage2();
            case "ITA":
                return LanguageItalian.getLocationDemonGatesEmbedMessage2();
            default:
                return LanguageEnglish.getLocationDemonGatesEmbedMessage2();
        }
    }

    public static String getHauntedCarriageEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHauntedCarriageEmbedMessage();
            case "ESP":
                return LanguageSpain.getHauntedCarriageEmbedMessage();
            case "POL":
                return LanguagePolish.getHauntedCarriageEmbedMessage();
            case "FRA":
                return LanguageFrench.getHauntedCarriageEmbedMessage();
            case "ITA":
                return LanguageItalian.getHauntedCarriageEmbedMessage();
            default:
                return LanguageEnglish.getHauntedCarriageEmbedMessage();
        }
    }

    public static String getLocationHauntedCarriageEmbedMessage1(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationHauntedCarriageEmbedMessage1();
            case "ESP":
                return LanguageSpain.getLocationHauntedCarriageEmbedMessage1();
            case "POL":
                return LanguagePolish.getLocationHauntedCarriageEmbedMessage1();
            case "FRA":
                return LanguageFrench.getLocationHauntedCarriageEmbedMessage1();
            case "ITA":
                return LanguageItalian.getLocationHauntedCarriageEmbedMessage1();
            default:
                return LanguageEnglish.getLocationHauntedCarriageEmbedMessage1();
        }
    }

    public static String getLocationHauntedCarriageEmbedMessage2(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLocationHauntedCarriageEmbedMessage2();
            case "ESP":
                return LanguageSpain.getLocationHauntedCarriageEmbedMessage2();
            case "POL":
                return LanguagePolish.getLocationHauntedCarriageEmbedMessage2();
            case "FRA":
                return LanguageFrench.getLocationHauntedCarriageEmbedMessage2();
            case "ITA":
                return LanguageItalian.getLocationHauntedCarriageEmbedMessage2();
            default:
                return LanguageEnglish.getLocationHauntedCarriageEmbedMessage2();
        }
    }

    public static String getSpawnAtMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getSpawnAtMessage();
            case "ESP":
                return LanguageSpain.getSpawnAtMessage();
            case "POL":
                return LanguagePolish.getSpawnAtMessage();
            case "FRA":
                return LanguageFrench.getSpawnAtMessage();
            case "ITA":
                return LanguageItalian.getSpawnAtMessage();
            default:
                return LanguageEnglish.getSpawnAtMessage();
        }
    }

    public static String getCountdownEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCountdownEmbedMessage();
            case "ESP":
                return LanguageSpain.getCountdownEmbedMessage();
            case "POL":
                return LanguagePolish.getCountdownEmbedMessage();
            case "FRA":
                return LanguageFrench.getCountdownEmbedMessage();
            case "ITA":
                return LanguageItalian.getCountdownEmbedMessage();
            default:
                return LanguageEnglish.getCountdownEmbedMessage();
        }
    }

    public static String getWorldEventEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWorldEventEmbedMessage();
            case "ESP":
                return LanguageSpain.getWorldEventEmbedMessage();
            case "POL":
                return LanguagePolish.getWorldEventEmbedMessage();
            case "FRA":
                return LanguageFrench.getWorldEventEmbedMessage();
            case "ITA":
                return LanguageItalian.getWorldEventEmbedMessage();
            default:
                return LanguageEnglish.getWorldEventEmbedMessage();
        }
    }

}
