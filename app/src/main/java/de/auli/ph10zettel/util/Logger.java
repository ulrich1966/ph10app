package de.auli.ph10zettel.util;

import android.util.Log;

public class Logger {
    public static void log(String tag, String msg) {
        System.out.println("***********************");
        Log.d(tag, msg);
        System.out.println("***********************");
    }

    public static void log(String tag, String msg, Object value) {
        log(tag, String.format("%s %s", msg, value));
    }
}
