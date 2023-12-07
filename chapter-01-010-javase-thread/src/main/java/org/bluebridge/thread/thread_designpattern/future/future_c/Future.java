package org.bluebridge.thread.thread_designpattern.future.future_c;

/**
 * @author ronin
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
