package org.bluebridge.lock_19_multi_lock;

/**
 * 多把锁测试
 */
public class BigRoomMultiLockTest {
    public static void main(String[] args) {
        BigRoomMultiLock bigRoomMultiLock = new BigRoomMultiLock();
        new Thread(() -> {
            bigRoomMultiLock.study();
        },"小男").start();
        new Thread(() -> {
            bigRoomMultiLock.sleep();
        },"小女").start();
    }
}
