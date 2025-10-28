package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lingwh
 * @desc 演示ThreadLocal机制的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class ThreadLocalDemoTest {

    private static final int TOTAL_SERVICES = 3;
    // 使用ThreadLocal存储每个线程的初始化状态
    private static final ThreadLocal<Boolean> serviceInitializationStatus = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };
    
    // 用于存储服务线程的引用
    private static final List<Thread> serviceThreads = new ArrayList<>();

    public static void main(String[] args) {
        // 创建各个服务线程
        Thread databaseService = new Thread(new ServiceInitializer("数据库服务"));
        Thread cacheService = new Thread(new ServiceInitializer("缓存服务"));
        Thread mqService = new Thread(new ServiceInitializer("消息队列服务"));
        
        // 保存线程引用
        serviceThreads.add(databaseService);
        serviceThreads.add(cacheService);
        serviceThreads.add(mqService);
        
        // 启动各个服务
        databaseService.start();
        cacheService.start();
        mqService.start();

        try {
            log.info("应用启动中，等待关键服务初始化......");
            
            // 等待所有服务线程执行完成
            for (Thread serviceThread : serviceThreads) {
                serviceThread.join();
            }
            
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
                
                // 设置当前线程的初始化完成状态
                serviceInitializationStatus.set(true);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 清理ThreadLocal变量，防止内存泄漏
                serviceInitializationStatus.remove();
            }
        }
    }

}
