package org.bluebridge.thread_09_interrupt;

/**
 * 两阶段终止线程
 *  https://blog.csdn.net/xyxyxyxyxyxyx/article/details/126615784
 */
public class TwoPhaseTermination {
    private Thread monitor;

    /**
     * 启动监控线程
     */
    public void start() {
        monitor = new Thread(() -> {
           while (true) {
               Thread current = Thread.currentThread();
               if(current.isInterrupted()) {
                   System.out.println("料理后事...");
                   break;
               }

               try {
                   Thread.sleep(1000);
                   System.out.println("执行监控...");
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   System.out.println("打断标记： " + current.isInterrupted());
                   //重新设置打断标记
                   current.interrupt();
               }
           }
        });

        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
