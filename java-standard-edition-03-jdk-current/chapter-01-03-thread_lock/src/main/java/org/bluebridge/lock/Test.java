package org.bluebridge.lock;

public class Test {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter++;
                System.out.println(counter);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter--;
                System.out.println(counter);
            }
        }, "t2");

        t1.start();
        t2.start();

//        t1.join();
//        t2.join();
        System.out.println(counter);
    }
}
