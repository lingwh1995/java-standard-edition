package org.bluebridge.java9.interfac;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public void methodAbstract() {
        System.out.println("我是实现类中的抽象方法...");
    }

    @Override
    public void methodDefault() {
        System.out.println("我是实现类中的默认方法...");
    }
}
