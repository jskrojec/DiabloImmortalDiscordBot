package me.umbreon.diabloimmortalbot.configuration;

public class LanguageController {

    public static void loadConfigurations() {
        LanguageEnglish languageEnglish = new LanguageEnglish();
        languageEnglish.loadLanguageConfiguration();

        LanguageGerman languageGerman = new LanguageGerman();
        languageGerman.loadLanguageConfiguration();

        LanguageSpain languageSpain = new LanguageSpain();
        languageSpain.loadLanguageConfiguration();
    }

    public static String getHauntedCarriageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHauntedCarriageMessage();
            case "ESP":
                return LanguageSpain.getHauntedCarriageMessage();
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
            default:
                return LanguageEnglish.getHeadUpValueSetToMessage();
        }
    }

}
