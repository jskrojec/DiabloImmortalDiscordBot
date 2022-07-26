package me.umbreon.diabloimmortalbot.configuration;

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
            default:
                return LanguageEnglish.getEventDisabledMessage();
        }
    }

}
