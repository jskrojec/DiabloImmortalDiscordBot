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

    public static String getChannelRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getChannelRegisteredMessage();
            case "ESP":
                return LanguageSpain.getChannelRegisteredMessage();
            case "POL":
                return LanguagePolish.getChannelRegisteredMessage();
            case "FRA":
                return LanguageFrench.getChannelRegisteredMessage();
            case "ITA":
                return LanguageItalian.getChannelRegisteredMessage();
            case "RUS":
                return LanguageRussian.getChannelRegisteredMessage();
            case "IND":
                return LanguageIndonesia.getChannelRegisteredMessage();
            default:
                return LanguageEnglish.getChannelRegisteredMessage();
        }
    }

    public static String getChannelAlreadyRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getChannelAlreadyRegisteredMessage();
            case "ESP":
                return LanguageSpain.getChannelAlreadyRegisteredMessage();
            case "POL":
                return LanguagePolish.getChannelAlreadyRegisteredMessage();
            case "FRA":
                return LanguageFrench.getChannelAlreadyRegisteredMessage();
            case "ITA":
                return LanguageItalian.getChannelAlreadyRegisteredMessage();
            case "RUS":
                return LanguageRussian.getChannelAlreadyRegisteredMessage();
            case "IND":
                return LanguageIndonesia.getChannelAlreadyRegisteredMessage();
            default:
                return LanguageEnglish.getChannelAlreadyRegisteredMessage();
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

    public static String getChannelNotRegisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getChannelNotRegisteredMessage();
            case "ESP":
                return LanguageSpain.getChannelNotRegisteredMessage();
            case "POL":
                return LanguagePolish.getChannelNotRegisteredMessage();
            case "FRA":
                return LanguageFrench.getChannelNotRegisteredMessage();
            case "ITA":
                return LanguageItalian.getChannelNotRegisteredMessage();
            case "RUS":
                return LanguageRussian.getChannelNotRegisteredMessage();
            case "IND":
                return LanguageIndonesia.getChannelNotRegisteredMessage();
            default:
                return LanguageEnglish.getChannelNotRegisteredMessage();
        }
    }

    public static String getTimezoneChangedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getTimezoneChangedMessage();
            case "ESP":
                return LanguageSpain.getTimezoneChangedMessage();
            case "POL":
                return LanguagePolish.getTimezoneChangedMessage();
            case "FRA":
                return LanguageFrench.getTimezoneChangedMessage();
            case "ITA":
                return LanguageItalian.getTimezoneChangedMessage();
            case "RUS":
                return LanguageRussian.getTimezoneChangedMessage();
            case "IND":
                return LanguageIndonesia.getTimezoneChangedMessage();
            default:
                return LanguageEnglish.getTimezoneChangedMessage();
        }
    }

    public static String getChannelUnregisteredMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getChannelUnregisteredMessage();
            case "ESP":
                return LanguageSpain.getChannelUnregisteredMessage();
            case "POL":
                return LanguagePolish.getChannelUnregisteredMessage();
            case "FRA":
                return LanguageFrench.getChannelUnregisteredMessage();
            case "ITA":
                return LanguageItalian.getChannelUnregisteredMessage();
            case "RUS":
                return LanguageRussian.getChannelUnregisteredMessage();
            case "IND":
                return LanguageIndonesia.getChannelUnregisteredMessage();
            default:
                return LanguageEnglish.getChannelUnregisteredMessage();
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

    public static String getRoleChangedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getRoleChangedMessage();
            case "ESP":
                return LanguageSpain.getRoleChangedMessage();
            case "POL":
                return LanguagePolish.getRoleChangedMessage();
            case "FRA":
                return LanguageFrench.getRoleChangedMessage();
            case "ITA":
                return LanguageItalian.getRoleChangedMessage();
            case "RUS":
                return LanguageRussian.getRoleChangedMessage();
            case "IND":
                return LanguageIndonesia.getRoleChangedMessage();
            default:
                return LanguageEnglish.getRoleChangedMessage();
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


    public static String getCustomMessageCreatedMessage(String lang) {
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

    public static String getShowAllCustomMessages(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getShowAllCustomMessages();
            case "ESP":
                return LanguageSpain.getShowAllCustomMessages();
            case "POL":
                return LanguagePolish.getShowAllCustomMessages();
            case "FRA":
                return LanguageFrench.getShowAllCustomMessages();
            case "ITA":
                return LanguageItalian.getShowAllCustomMessages();
            case "RUS":
                return LanguageRussian.getShowAllCustomMessages();
            case "IND":
                return LanguageIndonesia.getShowAllCustomMessages();
            default:
                return LanguageEnglish.getShowAllCustomMessages();
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

    public static String getEmbedSpawnAtMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEmbedSpawnAtMessage();
            case "ESP":
                return LanguageSpain.getEmbedSpawnAtMessage();
            case "POL":
                return LanguagePolish.getEmbedSpawnAtMessage();
            case "FRA":
                return LanguageFrench.getEmbedSpawnAtMessage();
            case "ITA":
                return LanguageItalian.getEmbedSpawnAtMessage();
            case "RUS":
                return LanguageRussian.getEmbedSpawnAtMessage();
            case "IND":
                return LanguageIndonesia.getEmbedSpawnAtMessage();
            default:
                return LanguageEnglish.getEmbedSpawnAtMessage();
        }
    }

    public static String getEmbedCountdownMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEmbedCountdownMessage();
            case "ESP":
                return LanguageSpain.getEmbedCountdownMessage();
            case "POL":
                return LanguagePolish.getEmbedCountdownMessage();
            case "FRA":
                return LanguageFrench.getEmbedCountdownMessage();
            case "ITA":
                return LanguageItalian.getEmbedCountdownMessage();
            case "RUS":
                return LanguageRussian.getEmbedCountdownMessage();
            case "IND":
                return LanguageIndonesia.getEmbedCountdownMessage();
            default:
                return LanguageEnglish.getEmbedCountdownMessage();
        }
    }

    public static String getEmbedWorldEventMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEmbedWorldEventMessage();
            case "ESP":
                return LanguageSpain.getEmbedWorldEventMessage();
            case "POL":
                return LanguagePolish.getEmbedWorldEventMessage();
            case "FRA":
                return LanguageFrench.getEmbedWorldEventMessage();
            case "ITA":
                return LanguageItalian.getEmbedWorldEventMessage();
            case "RUS":
                return LanguageRussian.getEmbedWorldEventMessage();
            case "IND":
                return LanguageIndonesia.getEmbedWorldEventMessage();
            default:
                return LanguageEnglish.getEmbedWorldEventMessage();
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

    public static String getCustomMessageWhatChannelMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageWhatChannelMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageWhatChannelMessage();
            case "POL":
                return LanguagePolish.getCustomMessageWhatChannelMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageWhatChannelMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageWhatChannelMessage();
            case "RUS":
                return LanguageRussian.getCustomMessageWhatChannelMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageWhatChannelMessage();
            default:
                return LanguageEnglish.getCustomMessageWhatChannelMessage();
        }
    }

    public static String getCustomMessageWhatDayMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageWhatDayMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageWhatDayMessage();
            case "POL":
                return LanguagePolish.getCustomMessageWhatDayMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageWhatDayMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageWhatDayMessage();
            case "RUS":
                return LanguageRussian.getCustomMessageWhatDayMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageWhatDayMessage();
            default:
                return LanguageEnglish.getCustomMessageWhatDayMessage();
        }
    }

    public static String getCustomMessageWhatTimeMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageWhatTimeMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageWhatTimeMessage();
            case "POL":
                return LanguagePolish.getCustomMessageWhatTimeMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageWhatTimeMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageWhatTimeMessage();
            case "RUS":
                return LanguageRussian.getCustomMessageWhatTimeMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageWhatTimeMessage();
            default:
                return LanguageEnglish.getCustomMessageWhatTimeMessage();
        }
    }

    public static String getCustomMessageWhatMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageWhatMessageMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageWhatMessageMessage();
            case "POL":
                return LanguagePolish.getCustomMessageWhatMessageMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageWhatMessageMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageWhatMessageMessage();
            case "RUS":
                return LanguageRussian.getCustomMessageWhatMessageMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageWhatMessageMessage();
            default:
                return LanguageEnglish.getCustomMessageWhatMessageMessage();
        }
    }

    public static String getCustomMessageIsRepeatingMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageIsRepeatingMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageIsRepeatingMessage();
            case "POL":
                return LanguagePolish.getCustomMessageIsRepeatingMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageIsRepeatingMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageIsRepeatingMessage();
            case "RUS":
                return LanguageRussian.getCustomMessageIsRepeatingMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageIsRepeatingMessage();
            default:
                return LanguageEnglish.getCustomMessageIsRepeatingMessage();
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

    public static String getCustomMessageInvalidDayMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getCustomMessageInvalidDayMessage();
            case "ESP":
                return LanguageSpain.getCustomMessageInvalidDayMessage();
            case "POL":
                return LanguagePolish.getCustomMessageInvalidDayMessage();
            case "FRA":
                return LanguageFrench.getCustomMessageInvalidDayMessage();
            case "ITA":
                return LanguageItalian.getCustomMessageInvalidDayMessage();
            case "RUS":
                return LanguageRussian.getCustomMessageInvalidDayMessage();
            case "IND":
                return LanguageIndonesia.getCustomMessageInvalidDayMessage();
            default:
                return LanguageEnglish.getCustomMessageInvalidDayMessage();
        }
    }

    public static String getHelpRegistersChannelMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpRegistersChannelMessage();
            case "ESP":
                return LanguageSpain.getHelpRegistersChannelMessage();
            case "POL":
                return LanguagePolish.getHelpRegistersChannelMessage();
            case "FRA":
                return LanguageFrench.getHelpRegistersChannelMessage();
            case "ITA":
                return LanguageItalian.getHelpRegistersChannelMessage();
            case "RUS":
                return LanguageRussian.getHelpRegistersChannelMessage();
            case "IND":
                return LanguageIndonesia.getHelpRegistersChannelMessage();
            default:
                return LanguageEnglish.getHelpRegistersChannelMessage();
        }
    }

    public static String getHelpUnregistersChannelMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpUnregistersChannelMessage();
            case "ESP":
                return LanguageSpain.getHelpUnregistersChannelMessage();
            case "POL":
                return LanguagePolish.getHelpUnregistersChannelMessage();
            case "FRA":
                return LanguageFrench.getHelpUnregistersChannelMessage();
            case "ITA":
                return LanguageItalian.getHelpUnregistersChannelMessage();
            case "RUS":
                return LanguageRussian.getHelpUnregistersChannelMessage();
            case "IND":
                return LanguageIndonesia.getHelpUnregistersChannelMessage();
            default:
                return LanguageEnglish.getHelpUnregistersChannelMessage();
        }
    }

    public static String getHelpSetRoleMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpSetRoleMessage();
            case "ESP":
                return LanguageSpain.getHelpSetRoleMessage();
            case "POL":
                return LanguagePolish.getHelpSetRoleMessage();
            case "FRA":
                return LanguageFrench.getHelpSetRoleMessage();
            case "ITA":
                return LanguageItalian.getHelpSetRoleMessage();
            case "RUS":
                return LanguageRussian.getHelpSetRoleMessage();
            case "IND":
                return LanguageIndonesia.getHelpSetRoleMessage();
            default:
                return LanguageEnglish.getHelpSetRoleMessage();
        }
    }

    public static String getHelpShowInfoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpShowInfoMessage();
            case "ESP":
                return LanguageSpain.getHelpShowInfoMessage();
            case "POL":
                return LanguagePolish.getHelpShowInfoMessage();
            case "FRA":
                return LanguageFrench.getHelpShowInfoMessage();
            case "ITA":
                return LanguageItalian.getHelpShowInfoMessage();
            case "RUS":
                return LanguageRussian.getHelpShowInfoMessage();
            case "IND":
                return LanguageIndonesia.getHelpShowInfoMessage();
            default:
                return LanguageEnglish.getHelpShowInfoMessage();
        }
    }

    public static String getHelpCreateCustomMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpCreateCustomMessageMessage();
            case "ESP":
                return LanguageSpain.getHelpCreateCustomMessageMessage();
            case "POL":
                return LanguagePolish.getHelpCreateCustomMessageMessage();
            case "FRA":
                return LanguageFrench.getHelpCreateCustomMessageMessage();
            case "ITA":
                return LanguageItalian.getHelpCreateCustomMessageMessage();
            case "RUS":
                return LanguageRussian.getHelpCreateCustomMessageMessage();
            case "IND":
                return LanguageIndonesia.getHelpCreateCustomMessageMessage();
            default:
                return LanguageEnglish.getHelpCreateCustomMessageMessage();
        }
    }

    public static String getHelpDeleteCustomMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpDeleteCustomMessageMessage();
            case "ESP":
                return LanguageSpain.getHelpDeleteCustomMessageMessage();
            case "POL":
                return LanguagePolish.getHelpDeleteCustomMessageMessage();
            case "FRA":
                return LanguageFrench.getHelpDeleteCustomMessageMessage();
            case "ITA":
                return LanguageItalian.getHelpDeleteCustomMessageMessage();
            case "RUS":
                return LanguageRussian.getHelpDeleteCustomMessageMessage();
            case "IND":
                return LanguageIndonesia.getHelpDeleteCustomMessageMessage();
            default:
                return LanguageEnglish.getHelpDeleteCustomMessageMessage();
        }
    }

    public static String getHelpShowAllCustomMessagesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpShowAllCustomMessagesMessage();
            case "ESP":
                return LanguageSpain.getHelpShowAllCustomMessagesMessage();
            case "POL":
                return LanguagePolish.getHelpShowAllCustomMessagesMessage();
            case "FRA":
                return LanguageFrench.getHelpShowAllCustomMessagesMessage();
            case "ITA":
                return LanguageItalian.getHelpShowAllCustomMessagesMessage();
            case "RUS":
                return LanguageRussian.getHelpShowAllCustomMessagesMessage();
            case "IND":
                return LanguageIndonesia.getHelpShowAllCustomMessagesMessage();
            default:
                return LanguageEnglish.getHelpShowAllCustomMessagesMessage();
        }
    }

    public static String getHelpShowCustomMessageInfoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpShowAllCustomMessagesMessage();
            case "ESP":
                return LanguageSpain.getHelpShowAllCustomMessagesMessage();
            case "POL":
                return LanguagePolish.getHelpShowAllCustomMessagesMessage();
            case "FRA":
                return LanguageFrench.getHelpShowAllCustomMessagesMessage();
            case "ITA":
                return LanguageItalian.getHelpShowAllCustomMessagesMessage();
            case "RUS":
                return LanguageRussian.getHelpShowAllCustomMessagesMessage();
            case "IND":
                return LanguageIndonesia.getHelpShowAllCustomMessagesMessage();
            default:
                return LanguageEnglish.getHelpShowCustomMessageInfoMessage();
        }
    }

    public static String getHelpServerHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerHeadUpMessage();
            case "ESP":
                return LanguageSpain.getHelpServerHeadUpMessage();
            case "POL":
                return LanguagePolish.getHelpServerHeadUpMessage();
            case "FRA":
                return LanguageFrench.getHelpServerHeadUpMessage();
            case "ITA":
                return LanguageItalian.getHelpServerHeadUpMessage();
            case "RUS":
                return LanguageRussian.getHelpServerHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerHeadUpMessage();
            default:
                return LanguageEnglish.getHelpServerHeadUpMessage();
        }
    }

    public static String getHelpServerMessagesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerMessagesMessage();
            case "ESP":
                return LanguageSpain.getHelpServerMessagesMessage();
            case "POL":
                return LanguagePolish.getHelpServerMessagesMessage();
            case "FRA":
                return LanguageFrench.getHelpServerMessagesMessage();
            case "ITA":
                return LanguageItalian.getHelpServerMessagesMessage();
            case "RUS":
                return LanguageRussian.getHelpServerMessagesMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerMessagesMessage();
            default:
                return LanguageEnglish.getHelpServerMessagesMessage();
        }
    }

    public static String getHelpServerConfigMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerConfigMessage();
            case "ESP":
                return LanguageSpain.getHelpServerConfigMessage();
            case "POL":
                return LanguagePolish.getHelpServerConfigMessage();
            case "FRA":
                return LanguageFrench.getHelpServerConfigMessage();
            case "ITA":
                return LanguageItalian.getHelpServerConfigMessage();
            case "RUS":
                return LanguageRussian.getHelpServerConfigMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerConfigMessage();
            default:
                return LanguageEnglish.getHelpServerConfigMessage();
        }
    }

    public static String getHelpServerLanguageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerLanguageMessage();
            case "ESP":
                return LanguageSpain.getHelpServerLanguageMessage();
            case "POL":
                return LanguagePolish.getHelpServerLanguageMessage();
            case "FRA":
                return LanguageFrench.getHelpServerLanguageMessage();
            case "ITA":
                return LanguageItalian.getHelpServerLanguageMessage();
            case "RUS":
                return LanguageRussian.getHelpServerLanguageMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerLanguageMessage();
            default:
                return LanguageEnglish.getHelpServerLanguageMessage();
        }
    }

    public static String getHelpServerTimezoneMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerTimezoneMessage();
            case "ESP":
                return LanguageSpain.getHelpServerTimezoneMessage();
            case "POL":
                return LanguagePolish.getHelpServerTimezoneMessage();
            case "FRA":
                return LanguageFrench.getHelpServerTimezoneMessage();
            case "ITA":
                return LanguageItalian.getHelpServerTimezoneMessage();
            case "RUS":
                return LanguageRussian.getHelpServerTimezoneMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerTimezoneMessage();
            default:
                return LanguageEnglish.getHelpServerTimezoneMessage();
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

    public static String getHelpServerAutoDeleteSetMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerAutoDeleteSetMessage();
            case "ESP":
                return LanguageSpain.getHelpServerAutoDeleteSetMessage();
            case "POL":
                return LanguagePolish.getHelpServerAutoDeleteSetMessage();
            case "FRA":
                return LanguageFrench.getHelpServerAutoDeleteSetMessage();
            case "ITA":
                return LanguageItalian.getHelpServerAutoDeleteSetMessage();
            case "RUS":
                return LanguageRussian.getHelpServerAutoDeleteSetMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerAutoDeleteSetMessage();
            default:
                return LanguageEnglish.getHelpServerAutoDeleteSetMessage();
        }
    }

    public static String getHelpServerAutoDeleteValueMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpServerAutoDeleteValueMessage();
            case "ESP":
                return LanguageSpain.getHelpServerAutoDeleteValueMessage();
            case "POL":
                return LanguagePolish.getHelpServerAutoDeleteValueMessage();
            case "FRA":
                return LanguageFrench.getHelpServerAutoDeleteValueMessage();
            case "ITA":
                return LanguageItalian.getHelpServerAutoDeleteValueMessage();
            case "RUS":
                return LanguageRussian.getHelpServerAutoDeleteValueMessage();
            case "IND":
                return LanguageIndonesia.getHelpServerAutoDeleteValueMessage();
            default:
                return LanguageEnglish.getHelpServerAutoDeleteValueMessage();
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

    public static String getFooterReportToDevMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getFooterReportToDevMessage();
            case "ESP":
                return LanguageSpain.getFooterReportToDevMessage();
            case "POL":
                return LanguagePolish.getFooterReportToDevMessage();
            case "FRA":
                return LanguageFrench.getFooterReportToDevMessage();
            case "ITA":
                return LanguageItalian.getFooterReportToDevMessage();
            case "RUS":
                return LanguageRussian.getFooterReportToDevMessage();
            case "IND":
                return LanguageIndonesia.getFooterReportToDevMessage();
            default:
                return LanguageEnglish.getFooterReportToDevMessage();
        }
    }

    public static String getWrathborneInvasionMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWrathborneInvasionMessage();
            case "ESP":
                return LanguageSpain.getWrathborneInvasionMessage();
            case "POL":
                return LanguagePolish.getWrathborneInvasionMessage();
            case "FRA":
                return LanguageFrench.getWrathborneInvasionMessage();
            case "ITA":
                return LanguageItalian.getWrathborneInvasionMessage();
            case "RUS":
                return LanguageRussian.getWrathborneInvasionMessage();
            case "IND":
                return LanguageIndonesia.getWrathborneInvasionMessage();
            default:
                return LanguageEnglish.getWrathborneInvasionMessage();
        }
    }

    public static String getWrathborneInvasionHeadUpMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getWrathborneInvasionHeadUpMessage();
            case "ESP":
                return LanguageSpain.getWrathborneInvasionHeadUpMessage();
            case "POL":
                return LanguagePolish.getWrathborneInvasionHeadUpMessage();
            case "FRA":
                return LanguageFrench.getWrathborneInvasionHeadUpMessage();
            case "ITA":
                return LanguageItalian.getWrathborneInvasionHeadUpMessage();
            case "RUS":
                return LanguageRussian.getWrathborneInvasionHeadUpMessage();
            case "IND":
                return LanguageIndonesia.getWrathborneInvasionHeadUpMessage();
            default:
                return LanguageEnglish.getWrathborneInvasionHeadUpMessage();
        }
    }

    public static String getInstall1Message(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInstall1Message();
            case "ESP":
                return LanguageSpain.getInstall1Message();
            case "POL":
                return LanguagePolish.getInstall1Message();
            case "FRA":
                return LanguageFrench.getInstall1Message();
            case "ITA":
                return LanguageItalian.getInstall1Message();
            case "RUS":
                return LanguageRussian.getInstall1Message();
            case "IND":
                return LanguageIndonesia.getInstall1Message();
            default:
                return LanguageEnglish.getInstall1Message();
        }
    }

    public static String getInstall2Message(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInstall2Message();
            case "ESP":
                return LanguageSpain.getInstall2Message();
            case "POL":
                return LanguagePolish.getInstall2Message();
            case "FRA":
                return LanguageFrench.getInstall2Message();
            case "ITA":
                return LanguageItalian.getInstall2Message();
            case "RUS":
                return LanguageRussian.getInstall2Message();
            case "IND":
                return LanguageIndonesia.getInstall2Message();
            default:
                return LanguageEnglish.getInstall2Message();
        }
    }

    public static String getInstall3Message(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInstall3Message();
            case "ESP":
                return LanguageSpain.getInstall3Message();
            case "POL":
                return LanguagePolish.getInstall3Message();
            case "FRA":
                return LanguageFrench.getInstall3Message();
            case "ITA":
                return LanguageItalian.getInstall3Message();
            case "RUS":
                return LanguageRussian.getInstall3Message();
            case "IND":
                return LanguageIndonesia.getInstall3Message();
            default:
                return LanguageEnglish.getInstall3Message();
        }
    }

    public static String getInstall4Message(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInstall4Message();
            case "ESP":
                return LanguageSpain.getInstall4Message();
            case "POL":
                return LanguagePolish.getInstall4Message();
            case "FRA":
                return LanguageFrench.getInstall4Message();
            case "ITA":
                return LanguageItalian.getInstall4Message();
            case "RUS":
                return LanguageRussian.getInstall4Message();
            case "IND":
                return LanguageIndonesia.getInstall4Message();
            default:
                return LanguageEnglish.getInstall4Message();
        }
    }

    public static String getInstall5Message(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInstall5Message();
            case "ESP":
                return LanguageSpain.getInstall5Message();
            case "POL":
                return LanguagePolish.getInstall5Message();
            case "FRA":
                return LanguageFrench.getInstall5Message();
            case "ITA":
                return LanguageItalian.getInstall5Message();
            case "RUS":
                return LanguageRussian.getInstall5Message();
            case "IND":
                return LanguageIndonesia.getInstall5Message();
            default:
                return LanguageEnglish.getInstall5Message();
        }
    }

    public static String getInstructionsMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInstructionsMessage();
            case "ESP":
                return LanguageSpain.getInstructionsMessage();
            case "POL":
                return LanguagePolish.getInstructionsMessage();
            case "FRA":
                return LanguageFrench.getInstructionsMessage();
            case "ITA":
                return LanguageItalian.getInstructionsMessage();
            case "RUS":
                return LanguageRussian.getInstructionsMessage();
            case "IND":
                return LanguageIndonesia.getInstructionsMessage();
            default:
                return LanguageEnglish.getInstructionsMessage();
        }
    }

    public static String getInfoTimezoneMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoTimezoneMessage();
            case "ESP":
                return LanguageSpain.getInfoTimezoneMessage();
            case "POL":
                return LanguagePolish.getInfoTimezoneMessage();
            case "FRA":
                return LanguageFrench.getInfoTimezoneMessage();
            case "ITA":
                return LanguageItalian.getInfoTimezoneMessage();
            case "RUS":
                return LanguageRussian.getInfoTimezoneMessage();
            case "IND":
                return LanguageIndonesia.getInfoTimezoneMessage();
            default:
                return LanguageEnglish.getInfoTimezoneMessage();
        }
    }

    public static String getInfoCurrentTimeMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoCurrentTimeMessage();
            case "ESP":
                return LanguageSpain.getInfoCurrentTimeMessage();
            case "POL":
                return LanguagePolish.getInfoCurrentTimeMessage();
            case "FRA":
                return LanguageFrench.getInfoCurrentTimeMessage();
            case "ITA":
                return LanguageItalian.getInfoCurrentTimeMessage();
            case "RUS":
                return LanguageRussian.getInfoCurrentTimeMessage();
            case "IND":
                return LanguageIndonesia.getInfoCurrentTimeMessage();
            default:
                return LanguageEnglish.getInfoCurrentTimeMessage();
        }
    }

    public static String getInfoTextChannelIDMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoTextChannelIDMessage();
            case "ESP":
                return LanguageSpain.getInfoTextChannelIDMessage();
            case "POL":
                return LanguagePolish.getInfoTextChannelIDMessage();
            case "FRA":
                return LanguageFrench.getInfoTextChannelIDMessage();
            case "ITA":
                return LanguageItalian.getInfoTextChannelIDMessage();
            case "RUS":
                return LanguageRussian.getInfoTextChannelIDMessage();
            case "IND":
                return LanguageIndonesia.getInfoTextChannelIDMessage();
            default:
                return LanguageEnglish.getInfoTextChannelIDMessage();
        }
    }

    public static String getInfoMentionedRoleMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoMentionedRoleMessage();
            case "ESP":
                return LanguageSpain.getInfoMentionedRoleMessage();
            case "POL":
                return LanguagePolish.getInfoMentionedRoleMessage();
            case "FRA":
                return LanguageFrench.getInfoMentionedRoleMessage();
            case "ITA":
                return LanguageItalian.getInfoMentionedRoleMessage();
            case "RUS":
                return LanguageRussian.getInfoMentionedRoleMessage();
            case "IND":
                return LanguageIndonesia.getInfoMentionedRoleMessage();
            default:
                return LanguageEnglish.getInfoMentionedRoleMessage();
        }
    }

    public static String getInfoYesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoYesMessage();
            case "ESP":
                return LanguageSpain.getInfoYesMessage();
            case "POL":
                return LanguagePolish.getInfoYesMessage();
            case "FRA":
                return LanguageFrench.getInfoYesMessage();
            case "ITA":
                return LanguageItalian.getInfoYesMessage();
            case "RUS":
                return LanguageRussian.getInfoYesMessage();
            case "IND":
                return LanguageIndonesia.getInfoYesMessage();
            default:
                return LanguageEnglish.getInfoYesMessage();
        }
    }

    public static String getInfoNoMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoNoMessage();
            case "ESP":
                return LanguageSpain.getInfoNoMessage();
            case "POL":
                return LanguagePolish.getInfoNoMessage();
            case "FRA":
                return LanguageFrench.getInfoNoMessage();
            case "ITA":
                return LanguageItalian.getInfoNoMessage();
            case "RUS":
                return LanguageRussian.getInfoNoMessage();
            case "IND":
                return LanguageIndonesia.getInfoNoMessage();
            default:
                return LanguageEnglish.getInfoNoMessage();
        }
    }

    public static String getInfoEventMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoEventMessageMessage();
            case "ESP":
                return LanguageSpain.getInfoEventMessageMessage();
            case "POL":
                return LanguagePolish.getInfoEventMessageMessage();
            case "FRA":
                return LanguageFrench.getInfoEventMessageMessage();
            case "ITA":
                return LanguageItalian.getInfoEventMessageMessage();
            case "RUS":
                return LanguageRussian.getInfoEventMessageMessage();
            case "IND":
                return LanguageIndonesia.getInfoEventMessageMessage();
            default:
                return LanguageEnglish.getInfoEventMessageMessage();
        }
    }

    public static String getInfoHeadUpMessageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoHeadUpMessageMessage();
            case "ESP":
                return LanguageSpain.getInfoHeadUpMessageMessage();
            case "POL":
                return LanguagePolish.getInfoHeadUpMessageMessage();
            case "FRA":
                return LanguageFrench.getInfoHeadUpMessageMessage();
            case "ITA":
                return LanguageItalian.getInfoHeadUpMessageMessage();
            case "RUS":
                return LanguageRussian.getInfoHeadUpMessageMessage();
            case "IND":
                return LanguageIndonesia.getInfoHeadUpMessageMessage();
            default:
                return LanguageEnglish.getInfoHeadUpMessageMessage();
        }
    }

    public static String getInfoAncientNightmareMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoAncientNightmareMessage();
            case "ESP":
                return LanguageSpain.getInfoAncientNightmareMessage();
            case "POL":
                return LanguagePolish.getInfoAncientNightmareMessage();
            case "FRA":
                return LanguageFrench.getInfoAncientNightmareMessage();
            case "ITA":
                return LanguageItalian.getInfoAncientNightmareMessage();
            case "RUS":
                return LanguageRussian.getInfoAncientNightmareMessage();
            case "IND":
                return LanguageIndonesia.getInfoAncientNightmareMessage();
            default:
                return LanguageEnglish.getInfoAncientNightmareMessage();
        }
    }

    public static String getInfoAncientArenaMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoAncientArenaMessage();
            case "ESP":
                return LanguageSpain.getInfoAncientArenaMessage();
            case "POL":
                return LanguagePolish.getInfoAncientArenaMessage();
            case "FRA":
                return LanguageFrench.getInfoAncientArenaMessage();
            case "ITA":
                return LanguageItalian.getInfoAncientArenaMessage();
            case "RUS":
                return LanguageRussian.getInfoAncientArenaMessage();
            case "IND":
                return LanguageIndonesia.getInfoAncientArenaMessage();
            default:
                return LanguageEnglish.getInfoAncientArenaMessage();
        }
    }

    public static String getInfoAssemblyMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoAssemblyMessage();
            case "ESP":
                return LanguageSpain.getInfoAssemblyMessage();
            case "POL":
                return LanguagePolish.getInfoAssemblyMessage();
            case "FRA":
                return LanguageFrench.getInfoAssemblyMessage();
            case "ITA":
                return LanguageItalian.getInfoAssemblyMessage();
            case "RUS":
                return LanguageRussian.getInfoAssemblyMessage();
            case "IND":
                return LanguageIndonesia.getInfoAssemblyMessage();
            default:
                return LanguageEnglish.getInfoAssemblyMessage();
        }
    }

    public static String getInfoBattlegroundMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoBattlegroundMessage();
            case "ESP":
                return LanguageSpain.getInfoBattlegroundMessage();
            case "POL":
                return LanguagePolish.getInfoBattlegroundMessage();
            case "FRA":
                return LanguageFrench.getInfoBattlegroundMessage();
            case "ITA":
                return LanguageItalian.getInfoBattlegroundMessage();
            case "RUS":
                return LanguageRussian.getInfoBattlegroundMessage();
            case "IND":
                return LanguageIndonesia.getInfoBattlegroundMessage();
            default:
                return LanguageEnglish.getInfoBattlegroundMessage();
        }
    }

    public static String getInfoDefendTheVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoDefendTheVaultMessage();
            case "ESP":
                return LanguageSpain.getInfoDefendTheVaultMessage();
            case "POL":
                return LanguagePolish.getInfoDefendTheVaultMessage();
            case "FRA":
                return LanguageFrench.getInfoDefendTheVaultMessage();
            case "ITA":
                return LanguageItalian.getInfoDefendTheVaultMessage();
            case "RUS":
                return LanguageRussian.getInfoDefendTheVaultMessage();
            case "IND":
                return LanguageIndonesia.getInfoDefendTheVaultMessage();
            default:
                return LanguageEnglish.getInfoDefendTheVaultMessage();
        }
    }

    public static String getInfoRaidTheVaultMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoRaidTheVaultMessage();
            case "ESP":
                return LanguageSpain.getInfoRaidTheVaultMessage();
            case "POL":
                return LanguagePolish.getInfoRaidTheVaultMessage();
            case "FRA":
                return LanguageFrench.getInfoRaidTheVaultMessage();
            case "ITA":
                return LanguageItalian.getInfoRaidTheVaultMessage();
            case "RUS":
                return LanguageRussian.getInfoRaidTheVaultMessage();
            case "IND":
                return LanguageIndonesia.getInfoRaidTheVaultMessage();
            default:
                return LanguageEnglish.getInfoRaidTheVaultMessage();
        }
    }

    public static String getInfoDemonGatesMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoDemonGatesMessage();
            case "ESP":
                return LanguageSpain.getInfoDemonGatesMessage();
            case "POL":
                return LanguagePolish.getInfoDemonGatesMessage();
            case "FRA":
                return LanguageFrench.getInfoDemonGatesMessage();
            case "ITA":
                return LanguageItalian.getInfoDemonGatesMessage();
            case "RUS":
                return LanguageRussian.getInfoDemonGatesMessage();
            case "IND":
                return LanguageIndonesia.getInfoDemonGatesMessage();
            default:
                return LanguageEnglish.getInfoDemonGatesMessage();
        }
    }

    public static String getInfoShadowLotteryMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoShadowLotteryMessage();
            case "ESP":
                return LanguageSpain.getInfoShadowLotteryMessage();
            case "POL":
                return LanguagePolish.getInfoShadowLotteryMessage();
            case "FRA":
                return LanguageFrench.getInfoShadowLotteryMessage();
            case "ITA":
                return LanguageItalian.getInfoShadowLotteryMessage();
            case "RUS":
                return LanguageRussian.getInfoShadowLotteryMessage();
            case "IND":
                return LanguageIndonesia.getInfoShadowLotteryMessage();
            default:
                return LanguageEnglish.getInfoShadowLotteryMessage();
        }
    }

    public static String getInfoHauntedCarriageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoHauntedCarriageMessage();
            case "ESP":
                return LanguageSpain.getInfoHauntedCarriageMessage();
            case "POL":
                return LanguagePolish.getInfoHauntedCarriageMessage();
            case "FRA":
                return LanguageFrench.getInfoHauntedCarriageMessage();
            case "ITA":
                return LanguageItalian.getInfoHauntedCarriageMessage();
            case "RUS":
                return LanguageRussian.getInfoHauntedCarriageMessage();
            case "IND":
                return LanguageIndonesia.getInfoHauntedCarriageMessage();
            default:
                return LanguageEnglish.getInfoHauntedCarriageMessage();
        }
    }

    public static String getInfoWrathborneInvasionMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoWrathborneInvasionMessage();
            case "ESP":
                return LanguageSpain.getInfoWrathborneInvasionMessage();
            case "POL":
                return LanguagePolish.getInfoWrathborneInvasionMessage();
            case "FRA":
                return LanguageFrench.getInfoWrathborneInvasionMessage();
            case "ITA":
                return LanguageItalian.getInfoWrathborneInvasionMessage();
            case "RUS":
                return LanguageRussian.getInfoWrathborneInvasionMessage();
            case "IND":
                return LanguageIndonesia.getInfoWrathborneInvasionMessage();
            default:
                return LanguageEnglish.getInfoWrathborneInvasionMessage();
        }
    }

    public static String getInfoHauntedCarriageEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoHauntedCarriageEmbedMessage();
            case "ESP":
                return LanguageSpain.getInfoHauntedCarriageEmbedMessage();
            case "POL":
                return LanguagePolish.getInfoHauntedCarriageEmbedMessage();
            case "FRA":
                return LanguageFrench.getInfoHauntedCarriageEmbedMessage();
            case "ITA":
                return LanguageItalian.getInfoHauntedCarriageEmbedMessage();
            case "RUS":
                return LanguageRussian.getInfoHauntedCarriageEmbedMessage();
            case "IND":
                return LanguageIndonesia.getInfoHauntedCarriageEmbedMessage();
            default:
                return LanguageEnglish.getInfoHauntedCarriageEmbedMessage();
        }
    }

    public static String getInfoDemonGatesEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoDemonGatesEmbedMessage();
            case "ESP":
                return LanguageSpain.getInfoDemonGatesEmbedMessage();
            case "POL":
                return LanguagePolish.getInfoDemonGatesEmbedMessage();
            case "FRA":
                return LanguageFrench.getInfoDemonGatesEmbedMessage();
            case "ITA":
                return LanguageItalian.getInfoDemonGatesEmbedMessage();
            case "RUS":
                return LanguageRussian.getInfoDemonGatesEmbedMessage();
            case "IND":
                return LanguageIndonesia.getInfoDemonGatesEmbedMessage();
            default:
                return LanguageEnglish.getInfoDemonGatesEmbedMessage();
        }
    }

    public static String getInfoAncientNightmareEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoAncientNightmareEmbedMessage();
            case "ESP":
                return LanguageSpain.getInfoAncientNightmareEmbedMessage();
            case "POL":
                return LanguagePolish.getInfoAncientNightmareEmbedMessage();
            case "FRA":
                return LanguageFrench.getInfoAncientNightmareEmbedMessage();
            case "ITA":
                return LanguageItalian.getInfoAncientNightmareEmbedMessage();
            case "RUS":
                return LanguageRussian.getInfoAncientNightmareEmbedMessage();
            case "IND":
                return LanguageIndonesia.getInfoAncientNightmareEmbedMessage();
            default:
                return LanguageEnglish.getInfoAncientNightmareEmbedMessage();
        }
    }

    public static String getInfoAncientArenaEmbedMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoAncientArenaEmbedMessage();
            case "ESP":
                return LanguageSpain.getInfoAncientArenaEmbedMessage();
            case "POL":
                return LanguagePolish.getInfoAncientArenaEmbedMessage();
            case "FRA":
                return LanguageFrench.getInfoAncientArenaEmbedMessage();
            case "ITA":
                return LanguageItalian.getInfoAncientArenaEmbedMessage();
            case "RUS":
                return LanguageRussian.getInfoAncientArenaEmbedMessage();
            case "IND":
                return LanguageIndonesia.getInfoAncientArenaEmbedMessage();
            default:
                return LanguageEnglish.getInfoAncientArenaEmbedMessage();
        }
    }

    public static String getErrorCannotDisableEventMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getErrorCannotDisableEventMessage();
            case "ESP":
                return LanguageSpain.getErrorCannotDisableEventMessage();
            case "POL":
                return LanguagePolish.getErrorCannotDisableEventMessage();
            case "FRA":
                return LanguageFrench.getErrorCannotDisableEventMessage();
            case "ITA":
                return LanguageItalian.getErrorCannotDisableEventMessage();
            case "RUS":
                return LanguageRussian.getErrorCannotDisableEventMessage();
            case "IND":
                return LanguageIndonesia.getErrorCannotDisableEventMessage();
            default:
                return LanguageEnglish.getErrorCannotDisableEventMessage();
        }
    }

    public static String getFooterCreatedByMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getFooterCreatedByMessage();
            case "ESP":
                return LanguageSpain.getFooterCreatedByMessage();
            case "POL":
                return LanguagePolish.getFooterCreatedByMessage();
            case "FRA":
                return LanguageFrench.getFooterCreatedByMessage();
            case "ITA":
                return LanguageItalian.getFooterCreatedByMessage();
            case "RUS":
                return LanguageRussian.getFooterCreatedByMessage();
            case "IND":
                return LanguageIndonesia.getFooterCreatedByMessage();
            default:
                return LanguageEnglish.getFooterCreatedByMessage();
        }
    }

    public static String getAutoDeleteEnabledMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAutoDeleteEnabledMessage();
            case "ESP":
                return LanguageSpain.getAutoDeleteEnabledMessage();
            case "POL":
                return LanguagePolish.getAutoDeleteEnabledMessage();
            case "FRA":
                return LanguageFrench.getAutoDeleteEnabledMessage();
            case "ITA":
                return LanguageItalian.getAutoDeleteEnabledMessage();
            case "RUS":
                return LanguageRussian.getAutoDeleteEnabledMessage();
            case "IND":
                return LanguageIndonesia.getAutoDeleteEnabledMessage();
            default:
                return LanguageEnglish.getAutoDeleteEnabledMessage();
        }
    }

    public static String getAutoDeleteDisabledMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAutoDeleteDisabledMessage();
            case "ESP":
                return LanguageSpain.getAutoDeleteDisabledMessage();
            case "POL":
                return LanguagePolish.getAutoDeleteDisabledMessage();
            case "FRA":
                return LanguageFrench.getAutoDeleteDisabledMessage();
            case "ITA":
                return LanguageItalian.getAutoDeleteDisabledMessage();
            case "RUS":
                return LanguageRussian.getAutoDeleteDisabledMessage();
            case "IND":
                return LanguageIndonesia.getAutoDeleteDisabledMessage();
            default:
                return LanguageEnglish.getAutoDeleteDisabledMessage();
        }
    }

    public static String getAutoDeleteValueSetMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getAutoDeleteValueSetMessage();
            case "ESP":
                return LanguageSpain.getAutoDeleteValueSetMessage();
            case "POL":
                return LanguagePolish.getAutoDeleteValueSetMessage();
            case "FRA":
                return LanguageFrench.getAutoDeleteValueSetMessage();
            case "ITA":
                return LanguageItalian.getAutoDeleteValueSetMessage();
            case "RUS":
                return LanguageRussian.getAutoDeleteValueSetMessage();
            case "IND":
                return LanguageIndonesia.getAutoDeleteValueSetMessage();
            default:
                return LanguageEnglish.getAutoDeleteValueSetMessage();
        }
    }

    public static String getInfoLanguageMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoLanguageMessage();
            case "ESP":
                return LanguageSpain.getInfoLanguageMessage();
            case "POL":
                return LanguagePolish.getInfoLanguageMessage();
            case "FRA":
                return LanguageFrench.getInfoLanguageMessage();
            case "ITA":
                return LanguageItalian.getInfoLanguageMessage();
            case "RUS":
                return LanguageRussian.getInfoLanguageMessage();
            case "IND":
                return LanguageIndonesia.getInfoLanguageMessage();
            default:
                return LanguageEnglish.getInfoLanguageMessage();
        }
    }

    public static String getInfoGuildIdMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getInfoGuildIdMessage();
            case "ESP":
                return LanguageSpain.getInfoGuildIdMessage();
            case "POL":
                return LanguagePolish.getInfoGuildIdMessage();
            case "FRA":
                return LanguageFrench.getInfoGuildIdMessage();
            case "ITA":
                return LanguageItalian.getInfoGuildIdMessage();
            case "RUS":
                return LanguageRussian.getInfoGuildIdMessage();
            case "IND":
                return LanguageIndonesia.getInfoGuildIdMessage();
            default:
                return LanguageEnglish.getInfoGuildIdMessage();
        }
    }

    public static String getEventMessagesAlreadyOnMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEventMessagesAlreadyOnMessage();
            case "ESP":
                return LanguageSpain.getEventMessagesAlreadyOnMessage();
            case "POL":
                return LanguagePolish.getEventMessagesAlreadyOnMessage();
            case "FRA":
                return LanguageFrench.getEventMessagesAlreadyOnMessage();
            case "ITA":
                return LanguageItalian.getEventMessagesAlreadyOnMessage();
            case "RUS":
                return LanguageRussian.getEventMessagesAlreadyOnMessage();
            case "IND":
                return LanguageIndonesia.getEventMessagesAlreadyOnMessage();
            default:
                return LanguageEnglish.getEventMessagesAlreadyOnMessage();
        }
    }

    public static String getEventMessagesAlreadyOffMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getEventMessagesAlreadyOffMessage();
            case "ESP":
                return LanguageSpain.getEventMessagesAlreadyOffMessage();
            case "POL":
                return LanguagePolish.getEventMessagesAlreadyOffMessage();
            case "FRA":
                return LanguageFrench.getEventMessagesAlreadyOffMessage();
            case "ITA":
                return LanguageItalian.getEventMessagesAlreadyOffMessage();
            case "RUS":
                return LanguageRussian.getEventMessagesAlreadyOffMessage();
            case "IND":
                return LanguageIndonesia.getEventMessagesAlreadyOffMessage();
            default:
                return LanguageEnglish.getEventMessagesAlreadyOffMessage();
        }
    }

    public static String getHeadUpMessagesAlreadyOnMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpMessagesAlreadyOnMessage();
            case "ESP":
                return LanguageSpain.getHeadUpMessagesAlreadyOnMessage();
            case "POL":
                return LanguagePolish.getHeadUpMessagesAlreadyOnMessage();
            case "FRA":
                return LanguageFrench.getHeadUpMessagesAlreadyOnMessage();
            case "ITA":
                return LanguageItalian.getHeadUpMessagesAlreadyOnMessage();
            case "RUS":
                return LanguageRussian.getHeadUpMessagesAlreadyOnMessage();
            case "IND":
                return LanguageIndonesia.getHeadUpMessagesAlreadyOnMessage();
            default:
                return LanguageEnglish.getHeadUpMessagesAlreadyOnMessage();
        }
    }

    public static String getHeadUpMessagesAlreadyOffMessages(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHeadUpMessagesAlreadyOffMessages();
            case "ESP":
                return LanguageSpain.getHeadUpMessagesAlreadyOffMessages();
            case "POL":
                return LanguagePolish.getHeadUpMessagesAlreadyOffMessages();
            case "FRA":
                return LanguageFrench.getHeadUpMessagesAlreadyOffMessages();
            case "ITA":
                return LanguageItalian.getHeadUpMessagesAlreadyOffMessages();
            case "RUS":
                return LanguageRussian.getHeadUpMessagesAlreadyOffMessages();
            case "IND":
                return LanguageIndonesia.getHeadUpMessagesAlreadyOffMessages();
            default:
                return LanguageEnglish.getHeadUpMessagesAlreadyOffMessages();
        }
    }

    public static String getFooterTimesIn24HrsFormatMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getFooterTimesIn24HrsFormatMessage();
            case "ESP":
                return LanguageSpain.getFooterTimesIn24HrsFormatMessage();
            case "POL":
                return LanguagePolish.getFooterTimesIn24HrsFormatMessage();
            case "FRA":
                return LanguageFrench.getFooterTimesIn24HrsFormatMessage();
            case "ITA":
                return LanguageItalian.getFooterTimesIn24HrsFormatMessage();
            case "RUS":
                return LanguageRussian.getFooterTimesIn24HrsFormatMessage();
            case "IND":
                return LanguageIndonesia.getFooterTimesIn24HrsFormatMessage();
            default:
                return LanguageEnglish.getFooterTimesIn24HrsFormatMessage();
        }
    }

    public static String getHelpEventListMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpEventListMessage();
            case "ESP":
                return LanguageSpain.getHelpEventListMessage();
            case "POL":
                return LanguagePolish.getHelpEventListMessage();
            case "FRA":
                return LanguageFrench.getHelpEventListMessage();
            case "ITA":
                return LanguageItalian.getHelpEventListMessage();
            case "RUS":
                return LanguageRussian.getHelpEventListMessage();
            case "IND":
                return LanguageIndonesia.getHelpEventListMessage();
            default:
                return LanguageEnglish.getHelpEventListMessage();
        }
    }

    public static String getHelpEventSetMessage(String lang) {
        switch (lang.toUpperCase()) {
            case "GER":
                return LanguageGerman.getHelpEventSetMessage();
            case "ESP":
                return LanguageSpain.getHelpEventSetMessage();
            case "POL":
                return LanguagePolish.getHelpEventSetMessage();
            case "FRA":
                return LanguageFrench.getHelpEventSetMessage();
            case "ITA":
                return LanguageItalian.getHelpEventSetMessage();
            case "RUS":
                return LanguageRussian.getHelpEventSetMessage();
            case "IND":
                return LanguageIndonesia.getHelpEventSetMessage();
            default:
                return LanguageEnglish.getHelpEventSetMessage();
        }
    }

}