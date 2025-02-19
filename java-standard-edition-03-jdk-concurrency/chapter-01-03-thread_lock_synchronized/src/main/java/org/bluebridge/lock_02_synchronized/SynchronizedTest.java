package org.bluebridge.lock_02_synchronized;

/**
 * 使用 synchronized 避免临界区中发生竞态条件
 */
public class SynchronizedTest {
    static final Object lock = new Object();

    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (lock) {
                    counter--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("counter = " + counter);
    }
}
