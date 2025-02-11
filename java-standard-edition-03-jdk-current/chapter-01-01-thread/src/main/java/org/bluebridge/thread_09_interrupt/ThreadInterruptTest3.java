package org.bluebridge.thread_09_interrupt;

/**
 * interrupt()      其作用是中断此线程（此线程不一定是当前线程，而是指调用该方法的Thread实例所代表的线程），但实际上只是给线程设置一个中断标志，线程仍会继续运行。）作用与正常线程会将中断标记设置为true,但是作用于阻塞线程会将中断标志刷新false（中断标记默认为false，刷新就是重新刷会默认）。
 * interrupted()    作用是测试当前线程是否被中断（检查中断标志），返回一个boolean并清除中断状态，第二次再调用时中断状态已经被清除，将返回一个false。
 * isInterrupted()  作用是只测试此线程是否被中断 ，不清除中断状态。
 *
 */
public class ThreadInterruptTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                //...
                //System.out.println("......");
            }
        });
        t.start();
        t.interrupt();

        Thread.currentThread().interrupted();
        Thread.interrupted();

        System.out.println("第一次调用thread.isInterrupted()：" + t.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted()：" + t.isInterrupted());
        System.out.println("thread是否存活：" + t.isAlive());
    }
}
