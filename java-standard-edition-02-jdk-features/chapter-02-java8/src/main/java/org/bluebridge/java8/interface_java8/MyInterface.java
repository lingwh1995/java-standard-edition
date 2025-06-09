package org.bluebridge.java8.interface_java8;

public interface MyInterface {
    /**
     * 定义一个静态方法
     */
    static void staticMethod() {
        System.out.println("我是接口中的静态方法......");
    }

    /**
     * 定义一个默认方法
     */
    default void defaultMethod() {
        System.out.println("我是接口中的默认方法......");
    }
}
