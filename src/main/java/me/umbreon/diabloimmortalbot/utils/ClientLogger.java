package me.umbreon.diabloimmortalbot.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ClientLogger {

    private static File logFolder;
    private static File logFile;

    private ClientLogger() {
    }

    public static void checkIfLogFolderExists(String logFolderPath) {
        logFolder = new File(logFolderPath);
        if (!doesLogFolderExists()) {
            logFolder.mkdir();
        }
    }

    public static void createNewLogEntry(String guildID, String guildName, String ownerID, String message) {
        logFile = new File("/home/discord/logs/" + guildID + ".log");

        if (!doesLogFileExist()) {
            createNewLogFile(guildID, guildName, ownerID);
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.append("\n[").append(getCurrentDate()).append(" ")
                    .append(getCurrentTime()).append("] ").append(message);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewLogEntry(String guildID, String guildName, String ownerID, Exception message) {
        logFile = new File("/home/discord/logs/" + guildID + ".log");

        if (!doesLogFileExist()) {
            createNewLogFile(guildID, guildName, ownerID);
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.append("\n[").append(getCurrentDate()).append(" ")
                    .append(getCurrentTime()).append("] ").append(message.getMessage()).append("\n");
            for (StackTraceElement e : message.getStackTrace()) {
                bufferedWriter.append(String.valueOf(e)).append("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewInfoLogEntry(String message) {
        logFile = new File("/home/discord/logs/client-log.log");

        if (!doesLogFileExist()) {
            createNewLogFile("client-log", "Client_Log", "Umbreon");
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.append("\n[").append(getCurrentDate()).append(" ")
                    .append(getCurrentTime()).append("] ").append(message);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewLogFile(String guildID, String guildName, String ownerID) {
        logFile = new File("/home/discord/logs/" + guildID + ".log");

        try {
            logFile.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));

            String headerMessage = "#### Author: Umbreon ####\n" +
                    "GuildID: " + guildID + " | Guildname: " + guildName + " | OwnerID: " + ownerID + "\n\n";

            bufferedWriter.append(headerMessage);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean doesLogFolderExists() {
        return logFolder.exists();
    }

    private static boolean doesLogFileExist() {
        return logFile.exists();
    }

    private static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }

    private static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        return dateFormat.format(new Date());
    }

}
