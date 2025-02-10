package org.bluebridge.thread_sleep;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 使用 TimeUnit.SECONDS.sleep(10) 代替 Thread.sleep() ,使得代码可读性更强
 */
public class TimeUnitTest {

    @Test
    public void test() throws InterruptedException {
        System.out.println("TimeUnit test start...");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("TimeUnit test end...");
    }
}
