package org.bluebridge.lock_19_multi_lock;

/**
 * 单把锁测试
 */
public class BigRoomSingleLockTest {
    public static void main(String[] args) {
        BigRoomSingleLock bigRoomSingleLock = new BigRoomSingleLock();
        new Thread(() -> {
            bigRoomSingleLock.study();
        },"小男").start();
        new Thread(() -> {
            bigRoomSingleLock.sleep();
        },"小女").start();
    }
}
