package org.bluebridge.lock_10_synchronized_upgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁    101
 *      在锁对象的对象头中记录一下当前获取到该锁的线程ID，该线程下次如果又来获取该锁就可以直接获取到了，也就是支持锁重入。偏向锁作用，主要是解决可重入问题，当线程重复获取锁的时候，就判断该锁是否有线程ID
 *
 * 测试偏向锁准备工作
 *      1.JDK版本设置为1.8
 *      2.VM配置参数设置为 -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 */
public class Sychronized_02_BiasedLockTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建新对象，初始为无锁状态
        Object lock = new Object();
        System.out.println("初始：" + ClassLayout.parseInstance(lock).toPrintableSimple());

        // 第一个线程获取锁，将进入偏向锁状态
        synchronized (lock) {
            // 在这里，对象头中的锁标志位被设置为偏向锁模式，并记录了当前线程ID
            System.out.println("Thread " + Thread.currentThread().getId() + " 已经获取到了偏向锁......");
            System.out.println("偏向锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
        }

        // 当前线程释放锁后，对象保持偏向锁状态，直到有其他线程尝试获取锁
        System.out.println("解锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
    }
}
