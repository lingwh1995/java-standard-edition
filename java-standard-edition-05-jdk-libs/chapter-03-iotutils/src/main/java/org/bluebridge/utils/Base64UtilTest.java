package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;

public class Base64UtilTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "680003004C0101300677F217F72B4513DF86B5E6A21B4B4712063915208405C0C2B252CC385ADB9E1C73330458D5E175617D47E983012C31D57948FA1F1FDE72D962D068556423745D63CA16";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}