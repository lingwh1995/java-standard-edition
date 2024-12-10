package org.bluebridge.java8.functioninterface;

/**
 * @author ronin
 */
public class MyFunctionInteface2Test {
    public static void main(String[] args) {
        MyFunctionInteface2 functionInteface = new MyFunctionInteface2Impl();
        functionInteface.fun();
        functionInteface.method();
    }
}
