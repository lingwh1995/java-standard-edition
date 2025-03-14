package org.bluebridge.cas_04_atomic_aba;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 带有是否更新标识的原子引用（不关心引用变量更改了几次，只是单纯的关心是否更改过）
 *      可以注释掉打扫卫生线程代码，再观察输出
 */
public class AtomicMarkableReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        GarbageBag bag = new GarbageBag("装满了垃圾......");
        // 参数2 mark 可以看作一个标记，表示垃圾袋满了
        AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<>(bag, true);
        System.out.println("主线程 start......");
        GarbageBag prev = ref.getReference();
        System.out.println(prev.toString());
        new Thread(() -> {
            System.out.println("打扫卫生的线程 start......");
            bag.setDesc("空垃圾袋");
            while (!ref.compareAndSet(bag, bag, true, false)) {}
            System.out.println(bag.toString());
        }).start();
        Thread.sleep(1000);
        System.out.println("主线程想换一只新垃圾袋？");
        boolean success = ref.compareAndSet(prev, new GarbageBag("空垃圾袋"), true, false);
        System.out.println("换了么？" + success);
        System.out.println(ref.getReference().toString());
    }
}

class GarbageBag {
    String desc;
    public GarbageBag(String desc) {
        this.desc = desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return super.toString() + " " + desc;
    }
}