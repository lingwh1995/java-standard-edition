package org.bluebridge.java8.lambda;

import org.junit.Test;

/**
 * @author ronin
 */
public class LambdaThread {
    
	@Test
	public void testLambdaHelloWorld() {
    	/**
    	 * 不使用lambda函数创建线程
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
	}
}
