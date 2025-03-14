package org.bluebridge.cas_06_atomic_field_updater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class FieldUpdaterTest {
    private volatile int field;
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(FieldUpdaterTest.class, "field");

        FieldUpdaterTest fieldUpdaterTest = new FieldUpdaterTest();
        fieldUpdater.compareAndSet(fieldUpdaterTest, 0, 10);
        // 修改成功 field = 10
        System.out.println(fieldUpdaterTest.field);
        // 修改成功 field = 20
        fieldUpdater.compareAndSet(fieldUpdaterTest, 10, 20);
        System.out.println(fieldUpdaterTest.field);
        // 修改失败 field = 20
        fieldUpdater.compareAndSet(fieldUpdaterTest, 10, 30);
        System.out.println(fieldUpdaterTest.field);
    }
}
