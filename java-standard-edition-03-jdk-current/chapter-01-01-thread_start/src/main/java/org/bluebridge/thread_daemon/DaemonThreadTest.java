package org.bluebridge.thread_daemon;

public class DaemonThreadTest {
    public static void main(String[] args) {
        // 创建一个守护线程
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(500); // 模拟任务执行
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread interrupted...");
                }
            }
        });

        // 设置为守护线程
        daemonThread.setDaemon(true);

        // 启动守护线程
        daemonThread.start();

        // 主线程（非守护线程）执行任务
        System.out.println("Main thread starts...");
        try {
            Thread.sleep(2000); // 模拟主线程执行任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ends.");
    }
}
