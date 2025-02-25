package org.bluebridge.lock_14_synchronized_wait_notify;

import java.util.concurrent.TimeUnit;

public class SynchronizedWaitNotifyTest {
    final static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread " + Thread.currentThread().getName() + " 执行......");
                try {
                    lock.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " 其它代码......");
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread " + Thread.currentThread().getName() + " 执行......");
                try {
                    lock.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " 其它代码......");
            }
        },"t2");
        t2.start();

        // 主线程两秒后执行
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("唤醒 obj 上其它线程......");
        synchronized (lock) {
            lock.notify(); // 唤醒obj上一个线程
            //lock.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
}
