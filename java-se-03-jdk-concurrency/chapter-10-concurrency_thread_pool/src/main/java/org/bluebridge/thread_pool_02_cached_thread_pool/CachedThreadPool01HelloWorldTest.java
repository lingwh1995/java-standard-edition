package org.bluebridge.thread_pool_02_cached_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存的线程池CahcedThreadPool
 *      1.核心线程数是 0， 最大线程数是 Integer.MAX_VALUE，救急线程的空闲生存时间是 60s，
 *      2.意味着全部都是救急线程（60s 后可以回收）
 *      3.救急线程可以无限创建
 *      4.队列采用了 SynchronousQueue 实现特点是，它没有容量，没有线程来取是放不进去的（一手交钱、一手交货）
 *
 * 线程池基础功能测试
 */
public class CachedThreadPool01HelloWorldTest {
    public static void main(String[] args) {
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
}
