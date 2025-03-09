package org.bluebridge;

import java.util.concurrent.TimeUnit;

/**
 * 没有解决共享变量多线程可见性问题
 */
public class SharedVariableTest {

    private static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(run){

            }
        },"t");
        t.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        run = false; // 线程t不会如预想的停下来
    }
}