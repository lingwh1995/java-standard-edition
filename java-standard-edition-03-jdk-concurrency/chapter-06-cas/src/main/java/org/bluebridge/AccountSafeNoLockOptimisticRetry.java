package org.bluebridge;

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
        while (true) {
            int prev = balance.get();
            int next = prev - amount;
            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-1 * amount);
    }
}