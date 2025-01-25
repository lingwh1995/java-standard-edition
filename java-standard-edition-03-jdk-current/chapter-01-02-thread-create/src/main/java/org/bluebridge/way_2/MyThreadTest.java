package org.bluebridge.way_2;

import org.bluebridge.way_1.MyThread;

public class MyThreadTest {

    public static void main(String[] args) {
        //传统方式实现Runnable接口创建线程
        /*
        Thread t = new Thread(new MyThread());
        t.start();
        */

        //匿名内部类方式实现Runnable接口创建线程
        /*
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread " + Thread.currentThread().getName() + " is running...");
            }
        };
        r.run();
        */

        //lambda方式实现Runnable接口创建线程
        Runnable r = () -> System.out.println("MyThread " + Thread.currentThread().getName() + " is running...");
        r.run();

        System.out.println(Thread.currentThread().getName() + " thread is running...");
    }
}
