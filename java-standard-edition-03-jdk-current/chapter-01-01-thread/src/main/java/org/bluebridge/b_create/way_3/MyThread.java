package org.bluebridge.b_create.way_3;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
        int i = 10;
        int j = 10;
        Thread.sleep(1000);
        return Integer.sum(i, j);
    }
}
