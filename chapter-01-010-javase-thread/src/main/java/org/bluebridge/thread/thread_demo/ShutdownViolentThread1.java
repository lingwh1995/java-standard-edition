package org.bluebridge.thread.thread_demo;

/**
 * 暴力结束线程,避免使用stop()
 * @author ronin
 */
public class ShutdownViolentThread1 {

    public static class Worker extends Thread{
        @Override
        public void run() {
            while(true){
               read();
            }

        }

        /**
         * 模拟从数据库读取数据，并且连接超时，进入了阻塞的状态
         */
        public static void read(){
            System.out.println("thread is running......");
            Thread.currentThread().suspend();
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        //当一个线程被阻塞,就没有机会打断这个线程
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
