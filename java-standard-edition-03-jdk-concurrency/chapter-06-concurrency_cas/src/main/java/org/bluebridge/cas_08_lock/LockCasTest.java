package org.bluebridge.cas_08_lock;

import static java.lang.Thread.sleep;

public class LockCasTest {
    public static void main(String[] args) {
        LockCas lock = new LockCas();
        new Thread(() -> {
            System.out.println("begin......");
            lock.lock();
            try {
                System.out.println("lock......");
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            System.out.println("begin......");
            lock.lock();
            try {
                System.out.println("lock......");
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
