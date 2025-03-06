package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_04_fair_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFairLockTest {
    public static void main(String[] args) {
        //使用公平锁
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " running......");
                } finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }

        try {
            // 1s之后去争抢锁
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " start......");
            lock.lock();
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " running......");
            } finally {
                lock.unlock();
            }
        }, "强行插入").start();
        lock.unlock();
    }
}
