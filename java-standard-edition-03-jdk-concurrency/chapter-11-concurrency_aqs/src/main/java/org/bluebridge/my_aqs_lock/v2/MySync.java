package org.bluebridge.my_aqs_lock.v2;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

final class MySync extends AbstractQueuedSynchronizer {

    /**
     * 尝试获取锁
     * @param acquires the acquire argument. This value is always the one
     *        passed to an acquire method, or is the value saved on entry
     *        to a condition wait.  The value is otherwise uninterpreted
     *        and can represent anything you like.
     * @return
     */
    @Override
    protected boolean tryAcquire(int acquires) {
        if (acquires == 1){
            int state = getState();
            System.out.println("Thread " + Thread.currentThread().getName() + " state[tryAcquire] = " + state);
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        }
        return false;
    }

    /**
     * 尝试释放锁
     * @param acquires the release argument. This value is always the one
     *        passed to a release method, or the current state value upon
     *        entry to a condition wait.  The value is otherwise
     *        uninterpreted and can represent anything you like.
     * @return
     */
    @Override
    protected boolean tryRelease(int acquires) {
        if(acquires == 1) {
            int state = getState();
            System.out.println("Thread " + Thread.currentThread().getName() + " state[tryRelease] = " + state);
            if(getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        return false;
    }

    protected Condition newCondition() {
        return new ConditionObject();
    }

    /**
     * 判断该线程是否正在独占资源
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}