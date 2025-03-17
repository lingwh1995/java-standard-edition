package org.bluebridge.cas_07_lock;

import java.util.concurrent.atomic.AtomicInteger;

public class LockCas {

    private AtomicInteger state = new AtomicInteger(0);
    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }
    public void unlock() {
        System.out.println("unlock......");
        state.set(0);
    }
}
