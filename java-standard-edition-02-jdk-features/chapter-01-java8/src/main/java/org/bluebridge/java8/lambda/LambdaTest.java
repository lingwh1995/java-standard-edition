package org.bluebridge.java8.lambda;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

import org.junit.Test;

/**
 * @author ronin
 */
public class LambdaTest {

	/**
	 * 测试分别使用匿名内部类和lambda表达式创建一个线程
	 */
	@Test
	public void testLambdaThread() {
		/**
		 * 使用匿名内部类方式创建线程
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread1 is running......");
			}
		}).start();

		/**
		 * 使用lambda函数创建线程
		 */
		new Thread(() -> {
			System.out.println("Thread2 is running......");
		}).start();

		/**
		 * 使用lambda函数创建线程(简写形式)
		 */
		new Thread(() -> System.out.println("Thread2 is running......")).start();

		/**
		 * 使用lambda函数创建线程(创建线程和调用分开写)
		 */
		Runnable t3 = () -> System.out.println("Thread3 is running......");
		//注意：这里调用要用run()方法
		t3.run();
	}


	/**
	 * 测试使用匿名内部类方式和lambda方式调用参数为 IntBinaryOperator 接口方法
	 */
	@Test
	public void testIntBinaryOperator() {
		/**
		 * 使用匿名内部类方式调用方法
		 */
		int result = calculateNum(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return left + right;
			}
		});
		System.out.println("不使用lambda方式调用:" + result);

		/**
		 * 使用lambda方式调用
		 */
		result = calculateNum((int left, int right) -> {
			return left + right;
		});
		System.out.println("使用lambda方式调用:" + result);

		/**
		 * 使用lambda方式调用(简写形式)
		 */
		result = calculateNum((int left, int right) -> left + right);
		System.out.println("使用lambda方式调用(简写形式):" + result);
		
		/**
		 * 使用lambda方式调用(最简写形式)
		 */
		result = calculateNum((left, right) -> left + right);
		System.out.println("使用lambda方式调用(简写形式):" + result);
	}

	/**
	 * 这个方法的参数是一个接口
	 * 
	 * @param operator
	 * @return
	 */
	public static int calculateNum(IntBinaryOperator operator) {
		return operator.applyAsInt(10, 20);
	}


	/**
	 * 测试使用匿名内部类方式和lambda方式调用参数为 IntBinaryOperator 接口方法
	 */
	@Test
	public void testIntPredicate() {
		/**
		 * 使用匿名内部类方式调用方法
		 */
		filterNum(new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value % 2 == 0 ? true : false;
			}
		});

		/**
		 * 使用lambda方式调用
		 */
		filterNum((value) -> {
			return value % 2 == 0 ? true : false;
		});

		/**
		 * 使用lambda方式调用(简写形式)
		 */
		filterNum(value -> value % 2 == 0 ? true : false);
	}

	/**
	 * 这个方法的参数是一个接口
	 * 
	 * @param predicate
	 * @return
	 */
	public static void filterNum(IntPredicate predicate) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int num : nums) {
			if (predicate.test(num)) {
				System.out.println(num);
			}
		}
	}

	
	@Test
	public void testComparator() {
		/**
		 * 使用匿名内部类调用
		 */
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		int result = comparator.compare(10, 20);
		System.out.println(result);
		
		/**
		 * 使用lambda方式调用
		 */
		comparator = (Integer o1, Integer o2) -> Integer.compare(o1, o2);
		result = comparator.compare(20, 10);
		System.out.println(result);
		
		/**
		 * 使用lambda方式调用(简写形式)
		 */
		comparator = (o1, o2) -> Integer.compare(o1, o2);
		result = comparator.compare(20, 10);
		System.out.println(result);
		
		/**
		 * 使用lambda方式调用(最简写形式:方法引用)
		 */
		comparator = Integer :: compare;
		result = comparator.compare(20, 10);
		System.out.println(result);
	}
}
