package org.bluebridge.unsafe_10_unsafe_atomic_integer;

import java.util.ArrayList;

interface Account{
    //获取balance的方法
    int getBalance();
    //取款的方法
    void decrease(int amount);
    //演示多线程取款，检查安全性。
    default void demo(){
        ArrayList<Thread> ts = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                decrease(10);
            }));
        }
        for (Thread t:ts) {
            t.start();
        }
        for (Thread t:ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getBalance());
    }
}
