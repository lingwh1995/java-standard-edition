package org.bluebridge.test;

public class UnsafeAtomicTest {
    public static void main(String[] args) {
        //赋初始值10000，调用demo后正确的输出结果为0
        AccountImpl account = new AccountImpl(10000);
        //结果正确地输出0
        account.demo();
    }
}
