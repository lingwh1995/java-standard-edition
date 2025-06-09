package org.bluebridge.java8.lambda;

import java.io.Serializable;

public class LambdaTest1 {

	/**
	 * 普通的方法
	 * @param a
	 * @param b
	 * @return
	 */
	static int add(int a, int b) {
		return a + b;
	}
	
	/**
	 * 函数式接口
	 */
	@FunctionalInterface
	interface LambdaCalculator extends Serializable {
		int calc(int a, int b);
	}
	
	// 使用对象来表示函数
	static LambdaCalculator add = (a,b) -> a + b;
	static LambdaCalculator sub = (a,b) -> a - b;
	static LambdaCalculator mul = (a,b) -> a * b;
	static LambdaCalculator div = (a,b) -> a / b;
	
	
	public static void main(String[] args) {
		// 调用普通的方法
		System.out.println(LambdaTest1.add(1, 2));
		
		//调用Lambda对象
		System.out.println(add.calc(100,10));
		System.out.println(sub.calc(100,10));
		System.out.println(mul.calc(100,10));
		System.out.println(div.calc(100,10));
	}

}
