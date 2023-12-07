package org.bluebridge.thread.thread_start;

/**
 * @author ronin
 */
public class SleepAndWaitTest {
    private static final Object object = new Object();
    public static void main(String[] args) {
        synchronized (object) {
            System.out.println("---------------------");
            try {
                object.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("---------------------");
        }
        synchronized (object) {
            System.out.println("锁释放了......");
        }
    }
}
