package org.bluebridge.e_sleep;

/**
 * sleep() 应用
 *      防止单核单线程时发生CPU 100% 被占用情况
 */
public class SleepCpuTest {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("...........................");
            }
        }).start();
    }
}
