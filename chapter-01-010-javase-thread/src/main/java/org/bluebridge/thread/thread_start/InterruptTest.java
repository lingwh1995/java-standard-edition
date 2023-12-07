package org.bluebridge.thread.thread_start;

/**
 * @author ronin
 */
public class InterruptTest {
    private static Object lock = new Object();
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                        System.out.println("thread is running......");
                    } catch (InterruptedException e) {
                        System.out.println("收到打断信号......");
                        e.printStackTrace();
                        //捕获到异常之后break掉可以结束线程
                        break;
                    }
                }
                //此种阻塞情况下,interrupt()无法打断
//                while (true){
//                    synchronized (lock){
//                        try {
//                            lock.wait(10);
//                        } catch (InterruptedException e) {
//                            System.out.println("收到打断信号......");
//                            e.printStackTrace();
//                        }
//                    }
//                }
            }
        });
        t.start();
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
