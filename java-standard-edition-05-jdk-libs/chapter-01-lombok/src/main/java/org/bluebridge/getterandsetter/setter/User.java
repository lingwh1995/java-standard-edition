package org.bluebridge.getterandsetter.setter;


import lombok.AccessLevel;
import lombok.Setter;

/**
 * @author lingwh
 * @desc User实体，在属性上使用@Setter注解
 * @date 2025/8/18 11:52
 */
public class User {
    @Setter
    private String id;
    @Setter
    private String name;
    @Setter
    private int age;
    // 设置生成的Setter()方法的访问权限为private,外部无法调用
    @Setter(AccessLevel.PRIVATE)
    private String email;
}
