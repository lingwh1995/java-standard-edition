package org.bluebridge.basic;

import org.junit.Test;

import java.util.Random;

/**
 * java中没有goto,但是可以使用break和continue实现类似于goto的效果
 */
public class GotoTest {
	
	@Test
	public void testGoto() {
        outer:
        for (int i = 0; i < 10; i++) {
            System.out.println("outer_loop:" + i);
            for (int k = 0; i < 10; k++) {
                System.out.print(k + " ");
                int x = new Random().nextInt(10);
                if (x > 7) {
                    System.out.print(" >>x == " + x + ",结束inner循环，继续迭代执行outer循环了！");
                    continue outer;
                }
                if (x == 1) {
                    System.out.print(" >>x == 1,跳出并结束整个outer和inner循环！");
                    break outer;
                }
            }
        }
        System.out.println("------>>>所有循环执行完毕！");
	}
}
