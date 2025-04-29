package org.bluebridge.utils.utils;

import cn.hutool.core.io.checksum.crc16.CRC16XModem;

/**
 * HuTools提供了常见的CRC实现 根据需要调用即可
 *
 * @author lenovo
 */
public class CRCUtil {

    public static long XModem(byte[] bytes) {
        CRC16XModem crc16XModem = new CRC16XModem();
        crc16XModem.update(bytes);
        return crc16XModem.getValue();
    }

}
