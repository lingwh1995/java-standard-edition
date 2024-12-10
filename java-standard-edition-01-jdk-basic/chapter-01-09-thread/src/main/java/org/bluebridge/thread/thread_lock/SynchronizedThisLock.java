package org.bluebridge.thread.thread_lock;

/**
 * this锁:同步方法的锁是this
 * @author ronin
 */
public class SynchronizedThisLock {
    public static void main(String[] args) {
        //第一次验证this锁的存在
        //validateThisLock1();
        //第二次验证this锁的存在
        validateThisLock2();
    }

    /**
     * 第二次验证this锁的存在
     */
    private static void validateThisLock2() {
        ThisLock2 thisLock2 = new ThisLock2();
        /**
         * 当m1()抢到了锁,m1()不释放锁,无法进入m2()
         */
        new Thread(()->{
            thisLock2.m1();
        }).start();
        new Thread(()->{
            thisLock2.m2();
        }).start();
    }

    /**
     * 第一次验证this锁的存在
     */
    private static void validateThisLock1() {
        ThisLock1 thisLock1 = new ThisLock1();
        new Thread("T1"){
            @Override
            public void run() {
                thisLock1.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                thisLock1.m2();
            }
        }.start();

        new Thread("T3"){
            @Override
            public void run() {
                thisLock1.m3();
            }
        }.start();
    }

}

/**
 * 如果同步方法的锁不是this,那么访问m1()的同时也可以访问m2(),如果是this锁,则
 * 线程1先抢到锁，线程1就开始执行，线程2抢到锁，线程2就开始执行,
 * 效果是m1和m3会同时执行,因为m1()的锁是this,m3()的锁是lock
 */
class ThisLock1 {

    /**
     * m()3的锁
     */
    private final Object lock = new Object();

    public synchronized void m1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void m3(){
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThisLock2 {
    public void m1(){
        synchronized (this){
            try {
                System.out.println("进入了方法m1,"+Thread.currentThread().getName()+"抢到了this锁,并且wait()......");
                System.out.println(Thread.currentThread().getName()+"是否持有this锁:"+Thread.holdsLock(this));
                System.out.println("方法一进入阻塞状态......");
                Thread.sleep(10_000L);
                System.out.println("方法一结束阻塞状态......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void m2(){
        try {
            System.out.println("进入了方法m2,"+Thread.currentThread().getName()+"是否持有this锁:"+Thread.holdsLock(this));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
