package org.bluebridge.thread.thread_designpattern.balking.guarded_timed;

import java.util.concurrent.TimeoutException;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/17 10:51
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host(10000);
        try {
            System.out.println("execute BEGIN......");
            host.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
