package org.bluebridge.unsafe_01_start;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeAccessorTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        Field id = Student.class.getDeclaredField("id");
        Field name = Student.class.getDeclaredField("name");

        // 获得成员变量的偏移量
        long idOffset = UnsafeAccessor.unsafe.objectFieldOffset(id);
        System.out.println("idOffset = " + idOffset);
        long nameOffset = UnsafeAccessor.unsafe.objectFieldOffset(name);
        System.out.println("nameOffset = " + nameOffset);
        Student student = new Student();

        // 使用 cas 方法替换成员变量的值
        UnsafeAccessor.unsafe.compareAndSwapInt(student, idOffset, 0, 20); // 返回 true
        UnsafeAccessor.unsafe.compareAndSwapObject(student, nameOffset, null, "张三"); // 返回 true
        System.out.println(student);
    }
}
