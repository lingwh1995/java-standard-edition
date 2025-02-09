package org.bluebridge.g_priority;

/**
 * 注意：yield和设置线程优先级都不能真正的做到设置优先，这个仅仅是对调度器的一个提示
 */
public class PriorityTest {

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
        //设置线程优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        //t2线程
        Thread t2 = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " " + count++);
                }
            }
        }, "t2");
        //设置线程优先级
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
    }
}
