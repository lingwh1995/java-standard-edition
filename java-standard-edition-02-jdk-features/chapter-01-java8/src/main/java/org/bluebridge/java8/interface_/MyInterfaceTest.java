package org.bluebridge.java8.interface_;

public class MyInterfaceTest {
    public static void main(String[] args) {
        //直接调用接口中的静态方法
        MyInterface.staticMethod();

        //创建对象调用接口中的默认方法
        new MyInterfaceImpl().defaultMethod();
    }
}
