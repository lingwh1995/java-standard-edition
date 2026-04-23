package org.bluebridge.thread.thread_designpattern.observer;

import java.util.Arrays;

/**
 * @author ronin
 */
public class Client {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().currentQuery(Arrays.asList("1","2"));
    }
}
