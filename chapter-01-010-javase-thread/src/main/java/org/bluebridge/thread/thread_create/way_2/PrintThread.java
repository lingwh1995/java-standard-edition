package org.bluebridge.thread.thread_create.way_2;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/11 17:27
 */
public class PrintThread implements Runnable {

    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i+":"+this.message);
        }
    }
}
