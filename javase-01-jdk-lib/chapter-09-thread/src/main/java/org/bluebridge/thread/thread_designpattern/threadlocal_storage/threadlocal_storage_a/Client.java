package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal_storage_a;

import java.util.stream.IntStream;

/**
 * @author ronin
 */
public class Client {
    public static void main(String[] args) {
        IntStream.range(1,5).forEach(i -> {
            //每一个线程都有一个自己的上下文
            new Thread(new ExecutionTask()).start();
        });
    }
}
