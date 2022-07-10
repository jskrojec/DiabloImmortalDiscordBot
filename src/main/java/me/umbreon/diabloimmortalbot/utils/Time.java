package me.umbreon.diabloimmortalbot.utils;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Time {

    public static String getFullTime(String timezone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE HH:mm");
        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(currentDate);
    }

    public static String getTime(String timezone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(timezone);

        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(currentDate);
    }

    public static boolean isTimeZoneUTC(String timeZone) {
        return timeZone.substring(0, 3).equalsIgnoreCase("utc");
    }

    public static boolean isTimeZoneCEST(String timeZone) {
        return timeZone.substring(0, 4).equalsIgnoreCase("cest");
    }

    public static boolean isTimeZoneEST(String timeZone) {
        return timeZone.substring(0, 3).equalsIgnoreCase("est");
    }

    public static boolean isTimeZoneGMT(String timeZone) {
        return timeZone.substring(0, 3).equalsIgnoreCase("gmt");
    }

    public static String replaceUtcTimeZone(String timeZone) {
        int timeZoneLength = timeZone.length();
        return "GMT" + timeZone.substring(3, timeZoneLength);
    }
}
