package org.bluebridge.thread_pool_executor;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 固定大小的线程池
 *      核心线程数和最大线程数相等，使用无界队列。
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个固定大小为4的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 提交任务
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " - 1");
        });
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " - 2");
        });
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " - 3");
        });

        // 关闭线程池（必须显式关闭）
        executor.shutdown();
    }

    @Test
    public void testLinkedBlockingQueue() {
        BlockingQueue queue = new LinkedBlockingQueue();
    }
}
