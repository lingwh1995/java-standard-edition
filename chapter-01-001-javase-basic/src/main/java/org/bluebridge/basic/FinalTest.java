package org.bluebridge.basic;

import org.junit.Test;

public class FinalTest {

    @Test
    public void testFinal() {
        String str = "hello2";
        final String a = "hello";
        String b = "hello";
        String c = a + 2;
        String d = b + 2;
        String e = a + getHello();
        String f = b + getHello();
        System.out.println(str == c);
        System.out.println(str == d);
        System.out.println(str == e);
        System.out.println(str == f);
    }

    public static String getHello() {
        return "hello";
    }
}
