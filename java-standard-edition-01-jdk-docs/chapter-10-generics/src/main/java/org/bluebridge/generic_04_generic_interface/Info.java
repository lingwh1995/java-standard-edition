package org.bluebridge.generic_04_generic_interface;

//在接口上定义泛型
public interface Info<T>{
    // 在抽象方法的返回值处使用泛型
    T getVar();
    // 在抽象方法的形参处使用泛型
    void setVar(T x);
}
