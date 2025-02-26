package org.bluebridge.thread.thread_designpattern.thread_pre_message.thread_pre_message_a;

import java.util.Random;

/**
 * @author ronin
 */
public class MessageHandler {
    private final static Random random = new Random(System.currentTimeMillis());

    public void request(Message message){
        new Thread(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
