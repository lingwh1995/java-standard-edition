package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.Semaphore;

/**
 * @author lingwh
 * @desc 演示Semaphore机制的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class SemaphoreDemoTest {

    private static final int TOTAL_SERVICES = 3;
    // 创建Semaphore，初始许可数为0
    private static final Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        // 启动各个服务
        new Thread(new ServiceInitializer("数据库服务")).start();
        new Thread(new ServiceInitializer("缓存服务")).start();
        new Thread(new ServiceInitializer("消息队列服务")).start();

        try {
            log.info("应用启动中，等待关键服务初始化......");
            // 获取TOTAL_SERVICES个许可，阻塞直到所有服务初始化完成
            semaphore.acquire(TOTAL_SERVICES);
            log.info("所有关键服务初始化完成，应用启动成功......");
        } catch (InterruptedException e) {
            log.error("应用启动被中断", e);
            Thread.currentThread().interrupt();
        }
    }

    static class ServiceInitializer implements Runnable {
        private final String serviceName;

        public ServiceInitializer(String serviceName) {
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
            }

            // 释放一个许可
            semaphore.release();
        }
    }

}
