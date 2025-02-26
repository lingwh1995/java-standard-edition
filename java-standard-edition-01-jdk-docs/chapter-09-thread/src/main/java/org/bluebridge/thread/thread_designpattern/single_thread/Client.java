package org.bluebridge.thread.thread_designpattern.single_thread;

/**
 * @author ronin
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alas").start();
        new UserThread(gate, "Bobby", "Brazli").start();
        new UserThread(gate, "Chirs", "Canda").start();
    }
}
