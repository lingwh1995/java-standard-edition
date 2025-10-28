package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lingwh
 * @desc 演示CyclicBarrier机制的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class CyclicBarrierDemoTest {

    private static final int TOTAL_SERVICES = 3;
    // 创建CyclicBarrier，指定需要等待的线程数和屏障动作
    private static final CyclicBarrier barrier = new CyclicBarrier(TOTAL_SERVICES, () -> {
        log.info("所有关键服务初始化完成，应用启动成功......");
    });

    public static void main(String[] args) {
        log.info("应用启动中，等待关键服务初始化......");
        
        // 启动各个服务
        new Thread(new ServiceInitializer("数据库服务")).start();
        new Thread(new ServiceInitializer("缓存服务")).start();
        new Thread(new ServiceInitializer("消息队列服务")).start();
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
                
                // 等待其他线程，当所有线程都到达屏障点时执行回调
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                log.error("{} 初始化过程中发生异常", serviceName, e);
                Thread.currentThread().interrupt();
            }
        }
    }

}
