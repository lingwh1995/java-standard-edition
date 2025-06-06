package org.bluebridge.beginner;

import org.junit.Test;

/**
 * 可变参数
 */
public class VarargsTest {
    /**
     * 可变参数:
     * 		1.只有最后一个形参才能被定义成可变参数
     * 		2.一个方法的形参列表中只能有一个可变参数
     * 		3.方法的形参数组,如:fun(int[] nums)也可以实现可变参数的效果，但是调用时较为复杂，可变参数调用时就简单很多了
     * 		4.可变参数底层也是通过数组实现，获取该可变参数的具体类型，根据该类型创建该类型的形参数组
     * 		5.泛型不可以和可变参数配置使用,如:fun(T... args)
     */

    /**
     * 测试java的可变参数
     */
    @Test
    public void testVariableArguments() {
        /**
         * 传递多个String类型参数
         */
    	testVariableArguments1(1,"乒乓","篮球");
        /**
         * 传递一个String[]类型的参数
         */
    	testVariableArguments1(2,new String[]{"唱歌","听音乐"});
        /**
         * 接收并转发可变参数
         */
    	testVariableArguments2(3,new String[]{"吃饭","睡觉"});

        /**
         * 可变参数和泛型配合使用
         */
    	testVariableArguments3(4,"hello",123);
    	testVariableArguments3(4,123,"world");
    }

    /**
     * @Title: testVarArgs1
     * 接收并处理可变参数:
     * 			1.只有最后一个形参可以作为可变参数
     * 			2.可变参数类型为:多个String字符串/一个String[])
     * @param
     * @return void
     * @throws
     */
    private static void testVariableArguments1(int age,String... favorites) {
        System.out.println("#可变参数接收多个String字符串/一个String[]:");
        System.out.println("第一个参数:" + age);
        System.out.println("可变参数的类型:" + favorites.getClass().getSimpleName());
        System.out.print("第二个参数:");
        for(String favorite:favorites){
            System.out.print(favorite+" ");
        }
        System.out.println("\n-------------------------------------------");
    }


    /**
     * 接收转发可变参数
     * @param
     * @return void
     * @throws
     */
    private static void testVariableArguments2(int age,String... favorites) {
        System.out.println("#可变参数转发:");
        testVariableArguments1(age,favorites);
    }

    /**
     * @param <T>
     * 可变参数和泛型转发使用
     * @param
     * @return void
     * @throws
     */
    private static <T> void testVariableArguments3(int age,T... favorites) {
        System.out.println("#可变参数和泛型配合使用:");
        System.out.println("第一个参数:" + age);
        System.out.println("可变参数的类型:" + favorites.getClass().getSimpleName());
        System.out.print("第二个参数:");
        for(T favorite:favorites){
            System.out.print(favorite+" ");
        }
        System.out.println("\n-------------------------------------------");
    }
}
