package org.bluebridge.thread.thread_start;

/**
 * 优先级测试
 * @author ronin
 */
public class PriorityTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
                }
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getId());
                }
            }
        };
        //设置线程优先级
        //设置线程优先级为1
        t1.setPriority(Thread.MIN_PRIORITY);
        //优先级为5
        t2.setPriority(Thread.NORM_PRIORITY);
        //优先级为10
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
