package org.bluebridge.ioc.anno_one.test;


import org.bluebridge.ioc.anno_one.factory.ClassPathAnnoApplicationContext;

/**
 * @author ronin
 * @date 2019年3月20日  
 *    
 */
public class ClassPathAnnoApplicationContextTest {
	public static void main(String[] args) {
		ClassPathAnnoApplicationContext applicationContext = new ClassPathAnnoApplicationContext("applicationContext-ioc-anno-one.xml");
	}
}
