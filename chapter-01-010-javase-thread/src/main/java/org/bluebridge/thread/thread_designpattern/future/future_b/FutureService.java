package org.bluebridge.thread.thread_designpattern.future.future_b;

/**
 * @author ronin
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task){
        final AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }
}
