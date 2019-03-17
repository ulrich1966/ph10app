package de.auli.ph10app.util;

import android.util.Log;

public class AppLogger {
    public static AppLogger ourInstance;
    private String className;
    private Boolean isLog;

    /**
     * Set true for logging debug  - false for advoid logging in debug
     *
     * @param clazz Class to be logged
     * @param isLog Either should log or not
     * @return The instance of this logger
     */
    public AppLogger(Class clazz, boolean isLog) {
        className = clazz.getSimpleName();
        this.isLog = isLog;
    }

    private void out(String msg) {
        if (msg == null) msg = new String("");
        if (isLog) {
            System.out.println("***********************");
            Log.d(className, msg);
            System.out.println("***********************");
        }
    }

    public void log(String msg) {
        out(msg);
    }

    public void log(Object value) {
        out(String.format("", value));
    }

    public void log(String msg, Object value) {
        out(String.format("%s %s", msg, value));
    }

    public void log(Object param$1, Object param$2) {
        out(String.format("%s %s", param$1, param$2));
    }

    public void log(String msg, Object param$1, Object param$2) {
        out(String.format("%s %s %s", msg, param$1, param$2));
    }


    private boolean getIsLog() {
        return isLog;
    }

    public void error(String msg, Exception e) {
        Log.e(className, msg, e);
    }
}
