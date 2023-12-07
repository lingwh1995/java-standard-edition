package org.bluebridge.thread.thread_designpattern.readwritelock.readwritelock_b;

/**
 * @author ronin
 */
public class Client {
    public static void main(String[] args) {
        final Data sharedData = new Data(10);
        new ReaderThread(sharedData).start();
        new ReaderThread(sharedData).start();
        new ReaderThread(sharedData).start();
        new ReaderThread(sharedData).start();
        new ReaderThread(sharedData).start();
        new WriteThread(sharedData, "123456789").start();
        new WriteThread(sharedData, "ABCEFG").start();
    }
}
