/**  
 * @author ronin
 * @date 2019年3月26日  
 * @version V1.0  
 */ 
package org.bluebridge.javassist.domain;


import lombok.Data;

/**
 * @author lingwh
 * @desc 测试hsqldb基本功能
 * @date 2025/8/18 14:30
 */
@Data
public class Employee {
	private String id;
	private int age;
	private String name;

	public Employee() {
		super();
	}

	public String sayHello(String param){
		System.out.println("我是参数:"+param);
		return "I am ok!";
	}
	
}
