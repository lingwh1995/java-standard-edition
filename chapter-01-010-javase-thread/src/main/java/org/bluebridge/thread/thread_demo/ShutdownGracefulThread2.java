package org.bluebridge.thread.thread_demo;

/**
 * 优雅的结束线程:
 *      方式二:使用Thread.interrupted()+break这个静态方法
 * @author ronin
 */
public class ShutdownGracefulThread2 {
    public static class Worker extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("thread is running......");
//                if(Thread.currentThread().isInterrupted()){
//                    break;
//                }
                if(Thread.interrupted()){
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            //worker.sleep(3000);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
