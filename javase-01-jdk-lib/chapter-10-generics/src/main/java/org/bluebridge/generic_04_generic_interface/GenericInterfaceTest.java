package org.bluebridge.generic_04_generic_interface;

import org.junit.Test;

public class GenericInterfaceTest {

    /**
     * 泛型接口测试
     */
    @Test
    public void testGenericInterface() {
        InfoImpl i = new InfoImpl("hello~");
        System.out.println(i.getVar());
    }
}
