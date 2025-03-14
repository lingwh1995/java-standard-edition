package org.bluebridge.cas_02_atomic_integer;

/**
 * 线程安全的实现-悲观锁（synchronized）
 */
public class AccountSafePessimisticLockSynchronized implements Account {

    private Integer balance;

    public AccountSafePessimisticLockSynchronized(Integer balance) {
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