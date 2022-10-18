package me.umbreon.diabloimmortalbot.languages;

import java.util.List;

public class LanguageController {

    private static final String SHORT_ENGLISH = "ENG";
    private static final String SHORT_GERMAN = "GER";
    private static final String SHORT_SPAIN = "ESP";
    private static final String SHORT_POLISH = "POL";
    private static final String SHORT_FRENCH = "FRA";
    private static final String SHORT_ITALIAN = "ITA";
    private static final String SHORT_RUSSIAN = "RUS";
    private static final String SHORT_INDONESIA = "IND";
    private static final String SHORT_UKRAINIAN = "UKR";
    private static final String SHORT_BRAZILIAN_PORTUGUESE = "BRPT";

    public static final List<String> languages = List.of(SHORT_ENGLISH, SHORT_GERMAN, SHORT_SPAIN, SHORT_POLISH, SHORT_FRENCH,
            SHORT_ITALIAN, SHORT_RUSSIAN, SHORT_INDONESIA, SHORT_UKRAINIAN, SHORT_BRAZILIAN_PORTUGUESE);

    private LanguageController() {
        //All static methods.
    }

    public static String getHauntedCarriageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHauntedCarriageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHauntedCarriageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHauntedCarriageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHauntedCarriageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHauntedCarriageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHauntedCarriageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHauntedCarriageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHauntedCarriageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHauntedCarriageMessage();
            default:
                return LanguageEnglish.getHauntedCarriageMessage();
        }
    }

    public static String getHauntedCarriageHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHauntedCarriageHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHauntedCarriageHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHauntedCarriageHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHauntedCarriageHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHauntedCarriageHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHauntedCarriageHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHauntedCarriageHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHauntedCarriageHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHauntedCarriageHeadUpMessage();
            default:
                return LanguageEnglish.getHauntedCarriageHeadUpMessage();
        }
    }

    public static String getDemonGatesMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getDemonGatesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getDemonGatesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getDemonGatesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getDemonGatesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getDemonGatesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getDemonGatesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getDemonGatesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getDemonGatesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getDemonGatesMessage();
            default:
                return LanguageEnglish.getDemonGatesMessage();
        }
    }

    public static String getDemonGatesHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getDemonGatesHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getDemonGatesHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getDemonGatesHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getDemonGatesHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getDemonGatesHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getDemonGatesHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getDemonGatesHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getDemonGatesHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getDemonGatesHeadUpMessage();
            default:
                return LanguageEnglish.getDemonGatesHeadUpMessage();
        }
    }

    public static String getBattlegroundMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getBattlegroundMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getBattlegroundMessage();
            case SHORT_POLISH:
                return LanguagePolish.getBattlegroundMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getBattlegroundMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getBattlegroundMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getBattlegroundMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getBattlegroundMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getBattlegroundMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getBattlegroundMessage();
            default:
                return LanguageEnglish.getBattlegroundMessage();
        }
    }

    public static String getBattlegroundHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getBattlegroundHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getBattlegroundHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getBattlegroundHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getBattlegroundHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getBattlegroundHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getBattlegroundHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getBattlegroundHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getBattlegroundHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getBattlegroundHeadUpMessage();
            default:
                return LanguageEnglish.getBattlegroundHeadUpMessage();
        }
    }

    public static String getAncientNightmareMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAncientNightmareMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAncientNightmareMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAncientNightmareMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAncientNightmareMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAncientNightmareMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAncientNightmareMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAncientNightmareMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAncientNightmareMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAncientNightmareMessage();
            default:
                return LanguageEnglish.getAncientNightmareMessage();
        }
    }

    public static String getAncientNightmareHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAncientNightmareHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAncientNightmareHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAncientNightmareHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAncientNightmareHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAncientNightmareHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAncientNightmareHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAncientNightmareHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAncientNightmareHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAncientNightmareHeadUpMessage();
            default:
                return LanguageEnglish.getAncientNightmareHeadUpMessage();
        }
    }

    public static String getAncientArenaMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAncientArenaMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAncientArenaMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAncientArenaMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAncientArenaMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAncientArenaMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAncientArenaMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAncientArenaMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAncientArenaMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAncientArenaMessage();
            default:
                return LanguageEnglish.getAncientArenaMessage();
        }
    }

    public static String getAncientArenaHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAncientArenaHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAncientArenaHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAncientArenaHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAncientArenaHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAncientArenaHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAncientArenaHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAncientArenaHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAncientArenaHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAncientArenaHeadUpMessage();
            default:
                return LanguageEnglish.getAncientArenaHeadUpMessage();
        }
    }

    public static String getAssemblyMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAssemblyMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAssemblyMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAssemblyMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAssemblyMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAssemblyMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAssemblyMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAssemblyMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAssemblyMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAssemblyMessage();
            default:
                return LanguageEnglish.getAssemblyMessage();
        }
    }

    public static String getAssemblyHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAssemblyHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAssemblyHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAssemblyHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAssemblyHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAssemblyHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAssemblyHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAssemblyHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAssemblyHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAssemblyHeadUpMessage();
            default:
                return LanguageEnglish.getAssemblyHeadUpMessage();
        }
    }

    public static String getShadowLotteryMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getShadowLotteryMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getShadowLotteryMessage();
            case SHORT_POLISH:
                return LanguagePolish.getShadowLotteryMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getShadowLotteryMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getShadowLotteryMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getShadowLotteryMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getShadowLotteryMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getShadowLotteryMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getShadowLotteryMessage();
            default:
                return LanguageEnglish.getShadowLotteryMessage();
        }
    }

    public static String getShadowLotteryHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getShadowLotteryHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getShadowLotteryHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getShadowLotteryHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getShadowLotteryHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getShadowLotteryHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getShadowLotteryHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getShadowLotteryHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getShadowLotteryHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getShadowLotteryHeadUpMessage();
            default:
                return LanguageEnglish.getShadowLotteryHeadUpMessage();
        }
    }

    public static String getChannelRegisteredMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getChannelRegisteredMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getChannelRegisteredMessage();
            case SHORT_POLISH:
                return LanguagePolish.getChannelRegisteredMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getChannelRegisteredMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getChannelRegisteredMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getChannelRegisteredMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getChannelRegisteredMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getChannelRegisteredMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getChannelRegisteredMessage();
            default:
                return LanguageEnglish.getChannelRegisteredMessage();
        }
    }

    public static String getChannelAlreadyRegisteredMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getChannelAlreadyRegisteredMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getChannelAlreadyRegisteredMessage();
            case SHORT_POLISH:
                return LanguagePolish.getChannelAlreadyRegisteredMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getChannelAlreadyRegisteredMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getChannelAlreadyRegisteredMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getChannelAlreadyRegisteredMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getChannelAlreadyRegisteredMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getChannelAlreadyRegisteredMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getChannelAlreadyRegisteredMessage();
            default:
                return LanguageEnglish.getChannelAlreadyRegisteredMessage();
        }
    }

    public static String getRoleNotFoundMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getRoleNotFoundMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getRoleNotFoundMessage();
            case SHORT_POLISH:
                return LanguagePolish.getRoleNotFoundMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getRoleNotFoundMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getRoleNotFoundMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getRoleNotFoundMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getRoleNotFoundMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getRoleNotFoundMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getRoleNotFoundMessage();
            default:
                return LanguageEnglish.getRoleNotFoundMessage();
        }
    }

    public static String getChannelNotRegisteredMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getChannelNotRegisteredMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getChannelNotRegisteredMessage();
            case SHORT_POLISH:
                return LanguagePolish.getChannelNotRegisteredMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getChannelNotRegisteredMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getChannelNotRegisteredMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getChannelNotRegisteredMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getChannelNotRegisteredMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getChannelNotRegisteredMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getChannelNotRegisteredMessage();
            default:
                return LanguageEnglish.getChannelNotRegisteredMessage();
        }
    }

    public static String getTimezoneChangedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getTimezoneChangedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getTimezoneChangedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getTimezoneChangedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getTimezoneChangedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getTimezoneChangedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getTimezoneChangedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getTimezoneChangedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getTimezoneChangedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getTimezoneChangedMessage();
            default:
                return LanguageEnglish.getTimezoneChangedMessage();
        }
    }

    public static String getChannelUnregisteredMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getChannelUnregisteredMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getChannelUnregisteredMessage();
            case SHORT_POLISH:
                return LanguagePolish.getChannelUnregisteredMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getChannelUnregisteredMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getChannelUnregisteredMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getChannelUnregisteredMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getChannelUnregisteredMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getChannelNotRegisteredMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getChannelNotRegisteredMessage();
            default:
                return LanguageEnglish.getChannelUnregisteredMessage();
        }
    }

    public static String getUnknownTimezoneMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getUnknownTimezoneMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getUnknownTimezoneMessage();
            case SHORT_POLISH:
                return LanguagePolish.getUnknownTimezoneMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getUnknownTimezoneMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getUnknownTimezoneMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getUnknownTimezoneMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getUnknownTimezoneMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getUnknownTimezoneMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getUnknownTimezoneMessage();
            default:
                return LanguageEnglish.getUnknownTimezoneMessage();
        }
    }

    public static String getRoleChangedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getRoleChangedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getRoleChangedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getRoleChangedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getRoleChangedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getRoleChangedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getRoleChangedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getRoleChangedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getRoleChangedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getRoleChangedMessage();
            default:
                return LanguageEnglish.getRoleChangedMessage();
        }
    }

    public static String getRaidTheVaultMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getRaidTheVaultMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getRaidTheVaultMessage();
            case SHORT_POLISH:
                return LanguagePolish.getRaidTheVaultMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getRaidTheVaultMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getRaidTheVaultMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getRaidTheVaultMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getRaidTheVaultMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getRaidTheVaultMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getRaidTheVaultMessage();
            default:
                return LanguageEnglish.getRaidTheVaultMessage();
        }
    }

    public static String getRaidTheVaultHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getRaidTheVaultHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getRaidTheVaultHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getRaidTheVaultHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getRaidTheVaultHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getRaidTheVaultHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getRaidTheVaultHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getRaidTheVaultHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getRaidTheVaultHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getRaidTheVaultHeadUpMessage();
            default:
                return LanguageEnglish.getRaidTheVaultHeadUpMessage();
        }
    }

    public static String getDefendTheVaultMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getDefendTheVaultMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getDefendTheVaultMessage();
            case SHORT_POLISH:
                return LanguagePolish.getDefendTheVaultMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getDefendTheVaultMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getDefendTheVaultMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getDefendTheVaultMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getDefendTheVaultMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getDefendTheVaultMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getDefendTheVaultMessage();
            default:
                return LanguageEnglish.getDefendTheVaultMessage();
        }
    }

    public static String getDefendTheVaultHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getDefendTheVaultHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getDefendTheVaultHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getDefendTheVaultHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getDefendTheVaultHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getDefendTheVaultHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getDefendTheVaultHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getDefendTheVaultHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getDefendTheVaultHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getDefendTheVaultHeadUpMessage();
            default:
                return LanguageEnglish.getDefendTheVaultHeadUpMessage();
        }
    }

    public static String getLanguageNotSupportedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLanguageNotSupportedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getLanguageNotSupportedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getLanguageNotSupportedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getLanguageNotSupportedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getLanguageNotSupportedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLanguageNotSupportedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLanguageNotSupportedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLanguageNotSupportedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLanguageNotSupportedMessage();
            default:
                return LanguageEnglish.getLanguageNotSupportedMessage();
        }
    }

    public static String getLanguageUpdatedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLanguageUpdatedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getLanguageUpdatedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getLanguageUpdatedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getLanguageUpdatedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getLanguageUpdatedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLanguageUpdatedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLanguageUpdatedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLanguageUpdatedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLanguageUpdatedMessage();
            default:
                return LanguageEnglish.getLanguageUpdatedMessage();
        }
    }

    public static String getLanguageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLanguageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getLanguageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getLanguageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getLanguageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getLanguageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLanguageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLanguageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLanguageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLanguageMessage();
            default:
                return LanguageEnglish.getLanguageMessage();
        }
    }

    public static String getEventEnabledMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEventEnabledMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEventEnabledMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEventEnabledMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEventEnabledMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEventEnabledMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEventEnabledMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEventEnabledMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEventEnabledMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEventEnabledMessage();
            default:
                return LanguageEnglish.getEventEnabledMessage();
        }
    }

    public static String getEventDisabledMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEventDisabledMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEventDisabledMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEventDisabledMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEventDisabledMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEventDisabledMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEventDisabledMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEventDisabledMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEventDisabledMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEventDisabledMessage();
            default:
                return LanguageEnglish.getEventDisabledMessage();
        }
    }

    public static String getChannelNotFoundMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getChannelNotFoundMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getChannelNotFoundMessage();
            case SHORT_POLISH:
                return LanguagePolish.getChannelNotFoundMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getChannelNotFoundMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getChannelNotFoundMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getChannelNotFoundMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getChannelNotFoundMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getChannelNotFoundMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getChannelNotFoundMessage();
            default:
                return LanguageEnglish.getChannelNotFoundMessage();
        }
    }


    public static String getCustomMessageCreatedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getCustomMessageCreatedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getCustomMessageCreatedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getCustomMessageCreatedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getCustomMessageCreatedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getCustomMessageCreatedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getCustomMessageCreatedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getCustomMessageCreatedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getCustomMessageCreatedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getCustomMessageCreatedMessage();
            default:
                return LanguageEnglish.getCustomMessageCreatedMessage();
        }
    }

    public static String getNoCustomMessagesMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getNoCustomMessagesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getNoCustomMessagesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getNoCustomMessagesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getNoCustomMessagesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getNoCustomMessagesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getNoCustomMessagesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getNoCustomMessagesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getNoCustomMessagesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getNoCustomMessagesMessage();
            default:
                return LanguageEnglish.getNoCustomMessagesMessage();
        }
    }

    public static String getShowAllCustomMessages(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getShowAllCustomMessages();
            case SHORT_SPAIN:
                return LanguageSpain.getShowAllCustomMessages();
            case SHORT_POLISH:
                return LanguagePolish.getShowAllCustomMessages();
            case SHORT_FRENCH:
                return LanguageFrench.getShowAllCustomMessages();
            case SHORT_ITALIAN:
                return LanguageItalian.getShowAllCustomMessages();
            case SHORT_RUSSIAN:
                return LanguageRussian.getShowAllCustomMessages();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getShowAllCustomMessages();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getShowAllCustomMessages();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getShowAllCustomMessages();
            default:
                return LanguageEnglish.getShowAllCustomMessages();
        }
    }

    public static String getCustomMessageWithIdDeleted(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getCustomMessageWithIdDeleted();
            case SHORT_SPAIN:
                return LanguageSpain.getCustomMessageWithIdDeleted();
            case SHORT_POLISH:
                return LanguagePolish.getCustomMessageWithIdDeleted();
            case SHORT_FRENCH:
                return LanguageFrench.getCustomMessageWithIdDeleted();
            case SHORT_ITALIAN:
                return LanguageItalian.getCustomMessageWithIdDeleted();
            case SHORT_RUSSIAN:
                return LanguageRussian.getCustomMessageWithIdDeleted();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getCustomMessageWithIdDeleted();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getCustomMessageWithIdDeleted();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getCustomMessageWithIdDeleted();
            default:
                return LanguageEnglish.getCustomMessageWithIdDeleted();
        }
    }

    public static String getInvalidCommandMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInvalidCommandMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInvalidCommandMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInvalidCommandMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInvalidCommandMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInvalidCommandMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInvalidCommandMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInvalidCommandMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInvalidCommandMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInvalidCommandMessage();
            default:
                return LanguageEnglish.getInvalidCommandMessage();
        }
    }

    public static String getAncientArenaEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAncientArenaEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAncientArenaEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAncientArenaEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAncientArenaEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAncientArenaEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAncientArenaEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAncientArenaEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAncientArenaEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAncientArenaEmbedMessage();
            default:
                return LanguageEnglish.getAncientArenaEmbedMessage();
        }
    }

    public static String getLocationAncientArenaEmbedMessage1(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationAncientArenaEmbedMessage1();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationAncientArenaEmbedMessage1();
            case SHORT_POLISH:
                return LanguagePolish.getLocationAncientArenaEmbedMessage1();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationAncientArenaEmbedMessage1();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationAncientArenaEmbedMessage1();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationAncientArenaEmbedMessage1();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationAncientArenaEmbedMessage1();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationAncientArenaEmbedMessage1();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationAncientArenaEmbedMessage1();
            default:
                return LanguageEnglish.getLocationAncientArenaEmbedMessage1();
        }
    }

    public static String getLocationAncientArenaEmbedMessage2(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationAncientArenaEmbedMessage2();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationAncientArenaEmbedMessage2();
            case SHORT_POLISH:
                return LanguagePolish.getLocationAncientArenaEmbedMessage2();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationAncientArenaEmbedMessage2();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationAncientArenaEmbedMessage2();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationAncientArenaEmbedMessage2();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationAncientArenaEmbedMessage2();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationAncientArenaEmbedMessage2();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationAncientArenaEmbedMessage2();
            default:
                return LanguageEnglish.getLocationAncientArenaEmbedMessage2();
        }
    }

    public static String getAncientNightmareEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAncientNightmareEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAncientNightmareEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAncientNightmareEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAncientNightmareEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAncientNightmareEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAncientNightmareEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAncientNightmareEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAncientNightmareEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAncientNightmareEmbedMessage();
            default:
                return LanguageEnglish.getAncientNightmareEmbedMessage();
        }
    }

    public static String getLocationAncientNightmareEmbedMessage1(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationAncientNightmareEmbedMessage1();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationAncientNightmareEmbedMessage1();
            case SHORT_POLISH:
                return LanguagePolish.getLocationAncientNightmareEmbedMessage1();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationAncientNightmareEmbedMessage1();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationAncientNightmareEmbedMessage1();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationAncientNightmareEmbedMessage1();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationAncientNightmareEmbedMessage1();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationAncientNightmareEmbedMessage1();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationAncientNightmareEmbedMessage1();
            default:
                return LanguageEnglish.getLocationAncientNightmareEmbedMessage1();
        }
    }

    public static String getLocationAncientNightmareEmbedMessage2(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationAncientNightmareEmbedMessage2();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationAncientNightmareEmbedMessage2();
            case SHORT_POLISH:
                return LanguagePolish.getLocationAncientNightmareEmbedMessage2();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationAncientNightmareEmbedMessage2();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationAncientNightmareEmbedMessage2();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationAncientNightmareEmbedMessage2();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationAncientNightmareEmbedMessage2();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationAncientNightmareEmbedMessage2();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationAncientNightmareEmbedMessage2();
            default:
                return LanguageEnglish.getLocationAncientNightmareEmbedMessage2();
        }
    }

    public static String getDemonGatesEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getDemonGatesEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getDemonGatesEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getDemonGatesEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getDemonGatesEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getDemonGatesEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getDemonGatesEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getDemonGatesEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getDemonGatesEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getDemonGatesEmbedMessage();
            default:
                return LanguageEnglish.getDemonGatesEmbedMessage();
        }
    }

    public static String getLocationDemonGatesEmbedMessage1(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationDemonGatesEmbedMessage1();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationDemonGatesEmbedMessage1();
            case SHORT_POLISH:
                return LanguagePolish.getLocationDemonGatesEmbedMessage1();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationDemonGatesEmbedMessage1();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationDemonGatesEmbedMessage1();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationDemonGatesEmbedMessage1();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationDemonGatesEmbedMessage1();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationDemonGatesEmbedMessage1();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationDemonGatesEmbedMessage1();
            default:
                return LanguageEnglish.getLocationDemonGatesEmbedMessage1();
        }
    }

    public static String getLocationDemonGatesEmbedMessage2(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationDemonGatesEmbedMessage2();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationDemonGatesEmbedMessage2();
            case SHORT_POLISH:
                return LanguagePolish.getLocationDemonGatesEmbedMessage2();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationDemonGatesEmbedMessage2();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationDemonGatesEmbedMessage2();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationDemonGatesEmbedMessage2();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationDemonGatesEmbedMessage2();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationDemonGatesEmbedMessage2();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationDemonGatesEmbedMessage2();
            default:
                return LanguageEnglish.getLocationDemonGatesEmbedMessage2();
        }
    }

    public static String getHauntedCarriageEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHauntedCarriageEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHauntedCarriageEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHauntedCarriageEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHauntedCarriageEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHauntedCarriageEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHauntedCarriageEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHauntedCarriageEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHauntedCarriageEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHauntedCarriageEmbedMessage();
            default:
                return LanguageEnglish.getHauntedCarriageEmbedMessage();
        }
    }

    public static String getLocationHauntedCarriageEmbedMessage1(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_POLISH:
                return LanguagePolish.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationHauntedCarriageEmbedMessage1();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationHauntedCarriageEmbedMessage1();
            default:
                return LanguageEnglish.getLocationHauntedCarriageEmbedMessage1();
        }
    }

    public static String getLocationHauntedCarriageEmbedMessage2(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_SPAIN:
                return LanguageSpain.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_POLISH:
                return LanguagePolish.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_FRENCH:
                return LanguageFrench.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_ITALIAN:
                return LanguageItalian.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_RUSSIAN:
                return LanguageRussian.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getLocationHauntedCarriageEmbedMessage2();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getLocationHauntedCarriageEmbedMessage2();
            default:
                return LanguageEnglish.getLocationHauntedCarriageEmbedMessage2();
        }
    }

    public static String getEmbedSpawnAtMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEmbedSpawnAtMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEmbedSpawnAtMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEmbedSpawnAtMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEmbedSpawnAtMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEmbedSpawnAtMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEmbedSpawnAtMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEmbedSpawnAtMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEmbedSpawnAtMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEmbedSpawnAtMessage();
            default:
                return LanguageEnglish.getEmbedSpawnAtMessage();
        }
    }

    public static String getEmbedCountdownMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEmbedCountdownMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEmbedCountdownMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEmbedCountdownMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEmbedCountdownMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEmbedCountdownMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEmbedCountdownMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEmbedCountdownMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEmbedCountdownMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEmbedCountdownMessage();
            default:
                return LanguageEnglish.getEmbedCountdownMessage();
        }
    }

    public static String getEmbedWorldEventMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEmbedWorldEventMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEmbedWorldEventMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEmbedWorldEventMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEmbedWorldEventMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEmbedWorldEventMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEmbedWorldEventMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEmbedWorldEventMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEmbedWorldEventMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEmbedWorldEventMessage();
            default:
                return LanguageEnglish.getEmbedWorldEventMessage();
        }
    }

    public static String getInvalidTimezoneMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInvalidTimezoneMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInvalidTimezoneMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInvalidTimezoneMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInvalidTimezoneMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInvalidTimezoneMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInvalidTimezoneMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInvalidTimezoneMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInvalidTimezoneMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInvalidTimezoneMessage();
            default:
                return LanguageEnglish.getInvalidTimezoneMessage();
        }
    }

    public static String getHelpRegistersChannelMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpRegistersChannelMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpRegistersChannelMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpRegistersChannelMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpRegistersChannelMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpRegistersChannelMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpRegistersChannelMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpRegistersChannelMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpRegistersChannelMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpRegistersChannelMessage();
            default:
                return LanguageEnglish.getHelpRegistersChannelMessage();
        }
    }

    public static String getHelpUnregistersChannelMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpUnregistersChannelMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpUnregistersChannelMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpUnregistersChannelMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpUnregistersChannelMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpUnregistersChannelMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpUnregistersChannelMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpUnregistersChannelMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpUnregistersChannelMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpUnregistersChannelMessage();
            default:
                return LanguageEnglish.getHelpUnregistersChannelMessage();
        }
    }

    public static String getHelpSetRoleMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpSetRoleMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpSetRoleMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpSetRoleMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpSetRoleMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpSetRoleMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpSetRoleMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpSetRoleMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpSetRoleMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpSetRoleMessage();
            default:
                return LanguageEnglish.getHelpSetRoleMessage();
        }
    }

    public static String getHelpShowInfoMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpShowInfoMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpShowInfoMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpShowInfoMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpShowInfoMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpShowInfoMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpShowInfoMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpShowInfoMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpShowInfoMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpShowInfoMessage();
            default:
                return LanguageEnglish.getHelpShowInfoMessage();
        }
    }

    public static String getHelpCreateCustomMessageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpCreateCustomMessageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpCreateCustomMessageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpCreateCustomMessageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpCreateCustomMessageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpCreateCustomMessageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpCreateCustomMessageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpCreateCustomMessageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpCreateCustomMessageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpCreateCustomMessageMessage();
            default:
                return LanguageEnglish.getHelpCreateCustomMessageMessage();
        }
    }

    public static String getHelpDeleteCustomMessageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpDeleteCustomMessageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpDeleteCustomMessageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpDeleteCustomMessageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpDeleteCustomMessageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpDeleteCustomMessageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpDeleteCustomMessageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpDeleteCustomMessageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpDeleteCustomMessageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpDeleteCustomMessageMessage();
            default:
                return LanguageEnglish.getHelpDeleteCustomMessageMessage();
        }
    }

    public static String getHelpShowAllCustomMessagesMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpShowAllCustomMessagesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpShowAllCustomMessagesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpShowAllCustomMessagesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpShowAllCustomMessagesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpShowAllCustomMessagesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpShowAllCustomMessagesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpShowAllCustomMessagesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpShowAllCustomMessagesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpShowAllCustomMessagesMessage();
            default:
                return LanguageEnglish.getHelpShowAllCustomMessagesMessage();
        }
    }

    public static String getHelpShowCustomMessageInfoMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpShowAllCustomMessagesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpShowAllCustomMessagesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpShowAllCustomMessagesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpShowAllCustomMessagesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpShowAllCustomMessagesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpShowAllCustomMessagesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpShowAllCustomMessagesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpShowAllCustomMessagesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpShowAllCustomMessagesMessage();
            default:
                return LanguageEnglish.getHelpShowCustomMessageInfoMessage();
        }
    }

    public static String getHelpServerHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerHeadUpMessage();
            default:
                return LanguageEnglish.getHelpServerHeadUpMessage();
        }
    }

    public static String getHelpServerMessagesMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerMessagesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerMessagesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerMessagesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerMessagesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerMessagesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerMessagesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerMessagesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerMessagesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerMessagesMessage();
            default:
                return LanguageEnglish.getHelpServerMessagesMessage();
        }
    }

    public static String getHelpServerConfigMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerConfigMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerConfigMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerConfigMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerConfigMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerConfigMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerConfigMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerConfigMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerConfigMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerConfigMessage();
            default:
                return LanguageEnglish.getHelpServerConfigMessage();
        }
    }

    public static String getHelpServerLanguageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerLanguageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerLanguageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerLanguageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerLanguageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerLanguageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerLanguageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerLanguageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerLanguageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerLanguageMessage();
            default:
                return LanguageEnglish.getHelpServerLanguageMessage();
        }
    }

    public static String getHelpServerTimezoneMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerTimezoneMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerTimezoneMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerTimezoneMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerTimezoneMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerTimezoneMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerTimezoneMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerTimezoneMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerTimezoneMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerTimezoneMessage();
            default:
                return LanguageEnglish.getHelpServerTimezoneMessage();
        }
    }

    public static String getShowsBotInstallMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getShowsBotInstallMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getShowsBotInstallMessage();
            case SHORT_POLISH:
                return LanguagePolish.getShowsBotInstallMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getShowsBotInstallMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getShowsBotInstallMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getShowsBotInstallMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getShowsBotInstallMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getShowsBotInstallMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getShowsBotInstallMessage();
            default:
                return LanguageEnglish.getShowsBotInstallMessage();
        }
    }

    public static String getShowsThisMessageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getShowsThisMessageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getShowsThisMessageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getShowsThisMessageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getShowsThisMessageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getShowsThisMessageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getShowsThisMessageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getShowsThisMessageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getShowsThisMessageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getShowsThisMessageMessage();
            default:
                return LanguageEnglish.getShowsThisMessageMessage();
        }
    }

    public static String getSupportDiscordMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getSupportDiscordMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getSupportDiscordMessage();
            case SHORT_POLISH:
                return LanguagePolish.getSupportDiscordMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getSupportDiscordMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getSupportDiscordMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getSupportDiscordMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getSupportDiscordMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getSupportDiscordMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getSupportDiscordMessage();
            default:
                return LanguageEnglish.getSupportDiscordMessage();
        }
    }

    public static String getHelpServerAutoDeleteSetMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerAutoDeleteSetMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerAutoDeleteSetMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerAutoDeleteSetMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerAutoDeleteSetMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerAutoDeleteSetMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerAutoDeleteSetMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerAutoDeleteSetMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerAutoDeleteSetMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerAutoDeleteSetMessage();
            default:
                return LanguageEnglish.getHelpServerAutoDeleteSetMessage();
        }
    }

    public static String getHelpServerAutoDeleteValueMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpServerAutoDeleteValueMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpServerAutoDeleteValueMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpServerAutoDeleteValueMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpServerAutoDeleteValueMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpServerAutoDeleteValueMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpServerAutoDeleteValueMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpServerAutoDeleteValueMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpServerAutoDeleteValueMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpServerAutoDeleteValueMessage();
            default:
                return LanguageEnglish.getHelpServerAutoDeleteValueMessage();
        }
    }

    public static String getShortHoursMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getShortHoursMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getShortHoursMessage();
            case SHORT_POLISH:
                return LanguagePolish.getShortHoursMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getShortHoursMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getShortHoursMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getShortHoursMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getShortHoursMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getShortHoursMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getShortHoursMessage();
            default:
                return LanguageEnglish.getShortHoursMessage();
        }
    }


    public static String getErrorOccurredMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getErrorOccurredMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getErrorOccurredMessage();
            case SHORT_POLISH:
                return LanguagePolish.getErrorOccurredMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getErrorOccurredMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getErrorOccurredMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getErrorOccurredMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getErrorOccurredMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getErrorOccurredMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getErrorOccurredMessage();
            default:
                return LanguageEnglish.getErrorOccurredMessage();
        }
    }

    public static String getFooterReportToDevMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getFooterReportToDevMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getFooterReportToDevMessage();
            case SHORT_POLISH:
                return LanguagePolish.getFooterReportToDevMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getFooterReportToDevMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getFooterReportToDevMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getFooterReportToDevMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getFooterReportToDevMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getFooterReportToDevMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getFooterReportToDevMessage();
            default:
                return LanguageEnglish.getFooterReportToDevMessage();
        }
    }

    public static String getWrathborneInvasionMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getWrathborneInvasionMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getWrathborneInvasionMessage();
            case SHORT_POLISH:
                return LanguagePolish.getWrathborneInvasionMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getWrathborneInvasionMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getWrathborneInvasionMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getWrathborneInvasionMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getWrathborneInvasionMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getWrathborneInvasionMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getWrathborneInvasionMessage();
            default:
                return LanguageEnglish.getWrathborneInvasionMessage();
        }
    }

    public static String getWrathborneInvasionHeadUpMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getWrathborneInvasionHeadUpMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getWrathborneInvasionHeadUpMessage();
            case SHORT_POLISH:
                return LanguagePolish.getWrathborneInvasionHeadUpMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getWrathborneInvasionHeadUpMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getWrathborneInvasionHeadUpMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getWrathborneInvasionHeadUpMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getWrathborneInvasionHeadUpMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getWrathborneInvasionHeadUpMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getWrathborneInvasionHeadUpMessage();
            default:
                return LanguageEnglish.getWrathborneInvasionHeadUpMessage();
        }
    }

    public static String getInstall1Message(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInstall1Message();
            case SHORT_SPAIN:
                return LanguageSpain.getInstall1Message();
            case SHORT_POLISH:
                return LanguagePolish.getInstall1Message();
            case SHORT_FRENCH:
                return LanguageFrench.getInstall1Message();
            case SHORT_ITALIAN:
                return LanguageItalian.getInstall1Message();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInstall1Message();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInstall1Message();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInstall1Message();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInstall1Message();
            default:
                return LanguageEnglish.getInstall1Message();
        }
    }

    public static String getInstall2Message(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInstall2Message();
            case SHORT_SPAIN:
                return LanguageSpain.getInstall2Message();
            case SHORT_POLISH:
                return LanguagePolish.getInstall2Message();
            case SHORT_FRENCH:
                return LanguageFrench.getInstall2Message();
            case SHORT_ITALIAN:
                return LanguageItalian.getInstall2Message();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInstall2Message();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInstall2Message();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInstall2Message();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInstall2Message();
            default:
                return LanguageEnglish.getInstall2Message();
        }
    }

    public static String getInstall3Message(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInstall3Message();
            case SHORT_SPAIN:
                return LanguageSpain.getInstall3Message();
            case SHORT_POLISH:
                return LanguagePolish.getInstall3Message();
            case SHORT_FRENCH:
                return LanguageFrench.getInstall3Message();
            case SHORT_ITALIAN:
                return LanguageItalian.getInstall3Message();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInstall3Message();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInstall3Message();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInstall3Message();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInstall3Message();
            default:
                return LanguageEnglish.getInstall3Message();
        }
    }

    public static String getInstall4Message(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInstall4Message();
            case SHORT_SPAIN:
                return LanguageSpain.getInstall4Message();
            case SHORT_POLISH:
                return LanguagePolish.getInstall4Message();
            case SHORT_FRENCH:
                return LanguageFrench.getInstall4Message();
            case SHORT_ITALIAN:
                return LanguageItalian.getInstall4Message();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInstall4Message();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInstall4Message();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInstall4Message();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInstall4Message();
            default:
                return LanguageEnglish.getInstall4Message();
        }
    }

    public static String getInstall5Message(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInstall5Message();
            case SHORT_SPAIN:
                return LanguageSpain.getInstall5Message();
            case SHORT_POLISH:
                return LanguagePolish.getInstall5Message();
            case SHORT_FRENCH:
                return LanguageFrench.getInstall5Message();
            case SHORT_ITALIAN:
                return LanguageItalian.getInstall5Message();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInstall5Message();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInstall5Message();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInstall5Message();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInstall5Message();
            default:
                return LanguageEnglish.getInstall5Message();
        }
    }

    public static String getInstructionsMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInstructionsMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInstructionsMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInstructionsMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInstructionsMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInstructionsMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInstructionsMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInstructionsMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInstructionsMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInstructionsMessage();
            default:
                return LanguageEnglish.getInstructionsMessage();
        }
    }

    public static String getInfoTimezoneMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoTimezoneMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoTimezoneMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoTimezoneMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoTimezoneMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoTimezoneMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoTimezoneMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoTimezoneMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoTimezoneMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoTimezoneMessage();
            default:
                return LanguageEnglish.getInfoTimezoneMessage();
        }
    }

    public static String getInfoCurrentTimeMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoCurrentTimeMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoCurrentTimeMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoCurrentTimeMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoCurrentTimeMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoCurrentTimeMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoCurrentTimeMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoCurrentTimeMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoCurrentTimeMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoCurrentTimeMessage();
            default:
                return LanguageEnglish.getInfoCurrentTimeMessage();
        }
    }

    public static String getInfoTextChannelIDMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoTextChannelIDMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoTextChannelIDMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoTextChannelIDMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoTextChannelIDMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoTextChannelIDMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoTextChannelIDMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoTextChannelIDMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoTextChannelIDMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoTextChannelIDMessage();
            default:
                return LanguageEnglish.getInfoTextChannelIDMessage();
        }
    }

    public static String getInfoMentionedRoleMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoMentionedRoleMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoMentionedRoleMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoMentionedRoleMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoMentionedRoleMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoMentionedRoleMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoMentionedRoleMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoMentionedRoleMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoMentionedRoleMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoMentionedRoleMessage();
            default:
                return LanguageEnglish.getInfoMentionedRoleMessage();
        }
    }

    public static String getInfoYesMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoYesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoYesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoYesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoYesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoYesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoYesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoYesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoYesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoYesMessage();
            default:
                return LanguageEnglish.getInfoYesMessage();
        }
    }

    public static String getInfoNoMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoNoMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoNoMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoNoMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoNoMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoNoMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoNoMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoNoMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoNoMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoNoMessage();
            default:
                return LanguageEnglish.getInfoNoMessage();
        }
    }

    public static String getInfoEventMessageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoEventMessageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoEventMessageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoEventMessageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoEventMessageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoEventMessageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoEventMessageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoEventMessageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoEventMessageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoEventMessageMessage();
            default:
                return LanguageEnglish.getInfoEventMessageMessage();
        }
    }

    public static String getInfoHeadUpMessageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoHeadUpMessageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoHeadUpMessageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoHeadUpMessageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoHeadUpMessageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoHeadUpMessageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoHeadUpMessageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoHeadUpMessageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoHeadUpMessageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoHeadUpMessageMessage();
            default:
                return LanguageEnglish.getInfoHeadUpMessageMessage();
        }
    }

    public static String getInfoAncientNightmareMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoAncientNightmareMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoAncientNightmareMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoAncientNightmareMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoAncientNightmareMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoAncientNightmareMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoAncientNightmareMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoAncientNightmareMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoAncientNightmareMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoAncientNightmareMessage();
            default:
                return LanguageEnglish.getInfoAncientNightmareMessage();
        }
    }

    public static String getInfoAncientArenaMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoAncientArenaMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoAncientArenaMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoAncientArenaMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoAncientArenaMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoAncientArenaMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoAncientArenaMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoAncientArenaMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoAncientArenaMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoAncientArenaMessage();
            default:
                return LanguageEnglish.getInfoAncientArenaMessage();
        }
    }

    public static String getInfoAssemblyMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoAssemblyMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoAssemblyMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoAssemblyMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoAssemblyMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoAssemblyMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoAssemblyMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoAssemblyMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoAssemblyMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoAssemblyMessage();
            default:
                return LanguageEnglish.getInfoAssemblyMessage();
        }
    }

    public static String getInfoBattlegroundMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoBattlegroundMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoBattlegroundMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoBattlegroundMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoBattlegroundMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoBattlegroundMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoBattlegroundMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoBattlegroundMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoBattlegroundMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoBattlegroundMessage();
            default:
                return LanguageEnglish.getInfoBattlegroundMessage();
        }
    }

    public static String getInfoDefendTheVaultMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoDefendTheVaultMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoDefendTheVaultMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoDefendTheVaultMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoDefendTheVaultMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoDefendTheVaultMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoDefendTheVaultMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoDefendTheVaultMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoDefendTheVaultMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoDefendTheVaultMessage();
            default:
                return LanguageEnglish.getInfoDefendTheVaultMessage();
        }
    }

    public static String getInfoRaidTheVaultMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoRaidTheVaultMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoRaidTheVaultMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoRaidTheVaultMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoRaidTheVaultMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoRaidTheVaultMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoRaidTheVaultMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoRaidTheVaultMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoRaidTheVaultMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoRaidTheVaultMessage();
            default:
                return LanguageEnglish.getInfoRaidTheVaultMessage();
        }
    }

    public static String getInfoDemonGatesMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoDemonGatesMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoDemonGatesMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoDemonGatesMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoDemonGatesMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoDemonGatesMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoDemonGatesMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoDemonGatesMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoDemonGatesMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoDemonGatesMessage();
            default:
                return LanguageEnglish.getInfoDemonGatesMessage();
        }
    }

    public static String getInfoShadowLotteryMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoShadowLotteryMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoShadowLotteryMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoShadowLotteryMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoShadowLotteryMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoShadowLotteryMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoShadowLotteryMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoShadowLotteryMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoShadowLotteryMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoShadowLotteryMessage();
            default:
                return LanguageEnglish.getInfoShadowLotteryMessage();
        }
    }

    public static String getInfoHauntedCarriageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoHauntedCarriageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoHauntedCarriageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoHauntedCarriageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoHauntedCarriageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoHauntedCarriageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoHauntedCarriageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoHauntedCarriageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoHauntedCarriageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoHauntedCarriageMessage();
            default:
                return LanguageEnglish.getInfoHauntedCarriageMessage();
        }
    }

    public static String getInfoWrathborneInvasionMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoWrathborneInvasionMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoWrathborneInvasionMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoWrathborneInvasionMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoWrathborneInvasionMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoWrathborneInvasionMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoWrathborneInvasionMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoWrathborneInvasionMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoWrathborneInvasionMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoWrathborneInvasionMessage();
            default:
                return LanguageEnglish.getInfoWrathborneInvasionMessage();
        }
    }

    public static String getInfoHauntedCarriageEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoHauntedCarriageEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoHauntedCarriageEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoHauntedCarriageEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoHauntedCarriageEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoHauntedCarriageEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoHauntedCarriageEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoHauntedCarriageEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoHauntedCarriageEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoHauntedCarriageEmbedMessage();
            default:
                return LanguageEnglish.getInfoHauntedCarriageEmbedMessage();
        }
    }

    public static String getInfoDemonGatesEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoDemonGatesEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoDemonGatesEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoDemonGatesEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoDemonGatesEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoDemonGatesEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoDemonGatesEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoDemonGatesEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoDemonGatesEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoDemonGatesEmbedMessage();
            default:
                return LanguageEnglish.getInfoDemonGatesEmbedMessage();
        }
    }

    public static String getInfoAncientNightmareEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoAncientNightmareEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoAncientNightmareEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoAncientNightmareEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoAncientNightmareEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoAncientNightmareEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoAncientNightmareEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoAncientNightmareEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoAncientNightmareEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoAncientNightmareEmbedMessage();
            default:
                return LanguageEnglish.getInfoAncientNightmareEmbedMessage();
        }
    }

    public static String getInfoAncientArenaEmbedMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoAncientArenaEmbedMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoAncientArenaEmbedMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoAncientArenaEmbedMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoAncientArenaEmbedMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoAncientArenaEmbedMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoAncientArenaEmbedMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoAncientArenaEmbedMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoAncientArenaEmbedMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoAncientArenaEmbedMessage();
            default:
                return LanguageEnglish.getInfoAncientArenaEmbedMessage();
        }
    }

    public static String getErrorCannotDisableEventMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getErrorCannotDisableEventMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getErrorCannotDisableEventMessage();
            case SHORT_POLISH:
                return LanguagePolish.getErrorCannotDisableEventMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getErrorCannotDisableEventMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getErrorCannotDisableEventMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getErrorCannotDisableEventMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getErrorCannotDisableEventMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getErrorCannotDisableEventMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getErrorCannotDisableEventMessage();
            default:
                return LanguageEnglish.getErrorCannotDisableEventMessage();
        }
    }

    public static String getFooterCreatedByMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getFooterCreatedByMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getFooterCreatedByMessage();
            case SHORT_POLISH:
                return LanguagePolish.getFooterCreatedByMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getFooterCreatedByMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getFooterCreatedByMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getFooterCreatedByMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getFooterCreatedByMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getFooterCreatedByMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getFooterCreatedByMessage();
            default:
                return LanguageEnglish.getFooterCreatedByMessage();
        }
    }

    public static String getAutoDeleteEnabledMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAutoDeleteEnabledMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAutoDeleteEnabledMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAutoDeleteEnabledMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAutoDeleteEnabledMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAutoDeleteEnabledMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAutoDeleteEnabledMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAutoDeleteEnabledMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAutoDeleteEnabledMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAutoDeleteEnabledMessage();
            default:
                return LanguageEnglish.getAutoDeleteEnabledMessage();
        }
    }

    public static String getAutoDeleteDisabledMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAutoDeleteDisabledMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAutoDeleteDisabledMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAutoDeleteDisabledMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAutoDeleteDisabledMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAutoDeleteDisabledMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAutoDeleteDisabledMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAutoDeleteDisabledMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAutoDeleteDisabledMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAutoDeleteDisabledMessage();
            default:
                return LanguageEnglish.getAutoDeleteDisabledMessage();
        }
    }

    public static String getAutoDeleteValueSetMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getAutoDeleteValueSetMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getAutoDeleteValueSetMessage();
            case SHORT_POLISH:
                return LanguagePolish.getAutoDeleteValueSetMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getAutoDeleteValueSetMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getAutoDeleteValueSetMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getAutoDeleteValueSetMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getAutoDeleteValueSetMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getAutoDeleteValueSetMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getAutoDeleteValueSetMessage();
            default:
                return LanguageEnglish.getAutoDeleteValueSetMessage();
        }
    }

    public static String getInfoLanguageMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoLanguageMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoLanguageMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoLanguageMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoLanguageMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoLanguageMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoLanguageMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoLanguageMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoLanguageMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoLanguageMessage();
            default:
                return LanguageEnglish.getInfoLanguageMessage();
        }
    }

    public static String getInfoGuildIdMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getInfoGuildIdMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getInfoGuildIdMessage();
            case SHORT_POLISH:
                return LanguagePolish.getInfoGuildIdMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getInfoGuildIdMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getInfoGuildIdMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getInfoGuildIdMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getInfoGuildIdMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getInfoGuildIdMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getInfoGuildIdMessage();
            default:
                return LanguageEnglish.getInfoGuildIdMessage();
        }
    }

    public static String getEventMessagesAlreadyOnMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEventMessagesAlreadyOnMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEventMessagesAlreadyOnMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEventMessagesAlreadyOnMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEventMessagesAlreadyOnMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEventMessagesAlreadyOnMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEventMessagesAlreadyOnMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEventMessagesAlreadyOnMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEventMessagesAlreadyOnMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEventMessagesAlreadyOnMessage();
            default:
                return LanguageEnglish.getEventMessagesAlreadyOnMessage();
        }
    }

    public static String getEventMessagesAlreadyOffMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getEventMessagesAlreadyOffMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getEventMessagesAlreadyOffMessage();
            case SHORT_POLISH:
                return LanguagePolish.getEventMessagesAlreadyOffMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getEventMessagesAlreadyOffMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getEventMessagesAlreadyOffMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getEventMessagesAlreadyOffMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getEventMessagesAlreadyOffMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getEventMessagesAlreadyOffMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getEventMessagesAlreadyOffMessage();
            default:
                return LanguageEnglish.getEventMessagesAlreadyOffMessage();
        }
    }

    public static String getHeadUpMessagesAlreadyOnMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHeadUpMessagesAlreadyOnMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHeadUpMessagesAlreadyOnMessage();
            default:
                return LanguageEnglish.getHeadUpMessagesAlreadyOnMessage();
        }
    }

    public static String getHeadUpMessagesAlreadyOffMessages(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_SPAIN:
                return LanguageSpain.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_POLISH:
                return LanguagePolish.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_FRENCH:
                return LanguageFrench.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_ITALIAN:
                return LanguageItalian.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHeadUpMessagesAlreadyOffMessages();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHeadUpMessagesAlreadyOffMessages();
            default:
                return LanguageEnglish.getHeadUpMessagesAlreadyOffMessages();
        }
    }

    public static String getFooterTimesIn24HrsFormatMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getFooterTimesIn24HrsFormatMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getFooterTimesIn24HrsFormatMessage();
            case SHORT_POLISH:
                return LanguagePolish.getFooterTimesIn24HrsFormatMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getFooterTimesIn24HrsFormatMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getFooterTimesIn24HrsFormatMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getFooterTimesIn24HrsFormatMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getFooterTimesIn24HrsFormatMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getFooterTimesIn24HrsFormatMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getFooterTimesIn24HrsFormatMessage();
            default:
                return LanguageEnglish.getFooterTimesIn24HrsFormatMessage();
        }
    }

    public static String getHelpEventListMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpEventListMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpEventListMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpEventListMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpEventListMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpEventListMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpEventListMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpEventListMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpEventListMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpEventListMessage();
            default:
                return LanguageEnglish.getHelpEventListMessage();
        }
    }

    public static String getHelpEventSetMessage(final String lang) {
        switch (lang.toUpperCase()) {
            case SHORT_GERMAN:
                return LanguageGerman.getHelpEventSetMessage();
            case SHORT_SPAIN:
                return LanguageSpain.getHelpEventSetMessage();
            case SHORT_POLISH:
                return LanguagePolish.getHelpEventSetMessage();
            case SHORT_FRENCH:
                return LanguageFrench.getHelpEventSetMessage();
            case SHORT_ITALIAN:
                return LanguageItalian.getHelpEventSetMessage();
            case SHORT_RUSSIAN:
                return LanguageRussian.getHelpEventSetMessage();
            case SHORT_INDONESIA:
                return LanguageIndonesia.getHelpEventSetMessage();
            case SHORT_UKRAINIAN:
                return LanguageUkrainian.getHelpEventSetMessage();
            case SHORT_BRAZILIAN_PORTUGUESE:
                return LanguageBrazilianPortuguese.getHelpEventSetMessage();
            default:
                return LanguageEnglish.getHelpEventSetMessage();
        }
    }
}