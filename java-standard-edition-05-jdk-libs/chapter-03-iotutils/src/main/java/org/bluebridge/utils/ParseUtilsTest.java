package org.bluebridge.utils;

public class ParseUtilsTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "680001002C02082009A526AEE8B79919ACBBAA432E1FC5BC1B528D4A5B77530D020174E57EA90A613802EF16";
        String base64Message = ParseUtils.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        stringMessage = ParseUtils.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}