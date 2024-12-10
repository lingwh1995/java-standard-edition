package org.bluebridge.thread.thread_lock;

import java.util.ArrayList;

/**
 * 使用静态代码块验证static()方法的锁是类的.class对象
 * @author ronin
 */
public class SynchronizedStaticClassLock {
    static{
        //StaticClassLock.class这个锁被下面的方法抢到了,则其他方法不能同时使用这个锁
        //锁生效
//        synchronized(StaticClassLock.class){
//            try {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(200000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //锁生效
//        synchronized(Object.class){
//            try {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(200000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //锁生效
        synchronized(ArrayList.class){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(200000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread("T1"){
            @Override
            public void run() {
                StaticClassLock.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                StaticClassLock.m2();
            }
        }.start();

        /**
         * m3()没有加锁
         */
        new Thread("T3"){
            @Override
            public void run() {
                StaticClassLock.m3();
            }
        }.start();
    }
}

/**
 * 如果同步方法的锁不是this,那么访问m1()的同时也可以访问m2(),如果是this锁,则
 * 线程1先抢到锁，线程1就开始执行，线程2抢到锁，线程2就开始执行,
 * 效果是m1和m3会同时执行,因为m1()的锁是this,m3()的锁是lock
 */
class StaticClassLock {

//    public synchronized static void m1(){
//        try {
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 这个写法等价于上面代码的写法
     */
    public static void m1(){
        synchronized(StaticClassLock.class) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void m2(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}