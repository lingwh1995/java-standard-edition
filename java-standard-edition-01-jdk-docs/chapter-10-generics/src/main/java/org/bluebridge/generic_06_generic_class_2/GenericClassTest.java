package org.bluebridge.generic_06_generic_class_2;

import org.junit.Test;

public class GenericClassTest {

    @Test
    public void testGenericClass() {
        InfoImpl<Integer,Double,String> i = new InfoImpl<>("hello~");
        System.out.println(i.getVar()) ;
    }
}
