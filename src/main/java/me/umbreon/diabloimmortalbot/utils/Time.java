package me.umbreon.diabloimmortalbot.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;
import java.util.Date;

public class Time {

    private static final String WEEKDAY_WITH_TIME_HH_MM = "EEEE HH:mm";
    private static final String TIME_HH_MM = "HH:mm";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(WEEKDAY_WITH_TIME_HH_MM);
    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(TIME_HH_MM);
    private static final DateFormat ddHHyyyy_dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static final DateFormat HHmmssSSS_dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

    private Time() {
    }

    public static String getTimeWithWeekday(String timezone) {
        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.format(formatter);
        } catch (ZoneRulesException e) {
            return "INVALID_TIMEZONE";
        }
    }

    public static String getTime(String timezone) {
        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.format(formatter2);
        } catch (ZoneRulesException e) {
            return "INVALID_TIMEZONE";
        }
    }

    public static long getTimeInUnix(String timezone) {
        try {
            Instant timeStamp = Instant.now();
            ZonedDateTime timestampAtGMTPlus1 = timeStamp.atZone(ZoneId.of(timezone, ZoneId.SHORT_IDS));
            return timestampAtGMTPlus1.toEpochSecond();
        } catch (ZoneRulesException e) {
            ClientLogger.createNewErrorLogEntry(e);
            return 0;
        }
    }

    static String getCurrentDate() {
        return ddHHyyyy_dateFormat.format(new Date());
    }

    static String getCurrentTime() {
        return HHmmssSSS_dateFormat.format(new Date());
    }
}
