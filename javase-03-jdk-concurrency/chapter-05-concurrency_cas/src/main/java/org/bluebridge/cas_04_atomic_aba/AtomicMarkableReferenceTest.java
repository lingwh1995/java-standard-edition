package org.bluebridge.cas_04_atomic_aba;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 带有是否更新标识的原子引用（不关心引用变量更改了几次，只是单纯的关心是否更改过）
 *      可以注释掉打扫卫生线程代码，再观察输出
 * 既然有了AtomicStampedReference为啥还需要再提供AtomicMarkableReference呢，在现实业务场景中，不关心引用变量被修改了几次，只是单纯的关心是否更改过。
 */
public class AtomicMarkableReferenceTest {
    public static void main(String[] args) {
        // 创建一个 AtomicMarkableReference 实例，初始值为 "Hello" 和标记 false
        AtomicMarkableReference<String> atomicMarkableReference = new AtomicMarkableReference<>("Hello", false);

        // 客户端调用：尝试更新引用和标记
        boolean updated = atomicMarkableReference.compareAndSet("Hello", "World", false, true);
        System.out.println("Updated: " + updated); // 输出：Updated: true

        // 获取当前值和标记
        String currentValue = atomicMarkableReference.getReference();
        boolean currentMark = atomicMarkableReference.isMarked();
        System.out.println("Current Value: " + currentValue + ", Mark: " + currentMark); // 输出：Current Value: World, Mark: true

        // 尝试基于旧值和旧标记更新，但这次会失败，因为当前值或标记与预期的不匹配
        updated = atomicMarkableReference.compareAndSet("Hello", "Java", false, false);
        System.out.println("Updated: " + updated); // 输出：Updated: false

        // 再次获取当前值和标记，以确认没有变化
        currentValue = atomicMarkableReference.getReference();
        currentMark = atomicMarkableReference.isMarked();
        System.out.println("Current Value: " + currentValue + ", Mark: " + currentMark); // 输出：Current Value: World, Mark: true
    }
}