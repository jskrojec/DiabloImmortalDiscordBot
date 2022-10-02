package me.umbreon.diabloimmortalbot.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClientLogger {

    private static File logFolder;
    private static File logFile;
    private static String path;

    static {
        if (true) {
            path = "C:\\workspace\\log\\";
        } else {
            path = "/home/discord/logs";
        }
    }

    private ClientLogger() {
    }

    public static void checkIfLogFolderExists(final String logFolderPath) {
        logFolder = new File(logFolderPath);
        if (!doesLogFolderExists()) {
            logFolder.mkdir();
        }
    }

    public static void createNewServerLogEntry(final String guildID, final String textChannelID, final String message) {
        if (!doServerFolderExists(guildID)) {
            createServerFolder(guildID);
        }

        if (!doServerLogFileExists(guildID, textChannelID)) {
            createServerLogFile(guildID, textChannelID);
        }

        File serverLogFile = new File(path + guildID + "/" + textChannelID + ".log");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(serverLogFile, true))) {
            bufferedWriter.append("\n[")
                    .append(TimeUtils.getCurrentDate())
                    .append(" ")
                    .append(TimeUtils.getCurrentTime())
                    .append("] ")
                    .append(message)
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean doServerFolderExists(final String guildID) {
        final Path folderPath = Path.of(path + guildID);
        return Files.exists(folderPath);
    }

    private static void createServerFolder(final String guildID) {
        new File(path + guildID).mkdirs();
    }

    private static boolean doServerLogFileExists(final String guildID, final String textChannelID) {
        final File serverLogFile = new File(path + guildID + "/" + textChannelID + ".log");
        return serverLogFile.exists();
    }

    private static void createServerLogFile(final String guildID, final String textChannelID) {
        try {
            Files.createFile(Path.of(path + guildID + "/" + textChannelID + ".log"));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewSqlLogEntry(final Exception logMessage) {
        logFile = new File(path + "sql-log.log");

        if (!doesLogFileExist()) {
            createNewLogFile("sql-log");
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.append("[")
                    .append(TimeUtils.getCurrentDate())
                    .append(" ")
                    .append(TimeUtils.getCurrentTime())
                    .append("] ")
                    .append(logMessage.getMessage())
                    .append("\n");
            for (StackTraceElement e : logMessage.getStackTrace()) {
                bufferedWriter.append(String.valueOf(e)).append("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewErrorLogEntry(final Exception logMessage) {
        logFile = new File(path + "error-log.log");

        if (!doesLogFileExist()) {
            createNewLogFile("client-log");
        }

        final BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.append("\n[")
                    .append(TimeUtils.getCurrentDate())
                    .append(" ")
                    .append(TimeUtils.getCurrentTime())
                    .append("] ")
                    .append(logMessage.getMessage())
                    .append("\n");
            for (final StackTraceElement e : logMessage.getStackTrace()) {
                bufferedWriter.append(String.valueOf(e)).append("\n");
            }
            bufferedWriter.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private static void createNewLogFile(final String logFileName) {
        logFile = new File(path + logFileName + ".log");

        try {
            logFile.createNewFile();
            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean doesLogFolderExists() {
        return logFolder.exists();
    }

    private static boolean doesLogFileExist() {
        return logFile.exists();
    }
}
