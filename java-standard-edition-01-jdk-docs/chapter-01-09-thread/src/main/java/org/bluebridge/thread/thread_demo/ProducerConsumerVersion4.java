package org.bluebridge.thread.thread_demo;

import java.util.stream.Stream;

/**
 * 只支持单生产线程和单消费线程
 * @author ronin
 */
public class ProducerConsumerVersion4 {
    private final Object lock = new Object();
    private int i = 0;
    private volatile boolean isProduced = false;
    public void produce(){
        synchronized (lock){
            while(isProduced) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println(Thread.currentThread().getName()+":P->"+i);
            lock.notifyAll();
            isProduced = true;
        }
    }
    public void consume(){
        synchronized (lock){
            while(!isProduced) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":C->" + i);
            //激活
            lock.notifyAll();
            isProduced = false;

        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion4 producerConsumer = new ProducerConsumerVersion4();
        /**
         * 单线程生产者消费者
         */
//        new Thread(){
//            @Override
//            public void run() {
//                  while(true) {
//                  producerConsumer.produce();
//                  }
//            }
//        }.start();
//        new Thread(){
//            @Override
//            public void run() {
//                  while(true) {
//                  producerConsumer.consume();
//                  }
//            }
//        }.start();

        /**
         * 多线程生产者消费者:
         *      会阻塞,但是不是由于死锁引起的
         */
        Stream.of("P1","P2").forEach(n -> {
            new Thread(){
                @Override
                public void run() {
                    while(true) {
                        producerConsumer.produce();
                    }
                }
            }.start();
        });
        Stream.of("C1","C2").forEach(n -> {
            new Thread(){
                @Override
                public void run() {
                    while(true) {
                        producerConsumer.consume();
                    }
                }
            }.start();
        });
    }
}
