package org.bluebridge.thread_17_communication.wait_for_other_worker;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.Semaphore;

/**
 * @author lingwh
 * @desc 演示Semaphore机制的使用场景：主线程等待多个工作线程完成
 * @date 2025/10/28 9:34
 */
@Slf4j
public class SemaphoreTest {

    // 总工作线程数量
    private static final int TOTAL_WORKERS = 3;
    // 创建Semaphore，初始许可数为0
    private static final Semaphore SEMAPHORE = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        // 启动3个工作线程
        new Thread(new Worker("工作线程1 => 启动服务A")).start();
        new Thread(new Worker("工作线程2 => 启动服务B")).start();
        new Thread(new Worker("工作线程3 => 启动服务C")).start();

        log.info("主线程等待所有工作线程完成......");

        // 获取TOTAL_WORKERS个许可，阻塞直到所有工作完成
        SEMAPHORE.acquire(TOTAL_WORKERS);

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

            // 释放一个许可
            SEMAPHORE.release();
        }
    }

}
