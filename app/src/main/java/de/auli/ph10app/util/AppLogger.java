package de.auli.ph10app.util;

import android.util.Log;

public class AppLogger {
    public static final AppLogger ourInstance = new AppLogger();
    private static String className;
    private static Boolean isLog;

    /**
     * Set true for logging debug  - false for advoid logging in debug
     *
     * @param clazz Class to be logged
     * @param isLog Either should log or not
     * @return The instance of this logger
     */
    public static AppLogger getLogger(Class clazz, boolean isLog) {
        AppLogger.className = clazz.getSimpleName();
        AppLogger.isLog = isLog;
        return ourInstance;
    }

    private AppLogger() {
    }

    private static void out(String msg) {
        if (msg == null) msg = new String("");
        if (isLog) {
            System.out.println("***********************");
            Log.d(className, msg);
            System.out.println("***********************");
        }
    }

    public static void log(String msg) {
        out(msg);
    }

    public static void log(Object value) {
        out(String.format("",value));
    }

    public static void log(String msg, Object value) {
        out(String.format("%s %s", msg, value));
    }

    public static void log(Object param$1, Object param$2) {
        out(String.format("%s %s", param$1, param$2));
    }

    public static void log(String msg, Object param$1, Object param$2) {
        out(String.format("%s %s %s", msg, param$1, param$2));
    }
}
