package org.bluebridge.thread_pool_executor;


import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 */
public class ThreadPoolTest {

    /**
     * 可缓存线程池。
     *     线程池大小无限制，线程空闲超过 60 秒会被回收。
     */
    @Test
    public void testCachedThreadPool() {
        ExecutorService executor = Executors.newCachedThreadPool();

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


    /**
     * 单线程的线程池。
     *     保证任务按提交顺序执行。
     */
    @Test
    public void testSingleThreadExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

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
}
