package org.bluebridge.f_yield;

/**
 * yield
 *      1. 调用 yield 会让当前线程从 Running 进入 Runnable 就绪状态，然后调度执行其它线程
 *      2. 具体的实现依赖于操作系统的任务调度器
 *
 * 注意：yield和设置线程优先级都不能真正的做到设置优先，这个仅仅是对调度器的一个提示
 */
public class YieldTest {

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
                    Thread.yield();
                    System.out.println("Thread " + Thread.currentThread().getName() + " " + count++);
                }
            }
        }, "t2");
        t2.start();
    }
}
