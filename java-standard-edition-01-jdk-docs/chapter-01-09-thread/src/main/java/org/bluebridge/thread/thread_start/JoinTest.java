package org.bluebridge.thread.thread_start;

/**
 * 作用:使得线程之间的并行执行变为串行执行
 *      顺序:先start()再join()
 *  注意:join()的是父线程，不是当前线程
 * @author ronin
 * @version V1.0
 * @since 2019/9/10 15:28
 */
public class JoinTest {
    public static void main(String[] args) {

        /**
         * join()测试1:要求线程执行顺序为:thread1->thread2->thread3
         */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 is running......");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("thread2 is running......");
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("thread3 is running......");
                }
            }
        });


        /**
         * join()测试2:执行完子线程，再执行主线程
         */
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread4 is running......");
                }
            }
        });
        t4.start();
        try {
            //主线程对t4失去了控制权，等待t4执行完成,然后再执行主线程
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FutureClient thread is running......");


        /**
         * join()测试3:保证程序不会因其他情况退出，让程序持续运行
         */
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
