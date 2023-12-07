package org.bluebridge.thread.thread_create.way_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static final int POOL_NUM = 100;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i<POOL_NUM; i++) {
            PrintThread thread = new PrintThread("线程"+i);
            //Thread.sleep(1000);
            executorService.execute(thread);
        }
        //关闭线程池
        executorService.shutdown();
    }
}
