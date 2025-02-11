package org.bluebridge.thread_11_getId;

/**
 * getId() 获取线程id
 */
public class ThreadGetIdTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello World~"), "t1");
        System.out.println("Thread " + t.getName() + " 的id " + t.getId());
        System.out.println("Thread " + Thread.currentThread().getName() + " 的id " + Thread.currentThread().getId());
    }
}
