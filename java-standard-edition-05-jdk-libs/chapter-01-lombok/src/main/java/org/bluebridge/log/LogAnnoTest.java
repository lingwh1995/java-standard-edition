package org.bluebridge.log;


import org.junit.Test;

/**
 * @author lingwh
 * @desc 测试@Log注解
 * @date 2025/8/18 12:00
 */
public class LogAnnoTest {

    @Test
    public void testLogAnno() {
        UserDao userDao = new UserDao();
        userDao.deleteById();
    }

}
