package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_03_unfair_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 非公平锁的锁获取流程
 *      +-------------------+
 *      |  线程1 请求锁      | ---> 立即尝试获取锁
 *      +-------------------+
 *      +-------------------+
 *      |  线程2 请求锁      | ---> 立即尝试获取锁
 *      +-------------------+
 *      +-------------------+
 *      |  线程3 请求锁      | ---> 立即尝试获取锁
 *      +-------------------+
 *
 * 非公平锁的优点
 *     高性能：非公平锁允许线程"抢占"锁，而不必按照排队的顺序等待。这样可以减少线程的上下文切换和调度开销，从而提升系统的并发性能。
 *     高吞吐量：由于锁可以被直接抢占，非公平锁在某些情况下能够快速处理短时间的任务，提高系统的整体吞吐量。
 *
 * 非公平锁的缺点
 *     可能导致线程饥饿：非公平锁不保证线程获取锁的顺序，某些线程可能长期处于等待状态，特别是在高并发场景中，如果线程抢不到锁，就会出现线程饥饿问题。
 *     任务顺序不确定：非公平锁不保证任务的执行顺序，在某些对顺序要求严格的场景下，非公平锁可能不合适。
 */
public class ReentrantLockNonFairLockTest {
    // 非公平锁（默认）
    private static final ReentrantLock nonFairLock = new ReentrantLock(false);

    public static void main(String[] args) {
        System.out.println("========= 非公平锁示例 =========");
        Runnable task = () -> {
            // 每个线程尝试获取锁2次
            for (int i = 0; i < 2; i++) {
                nonFairLock.lock();
                try {
                    System.out.printf("%s 获取锁 | 等待队列长度: %d%n",
                            Thread.currentThread().getName(),
                            nonFairLock.getQueueLength());
                    // 模拟业务逻辑
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    nonFairLock.unlock();
                }
            }
        };

        // 启动3个线程竞争锁
        for (int i = 0; i < 3; i++) {
            new Thread(task, "Thread-" + (i + 1)).start();
        }
    }
}
