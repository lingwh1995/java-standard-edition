package org.bluebridge.api;

import org.junit.Test;

import java.nio.charset.Charset;

public class CharsetTest {

    /**
     * 获取JVM默认字符集
     */
    @Test
    public void testDefaultCharset() {
        // 获取默认的字符集
        Charset defaultCharset = Charset.defaultCharset();

        // 打印默认字符集的名称
        System.out.println("Default charset: " + defaultCharset.name());

        // 打印默认字符集的别名
        System.out.println("Aliases: " + defaultCharset.aliases());
    }
}
