package org.bluebridge.cas_04_atomic_aba;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带版本号的原子引用
 */
public class AtomicStampedReferenceTest {

    private static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start......");
        // 获取值 A
        String prev = ref.getReference();
        // 获取版本号
        int stamp = ref.getStamp();
        System.out.println("版本 : " + stamp);
        // 如果中间有其它线程干扰，发生了 ABA 现象
        change();
        sleep(1000);
        // 尝试改为 C
        System.out.println("change A->C : " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
    }

    private static void change() {
        new Thread(() -> {
            System.out.println("change A->B : " + ref.compareAndSet(ref.getReference(), "B",
                    ref.getStamp(), ref.getStamp() + 1));
            System.out.println("更新版本为 : " + ref.getStamp());
        }, "t1").start();
        sleep(500);
        new Thread(() -> {
            System.out.println("change B->A : " + ref.compareAndSet(ref.getReference(), "A",
                    ref.getStamp(), ref.getStamp() + 1));
            System.out.println("更新版本为 : " + ref.getStamp());
        }, "t2").start();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
