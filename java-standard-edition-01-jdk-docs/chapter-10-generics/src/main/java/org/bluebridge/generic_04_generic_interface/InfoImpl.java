package org.bluebridge.generic_04_generic_interface;

// 定义泛型接口的子类(使用String填充泛型)
public class InfoImpl implements Info<String>{
    // 定义属性
    private String var;
    // 通过构造方法设置属性内容
    public InfoImpl(String var){
        this.setVar(var);
    }
    @Override
    public void setVar(String var){
        this.var = var;
    }
    @Override
    public String getVar(){
        return this.var;
    }
}