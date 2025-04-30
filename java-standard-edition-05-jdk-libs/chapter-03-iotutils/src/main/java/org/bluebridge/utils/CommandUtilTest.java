package org.bluebridge.utils;

import org.bluebridge.utils.utils.CommandUtil;
import org.junit.Test;

public class CommandUtilTest {

    /**
     * 测试构建报文数据区
     * @throws Exception
     */
    @Test
    public void testBuildFinalDataArea() throws Exception {
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

    /**
     * 测试解析报文数据区
     * @throws Exception
     */
    @Test
    public void testParseDataArea() throws Exception {
        // 主密钥
        String mainSecret = "31323334353637383930313233343536";
        // 随机通信码
        String randomCode = "20250430999999999999999900000000";
        // 数据区
        // 6868150015282499999999999999990009 01 21b9 16
        String dataAreaHex = "3D453A77AB24CD540501380A01604F4E766A1C25FA124EBDFA1B4069DFA5A73E1175B4D0CAF1F68F6688411E2248CC05";
        // 是否加密数据区
        boolean isEncryp = true;
        // 是否计算mac并添加mac到数据区尾部
        boolean withMac = true;
        CommandUtil commandUtil = new CommandUtil(mainSecret, randomCode, dataAreaHex, isEncryp, withMac);
        String originalDataAreaHex = commandUtil.parseDataArea();
        System.out.println("originalDataAreaHex = " + originalDataAreaHex);


    }
}
