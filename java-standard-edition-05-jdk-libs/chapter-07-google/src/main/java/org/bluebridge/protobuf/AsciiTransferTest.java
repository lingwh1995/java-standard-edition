package org.bluebridge.protobuf;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lingwh
 * @desc 字符串转换为Ascii和Ascii转换为字符串的案例
 * @date 2025/11/3 20:47
 */
@Slf4j
public class AsciiTransferTest {

    public static void main(String[] args) {
        //字符串转换为Ascii的案例
        String stringTransformAscii = stringTransformAscii("460030222028133");
        log.info("字符串转换为Ascii: {}", stringTransformAscii);
        //Ascii转换为字符串的案例
        String asciiTransformString = asciiTransformString("0052,0054,0048,0048,0051,0048,0050,0050,0050,0048,0050,0056,0049,0051,0051");
        log.info("Ascii转换为字符串: {}", asciiTransformString);
    }

    /**
     *  字符串转换为Ascii
     * @param value
     * @return
     */
    public static String stringTransformAscii(String value){
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1){
                sbu.append((int)chars[i]).append(",");
            } else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     *  Ascii转换为字符串
     * @param value
     * @return
     */
    public static String asciiTransformString(String value){
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

}