package me.umbreon.diabloimmortalbot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Umbreon Majora
 * <p>
 * External logger, which stores log messages in files.
 * Log files where created with the guild ID as file name.
 */
public class ClientLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientLogger.class);

    private static final String path;

    static {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            path = "C:\\workspace\\log\\";
        } else {
            path = "/home/discord/logs";
        }
    }

    private ClientLogger() {
        // all static methods
    }

    public static void checkIfLogFolderExists(final String logFolderPath) {
        File logFolder = new File(logFolderPath);
        if (!doesLogFolderExists(logFolder)) {
            if (logFolder.mkdir()) {
                LOGGER.info("Created new folder. " + logFolder.getAbsolutePath());
            }
        }
    }

    public static void createNewServerLogEntry(String guildID, String textChannelID, String message) {
        if (!doServerFolderExists(guildID)) {
            createServerFolder(guildID);
        }

        if (!doServerLogFileExists(guildID, textChannelID)) {
            createServerLogFile(guildID, textChannelID);
        }

        File serverLogFile = new File(path + guildID + "/" + textChannelID + ".log");
        String timeStamp = "[" + TimeUtils.getCurrentDate() + " " + TimeUtils.getCurrentTime() + "]";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(serverLogFile, true))) {
            bufferedWriter.append(timeStamp)
                    .append(" ")
                    .append(message)
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createNewErrorLogEntry(Exception logMessage) {
        File logFile = new File(path + "error-log.log");

        if (!doesLogFileExist(logFile)) {
            createNewLogFile();
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            String timeStamp = "[" + TimeUtils.getCurrentDate() + " " + TimeUtils.getCurrentTime() + "]";
            bufferedWriter.append(timeStamp)
                    .append(" ")
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

    private static void createNewLogFile() {
        File logFile = new File(path + "client-log.log");
        try {
            if (logFile.createNewFile()) {
                LOGGER.info("Create new log file. " + logFile.getAbsolutePath());
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean doesLogFolderExists(File logFolder) {
        return logFolder.exists();
    }

    private static boolean doesLogFileExist(File logFile) {
        return logFile.exists();
    }

    private static void createServerFolder(String guildID) {
        File file = new File(path + guildID);
        if (file.mkdirs()) {
            LOGGER.info("Created new server folder. " + file.getAbsolutePath());
        }
    }

    private static boolean doServerLogFileExists(String guildID, String textChannelID) {
        File serverLogFile = new File(path + guildID + "/" + textChannelID + ".log");
        return serverLogFile.exists();
    }

    private static void createServerLogFile(String guildID, String textChannelID) {
        try {
            Files.createFile(Path.of(path + guildID + "/" + textChannelID + ".log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean doServerFolderExists(String guildID) {
        Path folderPath = Path.of(path + guildID);
        return Files.exists(folderPath);
    }
}
