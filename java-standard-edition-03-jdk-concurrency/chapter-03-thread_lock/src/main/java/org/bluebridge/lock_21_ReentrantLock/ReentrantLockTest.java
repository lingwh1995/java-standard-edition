package org.bluebridge.lock_21_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 相对于synchronized，ReentrantLock具备如下特点
 *      可中断
 *      可以设置超时时间
 *      可以设置为公平锁
 *      支持多个条件变量
 *      与 synchronized 一样，都支持可重入（可重入是指同一个线程如果首次获得了这把锁，那么因为它是这把锁的拥有者，因此有权利再次获取这把锁如果是不可重入锁，那么第二次获得锁时，自己也会被锁挡住）
 *
 * 基本用法
 *      //获取ReentrantLock对象
 *      private ReentrantLock lock = new ReentrantLock();
 *      //加锁
 *      lock.lock();
 *      try {
 * 	        //需要执行的代码
 *      }finally {
 * 	        //释放锁
 * 	        lock.unlock();
 *      }
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(()-> {
            try {
                //加锁，可打断锁
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("等锁过程被打断......");
                return;
            }finally {
                //释放锁
                lock.unlock();
            }
        });

        lock.lock();
        System.out.println("获得锁......");
        t1.start();
        try {
            Thread.sleep(1000);
            //打断
            t1.interrupt();
            System.out.println("执行打断......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
