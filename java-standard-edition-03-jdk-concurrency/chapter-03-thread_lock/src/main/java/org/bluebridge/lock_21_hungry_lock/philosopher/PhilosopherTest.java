package org.bluebridge.lock_21_hungry_lock.philosopher;

/**
 * 哲学家就餐模拟饥饿锁
 *      会发现：有几个哲学家始终无法吃到东西，但是却不是因为死锁或者活锁，这就是饥饿锁现象
 */
public class PhilosopherTest {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底", c1, c2).start();
        new Philosopher("柏拉图", c2, c3).start();
        new Philosopher("亚里士多德", c3, c4).start();
        new Philosopher("赫拉克利特", c4, c5).start();
        new Philosopher("阿基米德", c1, c5).start();
    }
}
