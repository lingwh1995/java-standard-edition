package org.bluebridge.unsafe_01_hello_world;

import org.bluebridge.util.UnsafeAccessor;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 测试获取Unsafe实例
 */
public class UnsafeAccessorTest {

    /**
     * 测试获取Unsafe实例
     */
    @Test
    public void testUnsafeAccessor() {
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        System.out.println("unsafe = " + unsafe);
    }

    /**
     * 测试获取指定字段在对象内存中的偏移地址，这个偏移地址仅在该Unsafe函数中访问指定字段时使用‌。
     */
    @Test
    public void testObjectFieldOffset() throws NoSuchFieldException {
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        Field id = Student.class.getDeclaredField("id");
        Field name = Student.class.getDeclaredField("name");

        // 获得成员变量的偏移量
        long idOffset = unsafe.objectFieldOffset(id);
        System.out.println("idOffset = " + idOffset);
        long nameOffset = unsafe.objectFieldOffset(name);
        System.out.println("nameOffset = " + nameOffset);

        Student student = new Student();
        // 使用 cas 方法替换成员变量的值
        unsafe.compareAndSwapInt(student, idOffset, 0, 20); // 返回 true
        unsafe.compareAndSwapObject(student, nameOffset, null, "张三"); // 返回 true
        System.out.println(student);
    }
}
