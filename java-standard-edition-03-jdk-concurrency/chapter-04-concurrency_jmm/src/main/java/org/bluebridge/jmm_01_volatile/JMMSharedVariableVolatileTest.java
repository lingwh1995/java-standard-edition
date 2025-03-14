package org.bluebridge.jmm_01_volatile;

import java.util.concurrent.TimeUnit;

/**
 * 使用 Volatile 解决共享变量多线程可见性问题
 *      它可以用来修饰成员变量和静态成员变量，他可以避免线程从自己的工作缓存中查找变量的值，必须到主存中获取它的值，线程操作volatile变量都是直接操作主存
 *      volatile 仅仅保证了共享变量的可见性，让其它线程能够看到最新值，但不能解决指令交错问题（不能保证原 子性）
 */
public class JMMSharedVariableVolatileTest {

    private volatile static boolean run = true;

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