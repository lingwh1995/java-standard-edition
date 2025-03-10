package org.bluebridge;

import java.util.concurrent.TimeUnit;

/**
 * 使用 synchronized 解决共享变量多线程可见性问题
 */
public class SharedVariableSynchronizedTest {

    private static boolean run = true;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(run){
                synchronized (lock) {

                }
            }
        },"t");
        t.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        synchronized (lock){
            // 线程t不会如预想的停下来
            run = false;
        }
    }
}