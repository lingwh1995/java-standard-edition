package org.bluebridge;

import org.bluebridge.utils.Base64Util;
import org.junit.Test;

public class Base64UtilTest {

    @Test
    public void testBase64Util() {
        // IMEI 867860061213483
        String stringMessage = "68013c00aa01000001ea888029286d14d52632bb7c65bf9cffa3f49e42a0ce776db191fd1f3b6e0493c5c56abb135c5175b0329fe4c61d7e0ae93340";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }

}