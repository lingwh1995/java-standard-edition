package org.bluebridge.java8.functioninterface;//package org.bluebridge.java8.functioninterface;
//
//import java.util.function.Function;
//
///**
// * @author ronin
// */
//public class FunctionFunctionInterfaceTest {
//    public static void main(String[] args) {
//        FunctionFunctionInterfaceTest function = new FunctionFunctionInterfaceTest();
//        /**
//         * 测试apply()
//         */
//        System.out.println(function.apply("apply", value -> value));
//        System.out.println(function.apply("apply", value -> {return value;}));
//        /**
//         * 把行为作为参数传递给方法,之前的方法是先把行为定义好,现在是使用的时候把行为作为参数传递给方法
//         * 不是面向对象的编程(命令式编程),是函数式编程,具体行为由方法的传递进行告知,告知给apply(T t)方法
//         * 行为:value -> 2 * value,输入参数是value,返回 2 * value
//         */
//        System.out.println(function.compute(5, value -> 2 * value));
//        System.out.println(function.compute(5, value ->{return 8 + value;}));
//        System.out.println(function.convert(5,value->{return value+"hello lambda!";}));
//
//        Function<Integer,Integer> lambdaExpression = value -> 3 * value;
//        System.out.println(function.compute(18,lambdaExpression));
//
//        /**
//         * 函数组合
//         */
//        System.out.println(function.compose(2,value->value *3,value->value * value));
//        System.out.println(function.andThen(2,value->value *3,value->value * value));
//    }
//
//    /**
//     * apply():传入一个参数,返回一个值
//     * @param string
//     * @param function
//     * @return
//     */
//    public String apply(String string,Function<String,String> function){
//        return function.apply(string);
//    }
//
//    /**
//     * 高阶函数:接收一个函数作为参数
//     * @param i
//     * @param function
//     * @return
//     */
//    public int compute(int i, Function<Integer,Integer> function){
//        return function.apply(i);
//    }
//
//    /**
//     * 高阶函数:接收一个函数作为参数
//     * @param i
//     * @param function
//     * @return
//     */
//    public String convert(int i,Function<Integer,String> function){
//        return function.apply(i);
//    }
//
//    /**
//     * 函数串联
//     * @param i
//     * @param function1
//     * @param function2
//     * @return
//     */
//    public int compose(Integer i,Function<Integer,Integer> function1,Function<Integer,Integer> function2){
//        return function1.compose(function2).apply(i);
//    }
//
//    /**
//     * 函数串联
//     * @param i
//     * @param function1
//     * @param function2
//     * @return
//     */
//    public int andThen(Integer i,Function<Integer,Integer> function1,Function<Integer,Integer> function2){
//        return function1.andThen(function2).apply(i);
//    }
//}
