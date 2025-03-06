package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_01_api;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock()方法
 *      1.获取不到锁时不阻塞，返回false，若是成功获取锁则返回true。
 *      2.调用interrupt()无法中断线程
 */
public class ReentrantLockTryLockTest {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.tryLock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 得到锁......");
                //死循环
                for (int i = 0; i < 3; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
                System.out.println("Thread " + Thread.currentThread().getName() + " 释放锁......");
            }
        },"t1");

        Thread t2 = new Thread(() -> {
            boolean alreadyLock = false;
            try {
                alreadyLock = lock.tryLock();
                if (alreadyLock)
                    System.out.println("Thread " + Thread.currentThread().getName() + " 释放锁......");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (alreadyLock){
                    lock.unlock();
                }
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " 结束......");
        },"t2");

        t1.start();
        //让thread1先执行
        TimeUnit.MILLISECONDS.sleep(50);
        t2.start();

        //主线程阻塞一会让所有子线程启动
        TimeUnit.MILLISECONDS.sleep(100);

        //中断线程2
        t2.interrupt();
    }
}