package org.bluebridge.beginner;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DataTypeConversionTest {

    @Test
    public void testDataTypeConversion() {
        // 原始数据类型
        int i = 100;
        log.info("i = {}", i);
        // 小范围数据类型 => 大范围数据类型（不需要进行强制类型转换）
        double d = i;
        log.info("d = {}", d);
        // 大范围数据类型 => 小范围数据类型（需要进行强制类型转换）
        char c = (char) i;
        log.info("c = {}", c);
    }

}
