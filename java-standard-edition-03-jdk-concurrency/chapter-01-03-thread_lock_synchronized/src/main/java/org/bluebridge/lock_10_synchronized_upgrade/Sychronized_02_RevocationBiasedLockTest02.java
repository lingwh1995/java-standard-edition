package org.bluebridge.lock_10_synchronized_upgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 * 测试偏向锁准备工作
 *      1.JDK版本设置为1.8
 *      2.VM配置参数设置为 -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 *
 *  撤销偏向锁方式二：其他线程使用对象，下面代码实际上是偏向锁升级到轻量级锁，也属于撤消偏向锁的一种情况
 */
public class Sychronized_02_RevocationBiasedLockTest02 {

    public static void main(String[] args) throws InterruptedException {
        // 创建新对象，初始为无锁状态
        Object lock = new Object();
        System.out.println("初始：" + ClassLayout.parseInstance(lock).toPrintableSimple());

        // 第一个线程获取锁，将进入偏向锁状态
        synchronized (lock) {
            // 在这里，对象头中的锁标志位被设置为偏向锁模式，并记录了当前线程ID
            System.out.println("Thread " + Thread.currentThread().getName() + " 已经获取到了偏向锁......");
            System.out.println("偏向锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
        }

        Thread t = new Thread(() -> {
            // 第二个线程获取锁，将进入 偏向锁升级 -> 轻量锁 状态
            synchronized (lock) {
                System.out.println("Thread " + Thread.currentThread().getName() + " 偏向锁已经升级到了轻量锁......");
                System.out.println("轻量锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
            }
        });
        t.start();
        t.join();

        // 当前线程释放锁后，对象保持偏向锁状态，直到有其他线程尝试获取锁
        System.out.println("解锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
    }

}
