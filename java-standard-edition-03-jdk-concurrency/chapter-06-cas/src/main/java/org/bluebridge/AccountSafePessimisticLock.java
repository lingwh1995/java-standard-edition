package org.bluebridge;

/**
 * 线程安全的实现-悲观锁
 */
public class AccountSafePessimisticLock implements Account {

    private Integer balance;

    public AccountSafePessimisticLock(Integer balance) {
        this.balance = balance;
    }

    @Override
    public synchronized Integer getBalance() {
        return balance;
    }

    @Override
    public synchronized void withdraw(Integer amount) {
        balance -= amount;
    }
}