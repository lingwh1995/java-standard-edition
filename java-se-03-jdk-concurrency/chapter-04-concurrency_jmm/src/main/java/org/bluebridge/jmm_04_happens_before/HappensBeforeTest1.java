package org.bluebridge.jmm_04_happens_before;

/**
 * 线程解锁 m 之前对变量的写，对于接下来对 m 加锁的其它线程对该变量的读可见(synchronized关键字的可见性、监视器规则)
 */
public class HappensBeforeTest1 {
    private static int x;
    private static Object m = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized(m) {
                x = 10;
            }
        },"t1").start();

        new Thread(()->{
            synchronized(m) {
                System.out.println(x);
            }
        },"t2").start();
    }
}
