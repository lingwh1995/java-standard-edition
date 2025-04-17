package org.bluebridge.utils;

public class ParseUtilsTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "5354415254AA002500010869540069995418250417135707CF465B1597A0AD305FFE8177AF97C8CF3815991E54B20131148D4C5497FD86BD";
        String base64Message = ParseUtils.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        stringMessage = ParseUtils.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}