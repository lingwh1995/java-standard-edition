package org.bluebridge;

/**
 * 循环打印a-g
 */
public class PrintAToGTest {
    public static void main(String[] args) {
        printAToG1();
        printAToG2();
    }

    /**
     * 循环打印a-g方式一
     */
    private static void printAToG1() {
        String s = "abcdefg";
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            for (int j = 0; j < s.length(); j++) {
                System.out.print(s.charAt(k));
                k = k + 1;
                if (k == s.length()) {
                    k = 0;
                }
            }
            System.out.println();
        }
    }

    /**
     * 循环打印a-g方式二
     */
    private static void printAToG2() {
        String s = "abcdefg";
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            for (int j = 0; j < s.length(); j++) {
                System.out.print(s.charAt(k));
                k = k + 1;
                k = k % s.length();
            }
            System.out.println();
        }
    }
}