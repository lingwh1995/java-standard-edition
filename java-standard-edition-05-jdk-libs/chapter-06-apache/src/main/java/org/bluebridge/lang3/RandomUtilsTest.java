package org.bluebridge.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @author lingwh
 * @desc 随机数工具类
 * @date 2025/9/15 11:21
 */
@Slf4j(topic = "·")
public class RandomUtilsTest {

    /**
     * 使用随机值生成随机值
     */
    @Test
    public void testRandomUtils() {
        boolean randomBoolean = RandomUtils.nextBoolean();
        log.debug("{}", randomBoolean);
        int randomInt = RandomUtils.nextInt(10, 100);
        log.debug("{}", randomInt);
    }

}
