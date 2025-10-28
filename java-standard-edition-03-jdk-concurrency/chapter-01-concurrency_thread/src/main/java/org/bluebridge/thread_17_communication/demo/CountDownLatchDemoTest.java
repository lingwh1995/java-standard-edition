package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author lingwh
 * @desc 演示CountDownLatch的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/27 18:33
 */
@Slf4j
public class CountDownLatchDemoTest {
    
    public static void main(String[] args) {
        // 模拟应用启动需要等待3个服务初始化完成
        CountDownLatch startupLatch = new CountDownLatch(3);
        
        // 启动各个服务
        new Thread(new ServiceInitializer(startupLatch, "数据库服务")).start();
        new Thread(new ServiceInitializer(startupLatch, "缓存服务")).start();
        new Thread(new ServiceInitializer(startupLatch, "消息队列服务")).start();
        
        try {
            log.info("应用启动中，等待关键服务初始化......");
            // 等待所有关键服务初始化完成
            startupLatch.await();
            log.info("所有关键服务初始化完成，应用启动成功......");
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
