package org.bluebridge.thread_pool_06_catch_exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 正确处理执行任务异常
 *      方式一：使用try...catch...捕获异常
 *      方式二：使用 Future 处理异常
 */
public class ThreadPoolCatchExceptionTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //testTryCatchDealException();

        testFutureDealException();
    }

    /**
     * 使用try...catch...捕获异常
     */
    public static void testTryCatchDealException() {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
            try {
                System.out.println("task1......");
                int i = 1 / 0;
            } catch (Exception e) {
                System.out.println("error = " + e);
            }
        });

        //关闭线程池
        pool.shutdown();
    }

    /**
     * 使用 Future 处理异常
     */
    public static void testFutureDealException() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<Boolean> future = pool.submit(() -> {
            System.out.println("task1......");
            int i = 1 / 0;
            return true;
        });

        System.out.println("future" + future.get());

        //关闭线程池
        pool.shutdown();
    }
}
