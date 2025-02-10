package org.bluebridge.thread_interrupt;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *  interrupt()
 *      打断sleep()，wait()，join() 的线程，这几个方法都会让线程进入阻塞状态
 */
public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {
        //打断正在睡眠的线程
        testSleepThreadInterrupt();

        //打断正常的线程
        testNormalThreadInterrupt();
    }

    /**
     * 打断阻塞(打断正在睡眠的线程)
     * @throws InterruptedException
     */
    public static void testSleepThreadInterrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("打断标记：" + t1.isInterrupted());

        t1.interrupt();
        System.out.println("打断标记：" + t1.isInterrupted());
    }


    /**
     * 打断正常(打断正常的线程)
     * @throws InterruptedException
     */
    public static void testNormalThreadInterrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted, stop running...");
                    break;
                }else {
                    System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                }
            }
        },"t1");

        t1.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("打断标记：" + t1.isInterrupted());

        t1.interrupt();
        System.out.println("打断标记：" + t1.isInterrupted());
    }
}
