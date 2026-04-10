package org.bluebridge.thread.thread_designpattern.future.future_b;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 16:15
 */
public class FutureTaskImpl implements FutureTask<String>{
    @Override
    public String call() {
        return "FutureTaskImpl.call()的返回值:I am FutureTaskImpl......";
    }
}
