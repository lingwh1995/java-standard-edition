package org.bluebridge.thread_12_twoPhase;

/**
 * 两阶段终止线程
 *  https://blog.csdn.net/xyxyxyxyxyxyx/article/details/126615784
 */
public class TwoPhaseTermination {
    // 监控线程
    private Thread monitorThread;
    // 停止标记
    private volatile boolean stop = false;
    // 判断是否执行过 start 方法
    private boolean starting = false;

    // 启动监控线程
    public void start() {
        synchronized (this) {
            if (starting) { // false
                return;
            }
            starting = true;
        }
        monitorThread = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                // 是否被打断
                if (stop) {
                    System.out.println("料理后事...");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("执行监控记录...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //current.interrupt();//重新设置打断标记为真
                }
            }
        }, "monitor");
        monitorThread.start();
    }

    // 停止监控线程
    public void stop() {
        stop = true; //自己设置一个打断标志
        monitorThread.interrupt(); //打断
    }
}
