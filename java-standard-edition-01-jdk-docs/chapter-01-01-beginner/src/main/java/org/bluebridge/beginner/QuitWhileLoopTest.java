package org.bluebridge.beginner;

import org.junit.Test;

public class QuitWhileLoopTest {
    
	/**
	 * 测试推出while循环
	 */
	@Test
	public void testQuitWhileLoop() {
        boolean loop = true;
        int i = 0;
        while(loop){
            System.out.println(i);
            i++;
            if(i == 200){
                loop = false;
            }
        }
	}
}
