package org.bluebridge.thread.thread_start;

/**
 * @author ronin
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println("--------------------------------");
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1"){
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("ThreadName:"+Thread.currentThread().getName());
                        System.out.println("ThreadGroupName:"+Thread.currentThread().getThreadGroup().getName());
                        System.out.println("ThreadGroupParentName:"+Thread.currentThread().getThreadGroup().getParent());
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(tg1, "t2"){
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println("ThreadName:"+Thread.currentThread().getName());
                        System.out.println("ThreadGroupName:"+Thread.currentThread().getThreadGroup().getName());
                        System.out.println("ThreadGroupParentName:"+Thread.currentThread().getThreadGroup().getParent());
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
        System.out.println(tg1.activeCount());
    }
}
