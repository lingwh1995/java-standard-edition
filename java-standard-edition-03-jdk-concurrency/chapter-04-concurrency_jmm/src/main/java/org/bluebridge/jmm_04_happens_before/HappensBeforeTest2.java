package org.bluebridge.jmm_04_happens_before;

/**
 * 线程对 volatile 变量的写，对接下来其它线程对该变量的读可见(volatile关键字的可见性、volatile规则)
 */
public class HappensBeforeTest2 {
    private volatile static int x;
    public static void main(String[] args) {
        new Thread(()->{
            x = 10;
        },"t1").start();

        new Thread(()->{
            System.out.println(x);
        },"t2").start();
    }
}
