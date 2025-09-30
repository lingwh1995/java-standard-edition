package org.bluebridge.slf4j;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lingwh
 * @desc UserDao，在类上使用@Slf4j注解
 * @date 2025/8/18 13:43
 */
@Slf4j
public class UserDao {
    public void deleteById() {
        log.info("正在执行根据id删除操作....");
    }
}
