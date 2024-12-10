package org.bluebridge.thread.thread_lock;

/**
 * 使用jconsole和jstack监控阻塞的线程
 * @author ronin
 */
public class SynchronizedJconsoleTest {
    private static final Object monitor = new Object();

    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println("thread is running......");
                    try {
                        Thread.sleep(100_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
