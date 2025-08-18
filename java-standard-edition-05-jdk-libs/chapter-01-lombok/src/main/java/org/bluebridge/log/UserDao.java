package org.bluebridge.log;

import lombok.extern.java.Log;

/**
 * @author lingwh
 * @desc UserDao，在类上使用@Log注解
 * @date 2025/8/18 11:58
 */
@Log
public class UserDao {

    public void deleteById() {
        log.info("正在执行根据id删除操作....");
    }

}
