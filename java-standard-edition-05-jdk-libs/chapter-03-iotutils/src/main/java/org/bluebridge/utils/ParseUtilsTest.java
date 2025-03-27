package org.bluebridge.utils;

public class ParseUtilsTest {
    public static void main(String[] args) {
        //IMEI 867860061213483
        String stringMessage = "680001009747013001250220161714000B00211031363233313536343233363532353936000000000000000000000000000000000042433235504130344254000000556400024906F8B814A3C6EA5A192D97F58D72E4FC8600130000000846177709CA38363739343630363333353332333500005F6B8BF637531F190FE180FFFF0F4ECB04E9180FF3D6BD57F1FD0E883C10FB74A34D16";
        String base64Message = ParseUtils.stringToBase64(stringMessage);
        System.out.println("base64Message = " + base64Message);

        stringMessage = ParseUtils.base64ToString(base64Message);
        System.out.println("stringMessage = " + stringMessage);
    }
}