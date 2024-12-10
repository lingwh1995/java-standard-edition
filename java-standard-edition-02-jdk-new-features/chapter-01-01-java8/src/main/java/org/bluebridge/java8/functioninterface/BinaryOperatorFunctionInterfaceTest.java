package org.bluebridge.java8.functioninterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author ronin
 */
public class BinaryOperatorFunctionInterfaceTest {
    public static void main(String[] args) {
        System.out.println(compute(1, 2, (a, b) -> a + b));
        sort("a","bb",(a,b)->a.length()-b.length());
    }

    /**
     * 四则运算
     * @param a
     * @param b
     * @param binaryOperator
     * @return
     */
    public static int compute(Integer a, Integer b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

    /**
     * 排序
     * @param a
     * @param b
     * @param comparator
     * @return
     */
    public static String sort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}

