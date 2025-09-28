package org.bluebridge.java8.lambda;

import org.junit.Test;

/**
 * lambda表达式的延迟执行特性
 */
public class LambdaTest3 {

    /**
     * 测试不使用lambda表达式 - 条件通过情况
     */
    @Test
    public void testPrintNoUseLambdaExpression1() {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        long start = System.currentTimeMillis();
        //1.条件通过情况
        printNoUseLambdaExpression(1, msgA + msgB + msgC);
        long end = System.currentTimeMillis();
        System.out.println("未使用lambda表达式花费时间:" + (end - start));
    }

    /**
     * 测试不使用lambda表达式 - 条件不通过情况
     */
    @Test
    public void testPrintNoUseLambdaExpression2() {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        long start = System.currentTimeMillis();
        //1.条件不通过情况
        printNoUseLambdaExpression(2, msgA + msgB + msgC);
        long end = System.currentTimeMillis();
        System.out.println("未使用lambda表达式花费时间:"+(end-start));
    }

    /**
     * 测试使用lambda表达式 - 条件不通过的情况
     *      可以观察到：当使用lambda表达式 - 条件不通过时，会大大的缩小代码的执行时间，因为这种写法有的逻辑不会执行
     */
    @Test
    public void testPrintUseLambdaExpression1() {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        long start = System.currentTimeMillis();
        //1.条件不通过的情况
        printUseLambdaExpression(2, () -> {
            System.out.println("Lambda执行！");
            return msgA + msgB + msgC;
        });
        long end = System.currentTimeMillis();
        System.out.println("未延迟执行花费时间:"+(end-start));
    }

    /**
     * 测试使用lambda表达式 - 条件不通过的情况
     */
    @Test
    public void testPrintUseLambdaExpression2() {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        long start = System.currentTimeMillis();
        //1.条件不通过的情况
        printUseLambdaExpression(1, () -> {
            System.out.println("Lambda执行！");
            return msgA + msgB + msgC;
        });
        long end = System.currentTimeMillis();
        System.out.println("未延迟执行花费时间:"+(end-start));
    }

    /**
     * 没有使用lambda表达式的方法
     * @param level
     * @param msg
     */
    private static void printNoUseLambdaExpression(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    /**
     * 使用了lambda表达式的方法
     * @param level
     * @param builder
     */
    private void printUseLambdaExpression(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());
        }
    }

    /*
     * 下面这个是函数式接口，方便lambda表达式的使用。
     */
    @FunctionalInterface
    interface MessageBuilder {
        String buildMessage();
    }

}

