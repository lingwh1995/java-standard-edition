package org.bluebridge.java8.functioninterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author ronin
 */
public class BiFunctionFunctionInterfaceTest {
    public static void main(String[] args) {
        BiFunctionFunctionInterfaceTest function = new BiFunctionFunctionInterfaceTest();
        /**
         * 加法运算
         */
        System.out.println("加法:"+function.compute(4, 2, (v1, v2) -> v1 + v2));
        /**
         * 减法运算
         */
        System.out.println("减法:"+function.compute(4, 2, (v1, v2) -> v1 - v2));
        /**
         * 乘法法运算
         */
        System.out.println("乘法:"+function.compute(4, 2, (v1, v2) -> v1 * v2));
        /**
         * 除法运算
         */
        System.out.println("除法:"+function.compute(4, 2, (v1, v2) -> v1 / v2));

        /**
         * BiFunction函数串联
         */
        System.out.println(function.addThen(2, 3, (v1, v2) -> v1 + v2, v3 -> v3 * 3));
    }

    /**
     * BiFunction<T,U,R>:接收一个T类型和U类型参数,返回一个R类型参数
     * @param a
     * @param b
     * @param function
     * @return
     */
    public int compute(Integer a, Integer b, BiFunction<Integer,Integer,Integer> function){
        return function.apply(a, b);
    }

    /**
     * BiFunction函数串联
     * @param a
     * @param b
     * @param bifunction
     * @param function
     * @return
     */
    public int addThen(Integer a, Integer b, BiFunction<Integer,Integer,Integer> bifunction,Function<Integer,Integer> function){
        return bifunction.andThen(function).apply(a, b);
    }
}

