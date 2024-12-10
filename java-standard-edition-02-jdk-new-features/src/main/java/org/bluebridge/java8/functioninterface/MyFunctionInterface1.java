package org.bluebridge.java8.functioninterface;

/**
 * @author ronin
 */
@FunctionalInterface
public interface MyFunctionInterface1 {
    void fun();

    /**
     * 重写Object类中的方法不会影响@FunctionalInterface
     * @return
     */
    @Override
    String toString();

    /**
     * 放开报错,抽象方法的个数就超过一个了，不符合函数式接口规范
     */
    //void test();
}
