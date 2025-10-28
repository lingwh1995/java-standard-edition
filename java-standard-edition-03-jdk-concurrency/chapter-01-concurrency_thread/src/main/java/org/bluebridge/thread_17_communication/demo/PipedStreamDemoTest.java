package org.bluebridge.thread_17_communication.demo;

import lombok.extern.slf4j.Slf4j;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

/**
 * @author lingwh
 * @desc 演示PipedInputStream/PipedOutputStream机制的使用场景：应用启动需要等待多个关键服务初始化完成
 * @date 2025/10/28 9:30
 */
@Slf4j
public class PipedStreamDemoTest {

    private static final int TOTAL_SERVICES = 3;
    // 创建管道流数组
    private static final PipedOutputStream[] pipedOutputStreams = new PipedOutputStream[TOTAL_SERVICES];
    private static final PipedInputStream pipedInputStream = new PipedInputStream();
    
    static {
        try {
            // 初始化并连接管道流
            for (int i = 0; i < TOTAL_SERVICES; i++) {
                pipedOutputStreams[i] = new PipedOutputStream();
                pipedInputStream.connect(pipedOutputStreams[i]);
            }
        } catch (IOException e) {
            log.error("管道连接失败", e);
        }
    }

    public static void main(String[] args) {
        // 启动各个服务
        new Thread(new ServiceInitializer("数据库服务", pipedOutputStreams[0], 0)).start();
        new Thread(new ServiceInitializer("缓存服务", pipedOutputStreams[1], 1)).start();
        new Thread(new ServiceInitializer("消息队列服务", pipedOutputStreams[2], 2)).start();

        try {
            log.info("应用启动中，等待关键服务初始化......");
            
            // 从管道中读取初始化完成信号
            int initializedCount = 0;
            while (initializedCount < TOTAL_SERVICES) {
                pipedInputStream.read(); // 阻塞读取
                initializedCount++;
            }
            
            log.info("所有关键服务初始化完成，应用启动成功......");
        } catch (IOException e) {
            log.error("读取管道数据失败", e);
        } catch (Exception e) {
            log.error("应用启动过程中发生异常", e);
        } finally {
            // 关闭流资源
            try {
                pipedInputStream.close();
                for (PipedOutputStream pos : pipedOutputStreams) {
                    if (pos != null) {
                        pos.close();
                    }
                }
            } catch (IOException e) {
                log.error("关闭流资源失败", e);
            }
        }
    }

    static class ServiceInitializer implements Runnable {
        private final String serviceName;
        private final PipedOutputStream outputStream;
        private final int index;

        public ServiceInitializer(String serviceName, PipedOutputStream outputStream, int index) {
            this.serviceName = serviceName;
            this.outputStream = outputStream;
            this.index = index;
        }

        @Override
        public void run() {
            try {
                log.info("{} 初始化开始......", serviceName);
                // 模拟服务初始化时间
                Thread.sleep((long) (Math.random() * 5000));
                log.info("{} 初始化完成......", serviceName);
                
                // 向管道写入初始化完成信号
                outputStream.write(1); // 写入一个字节作为完成信号
                outputStream.flush();
            } catch (InterruptedException | IOException e) {
                log.error("{} 初始化过程中发生异常", serviceName, e);
                Thread.currentThread().interrupt();
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    log.error("{} 关闭输出流失败", serviceName, e);
                }
            }
        }
    }

}
