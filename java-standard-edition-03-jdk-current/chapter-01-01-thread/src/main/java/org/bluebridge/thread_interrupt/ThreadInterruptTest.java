package org.bluebridge.thread_interrupt;

import java.util.concurrent.TimeUnit;

/**
 *  interrupt()
 *      打断sleep()，wait()，join() 的线程，这几个方法都会让线程进入阻塞状态
 *  interrupt()和stop()区别
 *      interrupt() ，调用 interrupt()的线程会继续运行下去，但是会设置一个中断标志 true，由调用者线程决定什么时候来来判执行线程中断。
 *      stop() 虽然可以强行终止一个线程的运行，但使用stop()杀死线程，如果线程锁住了共享资源，那么当它被杀死后就再也没有机会释放锁，其它线程将永远无法获取锁，这个后果就很严重了。
 *  interrupt()的使用场景‌
 *      假设你在编写一个长时间运行的任务，你希望在特定条件下中断该任务。你可以在任务的关键部分检查中断标志，如果检测到中断，则优雅地停止任务并释放资源。
 */
public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {
        //打断阻塞状态的线程
        //testSleepThreadInterrupt();

        //打断正常运行的线程
        testNormalThreadInterrupt();
    }

    /**
     * 打断阻塞状态的线程
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
        //打断正在睡眠的线程
        t1.interrupt();
        System.out.println("打断标记：" + t1.isInterrupted());
    }


    /**
     * 打断正常运行的线程
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
        //打断正常运行的线程
        t1.interrupt();
        System.out.println("打断标记：" + t1.isInterrupted());
    }
}
