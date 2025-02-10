package org.bluebridge.thread_create.way_1;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
    }
}
