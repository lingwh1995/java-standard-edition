package org.bluebridge.api;

/**  
 * String、StringBuffer、StringBuilder区别
 * @author ronin  
 * @date 2019年4月14日  
 *    
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder("aaaa");
		//stringBuilder.setCharAt(0, '1');
		stringBuilder.insert(0, '1');
		stringBuilder.insert(0, "前驱").insert(0, "链式");
		System.out.println(stringBuilder.toString());
		stringBuilder.delete(0, 1);
		System.out.println(stringBuilder.toString());
		//https://www.jianshu.com/p/31dc06d4c137
	}
}
