package org.bluebridge.lock_17_lock_support_park_unpark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 暂停线程运行   LockSupport.park;
 * 恢复线程运行   LockSupport.unpark(thread);
 *
 * wait,notify 和 park,unpark的区别
 *     1.wait,notify是Object的方法,而park,unpark是LockSupport的方法
 *     2.wait,notify必须配合 Object Monitor一起使用,所以要在synchronized中使用,而park,unpark不需要
 *     3.park&unpark是以线程为单位来[阻塞]和[唤醒]线程的,而notify只能随机唤醒一个等待线程,notifyAll是唤醒所有等待线程,不那么精确.
 *     4.park &unpark 可以先调用unpark,而wait,notify不能先notify.
 */
public class ParkUnParkTest {
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
