package org.bluebridge.unsafe_08_class_operate;

import org.bluebridge.util.UnsafeAccessor;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe应用七    操作class
 */
public class UnsafeClassOperateTest {

    @Test
    public void testUnsafeClassOperate() throws NoSuchFieldException {
        Student student = new Student();
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        Field sexField = Student.class.getDeclaredField("name");
        long fieldOffset = unsafe.staticFieldOffset(sexField);
        Object fieldBase = unsafe.staticFieldBase(sexField);
        Object object = unsafe.getObject(fieldBase, fieldOffset);
        System.out.println(object);
    }
}
