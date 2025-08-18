package org.bluebridge.getterandsetter.getter;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author lingwh
 * @desc User实体，在属性上使用@Getter注解
 * @date 2025/8/18 11:49
 */
public class User {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private int age;
    // 设置生成的Getter()方法的访问权限为private，外部无法调用
    @Getter(AccessLevel.PRIVATE)
    private String email;
}
