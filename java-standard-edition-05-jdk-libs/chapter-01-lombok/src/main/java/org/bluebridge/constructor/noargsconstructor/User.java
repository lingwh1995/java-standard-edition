package org.bluebridge.constructor.noargsconstructor;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lingwh
 * @desc User实体，使用@NoArgsConstructor为类添加无参构造方法
 * @date 2025/8/18 11:32
 */
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String name;
    private int age;
    private String email;
}
