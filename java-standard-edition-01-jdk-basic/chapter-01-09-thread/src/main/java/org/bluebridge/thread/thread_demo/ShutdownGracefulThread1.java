package org.bluebridge.thread.thread_demo;

/**
 * jdk提供的stop()方法不能结束线程
 *      优雅的结束线程:方式1
 * @author ronin
 */
public class ShutdownGracefulThread1 {
    public static class Worker extends Thread{
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start){
                System.out.println("thread is running......");
            }
        }

        public void shutdown(){
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();
    }
}
