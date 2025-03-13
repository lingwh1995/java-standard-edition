package org.bluebridge.cas_02_demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的实现-无锁（乐观重试）
 */
public class AccountSafeNoLockOptimisticRetry implements Account{

    private AtomicInteger balance;

    public AccountSafeNoLockOptimisticRetry(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        // 需要不断尝试，直到成功为止
        while (true) {
            // 比如拿到了旧值 1000
            int expectedValue = balance.get();
            // 新的值 = 在这个基础上 1000-10 = 990
            int newValue = expectedValue - amount;
            if (balance.compareAndSet(expectedValue, newValue)) {
                break;
            }
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-1 * amount);
    }
}