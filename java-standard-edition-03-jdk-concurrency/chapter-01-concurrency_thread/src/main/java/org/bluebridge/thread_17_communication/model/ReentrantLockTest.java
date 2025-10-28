package org.bluebridge.thread_17_communication.model;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lingwh
 * @desc 演示ReentrantLock/Condition机制的使用场景：主线程等待多个工作线程完成
 * @date 2025/10/28 9:34
 */
@Slf4j
public class ReentrantLockTest {

    // 创建可重入锁
    private static final ReentrantLock lock = new ReentrantLock();
    // 创建条件对象
    private static final Condition completionCondition = lock.newCondition();
    // 记录完成的工作线程数量
    private static int completedWorkers = 0;
    // 总工作线程数量
    private static final int TOTAL_WORKERS = 3;

    public static void main(String[] args) throws InterruptedException {
        // 启动3个工作线程
        new Thread(new Worker("Worker-1")).start();
        new Thread(new Worker("Worker-2")).start();
        new Thread(new Worker("Worker-3")).start();

        lock.lock();
        try {
            log.info("主线程等待所有工作线程完成......");

            // 主线程等待所有工作完成
            while (completedWorkers < TOTAL_WORKERS) {
                completionCondition.await();
            }
        } finally {
            lock.unlock();
        }

        log.info("所有工作已完成，主线程继续执行......");
    }

    static class Worker implements Runnable {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                log.info("{} 开始工作......", name);
                // 模拟工作耗时
                Thread.sleep((long) (Math.random() * 3000));
                log.info("{} 工作完成......", name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            lock.lock();
            try {
                // 增加完成的工作线程计数
                completedWorkers++;
                // 唤醒等待的主线程
                completionCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

}
