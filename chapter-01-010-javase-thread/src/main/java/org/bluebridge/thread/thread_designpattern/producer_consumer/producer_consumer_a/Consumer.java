package org.bluebridge.thread.thread_designpattern.producer_consumer.producer_consumer_a;

import java.util.Random;

/**
 * @author ronin
 */
public class Consumer extends Thread{
    private final MessageQueue messageQueue;
    private final static Random random = new Random();

    public Consumer(MessageQueue messageQueue,int seq){
        super("CONSUMER" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = messageQueue.take();
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + ":take message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
