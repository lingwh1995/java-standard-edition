package javabase;


import org.junit.Test;

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
	}
}
