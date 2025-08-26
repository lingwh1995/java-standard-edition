package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;
import org.junit.Test;

public class Base64UtilTest {

    @Test
    public void testBase64Util() {
        // IMEI 867860061213483
        String stringMessage = "686D00404101002552507000002508250000018654002552507000002025082518524000810400200000140146030064610C000000610C000000151A000098035F00000000000000000000000347000101000120250825151536610C000000610C00000000000544BE5B9D0D16";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }

}