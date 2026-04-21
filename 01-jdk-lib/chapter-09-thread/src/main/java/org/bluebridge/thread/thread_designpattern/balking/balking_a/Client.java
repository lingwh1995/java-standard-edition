package org.bluebridge.thread.thread_designpattern.balking.balking_a;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/16 17:39
 */
public class Client {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangeThread("ChangerThread",data).start();
        new SaveThread("SaveThread",data).start();
    }
}
