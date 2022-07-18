package me.umbreon.diabloimmortalbot.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Date;
import java.util.TimeZone;

public class Time {

    private static final SimpleDateFormat weekdayWithTime = new SimpleDateFormat("EEEE HH:mm");
    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm");

    private static final String WEEKDAY_WITH_TIME = "EEEE HH:mm";
    private static final String time2 = "HH:mm";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(WEEKDAY_WITH_TIME);
    static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(time2);

    private Time() {
    }

    public static String getTimeWithWeekday(String timezone) {
        //try {
        //    Instant timeStamp = Instant.now();
        //    ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
        //    return timestampAtGMTPlus1.format(formatter);
        //} catch (ZoneRulesException e) {
        //    return "INVALID_TIMEZONE";
        //}
        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        weekdayWithTime.setTimeZone(timeZone);
        return weekdayWithTime.format(currentDate);
    }

    public static String getTime(String timezone) {
        //try {
        //    Instant timeStamp = Instant.now();
        //    ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
        //    return timestampAtGMTPlus1.format(formatter2);
        //} catch (ZoneRulesException e) {
        //    return "INVALID_TIMEZONE";
        //}
        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        time.setTimeZone(timeZone);
        return time.format(currentDate);
    }

    public static long getTimeInUnix(String timezone) {
        Instant timeStamp = Instant.now();
        ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
        return timestampAtGMTPlus1.toEpochSecond();
    }

}
