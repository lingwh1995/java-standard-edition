package org.bluebridge;

import org.junit.Test;

public class AccountTest {

    /**
     * 测试线程不安全的实现
     */
    @Test
    public void testAccountUnsafe() {
        Account.demo(new AccountUnsafe(10000));
    }

    /**
     * 测试线程安全的实现-无锁（乐观重试）
     */
    @Test
    public void testAccountSafePessimisticLock() {
        Account.demo(new AccountSafePessimisticLock(10000));
    }

    /**
     * 测试线程安全的实现-悲观锁
     */
    @Test
    public void testAccountSafeNoLockOptimisticRetry() {
        Account.demo(new AccountSafeNoLockOptimisticRetry(10000));
    }
}
