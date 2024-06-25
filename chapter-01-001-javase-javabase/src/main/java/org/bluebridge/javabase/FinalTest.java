package org.bluebridge.javabase;

public class FinalTest {
    public static void main(String[] args)  {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        String f = b + getHello();
        System.out.println("c:"+c+",e:"+e);
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println((a == f));
    }
    public static String getHello() {
        return "hello";
    }
}
