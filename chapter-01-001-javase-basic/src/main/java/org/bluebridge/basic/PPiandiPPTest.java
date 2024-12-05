package org.bluebridge.basic;

import org.junit.Test;

/**
 * i++和++i
 */
public class PPiandiPPTest {

	/**
	 * 测试i++和++i
	 */
	@Test
	public void testPPiandiPP() {
        int i = 0;
        System.out.println(++i);
        int j = 0;
        System.out.println(j++);
        System.out.println("----------------------------------");

        int a = 10,b = 10;
        int x = ++a;
        System.out.println("x:" + x);
        System.out.println("a:" + a);
        x = b++;
        System.out.println("x:" + x);
        System.out.println("b:" + b);
	}
}
