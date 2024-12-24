package org.bluebridge.beginner;

import org.junit.Test;

/**  
 * 这里用一句话描述这个类的作用
 * @author ronin  
 * @date 2019年3月12日  
 */
public class FinalTest {

	/**
	 * final修饰变量的初始化时机:
	 * 		A.被final修饰的变量只能赋值一次
	 * 		B.在构造方法完毕前(非静态的常量) 
	 */
	
	int num1 = 10;
	final int num2 = 100;
	
	/**
	 * 没有被final修饰的全部变量可以不初始化，但是被final修饰的全局变量一定要初始化
	 */
	int num3 ;
	
	@Test
	public void testFinal1(){
		num1 = 120;
		//如果要改变被final修饰的num2的值，则会报错
		//num2 = 200;
	}
	
    @Test
    public void testFinal2() {
        String str = "hello2";
        final String a = "hello";
        String b = "hello";
        String c = a + 2;
        String d = b + 2;
        String e = a + getHello();
        String f = b + getHello();
        System.out.println(str == c);
        System.out.println(str == d);
        System.out.println(str == e);
        System.out.println(str == f);
    }

    public static String getHello() {
        return "hello";
    }
}
