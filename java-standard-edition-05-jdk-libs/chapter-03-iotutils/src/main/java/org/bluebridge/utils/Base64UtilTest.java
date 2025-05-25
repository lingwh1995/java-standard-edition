package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;

public class Base64UtilTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "535441525400001B000208607220769995052505261547524E46000704250527000002C1";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "U1RBUlSqACUAAQhpVABpmVQYJQQXE1cHz0ZbFZegrTBf/oF3r5fIzzgVmR5UsgExFI1MVJf9hr0=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}