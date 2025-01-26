package org.bluebridge.d_sleep;

/**
 * 线程睡眠
 *      Thread.sleep(1000)，这行代码写在哪个线程里，就是哪个线程睡眠
 */
public class SleepTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1");

        System.out.println("当前线程" + t.getName() + "状态: " + t.getState());

        t.start();

        System.out.println("当前线程" + t.getName() + "状态: " + t.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("当前线程" + t.getName() + "状态: " + t.getState());

        System.out.println("Thread " + Thread.currentThread().getName() + " thread is running...");
    }
}
