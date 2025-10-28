package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lingwh
 * @desc 演示wait/notify机制的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class WaitNotifyDemoTest {

    private static final Object lock = new Object();
    private static int initializedServices = 0;
    private static final int TOTAL_SERVICES = 3;

    public static void main(String[] args) {
        // 启动各个服务
        new Thread(new ServiceInitializer("数据库服务")).start();
        new Thread(new ServiceInitializer("缓存服务")).start();
        new Thread(new ServiceInitializer("消息队列服务")).start();

        synchronized (lock) {
            try {
                log.info("应用启动中，等待关键服务初始化......");
                // 等待所有关键服务初始化完成
                while (initializedServices < TOTAL_SERVICES) {
                    lock.wait();
                }
                log.info("所有关键服务初始化完成，应用启动成功......");
            } catch (InterruptedException e) {
                log.error("应用启动被中断", e);
                Thread.currentThread().interrupt();
            }
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

            synchronized (lock) {
                initializedServices++;
                // 通知等待的线程
                lock.notifyAll();
            }
        }
    }

}
