package org.bluebridge.guarded_suspension.guarded_suspension_a;

/**
 * 单任务版GuardedObject
 */
public class GuardedObject {
    //结果
    private Object response;

    private final Object lock = new Object();

    /**
     * 获取结果(没有结果将处于一直等待状态,等待结果的产生)
     * @return
     */
    public Object get() {
        synchronized (lock) {
            // 没有结果则一直等待
            // 防止虚假唤醒
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    /**
     * 产生结果
     * @param response
     */
    public void complete(Object response) {
        synchronized (lock) {
            // 给成员变量赋值
            this.response = response;
            // 产生结果，通知等待线程
            lock.notifyAll();
        }
    }
}
