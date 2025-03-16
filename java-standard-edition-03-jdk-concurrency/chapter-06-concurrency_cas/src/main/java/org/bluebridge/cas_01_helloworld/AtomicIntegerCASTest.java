package org.bluebridge.cas_01_helloworld;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCASTest {

    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        int prev = counter.get();
        int next = prev + 1;
        System.out.println(counter.compareAndSet(prev, next));
        System.out.println("counter.get() = " + counter.get());
    }
}
