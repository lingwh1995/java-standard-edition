package org.bluebridge.beginner;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author lingwh
 * @desc   i++和++i测试
 * @date   2025/5/3 16:58
 */
@Slf4j(topic = "·")
public class PPiandiPPTest {

	/**
	 * 测试i++和++i
	 */
	@Test
	public void testPPiandiPP() {
        int i = 0;
        log.info("++i: {}", ++i);
        int j = 0;
        log.info("j++: {}", j++);
        log.info("----------------------------------");

        int a = 10,b = 10;
        int x = ++a;
        log.info("x: {}", x);
        log.info("a: {}", a);
        x = b++;
        log.info("x: {}", x);
        log.info("b: {}", b);
	}

}
