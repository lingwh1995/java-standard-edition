package org.bluebridge.thread_yield;

/**
 * yield
 *      1. 调用yield会暂停当前正在执行的线程，并执行其他同等优先级的线程
 *      2. yield和设置线程优先级都不能真正的做到设置优先，这个仅仅是对操作系统的任务调度器的一个提示
 */
public class ThreadYieldTest {

    public static void main(String[] args) {
        //t1线程
        Thread t1 = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " " + count++);
                }
            }
        }, "t1");
        t1.start();

        //t2线程
        Thread t2 = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    //t2 调用线程礼让方法
                    Thread.yield();
                    System.out.println("Thread " + Thread.currentThread().getName() + " " + count++);
                }
            }
        }, "t2");
        t2.start();
    }
}
