package org.bluebridge.lock_22_reentrant_lock.reentrant_lock_01_api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可重入测试
 */
public class ReentrantLockCanReentrantTest {

    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        method1();
    }
    public static void method1() {
        lock.lock();
        try {
            System.out.println("进入方法1......");
            method2();
        } finally {
            lock.unlock();
        }
    }
    public static void method2() {
        lock.lock();
        try {
            System.out.println("进入方法2......");
            method3();
        } finally {
            lock.unlock();
        }
    }
    public static void method3() {
        lock.lock();
        try {
            System.out.println("进入方法3......");
        } finally {
            lock.unlock();
        }
    }
}
