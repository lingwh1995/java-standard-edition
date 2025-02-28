package org.bluebridge.producer_consumer;

import java.util.LinkedList;

public class MessageQueue {
    private LinkedList<Message> queue;
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    /**
     * 从消息队列中获取数据
     */
    public void take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("没货了, wait......");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 给消息队列中存储数据
     */
    public void put() {

    }
}
