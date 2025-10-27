package org.bluebridge.thread_17_communication;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchDemoTest {
    
    public static void main(String[] args) {
        // 模拟应用启动需要等待3个服务初始化完成
        CountDownLatch startupLatch = new CountDownLatch(3);
        
        // 启动各个服务
        new Thread(new ServiceInitializer(startupLatch, "DatabaseService")).start();
        new Thread(new ServiceInitializer(startupLatch, "CacheService")).start();
        new Thread(new ServiceInitializer(startupLatch, "MessageQueueService")).start();
        
        try {
            log.info("应用启动中，等待关键服务初始化......");
            // 等待所有关键服务初始化完成
            startupLatch.await();
            log.info("所有关键服务初始化完成，应用启动成功！");
        } catch (InterruptedException e) {
            log.error("应用启动被中断", e);
            Thread.currentThread().interrupt();
        }
    }
    
    static class ServiceInitializer implements Runnable {
        private final CountDownLatch latch;
        private final String serviceName;
        
        public ServiceInitializer(CountDownLatch latch, String serviceName) {
            this.latch = latch;
            this.serviceName = serviceName;
        }
        
        @Override
        public void run() {
            try {
                log.info("{} 初始化开始......", serviceName);
                // 模拟服务初始化时间
                Thread.sleep((long) (Math.random() * 5000));
                log.info("{} 初始化完成......", serviceName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 初始化完成后计数减1
                latch.countDown();
            }
        }
    }

}
