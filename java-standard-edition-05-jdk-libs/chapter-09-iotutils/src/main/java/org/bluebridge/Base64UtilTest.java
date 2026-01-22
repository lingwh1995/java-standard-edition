package org.bluebridge;

import org.bluebridge.utils.Base64Util;
import org.junit.Test;

public class Base64UtilTest {

    @Test
    public void testBase64Util() {
        // IMEI 867860061213483
        String stringMessage = "680101005B020480FA424254434D4400000000009E2500002042433238434E53424C565230314130315F42455441303630354120000000006E37755030303733000000000000000000000000000000000000000000000000A51F16";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }

}