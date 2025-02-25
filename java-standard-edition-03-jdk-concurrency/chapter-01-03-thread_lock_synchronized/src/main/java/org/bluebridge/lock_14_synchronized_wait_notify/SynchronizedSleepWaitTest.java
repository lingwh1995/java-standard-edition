package org.bluebridge.lock_14_synchronized_wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * sleep(long n) 和 wait(long n) 的区别
 *    1.sleep 是 Thread 方法，而 wait 是 Object 的方法
 *    2.sleep 不需要强制和 synchronized 配合使用，但 wait 需要 和 synchronized 一起用
 *    3.sleep 在睡眠的同时，不会释放对象锁的，但 wait 在等待的时候会释放对象锁
 */
public class SynchronizedSleepWaitTest {
    final static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 获得锁......");
                try {
                    //TimeUnit.MILLISECONDS.sleep(20000);
                    lock.wait(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(1000);

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " 获得锁......");
        }
    }
}
