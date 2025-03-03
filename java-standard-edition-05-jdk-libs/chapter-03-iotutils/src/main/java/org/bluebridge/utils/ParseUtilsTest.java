package org.bluebridge.utils;

public class ParseUtilsTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "BB011101282024048019090241600055915BC2886F7AFEA99207641AABE000536D275DA8D01BD02462520BD7CF6CC3E4FB96CFF605C78421BE7CBACC448F97AC9226C86A649FF914813A0AB87963A8EEA5534543A21C11814B7111BBE62F181968949EB3D6B41044B72BEA5F9146C7FAB9EE";
        String base64Message = ParseUtils.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        stringMessage = ParseUtils.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}