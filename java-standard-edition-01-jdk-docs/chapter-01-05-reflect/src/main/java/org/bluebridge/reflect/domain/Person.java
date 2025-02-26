package org.bluebridge.reflect.domain;


/**  
 * 反射操作的类
 * @author ronin  
 * @date 2019年3月10日  
 *    
 */
public class Person {
	private String name;
	private String age;
	
	public Person() {
		System.out.println("我是无参构造方法...");
	}
	
	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
