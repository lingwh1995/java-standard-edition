package org.bluebridge.utils.utils;

/**
 * 补齐工具类
 */
public class PaddingUtil {
    public static byte[] paddingDataArea(byte[] dataArea) {
        byte[] paddingDataArea;
        int paddingNumber = dataArea.length % 16;
        if (paddingNumber == 0) {
            int length = dataArea.length + 16;
            paddingDataArea = new byte[length];
            System.arraycopy(dataArea, 0, paddingDataArea, 0, dataArea.length);
            for (int i = dataArea.length; i < paddingDataArea.length; i++) {
                paddingDataArea[i] = (byte) 16;
            }
        } else {
            int value = 16 - paddingNumber;
            paddingDataArea = new byte[dataArea.length + value];
            System.arraycopy(dataArea, 0, paddingDataArea, 0, dataArea.length);
            for (int i = dataArea.length; i < paddingDataArea.length; i++) {
                paddingDataArea[i] = (byte) value;
            }
        }
        return paddingDataArea;
    }
}
