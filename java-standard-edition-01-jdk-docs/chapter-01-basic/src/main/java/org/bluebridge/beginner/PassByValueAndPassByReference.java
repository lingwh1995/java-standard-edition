package org.bluebridge.beginner;

/**
 * 值传递和引用传递
 */
public class PassByValueAndPassByReference {

    public static void main(String[] args) {
        int a = 10, b = 20;
        swapNumber(a,b);
        // a和b的值没有改变的原因是java是值传递，在swapNumber()方法中，操作的是实参a和b的副本，而不是a和b本身
        System.out.printf("a = %d, b = %d\n", a, b);
    }

    /**
     * 交换两个数
     * @param a
     * @param b
     */
    private static void swapNumber(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("a = %d, b = %d\n", a, b);
    }
}
