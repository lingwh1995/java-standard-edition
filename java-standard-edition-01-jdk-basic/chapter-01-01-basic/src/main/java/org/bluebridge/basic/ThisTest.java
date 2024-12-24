package org.bluebridge.basic;

import org.junit.Test;

/**  
 * this的用法
 * @author ronin
 * @date 2019年4月10日  
 */
public class ThisTest {
	
	@Test
	public void test() {
		/**
		 * 测试区分二义性
		 */
		This_Identifier this_Identifier = new This_Identifier();
		this_Identifier.say(5);
		
		/**
		 * 测试调用有参无参方法
		 */
		new This_Identifier(1,2,3);
	}
	
}

/**  
 * this的用法
 * @author ronin
 * @date 2019年4月10日  
 */
class This_Identifier {
	
	/**
	 * this的用法:
	 * 		1.区分二义性
	 * 		2.调用当前类有参或者无参方法
	 */
	int a = 10;
	public void say(int a){
		System.out.println(this.a);
		System.out.println(a);
	}
	
	
	/**  
	 * 创建一个新的实例 This_Identifier.  
	 */ 
	public This_Identifier() {
		System.out.println("我是无参构造方法......");
	}
	
	
	/**  
	 * 创建一个新的实例 This_Identifier.  
	 */ 
	public This_Identifier(int a,int b) {
		this();
		System.out.println("我是第一个有参构造方法......");
		//System.out.println(a+"---"+b);
	}
	
	/**  
	 * 创建一个新的实例 This_Identifier.  
	 */ 
	public This_Identifier(int a,int b,int c) {
		this(a,b);
		System.out.println("我是第二个有参构造方法......");
	}
	
}
