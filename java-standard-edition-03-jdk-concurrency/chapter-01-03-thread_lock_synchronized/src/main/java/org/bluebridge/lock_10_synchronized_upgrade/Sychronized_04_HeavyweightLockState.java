package org.bluebridge.lock_10_synchronized_upgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 * 重量级锁状态   010
 *      两个或者以上线程并发的在一个对象上进行同步时，为了避免无用自旋锁cpu，轻量级锁就会升级成重量级锁。
 */
public class Sychronized_04_HeavyweightLockState {

    // 定义一个锁对象
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建第一个线程
        Thread t1 = new Thread(() -> {
            // 第一个线程尝试获取锁
            synchronized (lock) {
                System.out.println("线程 " + Thread.currentThread().getId() + " 已经获取了偏向锁......");
                try {
                    // 模拟长时间运行，以便让其他线程有机会尝试获取锁
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        // 创建第二个线程
        Thread t2 = new Thread(() -> {
            // 第二个线程尝试获取锁
            synchronized (lock) {
                System.out.println("线程 " + Thread.currentThread().getId() + " 正在尝试获取轻量锁......");
                System.out.println("---------------------------------------------------------------");
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
                System.out.println("---------------------------------------------------------------");
            }
        });

        // 启动第一个线程
        t1.start();
        // 启动第二个线程
        t2.start();

        // 等待两个线程完成
//        t1.join();
//        t2.join();

        System.out.println("所有线程已执行完毕......");
    }
}
