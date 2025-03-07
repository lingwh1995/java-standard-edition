package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_03_unfair_lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairVsNonFairLockDemo {

    // 公平锁
    private static final ReentrantLock fairLock = new ReentrantLock(true);
    // 非公平锁（默认）
    private static final ReentrantLock nonFairLock = new ReentrantLock(false);

    public static void main(String[] args) {
        System.out.println("========= 公平锁示例 =========");
        testLock(fairLock);  // 测试公平锁

        // 等待1秒，确保输出不混杂
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("\n========= 非公平锁示例 =========");
        testLock(nonFairLock);  // 测试非公平锁
    }

    /**
     * 测试锁的行为
     * @param lock 要测试的锁（公平或非公平）
     */
    private static void testLock(ReentrantLock lock) {
        Runnable task = () -> {
            for (int i = 0; i < 2; i++) {  // 每个线程尝试获取锁2次
                lock.lock();
                try {
                    System.out.printf("%s 获取锁 | 等待队列长度: %d%n",
                            Thread.currentThread().getName(),
                            lock.getQueueLength());
                    // 模拟业务逻辑
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        // 启动3个线程竞争锁
        for (int i = 0; i < 3; i++) {
            new Thread(task, "Thread-" + (i + 1)).start();
        }
    }
}
