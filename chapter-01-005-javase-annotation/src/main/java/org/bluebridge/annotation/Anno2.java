package org.bluebridge.annotation;

/**
 * 注解的属性和属性的默认值
 */
public @interface Anno2 {
    //注解的属性
    int age();
    String name();
    //为注解的属性设置默认值
    String school() default "UFE";
}
