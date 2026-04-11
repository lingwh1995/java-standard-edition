package org.bluebridge.generic_06_generic_class_2;

// 定义泛型接口的子类
public class InfoImpl<T,K,U> implements Info<U>{
    private U var ;
    private T x;
    private K y;
    // 通过构造方法设置属性内容
    public InfoImpl(U var){
        this.setVar(var) ;
    }
    public void setVar(U var){
        this.var = var ;
    }
    public U getVar(){
        return this.var ;
    }
}
