package org.bluebridge.thread.thread_designpattern.observer;

/**
 * @author ronin
 */
public interface LifeCycleListener {
    void onEvent(ObservableRunnable.RunnableEvent event);
}
