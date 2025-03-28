package org.bluebridge.generic_05_generic_class_1;

// 定义泛型接口的子类(构造了一个泛型类InfoImpl<T>，然后把泛型变量T传给了Info<T>，这说明接口和泛型类使用的都是同一个泛型变量。)
public  class InfoImpl<T> implements Info<T>{
    // 定义属性
    private T var ;
    // 通过构造方法设置属性内容
    public InfoImpl(T var){
        this.setVar(var) ;
    }
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
}
