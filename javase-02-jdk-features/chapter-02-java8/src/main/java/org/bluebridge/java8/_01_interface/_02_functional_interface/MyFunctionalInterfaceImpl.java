package org.bluebridge.java8._01_interface._02_functional_interface;

/**
 * @author lingwh
 * @desc 实现函数式接口中的抽象方法
 * @date 2025/12/2 15:22
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface{

    @Override
    public void abstractMethod() {
        System.out.println("我是实现类中的抽象方法......");
    }

}
