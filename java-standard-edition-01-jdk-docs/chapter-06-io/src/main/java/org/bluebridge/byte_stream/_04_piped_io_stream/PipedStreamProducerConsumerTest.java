package org.bluebridge.byte_stream._04_piped_io_stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @author lingwh
 * @desc 使用管道输入流和管道输出流实现生产者消费者模型
 * @date 2025/8/16 14:40
 */
@Slf4j(topic = "·")
public class PipedStreamProducerConsumerTest {

    @Test
    public void testPipedStreamProducerConsumer() {
        try {
            // 创建管道输入流
            PipedInputStream pis = new PipedInputStream();
            // 创建管道输出流
            PipedOutputStream pos = new PipedOutputStream();

            // 连接两个流
            pos.connect(pis);

            Thread producerThread = new Thread(new Producer(pos));
            Thread consumerThread = new Thread(new Consumer(pis));

            producerThread.start();
            consumerThread.start();

            producerThread.join();
            consumerThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Slf4j(topic = "·")
class Producer implements Runnable {
    private PipedOutputStream pos;
    private Random random = new Random();

    public Producer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                int number = random.nextInt(100);
                String message = "Number: " + number + "\n";
                pos.write(message.getBytes());
                log.info("Producer: 生成数据 - {}", number);
                // 模拟生产时间
                Thread.sleep(1000);
            }
            pos.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Slf4j(topic = "·")
class Consumer implements Runnable {
    private PipedInputStream pis;

    public Consumer(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            String line;
            while ((line = reader.readLine()) != null) {
                log.info("Consumer: 消费数据 - {}", line.trim());
            }
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}