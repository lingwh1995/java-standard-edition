package org.bluebridge.beginner;

/**  
 * 模拟goto:打印101到150之间的质数
 * @author ronin  
 * @date 2019年4月10日  
 *    
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lingwh
 * @desc   模拟goto:打印101到150之间的质数测试
 * @date   2019/4/10 13:39
 */
@Slf4j(topic = "·")
public class TagContinueTest {

	@Test
	public void testTagContinue() {
		outer:for(int i = 101; i < 150; i++){
			for(int j = 2; j < i/2; j++){
				if(i % j == 0){
					continue outer;
				}
			}
			log.info("{}",i);
		}
	}

}
