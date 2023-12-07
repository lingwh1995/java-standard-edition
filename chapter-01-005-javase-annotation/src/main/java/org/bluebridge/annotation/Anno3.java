package org.bluebridge.annotation;

/**
 * 注解的value属性
 */
public @interface Anno3 {
    //如果该注解只有一个属性而且该属性的值名为value，则在使用时可以直接写@Anno3(100)，而不需要写@Anno3(value=100)
    int value();
    String name() default "zhangsan";
}
