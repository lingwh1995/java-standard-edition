package org.bluebridge.enumeration;

import org.junit.Test;

public class ResponseCodeEnumTest {

	/**
	 * 测试响应状态码枚举
	 */
	@Test
	public void testResponseCodeEnum() {
		ResponseCodeEnum success = ResponseCodeEnum.SUCCESS;
		System.out.println(success.getCode() + "," + success.getDesc());
		ResponseCodeEnum error = ResponseCodeEnum.ERROR;
		System.out.println(error.getCode() + "," + error.getDesc());
	}
}
