package org.bluebridge.thread_pool_03_thread_pool_executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个固定大小为4的线程池
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个固定大小为4的线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 提交任务
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println("Task executed by " + Thread.currentThread().getName());
            });
        }

        // 关闭线程池（必须显式关闭）
        executor.shutdown();
    }
}
