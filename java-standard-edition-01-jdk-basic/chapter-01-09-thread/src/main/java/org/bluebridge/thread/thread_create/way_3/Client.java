package org.bluebridge.thread.thread_create.way_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Client {
    public static void main(String[] args) {
        // 创建PrintThread对象
        PrintThread printThread = new PrintThread();
        //使用FutureTask来包装PrintThread对象
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(printThread);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(printThread);
        FutureTask<Integer> futureTask3 = new FutureTask<Integer>(printThread);
        //FutureTask对象作为Thread对象的target创建新的线程
        Thread thread1 = new Thread(futureTask1,"001");
        Thread thread2 = new Thread(futureTask2,"002");
        Thread thread3 = new Thread(futureTask3,"003");
        //线程进入到就绪状态
        thread1.start();
        thread2.start();
        thread3.start();
        //取得新创建的新线程中的call()方法返回的结果
        try {
            int futureTask1Result =  futureTask1.get() ;
            int futureTask2Result =  futureTask2.get() ;
            int futureTask3Result =  futureTask3.get() ;
            System.out.println("futureTask1-call()返回值 = " + futureTask1Result);
            System.out.println("futureTask2-call()返回值 = " + futureTask2Result);
            System.out.println("futureTask3-call()返回值 = " + futureTask2Result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
