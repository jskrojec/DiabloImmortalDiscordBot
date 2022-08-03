package me.umbreon.diabloimmortalbot.utils;

public class IdentifierConverter {

    public static String removeAllNonNumbers(String string) {
        return string.replaceAll("[^\\d.]", "");
    }
}
