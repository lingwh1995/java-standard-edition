package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lingwh
 * @desc 演示ReentrantLock/Condition机制的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class ReentrantLockDemoTest {

    // 创建可重入锁
    private static final ReentrantLock lock = new ReentrantLock();
    // 创建条件对象
    private static final Condition serviceInitializedCondition = lock.newCondition();
    // 记录已完成初始化的服务数量
    private static int initializedServices = 0;
    // 总服务数量
    private static final int TOTAL_SERVICES = 3;

    public static void main(String[] args) {
        // 启动各个服务
        new Thread(new ServiceInitializer("数据库服务")).start();
        new Thread(new ServiceInitializer("缓存服务")).start();
        new Thread(new ServiceInitializer("消息队列服务")).start();

        lock.lock();
        try {
            log.info("应用启动中，等待关键服务初始化......");
            // 等待所有关键服务初始化完成
            while (initializedServices < TOTAL_SERVICES) {
                serviceInitializedCondition.await();
            }
            log.info("所有关键服务初始化完成，应用启动成功......");
        } catch (InterruptedException e) {
            log.error("应用启动被中断", e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
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

            lock.lock();
            try {
                initializedServices++;
                // 通知等待的线程
                serviceInitializedCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

}
