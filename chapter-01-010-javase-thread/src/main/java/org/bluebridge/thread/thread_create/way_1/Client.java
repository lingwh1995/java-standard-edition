package org.bluebridge.thread.thread_create.way_1;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/11 17:25
 */
public class Client {
    public static void main(String[] args) {
        new PrintThread("Bob!").start();
        new PrintThread("Sala!").start();
        new PrintThread("Mick!").start();
        new PrintThread("Jhon!").start();
    }
}
