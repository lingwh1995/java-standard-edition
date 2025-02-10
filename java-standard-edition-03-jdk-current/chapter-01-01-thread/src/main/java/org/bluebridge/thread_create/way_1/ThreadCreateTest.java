package org.bluebridge.thread_create.way_1;

import org.junit.Test;

public class ThreadCreateTest {

    @Test
    public void test() {
       //传统方式继承Thread类接口创建线程
       Thread t1 = new MyThread();
       //不设置线程名称注掉下面这行
       t1.setName("t1");
       t1.start();


       //匿名内部类方式继承Thread类接口创建线程
       //不设置线程名称 new Thread() 中不用传递参数
       Thread t2 = new Thread("t2") {
           @Override
           public void run() {
               System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
           }
       };
       t2.start();


       //lambda方式继承Thread类接口创建线程
       //不设置线程名称 new Thread() 中不用传递第二个参数
       Thread t3 = new Thread(() -> System.out.println("Thread " + Thread.currentThread().getName() + " is running..."),"t3");
       t3.start();


       System.out.println("Thread " + Thread.currentThread().getName() + " thread is running...");
   }
}
