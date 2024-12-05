package org.bluebridge.basic;

/**
 * i++和++i
 */
public class PPiandiPPTest {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(++i);
        int j = 0;
        System.out.println(j++);
        System.out.println("----------------------------------");

        int a = 10,b = 10;
        int x = ++a;
        System.out.println("x:" + x);
        System.out.println("a:" + a);
        x = b++;
        System.out.println("x:" + x);
        System.out.println("b:" + b);
    }
}
