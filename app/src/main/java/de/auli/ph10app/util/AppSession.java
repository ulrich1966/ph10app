package de.auli.ph10app.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppSession {
    private static final ConcurrentHashMap<String, Object> SESSION = new ConcurrentHashMap<>();

    public static void addValue(String key, Object value){
        SESSION.put(key,value );
    }

    public static Object getValue(String key){
        return SESSION.get(key);
    }

    public static Map<String, Object> getSession() {
        return SESSION;
    }
}
