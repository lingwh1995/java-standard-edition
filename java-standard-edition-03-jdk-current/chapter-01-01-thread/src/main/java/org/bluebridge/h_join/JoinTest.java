package org.bluebridge.h_join;

/**
 * join()
 *      https://blog.csdn.net/csdn_life18/article/details/139520863
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "t2");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println(Thread.currentThread().getName() + " is running...");
    }
}