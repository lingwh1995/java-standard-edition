package org.bluebridge;

import org.bluebridge.utils.Base64Util;
import org.junit.Test;

public class Base64UtilTest {

    @Test
    public void testBase64Util() {
        // IMEI 867860061213483
        String stringMessage = "68013C003401000001EA8880DAD4FC8A553308600F0B2D75222351BBD4269272771D73DC4015DA7C40C2EA0F0AC8108D445432EB42E97D5FE84C8F4B";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }

}