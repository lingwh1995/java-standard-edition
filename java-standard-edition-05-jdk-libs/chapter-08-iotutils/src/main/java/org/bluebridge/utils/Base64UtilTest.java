package org.bluebridge.utils;

import org.bluebridge.utils.utils.Base64Util;
import org.junit.Test;

public class Base64UtilTest {

    @Test
    public void testBase64Util() {
        // IMEI 867860061213483
        String stringMessage = "680197004B21000001A18800D46E0FC9DF25F5C73E1948A24AAB11833D0FC8E921F810E4AD386C447CC0A8E803037A83B6F06009D9B2B229722F9AF703037A83B6F06009D9B2B229722F9AF703037A83B6F06009D9B2B229722F9AF76CD90B0270F418983B517592275991886F86C3D0BF030EA4F44EB62410DE853646F4EBC451465150E880E0E3754BF88549BF65436BD9E1A1DB20CF7CF88E5E42";
        String base64Message = Base64Util.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        base64Message = "MFBVzvW5DiX917sncBQvwVTnAZATMoRP62c1a+vd5vA=";
        stringMessage = Base64Util.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }

}