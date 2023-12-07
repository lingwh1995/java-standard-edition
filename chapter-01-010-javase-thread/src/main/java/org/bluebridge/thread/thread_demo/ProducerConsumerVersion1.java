package org.bluebridge.thread.thread_demo;

/**
 * @author ronin
 */
public class ProducerConsumerVersion1 {
    private int i = 0;
    private final Object lock = new Object();

    public void produce(){
        synchronized(lock){
            System.out.println("P->"+(i++));
        }
    }

    public void consume(){
        synchronized(lock){
            System.out.println("C->"+(i++));
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion1 producerConsumer = new ProducerConsumerVersion1();
        //生产者
        new Thread(){
            @Override
            public void run() {
                while(true){
                    producerConsumer.produce();
                }
            }
        }.start();
        //消费者
        new Thread(){
            @Override
            public void run() {
                while(true){
                    producerConsumer.consume();
                }
            }
        }.start();
    }
}
