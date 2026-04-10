package org.bluebridge.thread.thread_designpattern.balking.balking_b;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/17 10:31
 */
public class Client {
    public static void main(String[] args) {
        Something something = new Something();
        something.init();
        something.init();
    }
}
