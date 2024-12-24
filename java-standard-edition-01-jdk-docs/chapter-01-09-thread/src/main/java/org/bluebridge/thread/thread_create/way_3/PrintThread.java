package org.bluebridge.thread.thread_create.way_3;

import java.util.concurrent.Callable;

public class PrintThread implements Callable<Integer> {
    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i+":"+Thread.currentThread().getName());
        }
        return 100;
    }

}
