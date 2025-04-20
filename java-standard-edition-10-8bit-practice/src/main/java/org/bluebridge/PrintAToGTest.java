package org.bluebridge;

/**
 * 循环打印a-g
 */
public class PrintAToGTest {
    public static void main(String[] args) {
        String s = "abcdefg";
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            for (int j = 0; j < s.length(); j++) {
                System.out.print(s.charAt(k));
                k = k + 1;
//                if (k == s.length()) {
//                    k = 0;
//                }
                k = k % s.length();
            }
            System.out.println();
        }
    }
}