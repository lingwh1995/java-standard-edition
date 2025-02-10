package org.bluebridge.thread_getId;

/**
 * getId() 获取线程id
 */
public class ThreadGetId {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Hello World~"), "t1");
        System.out.println("Thread " + t1.getName() + " 的id " + t1.getId());
        System.out.println("Thread " + Thread.currentThread().getName() + " 的id " + Thread.currentThread().getId());
    }
}
