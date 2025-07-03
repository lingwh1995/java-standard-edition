package org.bluebridge.beginner;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lingwh
 * @desc   退出while循环测试
 * @date   2025/5/3 16:58
 */
@Slf4j(topic = "·")
public class QuitWhileLoopTest {
    
	/**
	 * 测试推出while循环
	 */
	@Test
	public void testQuitWhileLoop() {
        boolean loop = true;
        int i = 0;
        while(loop){
            log.info("i: {}", i);
            i++;
            if(i == 20){
                loop = false;
            }
        }
	}

}
