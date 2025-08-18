package org.bluebridge.slf4j;

import org.junit.Test;

/**
 * @author lingwh
 * @desc 测试@Slf4j注解
 * @date 2025/8/18 13:45
 */
public class Slf4jAnnoTest {

    /**
     * 测试@Slf4j注解
     */
    @Test
    public void testSlf4jAnno() {
        UserDao userDao = new UserDao();
        userDao.deleteById();
    }

}
