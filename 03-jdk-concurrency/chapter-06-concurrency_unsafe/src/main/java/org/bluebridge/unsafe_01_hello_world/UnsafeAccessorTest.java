package org.bluebridge.unsafe_01_hello_world;

import org.bluebridge.util.UnsafeAccessor;
import org.junit.Test;
import sun.misc.Unsafe;

import java.nio.ByteOrder;

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
}
