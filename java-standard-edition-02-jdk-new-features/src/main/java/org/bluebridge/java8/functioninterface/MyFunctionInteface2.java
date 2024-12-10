package org.bluebridge.java8.functioninterface;

/**
 * 测试被default修饰的方法
 * @author ronin
 */
public interface MyFunctionInteface2 {
    default void method(){
        System.out.println("method......MyFunctionInteface2");
    }
    default void fun(){
        System.out.println("fun......MyFunctionInteface2");
    }
}
