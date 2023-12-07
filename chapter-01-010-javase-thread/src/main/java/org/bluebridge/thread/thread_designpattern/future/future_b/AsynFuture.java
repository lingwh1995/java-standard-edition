package org.bluebridge.thread.thread_designpattern.future.future_b;

/**
 * @author ronin
 */
public class AsynFuture<T> implements Future<T> {

    /**判断任务有没有执行完成*/
    private volatile boolean isDone = false;

    private T result;

    @Override
    public T get() throws InterruptedException {
        synchronized(this){
            while(!isDone){
                this.wait();
            }
        }
        return result;
    }

    public void done(T result){
        synchronized (this){
            this.result = result;
            this.isDone = true;
            this.notifyAll();
        }
    }
}
