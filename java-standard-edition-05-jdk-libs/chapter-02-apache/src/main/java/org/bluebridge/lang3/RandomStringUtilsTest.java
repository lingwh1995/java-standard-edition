package org.bluebridge.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * 随机字符串工具类
 */
@Slf4j
public class RandomStringUtilsTest {

    /**
     * 使用RandomStringUtils生成长度为6位的随机验证码
     */
    @Test
    public void testRandomStringUtils() {
        String randomCode = RandomStringUtils.randomNumeric(6);
        log.debug("{}", randomCode);
    }

}
