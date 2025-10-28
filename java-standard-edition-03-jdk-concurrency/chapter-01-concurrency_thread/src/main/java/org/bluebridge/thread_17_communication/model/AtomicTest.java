package org.bluebridge.thread_17_communication.model;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lingwh
 * @desc 演示原子变量的使用场景：主线程等待多个工作线程完成
 * @date 2025/10/28 9:34
 */
@Slf4j
public class AtomicTest {

    // 使用原子变量替代普通int变量
    private static final AtomicInteger completedWorkers = new AtomicInteger(0);
    // 总工作线程数量
    private static final int TOTAL_WORKERS = 3;

    public static void main(String[] args) throws InterruptedException {
        // 启动3个工作线程
        new Thread(new Worker("Worker-1")).start();
        new Thread(new Worker("Worker-2")).start();
        new Thread(new Worker("Worker-3")).start();

        log.info("主线程等待所有工作线程完成......");

        // 主线程轮询等待所有工作完成
        while (completedWorkers.get() < TOTAL_WORKERS) {
            Thread.sleep(100); // 短暂休眠避免过度占用CPU
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

            // 原子性增加完成的工作线程计数
            completedWorkers.incrementAndGet();
        }
    }

}
