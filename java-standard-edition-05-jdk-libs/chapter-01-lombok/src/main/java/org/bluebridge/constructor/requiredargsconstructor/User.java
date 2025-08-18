package org.bluebridge.constructor.requiredargsconstructor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author lingwh
 * @desc User实体，使用@RequiredArgsConstructor添加有参构造方法，只针对被final修饰或者@NonNull修饰的属性生成构造函数
 * @date 2025/8/18 11:36
 */
@RequiredArgsConstructor
@ToString
public class User {
    private final String id;
    @NonNull private String name;
    private int age;
    private String email;
}
