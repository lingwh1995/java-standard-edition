package org.bluebridge.java8.functioninterface;

import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorTest {
    public static void main(String[] args) {
        //匿名内部类方式使用 IntUnaryOperator
        IntUnaryOperator cube = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                return x * x * x;
            }
        };
        System.out.println("Cube Value: " + cube.applyAsInt(2));

        // 定义平方操作
        IntUnaryOperator square = (x) -> x * x;

        // 定义绝对值操作
        IntUnaryOperator absolute = (x) -> x < 0 ? -x : x;

        // 使用操作
        int squaredValue = square.applyAsInt(5);   // 25
        int absoluteValue = absolute.applyAsInt(-10); // 10

        System.out.println("Squared Value: " + squaredValue);
        System.out.println("Absolute Value: " + absoluteValue);
    }
}
