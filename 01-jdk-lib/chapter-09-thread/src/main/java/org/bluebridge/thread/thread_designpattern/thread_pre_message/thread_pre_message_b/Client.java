package org.bluebridge.thread.thread_designpattern.thread_pre_message.thread_pre_message_b;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/18 17:24
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("MAIN-THREAD BEGIN......");
        Host host = new Host();
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        System.out.println("MAIN-THREAD END......");
    }
}
