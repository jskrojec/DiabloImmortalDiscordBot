package me.umbreon.diabloimmortalbot.utils;

public class BooleanAssistant {

    public static boolean isValueTrue(String value) {
        switch (value.toLowerCase()) {
            case "true":
            case "yes":
            case "on":
            case "yeah":
            case "yessir":
                return true;
            default:
                return false;
        }
    }

    public static boolean isValueFalse(String value) {
        switch (value.toLowerCase()) {
            case "false":
            case "no":
            case "off":
            case "nah":
            case "noo":
                return true;
            default:
                return false;
        }
    }
}
