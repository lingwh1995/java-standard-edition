package org.bluebridge.way_1;

public class MyThreadTest {

    public static void main(String[] args) {
        //传统方式继承Thread类接口创建线程
        /*
        Thread t = new MyThread();
        t.start();
        */

        //匿名内部类方式继承Thread类接口创建线程
        /*
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("MyThread " + Thread.currentThread().getName() + " is running...");
            }
        };
        t.start();
        */

        //lambda方式继承Thread类接口创建线程
        Thread t = new Thread(() -> System.out.println("MyThread " + Thread.currentThread().getName() + " is running..."));
        t.start();

        System.out.println(Thread.currentThread().getName() + " thread is running...");
    }
}
