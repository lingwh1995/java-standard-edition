package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ronin
 */
public class ThreadLocalSimulator<T> {
    private final Map<Thread,T> storage = new HashMap<>();

    public void set(T t){
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if(value == null){
                return initValue();
            }
            return value;
        }
    }

    private T initValue() {
        return null;
    }
}
