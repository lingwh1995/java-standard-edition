/**  
 * @author ronin
 * @date 2019年3月11日  
 * @version V1.0  
 */ 
package org.bluebridge.api;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * String类高级API
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public class StringTest {
	
	/**
	 * String的Join方法:使用指定的拼接符号把数组/集合中每一个元素拼接起来,拼成一个字符串
	 * @param
	 * @return void
	 * @throws
	 */
	@Test
	public void joinTest(){
		/*
		 * 拼接数组
		 */
		String[] nums = {"123","456","789"};
		String arrayJoinToString = String.join("-",nums);
		System.out.println(arrayJoinToString);
		/*
		 * 拼接集合
		 */
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		String listJoinToString = String.join("+",list);
		System.out.println(listJoinToString);
	}
	
	
	/**
	 * 判断两个字符串是否相等，不区分大小写的情况
	 * @param
	 * @return String
	 * @throws
	 */
	@Test
	public void equalsIgnoreCaseTest(){
		String s1 = "HELLO";
		String s2 = "hello";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
	}

	/**
	 * 返回索引位置的字符的ascii码
	 */
	@Test
	public void codePointTest(){
		String str = "abcde";
		System.out.println("str.codePointAt(0) = " + str.codePointAt(0));
	}

	/**
	 * 返回索引位置的前一个字符的ascii码，如果前面没有字符，即index<=0抛出下标越界异常
	 */
	@Test
	public void codePointBeforeTest(){
		String str = "abcde";
		System.out.println("str.codePointBefore(1) = " + str.codePointBefore(1));
	}

	/**
	 * 从指定索引位置开始算，返回指定索引位置到结尾处的码点数
	 * 		码点和长度的区别:
	 * 			这个emoj	 😂	 的编码是 \uD83D和\uDE02，这个emoj的长度是2，码点数是1
	 */
	@Test
	public void codePointCount() {
		String str = "abcde\uD83D\uDE02";
		System.out.println("str.length() = " + str.length());
		System.out.println("str.codePointCount(1, str.length()) = " + str.codePointCount(1, str.length()));
	}

	/**
	 * split:如果不传入分隔符，则把一个字符串转换为字符数组
	 */
	@Test
	public void splitTest() {
		String source = "abcdef";
		String[] split = source.split("");
		System.out.println(Arrays.toString(split));
	}

	/**
	 * valueOf和toString():
	 * valueOf()源码:
	 * public static String valueOf(Object obj) {
	 *		return (obj == null) ? "null" : obj.toString();
	 * }
	 */
	@Test
	public void valueOfAndToStringTest(){
		//valueOf():不会抛空指针异常
		Integer num = null;
		System.out.println(String.valueOf(num));
		//toString():会跑出空指针异常
	}

	@Test
	public void concatTest() {
		String str1 = "abc";
		String str2 = "de";
		System.out.println("str1.concat(str2) = " + str1.concat(str2));
	}

	@Test
	public void replaceTest() {
		String str1 = "abcdea";
		//替换全部target字符串，不支持正则
		System.out.println(str1.replace("a", "a_"));

		//替换全部符合正则表达式的字符串
		//public String replaceAll(String regex, String replacement)

		String str2 = "123451";
		//只替换第一个字符串
		System.out.println(str2.replace("1", "first"));
	}

	@Test
	public void compileTest() {
		//在编译期会进行优化
		String s1 = "q" + "e";	//编译优化后 String s1 = "qe";
		String s2 = "3";
		//编译时期不会做优化，因为编译的时候还不知道s1和s3代表的具体值是什么
		String s3 = s1 + s2;
		System.out.println(s3);
	}

	//%s字符串，%c字符，%d正数，%f浮点型
//	public static String format(String format, Object... args)
}
