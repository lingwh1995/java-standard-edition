package org.bluebridge.thread.thread_designpattern.guarded_suspension.guarded_suspension_b;


/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/16 9:34
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alex",3141592L).start();
        new ServerThread(requestQueue,"Bobby",6535897L).start();
    }
}
