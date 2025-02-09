package org.bluebridge.c_demo;

public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(()-> {
            while (true){
                try {
                    Thread.sleep(100);
                    System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1").start();

        new Thread(()-> {
            while (true){
                try {
                    Thread.sleep(100);
                    System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t2").start();
    }
}
