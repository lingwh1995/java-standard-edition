package org.bluebridge.thread_pool_03_thread_pool_executor;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<String> future = pool.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "ok";
        });
        System.out.println(future.get());
    }
}
