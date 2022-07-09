package me.umbreon.diabloimmortalbot.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.GZIPOutputStream;

/**
 * @author Umbreon Majora
 */

public class ClientLogger {

    private static File logFolder;
    private static File logFile;
    private static boolean createdNewLogFolder;
    private static String date;

    public static void startTimer(String logFolderPath) {
        logFolder = new File(logFolderPath);
        date = getCurrentDate();
        createNewLogFile();

        new Timer().schedule(new TimerTask() {
            public void run() {
                date = getCurrentDate();
                compressLastTenLogFiles();
                checkForNewDateAndCreateNewFileIfNeeded();
            }
        }, 0, (60 * 1000) * 60);
    }

    public static void createNewLogEntry(String message) {
        if (Files.notExists(Paths.get(String.valueOf(logFile)))) {
            createNewLogFile();
            return;
        }

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
            bufferedWriter.append("\n[").append(getCurrentTime()).append("] ").append(message);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkForNewDateAndCreateNewFileIfNeeded() {
        if (!getCurrentDate().equals(date)) {
            createNewLogFile();
        }
    }

    private static boolean doesLogFolderExists() {
        return logFolder.exists();
    }

    private static void createNewLogFile() {
        if (!doesLogFolderExists()) {
            createdNewLogFolder = logFolder.mkdir();
        }
        logFile = new File("/home/discord/logs/" + date + ".log");
        System.out.println(logFile);
        if (!doesLogFileExist()) {
            try {
                boolean createdNewLogFile = logFile.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile, true));
                bufferedWriter.append("#### Author: Umbreon #### #### Date: ").append(getCurrentDate()).append(" ####\n\n");
                bufferedWriter.close();
                if (createdNewLogFolder) {
                    createNewLogEntry("Created new log folder.");
                }
                if (createdNewLogFile) {
                    createNewLogEntry("Created new log file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    private static String getOlderDate(int amount) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -amount);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(cal.getTime());
    }

    private static void compressLastTenLogFiles() {

        for (int i = 1; i <= 10; i++) {
            String date = getOlderDate(i);
            String finalPath = "/home/discord/logs/" + date + ".log";

            Path source = Paths.get(finalPath);
            Path target = Paths.get(finalPath + ".gz");

            if (!Files.notExists(source)) {
                try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(target.toFile()));
                     FileInputStream fis = new FileInputStream(source.toFile())) {

                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) > 0) {
                        gos.write(buffer, 0, len);
                    }

                    deleteLogFile(finalPath);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private static void deleteLogFile(String path) {
        File file = new File(path);
        if (file.delete()) {
            createNewLogEntry("Deleted file " + file.getName());
        }
    }


}
