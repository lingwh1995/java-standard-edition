package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_03_unfair_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

    private static final ReentrantLock lock = new ReentrantLock(true);  // 非公平锁

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " 获取了锁");
                    // 模拟业务操作
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            },"线程-" + i).start();
        }
    }
}
