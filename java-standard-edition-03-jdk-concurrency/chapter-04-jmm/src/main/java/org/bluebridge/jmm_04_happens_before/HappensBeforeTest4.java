package org.bluebridge.jmm_04_happens_before;

/**
 * 线程结束前对变量的写，对其它线程得知它结束后的读可见（比如其它线程调用 t1.isAlive() 或 t1.join()等待 它结束）(线程终止规则)
 */
public class HappensBeforeTest4 {
    private static int x;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            x = 10;
        },"t1");

        t1.start();
        t1.join();
        System.out.println(x);
    }
}
