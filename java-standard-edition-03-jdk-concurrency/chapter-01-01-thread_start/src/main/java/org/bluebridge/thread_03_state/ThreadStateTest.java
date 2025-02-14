package org.bluebridge.thread_03_state;

/**
 * 获取线程状态
 *      创建了线程       NEW
 *      启动线程后       RUNNABLE
 *      线程阻塞时       TIMED_WAITING
 *                     BLOCKED
 *                     WAITING
 *                     TERMINATED
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Thread " + Thread.currentThread().getName() + " is running..."),"t1");

        System.out.println("当前线程 " + t.getName() + " 状态: " + t.getState());

        t.start();

        System.out.println("当前线程 " + t.getName() + " 状态: " + t.getState());

        System.out.println("Thread " + Thread.currentThread().getName() + " thread is running...");
    }
}
