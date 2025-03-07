package org.bluebridge.lock_23_reentrant_lock.reentrant_lock_04_fair_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private static final ReentrantLock lock = new ReentrantLock(true);  // 公平锁

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(), "线程-" + i).start();
        }
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获取了锁");
                Thread.sleep(1000);  // 模拟业务操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
