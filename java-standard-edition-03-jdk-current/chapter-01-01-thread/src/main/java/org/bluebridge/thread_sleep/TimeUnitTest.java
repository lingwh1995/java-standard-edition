package org.bluebridge.thread_sleep;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 使用 TimeUnit.SECONDS.sleep(10) 代替 Thread.sleep() ,使得代码可读性更强
 */
public class TimeUnitTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("TimeUnit test start...");
        TimeUnit.MILLISECONDS.sleep(2000);
        //TimeUnit.SECONDS.sleep(2);
        System.out.println("TimeUnit test end...");
    }
}
