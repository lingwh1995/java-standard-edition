package org.bluebridge.thread_pool_01_fixed_thread_pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 固定大小的线程池FixedThreadPool
 *      1.线程池大小固定，不会随着任务的增长而增长。
 *      2.核心线程数和最大线程数相等，使用无界队列
 *      3.使用的工作队列是LinkedBlockingQueue
 *
 * 其他API测试
 */
public class FixedThreadPool03APITest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //testSubmit();

        //testInvokeAll();

        //testInvokeAny();

        testShutdownShutdownNowAndAwaitTermination();
    }


    /**
     * 测试submit()
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " running......");
            TimeUnit.MILLISECONDS.sleep(1000);
            return "ok";
        });

        System.out.println(future.get());

        // 关闭线程池（必须显式关闭）
        executor.shutdown();
    }

    /**
     * 测试invokeAll()
     * @throws InterruptedException
     */
    private static void testInvokeAll() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<Future<String>> futures = executor.invokeAll(Arrays.asList(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " begin......");
                    Thread.sleep(1000);
                    return "1";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName() + " begin......");
                    Thread.sleep(500);
                    return "2";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName() + " begin......");
                    Thread.sleep(2000);
                    return "3";
                }
        ));

        futures.forEach( f ->  {
            try {
                System.out.println(Thread.currentThread().getName() + " " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        // 关闭线程池（必须显式关闭）
        executor.shutdown();
    }

    /**
     * 测试invokeAny()
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String result = executor.invokeAny(Arrays.asList(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " begin......1");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " begin......1");
                    return "1";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName() + " begin......2");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " begin......2");
                    return "2";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName() + " begin......3");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " begin......3");
                    return "3";
                }
        ));

        System.out.println("result = " + result);

        // 关闭线程池（必须显式关闭）
        executor.shutdown();
    }

    /**
     * 测试shutdown、shutdownNow、awaitTermination
     */
    private static void testShutdownShutdownNowAndAwaitTermination() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = executor.submit(() -> {
            System.out.println("task 1 running......");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("task 1 finish......");
            return 1;
        });

        Future<Integer> result2 = executor.submit(() -> {
            System.out.println("task 2 running......");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("task 2 finish......");
            return 2;
        });

        Future<Integer> result3 = executor.submit(() -> {
            System.out.println("task 3 running......");
            Thread.sleep(1000);
            System.out.println("task 3 finish......");
            return 3;
        });

        System.out.println("shutdown......");
        executor.shutdown();

        //executor.awaitTermination(3, TimeUnit.SECONDS);

        //List<Runnable> runnables = executor.shutdownNow();
        //System.out.println("other.... = " + runnables);
    }
}
