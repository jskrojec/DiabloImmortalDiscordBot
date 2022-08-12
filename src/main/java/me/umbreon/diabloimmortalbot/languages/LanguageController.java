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

        LanguageRussian languageRussian = new LanguageRussian();
        languageRussian.loadLanguageConfiguration();

        LanguageIndonesia languageIndonesia = new LanguageIndonesia();
        languageIndonesia.loadLanguageConfiguration();
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
            case "RUS":
                return LanguageRussian.getHauntedCarriageMessage();
            case "IND":
                return LanguageIndonesia.getHauntedCarriageMessage();
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
            case "RUS":
                return LanguageRussian.getHauntedCarriageHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getHauntedCarriageHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getDemonGatesMessage();
            case "IND":
                return LanguageIndonesia.getDemonGatesMessage();
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
            case "RUS":
                return LanguageRussian.getDemonGatesHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getDemonGatesHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getBattlegroundMessage();
            case "IND":
                return LanguageIndonesia.getBattlegroundMessage();
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
            case "RUS":
                return LanguageRussian.getBattlegroundHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getBattlegroundHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getAncientNightmareMessage();
            case "IND":
                return LanguageIndonesia.getAncientNightmareMessage();
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
            case "RUS":
                return LanguageRussian.getAncientNightmareHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getAncientNightmareHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getAncientArenaMessage();
            case "IND":
                return LanguageIndonesia.getAncientArenaMessage();
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
            case "RUS":
                return LanguageRussian.getAncientArenaHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getAncientArenaHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getAssemblyMessage();
            case "IND":
                return LanguageIndonesia.getAssemblyMessage();
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
            case "RUS":
                return LanguageRussian.getAssemblyHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getAssemblyHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getShadowLotteryMessage();
            case "IND":
                return LanguageIndonesia.getShadowLotteryMessage();
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
            case "RUS":
                return LanguageRussian.getShadowLotteryHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getShadowLotteryHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getRegisteredMessage();
            case "IND":
                return LanguageIndonesia.getRegisteredMessage();
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
            case "RUS":
                return LanguageRussian.getAlreadyRegisteredMessage();
            case "IND":
                return LanguageIndonesia.getAlreadyRegisteredMessage();
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
            case "RUS":
                return LanguageRussian.getRoleNotFoundMessage();
            case "IND":
                return LanguageIndonesia.getRoleNotFoundMessage();
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
            case "RUS":
                return LanguageRussian.getNotRegisteredMessage();
            case "IND":
                return LanguageIndonesia.getNotRegisteredMessage();
            default:
                return LanguageEnglish.getNotRegisteredMessage();
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
            case "RUS":
                return LanguageRussian.getTimezoneSetToMessage();
            case "IND":
                return LanguageIndonesia.getTimezoneSetToMessage();
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
            case "RUS":
                return LanguageRussian.getUnregisteredChannel();
            case "IND":
                return LanguageIndonesia.getUnregisteredChannel();
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
            case "RUS":
                return LanguageRussian.getUnknownTimezoneMessage();
            case "IND":
                return LanguageIndonesia.getUnknownTimezoneMessage();
            default:
                return LanguageEnglish.getUnknownTimezoneMessage();
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
            case "RUS":
                return LanguageRussian.getIsSetMessage();
            case "IND":
                return LanguageIndonesia.getIsSetMessage();
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
            case "RUS":
                return LanguageRussian.getRaidTheVaultMessage();
            case "IND":
                return LanguageIndonesia.getRaidTheVaultMessage();
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
            case "RUS":
                return LanguageRussian.getRaidTheVaultHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getRaidTheVaultHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getDefendTheVaultMessage();
            case "IND":
                return LanguageIndonesia.getDefendTheVaultMessage();
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
            case "RUS":
                return LanguageRussian.getDefendTheVaultHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getDefendTheVaultHeadUpMessage();
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
            case "RUS":
                return LanguageRussian.getLanguageNotSupportedMessage();
            case "IND":
                return LanguageIndonesia.getLanguageNotSupportedMessage();
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
            case "RUS":
                return LanguageRussian.getLanguageUpdatedMessage();
            case "IND":
                return LanguageIndonesia.getLanguageUpdatedMessage();
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
            case "RUS":
                return LanguageRussian.getHeadUpValueSetToMessage();
            case "IND":
                return LanguageIndonesia.getHeadUpValueSetToMessage();
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
            case "RUS":
                return LanguageRussian.getLanguageMessage();
            case "IND":
                return LanguageIndonesia.getLanguageMessage();
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
            case "RUS":
                return LanguageRussian.getEventEnabledMessage();
            case "IND":
                return LanguageIndonesia.getEventEnabledMessage();
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
            case "RUS":
                return LanguageRussian.getEventDisabledMessage();
            case "IND":
                return LanguageIndonesia.getEventDisabledMessage();
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
            case "RUS":
                return LanguageRussian.getChannelNotFoundMessage();
            case "IND":
                return LanguageIndonesia.getChannelNotFoundMessage();
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
            case "RUS":
                return LanguageRussian.getDoBotGotRightsMessage();
            case "IND":
                return LanguageIndonesia.getDoBotGotRightsMessage();
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
            case "RUS":
                return LanguageRussian.getCustomMessageCreatedMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageCreatedMessage();
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
            case "RUS":
                return LanguageRussian.getNoCustomMessagesMessage();
            case "IND":
                return LanguageIndonesia.getNoCustomMessagesMessage();
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
            case "RUS":
                return LanguageRussian.getYourCustomMessagesMessage();
            case "IND":
                return LanguageIndonesia.getYourCustomMessagesMessage();
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
            case "RUS":
                return LanguageRussian.getCustomMessageDeletedMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageDeletedMessage();
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
            case "RUS":
                return LanguageRussian.getCustomMessageWithIdDeleted();
            case "IND":
                return LanguageIndonesia.getCustomMessageWithIdDeleted();
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
            case "RUS":
                return LanguageRussian.getInvalidCommandMessage();
            case "IND":
                return LanguageIndonesia.getInvalidCommandMessage();
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
            case "RUS":
                return LanguageRussian.getAncientArenaEmbedMessage();
            case "IND":
                return LanguageIndonesia.getAncientArenaEmbedMessage();
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
            case "RUS":
                return LanguageRussian.getLocationAncientArenaEmbedMessage1();
            case "IND":
                return LanguageIndonesia.getLocationAncientArenaEmbedMessage1();
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
            case "RUS":
                return LanguageRussian.getLocationAncientArenaEmbedMessage2();
            case "IND":
                return LanguageIndonesia.getLocationAncientArenaEmbedMessage2();
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
            case "RUS":
                return LanguageRussian.getAncientNightmareEmbedMessage();
            case "IND":
                return LanguageIndonesia.getAncientNightmareEmbedMessage();
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
            case "RUS":
                return LanguageRussian.getLocationAncientNightmareEmbedMessage1();
            case "IND":
                return LanguageIndonesia.getLocationAncientNightmareEmbedMessage1();
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
            case "RUS":
                return LanguageRussian.getLocationAncientNightmareEmbedMessage2();
            case "IND":
                return LanguageIndonesia.getLocationAncientNightmareEmbedMessage2();
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
            case "RUS":
                return LanguageRussian.getDemonGatesEmbedMessage();
            case "IND":
                return LanguageIndonesia.getDemonGatesEmbedMessage();
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
            case "RUS":
                return LanguageRussian.getLocationDemonGatesEmbedMessage1();
            case "IND":
                return LanguageIndonesia.getLocationDemonGatesEmbedMessage1();
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
            case "RUS":
                return LanguageRussian.getLocationDemonGatesEmbedMessage2();
            case "IND":
                return LanguageIndonesia.getLocationDemonGatesEmbedMessage2();
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
            case "RUS":
                return LanguageRussian.getHauntedCarriageEmbedMessage();
            case "IND":
                return LanguageIndonesia.getHauntedCarriageEmbedMessage();
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
            case "RUS":
                return LanguageRussian.getLocationHauntedCarriageEmbedMessage1();
            case "IND":
                return LanguageIndonesia.getLocationHauntedCarriageEmbedMessage1();
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
            case "RUS":
                return LanguageRussian.getLocationHauntedCarriageEmbedMessage2();
            case "IND":
                return LanguageIndonesia.getLocationHauntedCarriageEmbedMessage2();
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
            case "RUS":
                return LanguageRussian.getSpawnAtMessage();
            case "IND":
                return LanguageIndonesia.getSpawnAtMessage();
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
            case "RUS":
                return LanguageRussian.getCountdownEmbedMessage();
            case "IND":
                return LanguageIndonesia.getCountdownEmbedMessage();
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
            case "RUS":
                return LanguageRussian.getWorldEventEmbedMessage();
            case "IND":
                return LanguageIndonesia.getWorldEventEmbedMessage();
            default:
                return LanguageEnglish.getWorldEventEmbedMessage();
        }
    }

    public static String getInvalidTimezoneMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInvalidTimezoneMessage();
            case "ESP":
                return LanguageSpain.getInvalidTimezoneMessage();
            case "POL":
                return LanguagePolish.getInvalidTimezoneMessage();
            case "FRA":
                return LanguageFrench.getInvalidTimezoneMessage();
            case "ITA":
                return LanguageItalian.getInvalidTimezoneMessage();
            case "RUS":
                return LanguageRussian.getInvalidTimezoneMessage();
            case "IND":
                return LanguageIndonesia.getInvalidTimezoneMessage();
            default:
                return LanguageEnglish.getInvalidTimezoneMessage();
        }
    }

    public static String getHeadUpEnabledMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpEnabledMessage();
            case "ESP":
                return LanguageSpain.getHeadUpEnabledMessage();
            case "POL":
                return LanguagePolish.getHeadUpEnabledMessage();
            case "FRA":
                return LanguageFrench.getHeadUpEnabledMessage();
            case "ITA":
                return LanguageItalian.getHeadUpEnabledMessage();
            case "RUS":
                return LanguageRussian.getHeadUpEnabledMessage();
            case "IND":
                return LanguageIndonesia.getHeadUpEnabledMessage();
            default:
                return LanguageEnglish.getHeadUpEnabledMessage();
        }
    }

    public static String getHeadUpDisabledMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpDisabledMessage();
            case "ESP":
                return LanguageSpain.getHeadUpDisabledMessage();
            case "POL":
                return LanguagePolish.getHeadUpDisabledMessage();
            case "FRA":
                return LanguageFrench.getHeadUpDisabledMessage();
            case "ITA":
                return LanguageItalian.getHeadUpDisabledMessage();
            case "RUS":
                return LanguageRussian.getHeadUpDisabledMessage();
            case "IND":
                return LanguageIndonesia.getHeadUpDisabledMessage();
            default:
                return LanguageEnglish.getHeadUpDisabledMessage();
        }
    }

    public static String getCannotDisableEventMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCannotDisableEventMessage();
            case "ESP":
                return LanguageSpain.getCannotDisableEventMessage();
            case "POL":
                return LanguagePolish.getCannotDisableEventMessage();
            case "FRA":
                return LanguageFrench.getCannotDisableEventMessage();
            case "ITA":
                return LanguageItalian.getCannotDisableEventMessage();
            case "RUS":
                return LanguageRussian.getCannotDisableEventMessage();
            case "IND":
                return LanguageIndonesia.getCannotDisableEventMessage();
            default:
                return LanguageEnglish.getCannotDisableEventMessage();
        }
    }

    public static String getEventDoesNotExistMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEventDoesNotExistMessage();
            case "ESP":
                return LanguageSpain.getEventDoesNotExistMessage();
            case "POL":
                return LanguagePolish.getEventDoesNotExistMessage();
            case "FRA":
                return LanguageFrench.getEventDoesNotExistMessage();
            case "ITA":
                return LanguageItalian.getEventDoesNotExistMessage();
            case "RUS":
                return LanguageRussian.getEventDoesNotExistMessage();
            case "IND":
                return LanguageIndonesia.getEventDoesNotExistMessage();
            default:
                return LanguageEnglish.getEventDoesNotExistMessage();
        }
    }

    public static String getAvailableEventsMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAvailableEventsMessage();
            case "ESP":
                return LanguageSpain.getAvailableEventsMessage();
            case "POL":
                return LanguagePolish.getAvailableEventsMessage();
            case "FRA":
                return LanguageFrench.getAvailableEventsMessage();
            case "ITA":
                return LanguageItalian.getAvailableEventsMessage();
            case "RUS":
                return LanguageRussian.getAvailableEventsMessage();
            case "IND":
                return LanguageIndonesia.getAvailableEventsMessage();
            default:
                return LanguageEnglish.getAvailableEventsMessage();
        }
    }

    public static String getWhatTextChannelMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWhatTextChannelMessage();
            case "ESP":
                return LanguageSpain.getWhatTextChannelMessage();
            case "POL":
                return LanguagePolish.getWhatTextChannelMessage();
            case "FRA":
                return LanguageFrench.getWhatTextChannelMessage();
            case "ITA":
                return LanguageItalian.getWhatTextChannelMessage();
            case "RUS":
                return LanguageRussian.getWhatTextChannelMessage();
            case "IND":
                return LanguageIndonesia.getWhatTextChannelMessage();
            default:
                return LanguageEnglish.getWhatTextChannelMessage();
        }
    }

    public static String getThisMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getThisMessage();
            case "ESP":
                return LanguageSpain.getThisMessage();
            case "POL":
                return LanguagePolish.getThisMessage();
            case "FRA":
                return LanguageFrench.getThisMessage();
            case "ITA":
                return LanguageItalian.getThisMessage();
            case "RUS":
                return LanguageRussian.getThisMessage();
            case "IND":
                return LanguageIndonesia.getThisMessage();
            default:
                return LanguageEnglish.getThisMessage();
        }
    }

    public static String getWhatDayMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWhatDayMessage();
            case "ESP":
                return LanguageSpain.getWhatDayMessage();
            case "POL":
                return LanguagePolish.getWhatDayMessage();
            case "FRA":
                return LanguageFrench.getWhatDayMessage();
            case "ITA":
                return LanguageItalian.getWhatDayMessage();
            case "RUS":
                return LanguageRussian.getWhatDayMessage();
            case "IND":
                return LanguageIndonesia.getWhatDayMessage();
            default:
                return LanguageEnglish.getWhatDayMessage();
        }
    }

    public static String getWhatTimeMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWhatTimeMessage();
            case "ESP":
                return LanguageSpain.getWhatTimeMessage();
            case "POL":
                return LanguagePolish.getWhatTimeMessage();
            case "FRA":
                return LanguageFrench.getWhatTimeMessage();
            case "ITA":
                return LanguageItalian.getWhatTimeMessage();
            case "RUS":
                return LanguageRussian.getWhatTimeMessage();
            case "IND":
                return LanguageIndonesia.getWhatTimeMessage();
            default:
                return LanguageEnglish.getWhatTimeMessage();
        }
    }

    public static String getWhatMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWhatMessageMessage();
            case "ESP":
                return LanguageSpain.getWhatMessageMessage();
            case "POL":
                return LanguagePolish.getWhatMessageMessage();
            case "FRA":
                return LanguageFrench.getWhatMessageMessage();
            case "ITA":
                return LanguageItalian.getWhatMessageMessage();
            case "RUS":
                return LanguageRussian.getWhatMessageMessage();
            case "IND":
                return LanguageIndonesia.getWhatMessageMessage();
            default:
                return LanguageEnglish.getWhatMessageMessage();
        }
    }

    public static String getMessageFrequentlyMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getMessageFrequentlyMessage();
            case "ESP":
                return LanguageSpain.getMessageFrequentlyMessage();
            case "POL":
                return LanguagePolish.getMessageFrequentlyMessage();
            case "FRA":
                return LanguageFrench.getMessageFrequentlyMessage();
            case "ITA":
                return LanguageItalian.getMessageFrequentlyMessage();
            case "RUS":
                return LanguageRussian.getMessageFrequentlyMessage();
            case "IND":
                return LanguageIndonesia.getMessageFrequentlyMessage();
            default:
                return LanguageEnglish.getMessageFrequentlyMessage();
        }
    }

    public static String getYesOrNoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getYesOrNoMessage();
            case "ESP":
                return LanguageSpain.getYesOrNoMessage();
            case "POL":
                return LanguagePolish.getYesOrNoMessage();
            case "FRA":
                return LanguageFrench.getYesOrNoMessage();
            case "ITA":
                return LanguageItalian.getYesOrNoMessage();
            case "RUS":
                return LanguageRussian.getYesOrNoMessage();
            case "IND":
                return LanguageIndonesia.getYesOrNoMessage();
            default:
                return LanguageEnglish.getYesOrNoMessage();
        }
    }

    public static String getInvalidDayMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInvalidDayMessage();
            case "ESP":
                return LanguageSpain.getInvalidDayMessage();
            case "POL":
                return LanguagePolish.getInvalidDayMessage();
            case "FRA":
                return LanguageFrench.getInvalidDayMessage();
            case "ITA":
                return LanguageItalian.getInvalidDayMessage();
            case "RUS":
                return LanguageRussian.getInvalidDayMessage();
            case "IND":
                return LanguageIndonesia.getInvalidDayMessage();
            default:
                return LanguageEnglish.getInvalidDayMessage();
        }
    }

    public static String getRegistersChannelMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRegistersChannelMessage();
            case "ESP":
                return LanguageSpain.getRegistersChannelMessage();
            case "POL":
                return LanguagePolish.getRegistersChannelMessage();
            case "FRA":
                return LanguageFrench.getRegistersChannelMessage();
            case "ITA":
                return LanguageItalian.getRegistersChannelMessage();
            case "RUS":
                return LanguageRussian.getRegistersChannelMessage();
            case "IND":
                return LanguageIndonesia.getRegistersChannelMessage();
            default:
                return LanguageEnglish.getRegistersChannelMessage();
        }
    }

    public static String getUnregistersChannelMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getUnregistersChannelMessage();
            case "ESP":
                return LanguageSpain.getUnregistersChannelMessage();
            case "POL":
                return LanguagePolish.getUnregistersChannelMessage();
            case "FRA":
                return LanguageFrench.getUnregistersChannelMessage();
            case "ITA":
                return LanguageItalian.getUnregistersChannelMessage();
            case "RUS":
                return LanguageRussian.getUnregistersChannelMessage();
            case "IND":
                return LanguageIndonesia.getUnregistersChannelMessage();
            default:
                return LanguageEnglish.getUnregistersChannelMessage();
        }
    }

    public static String getSetsChannelRoleMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getSetsChannelRoleMessage();
            case "ESP":
                return LanguageSpain.getSetsChannelRoleMessage();
            case "POL":
                return LanguagePolish.getSetsChannelRoleMessage();
            case "FRA":
                return LanguageFrench.getSetsChannelRoleMessage();
            case "ITA":
                return LanguageItalian.getSetsChannelRoleMessage();
            case "RUS":
                return LanguageRussian.getSetsChannelRoleMessage();
            case "IND":
                return LanguageIndonesia.getSetsChannelRoleMessage();
            default:
                return LanguageEnglish.getSetsChannelRoleMessage();
        }
    }

    public static String getShowsChannelInfoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowsChannelInfoMessage();
            case "ESP":
                return LanguageSpain.getShowsChannelInfoMessage();
            case "POL":
                return LanguagePolish.getShowsChannelInfoMessage();
            case "FRA":
                return LanguageFrench.getShowsChannelInfoMessage();
            case "ITA":
                return LanguageItalian.getShowsChannelInfoMessage();
            case "RUS":
                return LanguageRussian.getShowsChannelInfoMessage();
            case "IND":
                return LanguageIndonesia.getShowsChannelInfoMessage();
            default:
                return LanguageEnglish.getShowsChannelInfoMessage();
        }
    }

    public static String getCreateCustomMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCreateCustomMessageMessage();
            case "ESP":
                return LanguageSpain.getCreateCustomMessageMessage();
            case "POL":
                return LanguagePolish.getCreateCustomMessageMessage();
            case "FRA":
                return LanguageFrench.getCreateCustomMessageMessage();
            case "ITA":
                return LanguageItalian.getCreateCustomMessageMessage();
            case "RUS":
                return LanguageRussian.getCreateCustomMessageMessage();
            case "IND":
                return LanguageIndonesia.getCreateCustomMessageMessage();
            default:
                return LanguageEnglish.getCreateCustomMessageMessage();
        }
    }

    public static String getDeleteCustomMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getDeleteCustomMessageMessage();
            case "ESP":
                return LanguageSpain.getDeleteCustomMessageMessage();
            case "POL":
                return LanguagePolish.getDeleteCustomMessageMessage();
            case "FRA":
                return LanguageFrench.getDeleteCustomMessageMessage();
            case "ITA":
                return LanguageItalian.getDeleteCustomMessageMessage();
            case "RUS":
                return LanguageRussian.getDeleteCustomMessageMessage();
            case "IND":
                return LanguageIndonesia.getDeleteCustomMessageMessage();
            default:
                return LanguageEnglish.getDeleteCustomMessageMessage();
        }
    }

    public static String getShowsAllCustomMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowsAllCustomMessageMessage();
            case "ESP":
                return LanguageSpain.getShowsAllCustomMessageMessage();
            case "POL":
                return LanguagePolish.getShowsAllCustomMessageMessage();
            case "FRA":
                return LanguageFrench.getShowsAllCustomMessageMessage();
            case "ITA":
                return LanguageItalian.getShowsAllCustomMessageMessage();
            case "RUS":
                return LanguageRussian.getShowsAllCustomMessageMessage();
            case "IND":
                return LanguageIndonesia.getShowsAllCustomMessageMessage();
            default:
                return LanguageEnglish.getShowsAllCustomMessageMessage();
        }
    }

    public static String getShowsCustomMessageInfoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowsCustomMessageInfoMessage();
            case "ESP":
                return LanguageSpain.getShowsCustomMessageInfoMessage();
            case "POL":
                return LanguagePolish.getShowsCustomMessageInfoMessage();
            case "FRA":
                return LanguageFrench.getShowsCustomMessageInfoMessage();
            case "ITA":
                return LanguageItalian.getShowsCustomMessageInfoMessage();
            case "RUS":
                return LanguageRussian.getShowsCustomMessageInfoMessage();
            case "IND":
                return LanguageIndonesia.getShowsCustomMessageInfoMessage();
            default:
                return LanguageEnglish.getShowsCustomMessageInfoMessage();
        }
    }

    public static String getHeadUpActivationMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpActivationMessage();
            case "ESP":
                return LanguageSpain.getHeadUpActivationMessage();
            case "POL":
                return LanguagePolish.getHeadUpActivationMessage();
            case "FRA":
                return LanguageFrench.getHeadUpActivationMessage();
            case "ITA":
                return LanguageItalian.getHeadUpActivationMessage();
            case "RUS":
                return LanguageRussian.getHeadUpActivationMessage();
            case "IND":
                return LanguageIndonesia.getHeadUpActivationMessage();
            default:
                return LanguageEnglish.getHeadUpActivationMessage();
        }
    }

    public static String getMessageActivationMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getMessageActivationMessage();
            case "ESP":
                return LanguageSpain.getMessageActivationMessage();
            case "POL":
                return LanguagePolish.getMessageActivationMessage();
            case "FRA":
                return LanguageFrench.getMessageActivationMessage();
            case "ITA":
                return LanguageItalian.getMessageActivationMessage();
            case "RUS":
                return LanguageRussian.getMessageActivationMessage();
            case "IND":
                return LanguageIndonesia.getMessageActivationMessage();
            default:
                return LanguageEnglish.getMessageActivationMessage();
        }
    }

    public static String getShowsServerConfigMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowsServerConfigMessage();
            case "ESP":
                return LanguageSpain.getShowsServerConfigMessage();
            case "POL":
                return LanguagePolish.getShowsServerConfigMessage();
            case "FRA":
                return LanguageFrench.getShowsServerConfigMessage();
            case "ITA":
                return LanguageItalian.getShowsServerConfigMessage();
            case "RUS":
                return LanguageRussian.getShowsServerConfigMessage();
            case "IND":
                return LanguageIndonesia.getShowsServerConfigMessage();
            default:
                return LanguageEnglish.getShowsServerConfigMessage();
        }
    }

    public static String getSetsServerLanguageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getSetsServerLanguageMessage();
            case "ESP":
                return LanguageSpain.getSetsServerLanguageMessage();
            case "POL":
                return LanguagePolish.getSetsServerLanguageMessage();
            case "FRA":
                return LanguageFrench.getSetsServerLanguageMessage();
            case "ITA":
                return LanguageItalian.getSetsServerLanguageMessage();
            case "RUS":
                return LanguageRussian.getSetsServerLanguageMessage();
            case "IND":
                return LanguageIndonesia.getSetsServerLanguageMessage();
            default:
                return LanguageEnglish.getSetsServerLanguageMessage();
        }
    }

    public static String getSetsTimezoneLanguageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getSetsTimezoneLanguageMessage();
            case "ESP":
                return LanguageSpain.getSetsTimezoneLanguageMessage();
            case "POL":
                return LanguagePolish.getSetsTimezoneLanguageMessage();
            case "FRA":
                return LanguageFrench.getSetsTimezoneLanguageMessage();
            case "ITA":
                return LanguageItalian.getSetsTimezoneLanguageMessage();
            case "RUS":
                return LanguageRussian.getSetsTimezoneLanguageMessage();
            case "IND":
                return LanguageIndonesia.getSetsTimezoneLanguageMessage();
            default:
                return LanguageEnglish.getSetsTimezoneLanguageMessage();
        }
    }

    public static String getShowsBotInstallMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowsBotInstallMessage();
            case "ESP":
                return LanguageSpain.getShowsBotInstallMessage();
            case "POL":
                return LanguagePolish.getShowsBotInstallMessage();
            case "FRA":
                return LanguageFrench.getShowsBotInstallMessage();
            case "ITA":
                return LanguageItalian.getShowsBotInstallMessage();
            case "RUS":
                return LanguageRussian.getShowsBotInstallMessage();
            case "IND":
                return LanguageIndonesia.getShowsBotInstallMessage();
            default:
                return LanguageEnglish.getShowsBotInstallMessage();
        }
    }

    public static String getShowsThisMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowsThisMessageMessage();
            case "ESP":
                return LanguageSpain.getShowsThisMessageMessage();
            case "POL":
                return LanguagePolish.getShowsThisMessageMessage();
            case "FRA":
                return LanguageFrench.getShowsThisMessageMessage();
            case "ITA":
                return LanguageItalian.getShowsThisMessageMessage();
            case "RUS":
                return LanguageRussian.getShowsThisMessageMessage();
            case "IND":
                return LanguageIndonesia.getShowsThisMessageMessage();
            default:
                return LanguageEnglish.getShowsThisMessageMessage();
        }
    }

    public static String getSupportDiscordMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getSupportDiscordMessage();
            case "ESP":
                return LanguageSpain.getSupportDiscordMessage();
            case "POL":
                return LanguagePolish.getSupportDiscordMessage();
            case "FRA":
                return LanguageFrench.getSupportDiscordMessage();
            case "ITA":
                return LanguageItalian.getSupportDiscordMessage();
            case "RUS":
                return LanguageRussian.getSupportDiscordMessage();
            case "IND":
                return LanguageIndonesia.getSupportDiscordMessage();
            default:
                return LanguageEnglish.getSupportDiscordMessage();
        }
    }

    public static String getCreatedByMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCreatedByMessage();
            case "ESP":
                return LanguageSpain.getCreatedByMessage();
            case "POL":
                return LanguagePolish.getCreatedByMessage();
            case "FRA":
                return LanguageFrench.getCreatedByMessage();
            case "ITA":
                return LanguageItalian.getCreatedByMessage();
            case "RUS":
                return LanguageRussian.getCreatedByMessage();
            case "IND":
                return LanguageIndonesia.getCreatedByMessage();
            default:
                return LanguageEnglish.getCreatedByMessage();
        }
    }

    public static String getAutoDeleteActivationMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAutoDeleteActivationMessage();
            case "ESP":
                return LanguageSpain.getAutoDeleteActivationMessage();
            case "POL":
                return LanguagePolish.getAutoDeleteActivationMessage();
            case "FRA":
                return LanguageFrench.getAutoDeleteActivationMessage();
            case "ITA":
                return LanguageItalian.getAutoDeleteActivationMessage();
            case "RUS":
                return LanguageRussian.getAutoDeleteActivationMessage();
            case "IND":
                return LanguageIndonesia.getAutoDeleteActivationMessage();
            default:
                return LanguageEnglish.getAutoDeleteActivationMessage();
        }
    }

    public static String getAutoDeleteValueMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAutoDeleteValueMessage();
            case "ESP":
                return LanguageSpain.getAutoDeleteValueMessage();
            case "POL":
                return LanguagePolish.getAutoDeleteValueMessage();
            case "FRA":
                return LanguageFrench.getAutoDeleteValueMessage();
            case "ITA":
                return LanguageItalian.getAutoDeleteValueMessage();
            case "RUS":
                return LanguageRussian.getAutoDeleteValueMessage();
            case "IND":
                return LanguageIndonesia.getAutoDeleteValueMessage();
            default:
                return LanguageEnglish.getAutoDeleteValueMessage();
        }
    }

    public static String getShortHoursMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShortHoursMessage();
            case "ESP":
                return LanguageSpain.getShortHoursMessage();
            case "POL":
                return LanguagePolish.getShortHoursMessage();
            case "FRA":
                return LanguageFrench.getShortHoursMessage();
            case "ITA":
                return LanguageItalian.getShortHoursMessage();
            case "RUS":
                return LanguageRussian.getShortHoursMessage();
            case "IND":
                return LanguageIndonesia.getShortHoursMessage();
            default:
                return LanguageEnglish.getShortHoursMessage();
        }
    }


    public static String getErrorOccurredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getErrorOccurredMessage();
            case "ESP":
                return LanguageSpain.getErrorOccurredMessage();
            case "POL":
                return LanguagePolish.getErrorOccurredMessage();
            case "FRA":
                return LanguageFrench.getErrorOccurredMessage();
            case "ITA":
                return LanguageItalian.getErrorOccurredMessage();
            case "RUS":
                return LanguageRussian.getErrorOccurredMessage();
            case "IND":
                return LanguageIndonesia.getErrorOccurredMessage();
            default:
                return LanguageEnglish.getErrorOccurredMessage();
        }
    }

    public static String getReportToDevMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getReportToDevMessage();
            case "ESP":
                return LanguageSpain.getReportToDevMessage();
            case "POL":
                return LanguagePolish.getReportToDevMessage();
            case "FRA":
                return LanguageFrench.getReportToDevMessage();
            case "ITA":
                return LanguageItalian.getReportToDevMessage();
            case "RUS":
                return LanguageRussian.getReportToDevMessage();
            case "IND":
                return LanguageIndonesia.getReportToDevMessage();
            default:
                return LanguageEnglish.getReportToDevMessage();
        }
    }

    public static String getYesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getYesMessage();
            case "ESP":
                return LanguageSpain.getYesMessage();
            case "POL":
                return LanguagePolish.getYesMessage();
            case "FRA":
                return LanguageFrench.getYesMessage();
            case "ITA":
                return LanguageItalian.getYesMessage();
            case "RUS":
                return LanguageRussian.getYesMessage();
            case "IND":
                return LanguageIndonesia.getYesMessage();
            default:
                return LanguageEnglish.getYesMessage();
        }
    }

    public static String getNoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getNoMessage();
            case "ESP":
                return LanguageSpain.getNoMessage();
            case "POL":
                return LanguagePolish.getNoMessage();
            case "FRA":
                return LanguageFrench.getNoMessage();
            case "ITA":
                return LanguageItalian.getNoMessage();
            case "RUS":
                return LanguageRussian.getNoMessage();
            case "IND":
                return LanguageIndonesia.getNoMessage();
            default:
                return LanguageEnglish.getNoMessage();
        }
    }


}
