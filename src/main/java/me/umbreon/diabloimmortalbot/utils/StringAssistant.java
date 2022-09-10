package me.umbreon.diabloimmortalbot.utils;

public class StringAssistant {

    // <@6857427252940856> -> 6857427252940856
    public static String removeAllNonNumbers(final String string) {
        return string.replaceAll("[^\\d.]", "");
    }

    public static boolean isStringInTimePattern(final String string) {
        return string.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    public static boolean isStringSingleDashWithDigits(final String string) {
        return string.matches("-[0-9]+");
    }
}
