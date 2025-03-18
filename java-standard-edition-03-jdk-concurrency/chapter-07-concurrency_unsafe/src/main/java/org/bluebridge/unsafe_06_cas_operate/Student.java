package org.bluebridge.unsafe_06_cas_operate;

import org.bluebridge.util.UnsafeAccessor;
import sun.misc.Unsafe;

public class Student {
    volatile int age;
    public void increment(int x){
        while (true){
            try {
                Unsafe unsafe = UnsafeAccessor.getUnsafe();
                long fieldOffset = unsafe.objectFieldOffset(Student.class.getDeclaredField("age"));
                if (unsafe.compareAndSwapInt(this,fieldOffset,x-1,x))
                    break;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
