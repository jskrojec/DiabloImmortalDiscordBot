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
}
