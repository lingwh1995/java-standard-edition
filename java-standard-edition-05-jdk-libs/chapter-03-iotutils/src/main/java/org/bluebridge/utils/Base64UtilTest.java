package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;

public class Base64UtilTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "68671500610001900125051516264039393939393939393939393939393939000138363139383730373138353439343338393836313132343231303030333237303931300000424339352D434E56000000000846177709CA00A0FFA200E39B7616";
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