package org.bluebridge.generic_05_generic_class_1;

import org.junit.Test;

public class GenericClassTest {

    @Test
    public void testGenericClass() {
        // 将泛型的类的泛型设置为 String 类型
        InfoImpl<String> s = new InfoImpl<>("hello~");
        System.out.println(s.getVar());

        // 将泛型类的泛型设置为 Integer 类型
        InfoImpl<Integer> i = new InfoImpl<>(1);
        System.out.println(i.getVar()) ;
    }
}
