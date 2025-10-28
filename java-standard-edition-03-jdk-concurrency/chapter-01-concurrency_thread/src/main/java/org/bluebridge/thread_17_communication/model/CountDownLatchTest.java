package org.bluebridge.thread_17_communication.model;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author lingwh
 * @desc 演示CountDownLatch的使用场景：主线程等待多个工作线程完成
 * @date 2025/10/27 18:25
 */
@Slf4j
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个计数为3的CountDownLatch
        CountDownLatch latch = new CountDownLatch(3);

        // 启动3个工作线程
        new Thread(new Worker(latch, "Worker-1")).start();
        new Thread(new Worker(latch, "Worker-2")).start();
        new Thread(new Worker(latch, "Worker-3")).start();

        log.info("主线程等待所有工作线程完成......");

        // 主线程等待所有工作完成
        latch.await();

        log.info("所有工作已完成，主线程继续执行......");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;
        private final String name;

        public Worker(CountDownLatch latch, String name) {
            this.latch = latch;
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
            } finally {
                // 工作完成后计数减1
                latch.countDown();
            }
        }
    }

}