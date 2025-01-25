package org.bluebridge.way_2;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("MyThread " + Thread.currentThread().getName() + " is running...");
    }
}
