package org.bluebridge.thread.thread_lock;

/**
 * 基础版的锁
 * @author ronin
 */
public class SellTicketSynchronizedTest {

    public static class Ticket implements Runnable{
        private final Object monitor = new Object();
        private int index = 1;
        private static int max = 500;

        @Override
        public void run() {
            while (true){
                synchronized (monitor) {
                    if (index > max) {
                        break;
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下" + index++ + "张电影票......");
                }
            }
        }
    }
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
    }
}
