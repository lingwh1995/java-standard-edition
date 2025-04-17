package org.bluebridge.beginner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 原码、反码、补码
 */
public class Code {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("********");
        // 十进制数字5 -> 二进制数字
        System.out.println(toBinaryStringWithLeftPadding(5, 8));
        System.out.println(toBinaryStringWithLeftPadding(1<<7, 8));
        System.out.println("********");

        int num = 5;
        System.out.println(toBinaryString(num,false));
        System.out.println(toBinaryString((1<<7) | num, true));

        int i = 9;
        System.out.println(8 - i % 8);
        i = 4;
        System.out.println(8 - i % 8);
        i = 15;
        System.out.println(8 - i % 8);
    }

    private static String toBinaryString(int num,boolean debug) {
        List<Integer> bits = new ArrayList<>();
        for(int i=7;i>=0;i--) {
            if(debug) {
                System.out.println(toBinaryStringWithLeftPadding((num >> i), 8));
                System.out.println(toBinaryStringWithLeftPadding(1, 8));
                System.out.println(toBinaryStringWithLeftPadding((num >> i) & 1, 8));
                System.out.println("--------");
            }
            bits.add((num >> i) & 1);
        }
        return bits.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    /**
     * 使用二进制表示十进制数，并且左补0进行格式化 - 方式一：String.format()实现
     * @param decimal
     * @param length
     * @return
     */
    public static String toBinaryStringWithLeftPadding(int decimal, int length) {
        return String.format("%" + length + "s", Integer.toBinaryString(decimal)).replace(' ', '0');
    }
}
