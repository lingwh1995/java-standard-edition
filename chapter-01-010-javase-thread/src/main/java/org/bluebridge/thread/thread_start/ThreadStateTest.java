package org.bluebridge.thread.thread_start;

/**
 * 线程状态枚举:Thread.State
 * @author ronin
 * @version V1.0
 * @since 2019/10/14 13:45
 */
public class ThreadStateTest {
    public static void main(String[] args) {
        ThreadStateTest threadStateTest = new ThreadStateTest();
        Thread t = new Thread(()->{
            threadStateTest.m1();
        });
        System.out.println("NEW状态:"+t.getState());
        t.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TIMED_WAITING
        System.out.println("TIMED_WAITING状态:"+t.getState());

//        Thread t2 = new Thread(()->{
//            threadStateTest.m2();
//        });
//        t2.start();
    }

    public void m1(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
                System.out.println("m1......");
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public synchronized void m2(){
//        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
//        System.out.println("m2......");
//    }
}
