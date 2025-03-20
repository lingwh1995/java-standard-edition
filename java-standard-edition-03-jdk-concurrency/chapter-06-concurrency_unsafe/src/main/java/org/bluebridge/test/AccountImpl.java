package org.bluebridge.test;

/**
 * 实现账户类，使用手动实现的原子整数作为余额类型
 */
public class AccountImpl implements Account{
    UnsafeAtomicInteger balance;

    public AccountImpl(int balance){
        this.balance = new UnsafeAtomicInteger(balance);
    }

    @Override
    public int getBalance() {
        return balance.get();
    }

    @Override
    public void decrease(int amount) {
        balance.getAndAccumulate(amount,(x,y) -> y - x);
    }
}
