package org.bluebridge.thread.thread_lock;

/**
 * 死锁：两个线程由于相互等待对方已经锁住的资源而进入循环等待，最后导致死锁
 * 如何避免死锁:尽量不要出现多个锁  相互  重叠的场景
 * @author ronin
 */
public class DeadLock extends Thread{
    public int flag = 1;
    static Object o1 = new Object() ;
    static Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if(flag == 1) {
            synchronized(o1) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o2) {
                    System.out.println("1");
                }
            }
        }

        if(flag == 0) {
            synchronized(o2) {
//                try {
//                    Thread.sleep(500);
//                } catch(InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized(o1) {
                    System.out.println("0");
                }
            }
        }
    }


    public static void main(String[] args) {
        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;
        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        t1.start();
        t2.start();

    }

}
