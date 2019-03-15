package de.auli.ph10app.service;

public class DataStore {
    private static final DataStore ourInstance = new DataStore();
    Object object;

    public static DataStore getInstance() {
        return ourInstance;
    }

    private DataStore() {
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
