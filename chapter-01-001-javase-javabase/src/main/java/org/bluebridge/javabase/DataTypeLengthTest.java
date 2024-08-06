package org.bluebridge.javabase;


import org.junit.Test;

/**
 * 数据类型长度
 */
public class DataTypeLengthTest {
	@Test
	public void fun() {
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
}
