package org.bluebridge.balking.balking_b;

public final class Singleton {
    private Singleton() {

    }

    private static Singleton INSTANCE = null;

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
