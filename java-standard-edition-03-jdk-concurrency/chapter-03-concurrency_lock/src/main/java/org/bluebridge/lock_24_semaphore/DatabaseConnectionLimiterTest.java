package org.bluebridge.lock_24_semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 限制数据库连接数
 */
public class DatabaseConnectionLimiterTest {
    private static final int MAX_CONNECTIONS = 5;
    private static final Semaphore semaphore = new Semaphore(MAX_CONNECTIONS);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    semaphore.acquire();
                    accessDatabase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executor.shutdown();
    }

    private static void accessDatabase() {
        System.out.println(Thread.currentThread().getName() + " accessing database......");
        try {
            // 模拟数据库操作
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " done accessing database......");
    }
}
