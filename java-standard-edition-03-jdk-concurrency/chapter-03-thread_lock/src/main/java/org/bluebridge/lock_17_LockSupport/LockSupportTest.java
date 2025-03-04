package org.bluebridge.lock_17_LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 暂停线程运行
 * LockSupport.park;
 *
 * 恢复线程运行
 * LockSupport.unpark(thread);
 *
 * wait/notify依赖于锁资源，所以要在synchronized中使用，park()和unpark()不依赖于锁资源
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " start......");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " park......");
            LockSupport.park();
            System.out.println("Thread " + Thread.currentThread().getName() + " resume......");
        },"t1");
        t1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " unpark......");
        LockSupport.unpark(t1);
    }
}
