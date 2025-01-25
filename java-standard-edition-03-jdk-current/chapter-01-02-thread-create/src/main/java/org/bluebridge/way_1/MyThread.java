package org.bluebridge.way_1;

public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println("MyThread " + Thread.currentThread().getName() + " is running...");
    }
}
