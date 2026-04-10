package org.bluebridge.lock_15_synchronized_wait_notify;

import java.util.concurrent.TimeUnit;

/**
 * obj.wait() 让进入 object 监视器的线程到 waitSet 等待
 * obj.notify() 在 object 上正在 waitSet 等待的线程中挑一个唤醒
 * obj.notifyAll() 让 object 上正在 waitSet 等待的线程全部唤醒
 *
 * 特别注意： 这几个方法都要和sychronized一起使用
 */
public class SynchronizedWaitNotifyTest {
    final static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread " + Thread.currentThread().getName() + " 执行......");
                try {
                    //让线程在lock上一直等待下去
                    lock.wait();
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
