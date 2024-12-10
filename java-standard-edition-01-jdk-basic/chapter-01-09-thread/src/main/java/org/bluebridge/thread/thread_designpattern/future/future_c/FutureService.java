package org.bluebridge.thread.thread_designpattern.future.future_c;

import java.util.function.Consumer;

/**
 * @author ronin
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task, Consumer<T> consumer){
        final AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}
