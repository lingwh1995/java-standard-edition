package org.bluebridge.thread_interrupt;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *  interrupt()
 *      打断sleep()，wait()，join() 的线程，这几个方法都会让线程进入阻塞状态
 */
public class ThreadInterruptTest {

    @Test
    public void fun() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        TimeUnit.MILLISECONDS.sleep(500);

        t1.interrupt();
    }
}
