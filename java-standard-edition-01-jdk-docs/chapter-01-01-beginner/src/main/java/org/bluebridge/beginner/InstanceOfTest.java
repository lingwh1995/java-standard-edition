package org.bluebridge.beginner;

import org.junit.Test;

/**
 * instanceof关键字测试
 */
public class InstanceOfTest {
	
	/**
	 * 测试继承时子类是不是父类
	 */
	@Test
	public void testClassExtend(){
	    A aa = new AA();
	    System.out.println(aa instanceof AA);//true
	    System.out.println(aa instanceof A);//true
	}

	/**
	 * 测试实现时实现类是不是instanceof父接口
	 */
	@Test
	public void testImplementInterface(){
	    B bb = new BB();
	    System.out.println(bb instanceof BB);//true
	    System.out.println(bb instanceof B);//true
	}
}


class A{

}
class AA extends A{

}

interface B{

}

class BB implements B{

}