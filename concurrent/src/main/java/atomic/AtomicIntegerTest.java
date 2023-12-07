package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ronin
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println("atomicInteger:"+atomicInteger);
        int addResult = atomicInteger.getAndAdd(15);
        System.out.println("atomicInteger.getAndAdd:"+addResult);
        System.out.println("atomicInteger.get():"+atomicInteger.get());
        System.out.println("atomicInteger.getAndSet():"+atomicInteger.getAndSet(18));
    }
}
