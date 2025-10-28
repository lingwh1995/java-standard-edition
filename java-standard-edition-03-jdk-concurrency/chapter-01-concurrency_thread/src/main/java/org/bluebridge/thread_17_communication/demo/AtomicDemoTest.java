package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lingwh
 * @desc 演示原子变量的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class AtomicDemoTest {

    // 使用原子变量替代普通int变量
    private static final AtomicInteger initializedServices = new AtomicInteger(0);
    private static final int TOTAL_SERVICES = 3;

    public static void main(String[] args) {
        // 启动各个服务
        new Thread(new ServiceInitializer("数据库服务")).start();
        new Thread(new ServiceInitializer("缓存服务")).start();
        new Thread(new ServiceInitializer("消息队列服务")).start();

        log.info("应用启动中，等待关键服务初始化......");
        
        // 轮询检查所有服务是否初始化完成
        while (initializedServices.get() < TOTAL_SERVICES) {
            try {
                Thread.sleep(100); // 短暂休眠避免过度占用CPU
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        log.info("所有关键服务初始化完成，应用启动成功......");
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

            // 原子性增加初始化完成的服务计数
            initializedServices.incrementAndGet();
        }
    }

}
