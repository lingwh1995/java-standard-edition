package org.bluebridge.lock_22_reentrant_lock.reentrant_lock_02_philosopher;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 筷子类
 */
class Chopstick extends ReentrantLock {
    String name;
    public Chopstick(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "筷子{" + name + '}';
    }
}
