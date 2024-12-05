package org.bluebridge.basic;


import org.junit.Test;

/**
 *	Java数据类型分为基本数据类型和引用数据类型
 *  	1. 基本数据类型：包括 整数类型(byte、short、int、long)、浮点数类型(float、double)、字符类型(char)、布尔类型(boolean)。
 *  	2. 引用数据类型：包括数组、 类、接口、枚举、注解、记录。
 *
 *	浮点类型详细说明
 *		1. 浮点类型的分类
 *	   		● float：单精度，尾数可以精确到7位有效数字。很多情况下，精度很难满足需求。
 *			● double：双精度，精度是float的两倍。通常采用此类型。
 * 		2. 浮点型常量有两种表示形式：
 *	    	● 十进制数形式。如：5.12       512.0f        .512   (必须有小数点）
 *			● 科学计数法形式。如：5.12e2      512E2     100E-2
 *		3.浮点类型实际使用
 *			● 定义float类型的变量，赋值时需要以"f"或"F"作为后缀。
 *			● Java 的浮点型常量默认为double型。
 *		4.浮点类型使用注意事项
 *			浮点类型float、double的数据不适合在不容许舍入误差的金融计算领域。如果需要精确数字计算或保留指定位数的精度，需要使用BigDecimal类。
 */
public class DataTypeTest {

	/**
	 * 测试各种数类型的长度
	 */
	@Test
	public void testDataTypeLength() {
		System.out.println("Byte类型数据所占字节长度:" + Byte.BYTES + ",Byte类型数据所占位数:"+Byte.SIZE);
		System.out.println("Short类型数据所占字节长度:" + Short.BYTES + ",Short类型数据所占位数:"+Short.SIZE);
		System.out.println("Integer类型数据所占字节长度:" + Integer.BYTES + ",Integer类型数据所占位数:"+Integer.SIZE);
		System.out.println("Long类型数据所占字节长度:" + Long.BYTES + ",Long类型数据所占位数:"+Long.SIZE);
		System.out.println("Double类型数据所占字节长度:" + Double.BYTES + ",Double类型数据所占位数:"+Double.SIZE);
		System.out.println("Float类型数据所占字节长度:" + Float.BYTES + ",Float类型数据所占位数:"+Float.SIZE);
		System.out.println("Character类型数据所占字节长度:" + Character.BYTES + ",Character类型数据所占位数:"+Character.SIZE);

		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Byte类型数据最小值:" + Byte.MIN_VALUE + ",Byte类型数据最大值:" + Byte.MAX_VALUE);
		System.out.println("Short类型数据最小值:" + Short.MIN_VALUE + ",Short类型数据最大值:" + Short.MAX_VALUE);
		System.out.println("Integer类型数据最小值:" + Integer.MIN_VALUE + ",Integer类型数据最大值:" + Integer.MAX_VALUE);
		System.out.println("Long类型数据最小值:" + Long.MIN_VALUE + ",Long类型数据最大值:" + Long.MAX_VALUE);
		System.out.println("Float类型数据最小值:" + Float.MIN_VALUE + ",Float类型数据最大值:" + Float.MAX_VALUE);
		System.out.println("Double类型数据最小值:" + Double.MIN_VALUE + ",Double类型数据最大值:" + Double.MAX_VALUE);
	}

	/**
	 * 测试float和double类型数据精度
	 * 		通过测试可以看到浮点数在计算时有时会引入舍入丢失精度，所以在金融等领域要求精确计算时不能使用浮点类型来定义小数
	 */
	@Test
	public void testFloatAndDoubleAccuracy() {
		//测试1
		float f1 = 0.1f;
		float f2 = 0.2f;
		float f3 = f1 + f2;
		System.out.println("f3 = " + f3);

		//测试2：
		float ff1 = 123123123f;
		float ff2 = ff1 + 1;
		System.out.println(ff1);
		System.out.println(ff2);
		System.out.println(ff1 == ff2);

		//测试3：可以看出 d1 + d2 并不等于 0.3
		double d1 = 0.1;
		double d2 = 0.2;
		double d3 = d1 + d2;
		System.out.println("d3 = " + d3);
	}
}
