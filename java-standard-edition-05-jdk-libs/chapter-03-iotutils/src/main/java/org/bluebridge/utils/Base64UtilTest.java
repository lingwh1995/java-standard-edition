package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;

public class Base64UtilTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "6868150054000199999999999999999101250427175715ffbb001c1f383636383737303739373532343238383938363038353831303234343031343434323000000042433935434e5601010001267991758b6616";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);

        // 如果不相等，则用大数减去小数，然后用这个较小数与它们相减的结果相比较，如果相等，则这个差就是它们的最大公约数，而如果不相等，则继续执行②操作。
        int a = 100, b = 80, diff = 100;
        while(diff >= 0) {
            if(a < b)
            {
                int temp = a;
                a = b;
                b = temp;
            }
            diff = a - b;
            a = b;
            b = diff;
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(diff);
    }
}