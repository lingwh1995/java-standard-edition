package org.bluebridge.lock_05_synchronized_thread8lock.lock_2;

import java.util.concurrent.TimeUnit;

/**
 * 情况2：1s后12，或 2 1s后 1
 */
public class Number {
    public synchronized void a() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1......");
    }

    public synchronized void b() {
        System.out.println("2......");
    }


    public static void main(String[] args) {
        Number n1 = new Number();
        new Thread(() -> { n1.a(); }).start();
        new Thread(() -> { n1.b(); }).start();
    }
}
