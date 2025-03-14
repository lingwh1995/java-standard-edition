package org.bluebridge.lock_19_multi_lock;

import java.util.concurrent.TimeUnit;

/**
 * 单把锁
 */
public class BigRoomSingleLock {
    public void sleep() {
        synchronized (this) {
            System.out.println("Thread " + Thread.currentThread().getName() + " 睡觉两个小时......");
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void study() {
        synchronized (this) {
            System.out.println("Thread " + Thread.currentThread().getName() + " 学习一个小时......");
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * 5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
