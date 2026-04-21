package org.bluebridge.generic_05_generic_class_1;

// 在接口上定义泛型
public  interface Info<T>{
    // 在方法返回值处使用泛型
    T getVar();
    // 在方法形参处使用泛型
    void setVar(T var);
}
