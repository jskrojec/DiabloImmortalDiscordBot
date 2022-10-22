package me.umbreon.diabloimmortalbot.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    private static final String WEEKDAY_WITH_TIME_HH_MM = "EEEE HH:mm";
    private static final String TIME_HH_MM = "HH:mm";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(WEEKDAY_WITH_TIME_HH_MM);
    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(TIME_HH_MM);

    private static final DateTimeFormatter WEEKDAY_FORMAT = DateTimeFormatter.ofPattern("EEEE");
    private static final DateFormat dd_MM_yyyy_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final DateFormat HH_mm_ss_SSS_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");

    private TimeUtils() {
        // all static methods.
    }

    public static String getTimeWithWeekday(final String timezone) {
        try {
            final Instant timeStamp = Instant.now();
            final ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.format(formatter);
        } catch (final ZoneRulesException e) {
            return "INVALID_TIMEZONE";
        }
    }

    public static String getTime(final String timezone) {
        try {
            final Instant timeStamp = Instant.now();
            final ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.format(formatter2);
        } catch (final ZoneRulesException e) {
            return "INVALID_TIMEZONE";
        }
    }

    public static long getTimeInUnix(final String timezone) {
        try {
            final Instant timeStamp = Instant.now();
            final ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.toEpochSecond();
        } catch (final ZoneRulesException e) {
            ClientLogger.createNewErrorLogEntry(e);
            return 0;
        }
    }

    static String getCurrentDate() {
        return dd_MM_yyyy_FORMAT.format(new Date());
    }

    static String getCurrentTime() {
        return HH_mm_ss_SSS_FORMAT.format(new Date());
    }

    public static String getCurrentWeekday(String timezone) {
        try {
            final Instant timeStamp = Instant.now();
            final ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.format(WEEKDAY_FORMAT);
        } catch (final ZoneRulesException e) {
            return "INVALID_TIMEZONE";
        }
    }

    public static Calendar getTimeAsCalendar(String time) {
        try {
            Date time1 = new SimpleDateFormat("HH:mm").parse(time);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);
            return calendar1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
