package org.bluebridge.thread.thread_middle;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author ronin
 */
public class WaitSetTest {
    private static final Object LOCK = new Object();

    private static void work(){
        synchronized (LOCK){
            System.out.println("Begin......");

            try {
                System.out.println("Thread will coming......");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread will out......");
        }
    }
    /**
     * 1.所有的对象都有一个wait set,用来存放该对象wait()方法之后进入blocked状态的线程
     * 2.调用notify()后,wait set中线程被唤醒顺序不是FIFO
     * 3.线程被notify()之后,不一定被立即执行
     * @param args
     */
    public static void main(String[] args) {
        new Thread(()->{
            work();
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LOCK){
            LOCK.notify();
        }
        //worksetTest();
    }

    private static void worksetTest() {
        IntStream.rangeClosed(1,10).forEach(i-> {
            new Thread(()->{
                synchronized (LOCK){
                    try {
                        Optional.of(Thread.currentThread().getName()+" will come to set ").ifPresent(System.out::println);
                        LOCK.wait();
                        Optional.of(Thread.currentThread().getName()+" will leave set ").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        IntStream.rangeClosed(1,10).forEach(i-> {
            synchronized (LOCK){
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
