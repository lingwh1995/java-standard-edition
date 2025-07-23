package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;

public class Base64UtilTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "3f8439c821e84e8596881149cc614aa4";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}