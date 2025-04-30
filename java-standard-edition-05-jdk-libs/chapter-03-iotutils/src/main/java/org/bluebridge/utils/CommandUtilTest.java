package org.bluebridge.utils;

import org.bluebridge.utils.utils.CommandUtil;
import org.junit.Test;

public class CommandUtilTest {

    @Test
    public void test() throws Exception {
        // 主密钥
        String mainSecret = "31323334353637383930313233343536";
        // 随机通信码
        String randomCode = "20250430999999999999999900000000";
        // 数据区
        String dataAreaHex = "01";
        // 是否加密数据区
        boolean isEncryp = true;
        // 是否计算mac并添加mac到数据区尾部
        boolean withMac = true;
        CommandUtil commandUtil = new CommandUtil(mainSecret, randomCode, dataAreaHex, isEncryp, withMac);
        String finalDataAreaHex = commandUtil.buildFinalDataArea();
        System.out.println("finalDataAreaHex = " + finalDataAreaHex);
    }
}
