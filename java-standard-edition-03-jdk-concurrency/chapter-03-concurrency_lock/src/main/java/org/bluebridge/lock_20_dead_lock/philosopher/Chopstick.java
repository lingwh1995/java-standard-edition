package org.bluebridge.lock_20_dead_lock.philosopher;

/**
 * 筷子类
 */
public class Chopstick {
    private String name;

    public Chopstick(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "筷子{" + name + '}';
    }
}
