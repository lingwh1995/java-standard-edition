package org.bluebridge.thread_02_create.way_4;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
    }

}
