package org.bluebridge.thread.thread_lock;

/**
 * 最大可能卖出502张电影票,发生了线程安全问题
 * @author ronin
 */
public class SellTicketTest {

    public static class Ticket implements Runnable{
        private int index = 1;
        private static int max = 500;
        @Override
        public void run() {
            while (true){
                if(index > max){
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"还剩下"+index++ +"张电影票......");
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
