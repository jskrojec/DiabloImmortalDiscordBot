package me.umbreon.diabloimmortalbot.configuration;

public class LanguageController {

    public static void loadConfigurations() {
        LanguageEnglish languageEnglish = new LanguageEnglish();
        languageEnglish.loadLanguageConfiguration();

        LanguageGerman languageGerman = new LanguageGerman();
        languageGerman.loadLanguageConfiguration();
    }

    public static String getVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getVaultMessage();
            default:
                return LanguageEnglish.getVaultMessage();
        }
    }

    public static String getVaultHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getVaultHeadUpMessage();
            default:
                return LanguageEnglish.getVaultHeadUpMessage();
        }
    }

    public static String getHauntedCarriageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHauntedCarriageMessage();
            default:
                return LanguageEnglish.getHauntedCarriageMessage();
        }
    }

    public static String getHauntedCarriageHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHauntedCarriageHeadUpMessage();
            default:
                return LanguageEnglish.getHauntedCarriageHeadUpMessage();
        }
    }

    public static String getDemonGatesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDemonGatesMessage();
            default:
                return LanguageEnglish.getDemonGatesMessage();
        }
    }

    public static String getDemonGatesHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDemonGatesHeadUpMessage();
            default:
                return LanguageEnglish.getDemonGatesHeadUpMessage();
        }
    }

    public static String getBattlegroundMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getBattlegroundMessage();
            default:
                return LanguageEnglish.getBattlegroundMessage();
        }
    }

    public static String getBattlegroundHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getBattlegroundHeadUpMessage();
            default:
                return LanguageEnglish.getBattlegroundHeadUpMessage();
        }
    }

    public static String getAncientNightmareMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientNightmareMessage();
            default:
                return LanguageEnglish.getAncientNightmareMessage();
        }
    }

    public static String getAncientNightmareHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientNightmareHeadUpMessage();
            default:
                return LanguageEnglish.getAncientNightmareHeadUpMessage();
        }
    }

    public static String getAncientArenaMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientArenaMessage();
            default:
                return LanguageEnglish.getAncientArenaMessage();
        }
    }

    public static String getAncientArenaHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAncientArenaHeadUpMessage();
            default:
                return LanguageEnglish.getAncientArenaHeadUpMessage();
        }
    }

    public static String getAssemblyMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAssemblyMessage();
            default:
                return LanguageEnglish.getAssemblyMessage();
        }
    }

    public static String getAssemblyHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAssemblyHeadUpMessage();
            default:
                return LanguageEnglish.getAssemblyHeadUpMessage();
        }
    }

    public static String getShadowLotteryMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShadowLotteryMessage();
            default:
                return LanguageEnglish.getShadowLotteryMessage();
        }
    }

    public static String getShadowLotteryHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShadowLotteryHeadUpMessage();
            default:
                return LanguageEnglish.getShadowLotteryHeadUpMessage();
        }
    }

    public static String getRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRegisteredMessage();
            default:
                return LanguageEnglish.getRegisteredMessage();
        }
    }

    public static String getAlreadyRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAlreadyRegisteredMessage();
            default:
                return LanguageEnglish.getAlreadyRegisteredMessage();
        }
    }

    public static String getRoleNotFoundMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRoleNotFoundMessage();
            default:
                return LanguageEnglish.getRoleNotFoundMessage();
        }
    }

    public static String getNotRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getNotRegisteredMessage();
            default:
                return LanguageEnglish.getNotRegisteredMessage();
        }
    }

    public static String getReceiveAllMessagesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveAllMessagesMessage();
            default:
                return LanguageEnglish.getReceiveAllMessagesMessage();
        }
    }

    public static String getReceiveImmortalMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveImmortalMessage();
            default:
                return LanguageEnglish.getReceiveImmortalMessage();
        }
    }

    public static String getReceiveShadowMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveShadowMessage();
            default:
                return LanguageEnglish.getReceiveShadowMessage();
        }
    }

    public static String getReceiveOwImmortalMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveOwImmortalMessage();
            default:
                return LanguageEnglish.getReceiveOwImmortalMessage();
        }
    }

    public static String getReceiveOwShadowMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveOwShadowMessage();
            default:
                return LanguageEnglish.getReceiveOwShadowMessage();
        }
    }

    public static String getReceiveOverworldMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReceiveOverworldMessage();
            default:
                return LanguageEnglish.getReceiveOverworldMessage();
        }
    }

    public static String getTimezoneSetToMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getTimezoneSetToMessage();
            default:
                return LanguageEnglish.getTimezoneSetToMessage();
        }
    }

    public static String getUnregisteredChannel(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnregisteredChannel();
            default:
                return LanguageEnglish.getUnregisteredChannel();
        }
    }

    public static String getUnknownTimezoneMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnknownTimezoneMessage();
            default:
                return LanguageEnglish.getUnknownTimezoneMessage();
        }
    }

    public static String getUnknownStatusMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnknownStatusMessage();
            default:
                return LanguageEnglish.getUnknownStatusMessage();
        }
    }

    public static String getIsSetMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getIsSetMessage();
            default:
                return LanguageEnglish.getIsSetMessage();
        }
    }

    public static String getRaidTheVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRaidTheVaultMessage();
            default:
                return LanguageEnglish.getRaidTheVaultMessage();
        }
    }

    public static String getRaidTheVaultHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRaidTheVaultHeadUpMessage();
            default:
                return LanguageEnglish.getRaidTheVaultHeadUpMessage();
        }
    }

    public static String getDefendTheVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDefendTheVaultMessage();
            default:
                return LanguageEnglish.getDefendTheVaultMessage();
        }
    }

    public static String getDefendTheVaultHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDefendTheVaultHeadUpMessage();
            default:
                return LanguageEnglish.getDefendTheVaultHeadUpMessage();
        }
    }

    public static String getLanguageNotSupportedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLanguageNotSupportedMessage();
            default:
                return LanguageEnglish.getLanguageNotSupportedMessage();
        }
    }

    public static String getLanguageUpdatedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getLanguageUpdatedMessage();
            default:
                return LanguageEnglish.getLanguageUpdatedMessage();
        }
    }

    public static String getHeadUpValueSetToMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpValueSetToMessage();
            default:
                return LanguageEnglish.getHeadUpValueSetToMessage();
        }
    }

}
