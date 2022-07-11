package me.umbreon.diabloimmortalbot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Time {

    private static final SimpleDateFormat weekdayWithTime = new SimpleDateFormat("EEEE HH:mm");
    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm");

    private Time() {
    }

    public static String getTimeWithWeekday(String timezone) {
        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        weekdayWithTime.setTimeZone(timeZone);
        return weekdayWithTime.format(currentDate);
    }

    public static String getTime(String timezone) {
        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        time.setTimeZone(timeZone);
        return time.format(currentDate);
    }

}
