package org.bluebridge.java9.interfac;

import org.junit.Test;

public class TestInvokeInterfaceMethod {

    /**
     * 测试调用接口中的抽象方法
     */
    @Test
    public void testInvokeMethodAbstract() {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.methodAbstract();
    }

    /**
     * 测试调用接口中的静态方法
     */
    @Test
    public void testInvokeMethodStatic() {
        //接口中的静态方法只能直接由接口调用，接口的实现类是不能调用这个方法的
        MyInterface.methodStatic();
    }

    /**
     * 测试调用接口中的默认方法
     */
    @Test
    public void testInvokeMethodDefault() {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.methodDefault();
    }
}
