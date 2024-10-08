package org.bluebridge.api;


import org.junit.Test;

/**
 * java.lang.Class<T>高级API
 * @author ronin
 * @date 2019年3月28日  
 *    
 */
public class ClassTest {
	
	/**
	 * 根据Class信息判断一个对象是不是数组
	 * @param
	 * @return void
	 * @throws
	 */
	@Test
	public void isArrayTest(){
		int[] arr = {1,2,3,4,5};
		String  str = "zhagnsan";
		System.out.println(arr.getClass().isArray());
		System.out.println(str.getClass().isArray());
	}
	
	/**
	 * 根据Class信息获取该Class对象的SuperClass信息
	 * @param
	 * @return void
	 * @throws
	 */
	@Test
	public void getSuperClassTest(){
		int[] nums = {1,2,3,4,5};
		String  str = "zhagnsan";
		Class<? extends int[]> numsClass = nums.getClass();
		Class<?> numsSuperclass = numsClass.getSuperclass();
		System.out.println("nums对象的SuperClass:"+numsSuperclass);
		
		Class<? extends String> stringClass = str.getClass();
		Class<?> stringSuperclass = stringClass.getSuperclass();
		System.out.println("str对象的SuperClass:"+stringSuperclass);
	}
	
	/**
	 * 获取返回表示数组组件类型的 Class
	 * @param
	 * @return void
	 * @throws
	 */
	@Test
	public void getComponentTypeTest(){
		Integer[] nums = new Integer[4];
		/**
		 * 获取返回表示数组组件类型的 Class
		 */
		System.out.println("getComponentType():"+nums.getClass().getComponentType());//class java.lang.Integer
		System.out.println("getName():"+nums.getClass().getName());//[Ljava.lang.Integer;
		
		String string = "我是你爸爸";
		System.out.println("getComponentType():"+string.getClass().getComponentType());//null
		System.out.println("getName():"+string.getClass().getName());//java.lang.String
	}

	/**
	 * 判断对象是否枚举)
	 * @param 
	 * @return void
	 * @throws
	 */
	@Test
	public void isEnumTest(){
		Integer[] nums = new Integer[4];
		System.out.println("判断对象是不是枚举:"+nums.getClass().isEnum());
	}

	@Test
	public void getNameAndGetSimpleName() {
		String str = "hello world~";
		System.out.println("str.getClass().getSimpleName() = " + str.getClass().getSimpleName());
		System.out.println("str.getClass().getName() = " + str.getClass().getName());
	}

}
