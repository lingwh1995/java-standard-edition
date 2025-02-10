package org.bluebridge.thread_join;


import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * join() 用于实现线程同步
 *      https://blog.csdn.net/csdn_life18/article/details/139520863
 *      Java 提供了多种机制来实现线程之间的协调，其中之一就是 Thread.join() 方法。join() 方法允许一个线程等待另一个线程完成，这在很多场景中是非常有用的。
 */
public class ThreadJoinTest {

    /**
     * 测试使用 join() 实现线程同步
     * @throws InterruptedException
     */
    @Test
    public void testThreadJoin1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(300);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(300);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "t2");

        t1.start();
        //同步执行线程一
        t1.join();

        t2.start();
        //同步执行线程二
        t2.join();

        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
    }

    /**
     * 测试使用 join() 实现线程同步
     * @throws InterruptedException
     */
    @Test
    public void testThreadJoin2() throws InterruptedException {
        AtomicInteger i = new AtomicInteger(1);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                i.set(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        //如果不使用 join() 实现线程同步的话，获取到的i的值是 1，如果使用 join() 实现线程同步，获取到的i的值是 10
        t1.join();
        System.out.println("i = " + i.get());
    }

    /**
     * 测试使用 join() 实现线程同步
     *      第一个 join()：等待时,t2并没有停止,而在运行
     *      第二个 join()：1s后,执行到此,t2也运行了1s,因此也只需再等待 1s
     * @throws InterruptedException
     */
    @Test
    public void testThreadJoin3() throws InterruptedException {
        AtomicInteger r1 = new AtomicInteger(0);
        AtomicInteger r2 = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                r1.set(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                r2.set(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("r1 = " + r1.get());
        System.out.println("r2 = " + r2.get());
        System.out.println("timeRange = " + (end - start));
    }

    /**
     * 测试使用 join(long millis) 实现线程同步
     *      限时同步
     * @throws InterruptedException
     */
    @Test
    public void testThreadJoin4() throws InterruptedException {
        AtomicInteger i = new AtomicInteger(1);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                i.set(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        //如果不使用 join() 实现线程同步的话，获取到的i的值是 1，如果使用 join() 实现线程同步，获取到的i的值是 10
        t1.join(1000);
        System.out.println("i = " + i.get());
    }
}