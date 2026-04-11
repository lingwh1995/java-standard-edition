package org.bluebridge.thread.thread_designpattern.guarded_suspension.guarded_suspension_c;


/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/16 9:34
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        ClientThread alex = new ClientThread(requestQueue, "Alex", 3141592L);
        alex.start();
        ServerThread bobby = new ServerThread(requestQueue, "Bobby", 6535897L);
        bobby.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        alex.interrupt();
//        bobby.interrupt();
    }
}
