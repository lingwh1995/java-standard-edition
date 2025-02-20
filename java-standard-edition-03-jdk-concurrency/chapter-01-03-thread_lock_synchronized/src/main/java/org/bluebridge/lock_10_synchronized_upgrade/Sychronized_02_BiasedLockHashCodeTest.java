package org.bluebridge.lock_10_synchronized_upgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁hashcode测试
 *
 * 测试偏向锁准备工作
 *      1.JDK版本设置为1.8
 *      2.VM配置参数设置为 -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 */
public class Sychronized_02_BiasedLockHashCodeTest {

    /**
     * 初始:                 00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000101     // 初始是匿名偏向状态
     * 上锁：                00000000 00000000 00000001 01010000 00111100 01001110 01100000 00000101     // 上锁之后是偏向锁状态,前 54 位是偏向线程 ID
     * hashCode:            11111101 10101111 00110101 1111100                                          // 对象的 hashCode 转成二进制
     * hashCode 调用后状态：  00000000 00000000 00000001 01010000 00111001 10010110 10000101 00111010     // 轻量级锁状态下调用 hashCode() 之后直接膨胀为重量级锁,前 64 位是指向 monitor 对象的地址
     * 解锁：                00000000 00000000 00000001 01010000 00111001 10010110 10000101 00111010     // 重量级锁解锁后依旧是重量级锁,因为升级为重量级锁之后不会再降级了
     */
    public static void main(String[] args) {
        Object lock = new Object();
        System.out.println("初始：" + ClassLayout.parseInstance(lock).toPrintableSimple());
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("上锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
                System.out.println("hashCode: "+ Integer.toBinaryString(lock.hashCode()));
                System.out.println("hashCode 调用后状态：" + ClassLayout.parseInstance(lock).toPrintableSimple());
            }
            System.out.println("解锁：" + ClassLayout.parseInstance(lock).toPrintableSimple());
        }).start();
    }

}
