package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_01_api;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 调试lock()方法源码，注意：请将JDK版本设置为1.8
 *      等待锁时不能被打断
 */
public class ReentrantLockSourceDebugTest {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 得到锁......");
                //死循环
                try {
                    Thread.sleep(1000 * 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 释放锁......");
            }
        },"t1");

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 得到锁......");
            }finally {
                lock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 释放锁......");
            }
        },"t2");

        //让thread1先执行
        t1.start();
        TimeUnit.MILLISECONDS.sleep(50);

        t2.start();
        //主线程阻塞一会让所有子线程启动
        TimeUnit.MILLISECONDS.sleep(100);

        //中断线程2
        t2.interrupt();
    }
}
