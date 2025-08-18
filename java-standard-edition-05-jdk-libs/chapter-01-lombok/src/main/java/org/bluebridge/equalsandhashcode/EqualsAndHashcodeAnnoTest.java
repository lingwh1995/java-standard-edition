package org.bluebridge.equalsandhashcode;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lingwh
 * @desc 测试@EqualsAndHashCode注解
 * @date 2025/8/18 11:47
 */
@Slf4j(topic = "·")
public class EqualsAndHashcodeAnnoTest {

    @Test
    public void testEqualsAndHashcodeAnno() {
        User user = new User();
        log.info("user.hashCode(): {}", user.hashCode());
    }

}
