package org.bluebridge.unsafe_09_system_info;

import org.bluebridge.util.UnsafeAccessor;
import org.junit.Test;
import sun.misc.Unsafe;

/**
 * Unsafe应用八    系统信息
 */
public class UnsafeSystemInfoTest {

    @Test
    public void testUnsafeSystemInfoTest() throws Exception{
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        System.out.println(unsafe.addressSize());
        System.out.println(unsafe.pageSize());
    }
}
