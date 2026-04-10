package org.bluebridge.thread.thread_designpattern.two_phrase_termination.tpt_a;

/**
 * @author ronin
 */
public class CounterIncrementTest {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();
        Thread.sleep(5_000L);
        counterIncrement.close();
    }
}
