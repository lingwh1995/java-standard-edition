package org.bluebridge.my_aqs_lock.v1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MyLockTest {
    public static void main(String[] args) {
        //testMyLockBasic();

        testMyLockReentrant();
    }

    /**
     * 测试 MyLock 基础功能
     */
    private static void testMyLockBasic() {
        MyLock lock = new MyLock();
        new Thread(() -> {
            lock.lock();
            try {
                log.debug("locking...");
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                log.debug("unlocking...");
                lock.unlock();
            }
        },"t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                log.debug("locking...");
            } finally {
                log.debug("unlocking...");
                lock.unlock();
            }
        },"t2").start();
    }

    /**
     * 测试 MyLock 不可重
     */
    private static void testMyLockReentrant() {
        MyLock lock = new MyLock();
        lock.lock();
        log.debug("locking...");
        lock.lock();
        log.debug("locking...");
    }
}
