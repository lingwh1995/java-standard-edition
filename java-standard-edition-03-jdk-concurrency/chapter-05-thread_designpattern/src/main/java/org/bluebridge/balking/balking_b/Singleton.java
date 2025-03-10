package org.bluebridge.balking.balking_b;

/**
 * Balking （犹豫）模式用在一个线程发现另一个线程或本线程已经做了某一件相同的事，那么本线程就无需再做 了，直接结束返回
 *
 * 单例模式 + 犹豫模式
 */
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
