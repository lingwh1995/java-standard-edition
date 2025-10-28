package org.bluebridge.thread_17_communication.model;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lingwh
 * @desc 演示CyclicBarrier机制的使用场景：主线程等待多个工作线程完成
 * @date 2025/10/28 9:34
 */
@Slf4j
public class CyclicBarrierTest {

    // 总工作线程数量
    private static final int TOTAL_WORKERS = 3;
    // 创建CyclicBarrier，指定需要等待的线程数和屏障动作
    private static final CyclicBarrier barrier = new CyclicBarrier(TOTAL_WORKERS, () -> {
        log.info("所有工作已完成，主线程继续执行......");
    });

    public static void main(String[] args) {
        log.info("主线程等待所有工作线程完成......");
        
        // 启动3个工作线程
        new Thread(new Worker("Worker-1")).start();
        new Thread(new Worker("Worker-2")).start();
        new Thread(new Worker("Worker-3")).start();
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
                
                // 等待其他线程，当所有线程都到达屏障点时执行回调
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                log.error("{} 工作过程中发生异常", name, e);
                Thread.currentThread().interrupt();
            }
        }
    }

}
