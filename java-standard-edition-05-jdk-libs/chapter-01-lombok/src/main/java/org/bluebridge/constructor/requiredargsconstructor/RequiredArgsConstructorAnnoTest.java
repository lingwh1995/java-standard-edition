package org.bluebridge.constructor.requiredargsconstructor;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lingwh
 * @desc 测试@RequiredArgsConstructor注解
 * @date 2025/8/18 11:38
 */
@Slf4j(topic = "·")
public class RequiredArgsConstructorAnnoTest {

    /**
     * 测试@RequiredArgsConstructor注解
     */
    @Test
    public void testRequiredArgsConstructorAnno() {
        User user = new User("001","张三");
        log.info("user: {}", user);
    }

}
