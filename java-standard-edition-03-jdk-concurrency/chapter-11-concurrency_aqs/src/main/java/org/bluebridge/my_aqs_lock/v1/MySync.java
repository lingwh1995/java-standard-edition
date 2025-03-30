package org.bluebridge.my_aqs_lock.v1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

final class MySync extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int acquires) {
        if (compareAndSetState(0, 1)) {
            //进入if表示锁已经加上了
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int acquires) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    protected Condition newCondition() {
        return new ConditionObject();
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}