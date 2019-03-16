package de.auli.ph10app.util;

import android.util.Log;

public class Logger {
    public static void log(String tag, String msg) {
        if(msg == null) msg = new String("");
        System.out.println("***********************");
        Log.d(tag, msg);
        System.out.println("***********************");
    }

    public static void log(String tag, String msg, Object value) {
        log(tag, String.format("%s %s", msg, value));
    }

    public static void log(String tag, Object param$1, Object param$2) {
        log(tag, String.format("%s %s", param$1, param$2));
    }

    public static void log(String tag, String msg, Object param$1, Object param$2) {
        log(tag, String.format("%s %s %s", msg, param$1, param$2));
    }

    public static void log(String tag, Object value) {
        log(tag, String.format("%s %s", "", value));
    }
}
