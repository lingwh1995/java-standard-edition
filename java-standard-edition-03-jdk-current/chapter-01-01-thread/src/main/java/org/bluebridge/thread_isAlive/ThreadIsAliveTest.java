package org.bluebridge.thread_isAlive;

import java.util.concurrent.TimeUnit;

/**
 * isAlive(): 判断线程是否还存活
 */
public class ThreadIsAliveTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");

        t1.start();
        System.out.println("Thread t1.isAlive() : " + t1.isAlive());

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Thread t1.isAlive() : " + t1.isAlive());
    }
}
