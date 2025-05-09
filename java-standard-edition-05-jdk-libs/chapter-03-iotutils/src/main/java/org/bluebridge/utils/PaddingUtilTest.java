package org.bluebridge.utils;

import cn.hutool.core.util.HexUtil;
import org.bluebridge.utils.utils.PaddingUtil;

public class PaddingUtilTest {
    public static void main(String[] args) {
        byte[] dataAreaBytes = HexUtil.decodeHex("00112233445566778899AABBCCDDEEFF");
        System.out.println("数组长度:" + dataAreaBytes.length);
        byte[] dataAreaBytesPadding = PaddingUtil.paddingDataArea(dataAreaBytes);
        String dataArea = HexUtil.encodeHexStr(dataAreaBytesPadding);
        System.out.println(dataArea);
    }
}
